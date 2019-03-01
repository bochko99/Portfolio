import io.restassured.RestAssured
import io.restassured.authentication.BasicAuthScheme
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.util.stream.Collectors

class UpdateParametersTask extends DefaultTask {

    @TaskAction
    def update() {

        String username = project.property("tc.login")
        String password = project.property("tc.password")
        def scheme = new BasicAuthScheme(userName: username, password: password)

        RequestSpecification spec = new RequestSpecBuilder()
                .setAuth(scheme)
                .addHeader("Origin", "https://tc.testessential.net")
                .setBaseUri("https://tc.testessential.net")
                .setBasePath("/httpAuth/app/rest/projects/TestAutomation_TestApi/parameters")
//                .addFilter(new RequestLoggingFilter())
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new ErrorLoggingFilter())
                .build()

        //get test classes
        List<File> allClasses = Arrays.asList(new File("${project.buildDir.path}/classes/java/test/tests").listFiles())

        //delete each test checkbox in tc and add new for each test class
        RestAssured.given().spec(spec).body("")
                .delete("/defineScope")
        RestAssured.given().spec(spec).get().then().extract().body().xmlPath()
                .getNode("properties").getNodes("property").forEach {
            def name = it.getAttribute("name")
            if (name != null && name.endsWith("Tests")) {
                RestAssured.given().spec(spec).delete("/${name}")
            }
        }

        def testClasses = allClasses.stream().filter {
            it.name.endsWith("Tests.class")
        }.sorted().collect(Collectors.toList())

        StringBuilder sb = new StringBuilder().append("\$defineScopeTemp\n")
        def template = "\$myArg = \"%myArg%\"\n" +
                "if (\$myArg -eq \"true\") {\n" +
                "   \$defineScopeTemp=\"\$defineScopeTemp --tests myArg\"\n" +
                "}\n"

        testClasses.forEach {
            def name = it.name.split('\\.')[0]
            RestAssured.given().spec(spec).body(true).put("${name}")
            RestAssured.given().spec(spec)
                    .body("checkbox uncheckedValue='false' display='prompt' checkedValue='true'")
                    .put("${name}/type/rawValue")
            //generating script to define scope based on user preferences
            sb.append(template.replaceAll("myArg", name))
            println name
        }

        sb.append("Write-Host \"##teamcity[setParameter name='testClasses' value='\$defineScopeTemp']\"")
        RestAssured.given().spec(spec).body(sb.toString())
                .put("/defineScope")

        //http://teamcity:8111/app/rest/buildTypes/<buildTypeLocator>/steps/<step_id>


    }
}
