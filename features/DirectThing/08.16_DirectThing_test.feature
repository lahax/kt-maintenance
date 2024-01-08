@DirectThing_Test_8.16
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.16
    Then I enter on "esol-ap29551-qa" project
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
    #Step 4
    # Send a "get History Logs" command by press the button "get history logs"
    Then I check the presence of DevicesDetailsPage.getHistoryLogsBTN Element and then i click it
    Then I check the presence of DirectThingLogsPage.historyRangeBox Element and then i click it
    Then I check the presence of DirectThingLogsPage.calendar
    Then I check the presence of DirectThingLogsPage.previousDayInTheFROMCalendar Element and then i click it
    And I check the presence of DirectThingLogsPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of DirectThingLogsPage.buttonNowIntoCalendar Element and then i click it
    Then I check the presence of DirectThingLogsPage.buttonConfirmIntoCalendar Element and then i click it
    Then I check the presence of DirectThingLogsPage.saveLogsOperationBTN Element and then i click it
    #---------------------------------Step 5

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    And I run the script "close_job_logs", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    And I wait 4 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept2 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

     #Step 6
    #Verify that you can see collect log command and see there is written "Last Collect Logs Invocation <date and time> | Currently Enabled"
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    And I check the presence of DevicesDetailsPage.lastCollectLogsEnabled

    #-------------------------------------Step 7
      #Do all steps again but in Tablet mode. Check that all the sections are correctly shown.
    #Then I set chrome "iPad pro" mode
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.devicesOption Element and then i click it
    #And I check the presence of DevicesPage.devicesLandingPageTitle
    #Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    #And I check the presence of DevicesDetailsPage.directThingPageTitle

    #The device is simulated through script NOTIFY_JOB
    #Then I kill the notify_job command still opened
    #Then I run the notify_job script on "DirectThingConcept2", in the project "esol_ap29551_qa"
    #Step 4
    # Send a "get History Logs" command by press the button "get history logs"
    #Then I check the presence of DevicesDetailsPage.getHistoryLogsBTN Element and then i click it
    #Then I check the presence of DirectThingLogsPage.historyRangeBox Element and then i click it
    #Then I check the presence of DirectThingLogsPage.calendar
    #Then I check the presence of DirectThingLogsPage.previousDayInTheFROMCalendar Element and then i click it
    #And I check the presence of DirectThingLogsPage.toTabsIntoCalendar Element and then i click it
    #And I check the presence of DirectThingLogsPage.buttonNowIntoCalendar Element and then i click it
#    And I check the presence of AlarmsPage.leftMonthBTNTo Element and then i click it
#    And I check the presence of AlarmsPage.fifteenthDayPreviousMonthTo Element and then i click it
    #Then I check the presence of DirectThingLogsPage.buttonConfirmIntoCalendar Element and then i click it
    #Then I check the presence of DirectThingLogsPage.saveLogsOperationBTN Element and then i click it
    #---------------------------------Step 5

     #Wait for the job notify and Run close job script using jobId contained in the previous message
    #Then I save the job ID from the job document received
    #Then I save the job ID from the job document received
    #And I run the script "close_job_logs", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    #Then I kill the notify_job command still opened

    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    #And I wait 2 minutes after script
    #Then I enter on "esol-ap29551-qa" project
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.diagnosticOption
    #And I click SidebarPage.stepFunctionSubOption
    #And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    #And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept2 Element and then i click it
    #And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

     #Step 6
    #Verify that you can see collect log command and see there is written "Last Collect Logs Invocation <date and time> | Currently Enabled"
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.devicesOption Element and then i click it
    #And I check the presence of DevicesPage.devicesLandingPageTitle
    #Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    #And I check the presence of DevicesDetailsPage.directThingPageTitle
    #And I check the presence of DevicesDetailsPage.lastCollectLogsEnabled

    Then I click on the user icon and log out.


