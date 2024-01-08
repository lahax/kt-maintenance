@DirectThing_Test_8.18_end
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.18 end
    Then I enter on "esol-ap29551-qa" project

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
    #Then I check the presence of DevicesDetailsPage.optionsFlag Element and then i click it
    #Step 5
    #Insert a test string, then click on "Update"
    #Then I input "Test_Sofware_Option" into the text area DevicesDetailsPage.firstRowIntTextarea
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    And I run the script "close_job_software", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
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
    And I reload the page
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
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
    #Then I check the presence of DevicesDetailsPage.optionsFlag Element and then i click it
    #Step 5
    #Insert a test string, then click on "Update"
    #Then I input "Test_Sofware_Option" into the text area DevicesDetailsPage.firstRowIntTextarea
    Then I check the presence of DevicesDetailsPage.updateFirmwareConfirmBTN Element and then i click it

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    And I run the script "close_job_software", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I reload the page
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
    And I reload the page
    And I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment

    #----------------------------------Step 2
    #Clicking on details button, it will show the direct thing detail.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    #Step 3
    #3a. Click on "direct thing detail" in actions column:
    #Then I input "DirectThing_Test15_26" in DevicesPage.searchBox
    #Then I input "DirectThingConcept2" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it

    #Step 4
    #Click on Search Button (next the refresh button) and check that the section is as shown in the screen:
    Then I count all the entries
    And I check that the refresh button works properly in the device details page
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.searchButton Element and then i click it
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.titleSearchingFilters
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.tabFilters
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.tabCustomQuery
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.buttonActivateLatest

    Then I check the presence of the label "Latest" of "generic" section
    Then I check the presence of the label "Status" of "generic" section
    And I check the presence of the dropdown "Status" of "generic" section
    Then I check the presence of the label "Deploy Type" of "generic" section
    And I check the presence of the dropdown "Deploy Type" of "generic" section

    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.titlePackagesToInstall
    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.plusIconPackagesToInstall
    Then I check the presence of the label "App Name*" of "package to install" section
    And I check the presence of the dropdown "App Name" of "package to install" section
    Then I check the presence of the label "Version*" of "package to install" section
    Then I check the presence of the dropdown "Version" of "package to install" section
    Then I check the presence of the label "Operator*" of "package to install" section
    Then I check the presence of the dropdown "Operator" of "package to install" section
    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.trashIconPackageToinstall

    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.titleCurrentStack
    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.plusIconCurrentStack
    Then I check the presence of the label "App Name*" of "current stack" section
    And I check the presence of the dropdown "App Name" of "current stack" section
    Then I check the presence of the label "Version*" of "current stack" section
    Then I check the presence of the dropdown "Version" of "current stack" section
    Then I check the presence of the label "Operator" of "current stack" section
    Then I check the presence of the dropdown "Operator" of "current stack" section
    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.trashIconCurrentStack
    And I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.titleDeploymentStart
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.calendarFrom
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.titleDeploymentEnd
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.calendarTo

    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.buttonSearch
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.buttonClear

    #Step 5
    #5a. If "Package to Install" and "Current Stack" are present and not filled, the "search" will not switch on:
    And I check that the SearchingFilterDeploymentHistoryDeviceDetailsPage.buttonSearch element is disabled
    #5b. If we delete these two sections, the "search" button will switch on:
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.trashIconPackageToinstall Element and then i click it
    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.trashIconCurrentStack Element and then i click it

    Then I check the presence of DevicesDetailsPage.statusFilterDropdown Element and then i click it
    Then I check the presence of DevicesDetailsPage.completeStatusValue Element and then i click it

    Then I check the presence of DevicesDetailsPage.deploymentEndRange Element and then i click it
    And I check the presence of DevicesDetailsPage.leftMonthBTNFromEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.fifteenthDayPreviousMonthFromEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.toTabsIntoCalendarEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.buttonNowIntoCalendarEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.buttonConfirmIntoCalendarEnd Element and then i click it

    Then I check the presence of SearchingFilterDeploymentHistoryDeviceDetailsPage.buttonSearch Element and then i click it

    Then I check the presence of DevicesDetailsPage.deploymentHistoryTableDirectThings
    And I check the filtered entries

        #Logout step
    Then I click on the user icon and log out.