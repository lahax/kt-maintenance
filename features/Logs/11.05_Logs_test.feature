@Logs_Test_11.5
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.5

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Select a "END TIME" date greater than the current date and check you can not select a future date (future date is grey)
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    Then I check the presence of LogPage.filtersBox Element and then i click it
    And I check the presence of LogPage.dateTimeFilterBox Element and then i click it
    Then I check the presence of LogPage.calendar
    Then I check the presence of LogPage.toTabsIntoCalendar Element and then i click it

    Then I check the presence of LogPage.followingDayInTheTOCalendar
    Then I check that the element LogPage.followingDayInTheTOCalendar is not active.



