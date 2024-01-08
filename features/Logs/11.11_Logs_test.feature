@Logs_Test_11.11
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.11

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Check that on the top of the page is shown a filter toolbox:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle
    Then I check the presence of LogPage.filtersBox Element and then i click it
    Then I check the presence of LogPage.statusFilterBox Element and then i click it
    Then I check the presence of LogPage.firstOptionOfStatusFilter Element and then i click it
    Then I click Element LogPage.dropdownStatusFilterBox using Javascript
    And I check the presence of LogPage.dateTimeFilterBox Element and then i click it
    And I check the presence of LogPage.leftMonthBTNFrom Element and then i click it
    And I wait 10 seconds
    And I check the presence of LogPage.fifteenthDayPreviousMonthFrom Element and then i click it
    And I check the presence of LogPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of LogPage.nowButtonCalendar Element and then i click it
    And I check the presence of LogPage.confirmButtonCalendar Element and then i click it
    Then I check the presence of LogPage.typeFilterBox Element and then i click it
    Then I check the presence of LogPage.firstOptionOfTypeFilter Element and then i click it
    Then I click Element LogPage.dropdownTypeFilterBox using Javascript
    Then I check the presence of LogPage.confirmButtonFilterSection Element and then i click it
    Then I check the presence of LogPage.exportIcon Element and then i click it
    Then I check the number of total rows on popUp on LogPage
    Then I check the presence of LogPage.confirmButton Element and then i click it
    Then I wait the progress bar for a maximum of "300" seconds
    Then I check the presence of LogPage.filtersBox Element and then i click it
    #And I read the filtered downloaded file and i delete it
    And I read the filtered downloaded csv file and i delete it