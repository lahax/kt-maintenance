@Logs_Test_11.10
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.10

    #STEP 1 - Login on DMC

   Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Check that on the top of the page is shown a filter toolbox:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    Then I check the presence of LogPage.paginationTableButton Element and then i click it
    Then I check the presence of LogPage.fiveRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    Then I check the presence of LogPage.paginationTableButton Element and then i click it
    Then I check the presence of LogPage.tenRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    Then I check the presence of LogPage.paginationTableButton Element and then i click it
    Then I check the presence of LogPage.twentyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    Then I check the presence of LogPage.paginationTableButton Element and then i click it
    Then I check the presence of LogPage.fiftyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    Then I check the presence of LogPage.paginationTableButton Element and then i click it
    Then I check the presence of LogPage.hundredRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    Then I check the presence of LogPage.buttonNextPageTable Element and then i click it
    Then I check if the number of rows present in the table is in accordion with the pagination number

    # Logout Step
    Then I click on the user icon and log out.


