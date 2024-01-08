@Alarms_Test_12.9
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.9

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    Then I check the presence of AlarmsPage.paginationTableButton Element and then i click it
    Then I check the presence of AlarmsPage.fiveRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    Then I check the presence of AlarmsPage.paginationTableButton Element and then i click it
    Then I check the presence of AlarmsPage.tenRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    Then I check the presence of AlarmsPage.paginationTableButton Element and then i click it
    Then I check the presence of AlarmsPage.twentyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    Then I check the presence of AlarmsPage.paginationTableButton Element and then i click it
    Then I check the presence of AlarmsPage.fiftyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    Then I check the presence of AlarmsPage.paginationTableButton Element and then i click it
    Then I check the presence of AlarmsPage.hundredRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    Then I check the presence of AlarmsPage.buttonNextPageTable Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage

    # Logout Step
    Then I click on the user icon and log out.
