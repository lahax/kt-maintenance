@Gateway_Test_7.41_endDeploy
Feature: Gateway

  Scenario: Test 7.41 end Deploy

        #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #STEP 2 - Access to Devices  Section then select a Gateway, enter the detail section then go to the deployment history

    Then I enter on "esol-ap29551-qa" project

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
    Then I check the presence of DevicesDetailsPage.version1_2OptionToSelect Element and then i click it
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
    Then I reload the page
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DevicesDetailsPage.lastDeployedSoftwareDetailedIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1Deployment

    Then I kill the notify_job command still opened


    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #Then I reload the page
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it

    #STEP 3 - Click on the floating button in the bottom right, and then try the functionality of search and refresh:

    Then I count all the entries
    Then I check the presence of DevicesDetailsPage.refreshDeploymentHistoryBTN Element and then i click it
    Then I check that the refresh button works properly in Deployments History Details
    Then I check the presence of DevicesDetailsPage.searchDeploymentHistoryBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.searchingFiltersTitle
    #Then I check the presence of DevicesDetailsPage.deleteFilterPackagesIcon Element and then i click it
    Then I click Element DevicesDetailsPage.deleteFilterPackagesIcon using Javascript
    #Then I check the presence of DevicesDetailsPage.deleteFilterCurrentStackIcon Element and then i click it
    Then I click Element DevicesDetailsPage.deleteFilterCurrentStackIcon using Javascript
    #Then I check the presence of DevicesDetailsPage.statusFilterDropdown Element and then i click it
    Then I click Element DevicesDetailsPage.statusFilterDropdown using Javascript
    #Then I check the presence of DevicesDetailsPage.completeStatusValue Element and then i click it
    Then I click Element DevicesDetailsPage.completeStatusValue using Javascript

    Then I check the presence of DevicesDetailsPage.deploymentEndRange Element and then i click it
    And I check the presence of DevicesDetailsPage.leftMonthBTNFromEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.fifteenthDayPreviousMonthFromEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.toTabsIntoCalendarEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.buttonNowIntoCalendarEnd Element and then i click it
    And I check the presence of DevicesDetailsPage.buttonConfirmIntoCalendarEnd Element and then i click it

    Then I check the presence of DevicesDetailsPage.searchFilterBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deploymentHistoryTable
    And I check the filtered entries

        #Logout step
    Then I click on the user icon and log out.