@Alarms_Test_12.3
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.3

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    ## STEP 2
    Then I check the presence of AlarmsPage.filtersBox
    Then I check the presence of AlarmsPage.dropdownIconFilterBox Element and then i click it

    Then I check the presence of AlarmsPage.dateTimeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.calendar
    And I check the presence of AlarmsPage.buttonNowIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.leftMonthBTNTo Element and then i click it
    Then I wait 2 seconds
    Then I click Element AlarmsPage.fifteenthDayPreviousMonthTo using Javascript

    Then I check that the AlarmsPage.buttonConfirmIntoCalendar element is disabled


