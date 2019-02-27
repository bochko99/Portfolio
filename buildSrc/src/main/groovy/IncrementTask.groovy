import io.restassured.RestAssured
import io.restassured.authentication.BasicAuthScheme
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class IncrementTask extends DefaultTask {

    @TaskAction
    def increment() {
        if (project.hasProperty("tc.login") && project.hasProperty("tc.password")) {
            String username = project.property("tc.login")
            String password = project.property("tc.password")
            def scheme = new BasicAuthScheme(userName: username, password: password)

            RequestSpecification spec = new RequestSpecBuilder()
                    .setAuth(scheme)
                    .addHeader("Origin", "https://tc.testessential.net")
                    .setBaseUri("https://tc.testessential.net")
                    .setBasePath("/httpAuth/app/rest/buildTypes/TestAutomation_QaaDev_ApiArtifactory/parameters")
                    .build()

            def minorVersion = Integer.parseInt(RestAssured.given().spec(spec).get("/VersionMinor").asString())
            def newMinorVersion = minorVersion + 1
            def majorVersion = RestAssured.given().spec(spec).get("/VersionMajor").asString()

            def version = majorVersion + '.' + newMinorVersion
            RestAssured.given().spec(spec).body(newMinorVersion).put("/VersionMinor")
            RestAssured.given().spec(spec).body(version).put("/system.newVersion")
            println "$majorVersion.$minorVersion -> $version"
            project.version = version
        }
    }
}