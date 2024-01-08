@Gateway_Test_7.10
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Connectivity history graph has no data in the selected range, or no data at all

  Scenario: Test 7.10
    #PROCEDURE
    #Step 1
    #Access to DMC and then open the sidemenu:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #Go to device page and select the gateway "EVO21"
    Then I input "EVO21" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.evo21GatewayWithoutDataDetailsIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.historyIcon Element and then i click it

    #Step 3
    #Verify that for a gateway without data the graph are empty

    And I check the presence of ConnectivityHistoryPage.meanConnectionLabel
    And I check the presence of ConnectivityHistoryPage.underNotAvailableDataMeanConnectionVoice

    And I check the presence of ConnectivityHistoryPage.connectivityHistoryLabel
    And I check the presence of ConnectivityHistoryPage.underNotAvailableDataConnectivityHistory

    And I check the presence of ConnectivityHistoryPage.zeroConnection
    And I check the presence of ConnectivityHistoryPage.zeroDisconnection
    And I check the presence of ConnectivityHistoryPage.notAvailableLastConnection
    And I check the presence of ConnectivityHistoryPage.notAvailableLastDisconnection
    And I check the presence of ConnectivityHistoryPage.notAvailableDataMeanConnection
    And I check the presence of ConnectivityHistoryPage.notAvailableDataConnectivityHistory



