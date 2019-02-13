#!/usr/bin/env bash
TARGET_FOLDER="$(date '+%Y-%m-%d_%H:%M:%S')"
cd ~/IdeaProjects/cryptApi/
gradle clean test
gradle allureReport
ditto build/reports/allure-report/ reports/$TARGET_FOLDER
