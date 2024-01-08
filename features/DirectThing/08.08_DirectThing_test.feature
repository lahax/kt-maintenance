@DirectThing_Test_8.8
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.8
    Then I enter on "esol-ap29551-qa" project
    Then I close all the step functions in progress of device "DirectThingConcept2"
    #----------------------------------Step 2: Repeat test 8.7, where:
    #there are more than 1 APP on the firmware update parameters
    #The rollback is "individual":
    #Go to device page and select a direct thing TYPE NOT GENERIC
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar
    Then If direct thing "DirectConceptDec2" is not present I run register_direct.sh
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle

    #The device is simulated through script NOTIFY_JOB
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "DirectThingConcept2", in the project "esol_ap29551_qa"
    #---------------------------------Step 3
    #Click on Firmware Update:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    #---------------------------------Step 4
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    #Add at least 2 pacckage
    Then I check the presence of DevicesDetailsPage.addNewPackageBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.app2OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelectSecondRow Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    And I run the script "close_job_software_partial", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept2 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #Step 3
    #Verify on the Deployments History details that only the apps indicated on the completion message are showed as installed
    # Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I wait 60 seconds
    Then I reload the page
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirectThingConcept2 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete

    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then  I reload the page
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment
    Then I check the presence of DevicesDetailsPage.app2Deployment

    #Step 4
    #Repeat test 8.8, where:
    #there are more than 1 APP on the firmware update parameters
    #The rollback is "global"

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then  I reload the page
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle

    #The device is simulated through script NOTIFY_JOB
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "DirectThingConcept2", in the project "esol_ap29551_qa"
    #---------------------------------Step 3
    #Click on Firmware Update:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    #---------------------------------Step 4
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    #Add at least 2 pacckage
    Then I check the presence of DevicesDetailsPage.addNewPackageBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.app2OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBoxSelection Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelectSecondRow Element and then i click it
    Then I check the presence of DevicesDetailsPage.globalFlag Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    And I run the script "close_job_failed_8,8", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Open Diagnostic - Step function
    #Check the Step function status is "FAILED"
    #Wait for the DMC response
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept2 Element and then i click it
    And I check the presence of StepFunctionPage.failedInDetailsStepFunction

    #Step 5
    #Verify on the Deployments History details that the deployments is completely failed
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I wait 60 seconds
    Then I reload the page
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirectThingConcept2 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusFailed


    Then I click on the user icon and log out.