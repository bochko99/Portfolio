package com.crypterium.cryptApi.tasks

import io.restassured.RestAssured
import io.restassured.authentication.BasicAuthScheme
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class UpdateTask extends DefaultTask {

    RequestSpecification spec = new RequestSpecBuilder()
            .setAuth(new BasicAuthScheme(userName: "${project.property('teamcity.auth.userId')}",
            password: "${project.property('teamcity.auth.userId')}"))
            .setBasePath("/app/rest/buildTypes/TestAutomation_QaaDev_ApiArtifactory/parameters")
            .setBaseUri("https://tc.testessential.net")
            .build()

    @TaskAction
    def incrementVersionOnTC() {
        def minor = RestAssured.given().spec(spec)
                .get("/VersionMinor").asString()
        println minor
    }

}
