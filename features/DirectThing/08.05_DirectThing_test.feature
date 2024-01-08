@DirectThing_Test_8.5
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.5
    Then I enter on "esol-ap29551-qa" project
    Then I close all the step functions in progress of device "DirectThingConcept2"
    #----------------------------------Step 2
    #Go to device page and select a direct thing
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
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
    Then I check the presence of DevicesDetailsPage.optionsFlag Element and then i click it
    #Step 6
    #Insert a test string, then click on "Update"
    Then I input "Test_Sofware_Option" into the text area DevicesDetailsPage.firstRowIntTextarea
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID
    #Then I save the job ID from the job document received and check the message: "Test_Sofware_Option"
    #Then I save the job ID from the job document received
    And I run the script "close_job_software", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 7
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


    # Step 7
    # Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirectThingConcept2 Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusComplete

    #Step 8
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment


    #Step 11
    #Do all steps again but in Tablet mode. Check that all the sections are correctly shown.

    #Then I set chrome "iPad pro" mode

    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.devicesOption Element and then i click it
    #And I check the presence of DevicesPage.devicesLandingPageTitle
    #Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    #And I check the presence of DevicesDetailsPage.directThingPageTitle

    #The device is simulated through script NOTIFY_JOB
    #hen I kill the notify_job command still opened
    #Then I run the notify_job script on "DirectThingConcept1", in the project "esol_ap29551_qa"
    #---------------------------------Step 3
    #Click on Firmware Update:
    #Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    #---------------------------------Step 4
    #Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    #Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    #Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    #Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    #Then I check the presence of DevicesDetailsPage.optionsFlag Element and then i click it
    #Step 6
    #Insert a test string, then click on "Update"
    #Then I input "Test_Sofware_Option" into the text area DevicesDetailsPage.firstRowIntTextarea
    #Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    #Then I save the job ID from the job document received and check the message: "Test_Sofware_Option"
    #Then I save the job ID from the job document received
    #And I run the script "close_job_software", with the job Id retrieved, on "DirectThingConcept1" in the project "esol_ap29551_qa"
    #Then I kill the notify_job command still opened

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    #And I wait 2 minutes after script
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.diagnosticOption
    #And I click SidebarPage.stepFunctionSubOption
    #And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    #And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept1 Element and then i click it
    #And I check the presence of StepFunctionPage.succeededInDetailsStepFunction


    # Step 7
    # Open Software Manager - Deployments History and search for the deployment status
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    #Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    #Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirectThingConcept2 Element and then i click it
    # I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusComplete

    #Step 8
    #Open Gateway's detailed page on Devices section and check the deployment is present on Deployment History section
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.devicesOption
    #Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    #Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    #Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    #Then I check the presence of DevicesDetailsPage.app1Deployment


    Then I click on the user icon and log out.
