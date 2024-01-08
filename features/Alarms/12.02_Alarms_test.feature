@Alarms_Test_12.2
Feature: Alarms
#GOAL:In the Alarms page there is a filter toolbox
  Background:
  # STEP 1 - Login on DMC and go to the Alarms page
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.2

    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    # STEP 2 - Check that on the top of the page is shown a filter toolbox:
    Then I check the presence of AlarmsPage.filtersBox
    Then I check the presence of AlarmsPage.dropdownIconFilterBox Element and then i click it

    #STEP EXTRA: https://jira.springlab.enel.com/browse/EXEGIP2-1829
    Then I check the presence of AlarmsPage.typeFilterBox Element and then i click it
    And I check the presence of AlarmsPage.thingEventDropdownOption
    And I check the presence of AlarmsPage.deviceAlarmDropdownOption
    And I check the presence of AlarmsPage.aggregatedAlarmDropdownOption
    Then I click Element AlarmsPage.typeFilterBox using Javascript

    Then I check the presence of AlarmsPage.messageFilterBox Element and then i click it
    And I check the presence of AlarmsPage.lifecycleDropdownOption
    And I check the presence of AlarmsPage.lowerThresholdDropdownOption
    And I check the presence of AlarmsPage.higherThresholdDropdownOption
    And I check the presence of AlarmsPage.businessAlarmDropdownOption
    And I check the presence of AlarmsPage.disserviceAlarmDropdownOption
    And I check the presence of AlarmsPage.telemetryMonitoringDropdownOption
    And I check the presence of AlarmsPage.aggregatedNotificationDropdownOption
    And I check the presence of AlarmsPage.zeroMessagesDropdownOption
    Then I click Element AlarmsPage.messageFilterBox using Javascript

    Then I check the presence of AlarmsPage.statusFilterBox Element and then i click it
    And I check the presence of AlarmsPage.onlineDropdownOption
    And I check the presence of AlarmsPage.offlineDropdownOption
    And I check the presence of AlarmsPage.inAlarmDropdownOption
    And I check the presence of AlarmsPage.errorDropdownOption
    And I check the presence of AlarmsPage.alarmClearedDropdownOption
    And I check the presence of AlarmsPage.alarmInvalidatedDropdownOption
    Then I click Element AlarmsPage.statusFilterBox using Javascript

    # STEP 3 - Set a filter by Type, Message, Status or Date Range and check the correct functionality of these.
    Then I check the presence of AlarmsPage.typeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfTypeFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownTypeFilterBox using Javascript

    Then I check the presence of AlarmsPage.messageFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfMessageFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownMessageFilterBox using Javascript

    Then I check the presence of AlarmsPage.statusFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfStatusFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownStatusFilterBox using Javascript

    And I check the presence of AlarmsPage.dateTimeFilterBox Element and then i click it
    And I check the presence of AlarmsPage.leftMonthBTNFrom Element and then i click it
    Then I wait 1 seconds
    Then I click Element AlarmsPage.fifteenthDayPreviousMonthFrom using Javascript
    And I check the presence of AlarmsPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.buttonNowIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.confirmButtoCalendar Element and then i click it

    Then I Save the filter set in AlarmsPage.typeFilterBox on AlarmPages
    Then I Save the filter set in AlarmsPage.messageFilterBox on AlarmPages
    Then I Save the filter set in AlarmsPage.statusFilterBox on AlarmPages

    Then I wait 15 seconds

    ## STEP 3
    Then I check the presence of AlarmsPage.confirmButtonFilterSection Element and then i click it
    And I wait 30 seconds
    Then I check that all rows contains only entries with the specified filter on AlarmsPage