#!/usr/bin/env bash
newVersion=1.0
curl -v --request PUT -d ${newVersion} --Header "Content-Type: text/plain" http://username:password@servername:8080/httpAuth/app/rest/projects/%system.teamcity.projectName%/parameters/system.version
