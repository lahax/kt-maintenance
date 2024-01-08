#!/bin/bash
# Usage: list the test name to execute them
echo "Starting DMC Test Guides..."
java -jar enel-dmc-automation-tests.jar chrome 01.01_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.02_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.03_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.04_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.05_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.06_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.07_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.08_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.09_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.10_ProjectsMenu_test
java -jar enel-dmc-automation-tests.jar chrome 01.11_ProjectsMenu_test

echo "Analyzing reports..."
java -jar report-analyzer.jar