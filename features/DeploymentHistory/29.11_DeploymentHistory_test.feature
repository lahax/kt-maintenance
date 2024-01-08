@29.11_DeploymentHistory_test
Feature: Deployment History

  #script

  #https://jira.springlab.enel.com/browse/EXEGIP2-1263

  #GOAL: Install a new package and verify if the icon of the package installed is purple

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.11

    Then I enter on "esol-ap29551-qa" project

    #1 Login on DMC and go to device page and select a Gateway
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    # es ./notify_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test
    #It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-17", in the project "esol_ap29551_qa"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I wait the progress bar

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    Then I input "Test_Concept-17" in DevicesPage.searchBox
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar

    Then The table should contains the "Test_Concept-17" row
    Then I click the details icon for the "Test_Concept-17"

    #2 In System commands section select Firmware Update
    And I click DevicesDetailsPage.firmwareUpdateBTN
    # Select two packages to install in "App name" section, then select the desired version. #try packages: APP1 V5.0 AND APP2 V1.0 GW have to be: GATEWAY TYPE regression-eig
    And I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    And I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    And I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    And I check the presence of DevicesDetailsPage.version5OptionToSelect Element and then i click it

    And I check the presence of DevicesDetailsPage.addNewPackageBTN Element and then i click it

    And I check the presence of DevicesDetailsPage.appNameBox2 Element and then i click it
    And I check the presence of DevicesDetailsPage.app2OptionToSelect Element and then i click it
    And I check the presence of DevicesDetailsPage.versionBox2 Element and then i click it
    And I check the presence of DevicesDetailsPage.version1OptionToSelectSecondRow Element and then i click it

    #Click on "Update" to start the updating process:
    And I check the presence of DevicesDetailsPage.confirmUpdateBTN Element and then i click it

    #4a. Wait for the job notify and Run close job script using jobId contained in the previous message:
    #Close Job Script : ./close_job.sh <host> <apm> <device_id> <job_id>
    #es:./close_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test esol_ap29551_dev-2110041247-f417224f-1db0-4523-ac38-d72364ba5959
    #It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/$job_id/update
    #4b. The compleation job message on the script must be this:{ \"status\":\"SUCCEEDED\",\"statusDetails\":{\"environment_prefix\": \"$environmentPrefix\" , \"step\": \"command succeeded\", \"install_status\": \"partial_install\",\"gateway_sw\": \"<app correctly installed>\" }}"
    Then I save the job ID from the job document received and I verify that the inbound message have the specified format
    And I run the script "close_job_software_partial_29_11", with the job Id retrieved, on "Test_Concept-17" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened
    And I wait 120 seconds after script
    Then If present i click on Enter Button
    #TODO TA improvement: get one elegant method to control stepfunction progress

    #4c. Verify on the Deployments History details that only the apps indicated on the message are showed as partial install
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I wait the progress bar
    Then I clear the search Box in the Device Page
    Then I input "Test_Concept-17" in DevicesPage.searchBox
    Then I wait the progress bar
    Then The table should contains the "Test_Concept-17" row
    Then I click the details icon for the "Test_Concept-17"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    And I wait 5 seconds
    And I check the presence of DevicesDetailsPage.iconPartial
    And I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    And I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete
    And I check the presence of DeploymentHistoryDeviceDetailsPage.packageInstallationOutcome2911
    And I check the presence of DeploymentHistoryDeviceDetailsPage.package2InstallationOutcome2911

    #5 Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept17 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #6 Open Software Manager - Deployments History and search for the deployment status
    #Click on Deployments Detail
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerDropDownOption
    And I click SidebarPage.deploymentsHistoryOption
    And I check the presence of DeploymentsHistoryPage.iconPartial
    And I check the presence of DeploymentsHistoryPage.lastDeployTestConcept17

  #non ce l'ultima parte su JIra, ma probabilmente necessario
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    And I click DeploymentsHistoryPage.detailBtn
    And I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete
    And I check the presence of DeploymentHistoryDeviceDetailsPage.packageInstallationOutcome2911
    And I check the presence of DeploymentHistoryDeviceDetailsPage.package2InstallationOutcome2911

    #Logout
    Then I click on the user icon and log out.