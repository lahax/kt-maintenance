@Gateway_Test_7.39
Feature: Gateway
#GOAL Firmware Update of the Gateway - all the desired packages are configured and installed (device type: Generic)

  Scenario: Test 7.39
    #STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - If the device is simulated through script
    #
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    #
    #     es: ./notify_job.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test
    #
    #     It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next

    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"

    #STEP 3 - Click on "Firmware Update" with the following query:

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I input with enter "Test_Concept-02" in DevicesPage.searchBox
    Then I close all the step functions in progress
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    And I check the absence of StepFunctionPage.deleteButtonEnabled
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.diagnosticDropDownOption Element and then i click it
    Then I click SidebarPage.devicesOption
    And I wait the progress bar
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.version11OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.optionsFlag Element and then i click it


    And I input the firmware update query into DevicesDetailsPage.firstRowIntTextarea for gateway "Test_Concept-02"
    """
       {
           "gateway_id":" %s ",
           "command":"firmware-update-gateway",
           "parameters": {
            "snapKey":  "test",
            "snapName":  "eig-agent",
            "snapVersion": "1.0" ,
            "installFlags":  "Y",
            "reboot":  "false"
            }
       }
    """
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

        #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_software", with the job Id retrieved, on "Test_Concept-02" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

        #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I reload the page
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I check the presence of SidebarPage.stepFunctionSubOption Element and then i click it
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

        # Step 7
    # Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithConcept02 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusComplete

        #Step 8
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I reload the page
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment

    Then I kill the notify_job command still opened


    Then I click on the user icon and log out.


