@Devices_Test_5.8
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.8

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Click on Sidebar menu then on "Devices" section.
    Then I click SidebarPage.devicesOption

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    ## STEP 3
    ## Select a page number at the bottom of the list, then check that the items are correctly shown:
    And I check the presence of DevicesPage.paginationTableButton Element and then i click it
    And I check the presence of DevicesPage.fiveRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in according with the pagination number in DevicesPage

    And I check the presence of DevicesPage.paginationTableButton Element and then i click it
    And I check the presence of DevicesPage.tenRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in according with the pagination number in DevicesPage

    And I check the presence of DevicesPage.paginationTableButton Element and then i click it
    And I check the presence of DevicesPage.twentyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in according with the pagination number in DevicesPage

    And I check the presence of DevicesPage.paginationTableButton Element and then i click it
    And I check the presence of DevicesPage.fiftyRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in according with the pagination number in DevicesPage

    And I check the presence of DevicesPage.paginationTableButton Element and then i click it
    And I check the presence of DevicesPage.hundredRowsPerPage Element and then i click it
    Then I check if the number of rows present in the table is in according with the pagination number in DevicesPage

    # Logout Step
    Then I click on the user icon and log out.