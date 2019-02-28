import io.restassured.RestAssured
import io.restassured.authentication.BasicAuthScheme
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.ErrorLoggingFilter
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.specification.RequestSpecification
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

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
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build()

        List<File> allClasses = Arrays.asList(new File("${project.buildDir.path}/classes/java/test/tests").listFiles())
        
        RestAssured.given().spec(spec).get().then().extract().body().xmlPath()
                .getNode("properties").getNodes("property").forEach {
            def name = it.getAttribute("name")
            if (name != null && name.endsWith("Tests.class")) {
                RestAssured.given().spec(spec).delete("/${name}")
            }
        }

        allClasses.stream().filter {
            it.name.endsWith("Tests.class")
        }.sorted().forEach {
            RestAssured.given().spec(spec).body(true).put("${it.name}")
            RestAssured.given().spec(spec)
                    .body("checkbox uncheckedValue='false' display='prompt' checkedValue='true'")
                    .put("${it.name}/type/rawValue")
        }

    }
}
