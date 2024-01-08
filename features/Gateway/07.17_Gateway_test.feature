@Gateway_Test_7.17
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #All the desired packages are configured and installed.

  Scenario: Test 7.17
    #PROCEDURE
    #Step 1
    #Login on DMC

    #Step 2
    #continue the test case 7.17
    Then I enter on "esol-ap29551-qa" project
    Then I close all the step functions in progress of device "Test_Concept-01"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    #Step 3 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 4
    #Click on "Update" to start the updating process:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

    #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_software", with the job Id retrieved, on "Test_Concept-01" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionUpdateWithConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    # Step 7
    # Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithConcept01 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusComplete

    #Step 8
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I cancel text from the input box element DevicesPage.searchBox
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment

    Then I kill the notify_job command still opened

  #Step 9
  #Repeat step 3 - 8, changing the job closure message on the script:
  #{\"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" , \"step\":
    #\"command succeeded\", \"install_status\": \"partial_install\",\"gateway_sw\": \"<app correctly installed>\" } }"
     #Verify on the Deployments History details that only the apps indicated are showed as installed
      #Default to clean dmc

    #Repeat step 3 - 8,
     #Step 3 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I cancel text from the input box element DevicesPage.searchBox
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 4
    #Click on "Update" to start the updating process:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    #Add at least 2 pacckage
    Then I check the presence of DevicesDetailsPage.addNewPackageBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.app2OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelectSecondRow Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it


    #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_software_partial", with the job Id retrieved, on "Test_Concept-01" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I reload the page
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionUpdateWithConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    # Step 7
    # Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithConcept01 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete

    #Step 8
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I cancel text from the input box element DevicesPage.searchBox
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment


    Then I click on the user icon and log out.