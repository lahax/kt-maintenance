@Logs_Test_11.4
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.4

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Verify that in the column actions, there is the Ticket button and details button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    And I check the presence of LogPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of LogPage.dateTimeFilterBox Element and then i click it
    And I check the presence of LogPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of LogPage.nowButtonCalendar Element and then i click it
       #To the fifteenth day of the previous month to avoid every activation
    And I wait 90 seconds
    Then I check the presence of LogPage.fromTabsIntoCalendar Element and then i click it
    And I check the presence of LogPage.nowButtonCalendar Element and then i click it
    #Then I check the presence of DevicesDetailsPage.fifteenDayPreviousMonthTo Element and then i click it
    And I check that the LogPage.buttonConfirmIntoCalendar element is disabled