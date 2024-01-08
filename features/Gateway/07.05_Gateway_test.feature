@Gateway_Test_7.4
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
    #Connectivity history graph has to be available for each thing in the "Devices > Gateway" page in the pop-up, for desktop and mobile

  Scenario: Test 7.5
    #PROCEDURE
    #Step 1
    #Access to DMC and then open the sidemenu:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #Access to a Gateway detail
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    #Step 3
    #Click on a row of things list and click on "connectivty history"
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
    Then I click on more info icon of the row with DeviceID "Test_Concept-01_thing1"
    Then I check the presence of ThingsPage.connectivityHistoryButton Element and then i click it

    #Step 4
    # Verify if the graph component is correctly displayed and responsive (also check the mobile view)
    Then I check the presence of ConnectivityHistoryPage.titlePageConnectivityHistory
    Then I check the presence of ConnectivityHistoryPage.dateTimesCalendar
    Then I check the presence of ConnectivityHistoryPage.downloadIcon
    Then I check the presence of ConnectivityHistoryPage.meanConnectionGraph
    Then I check the presence of ConnectivityHistoryPage.connectivityHistoryGraph
    Then I check all the label into the info section of Connectivity History page
      |Connections:       |
      |Disconnections:    |
      |Last Connection:   |
      |Last Disconnection:|
      |From:              |
      |To:                |

    #Then I set chrome "iPad pro" mode
    #Then I check the presence of ConnectivityHistoryPage.titlePageConnectivityHistory
    #Then I check the presence of ConnectivityHistoryPage.dateTimesCalendar
    #Then I check the presence of ConnectivityHistoryPage.downloadIcon
    #Then I check the presence of ConnectivityHistoryPage.meanConnectionGraph
    #Then I check the presence of ConnectivityHistoryPage.connectivityHistoryGraph
    #Then I check all the label into the info section of Connectivity History page
    #  |Connections:       |
    #  |Disconnections:    |
    #  |Last Connection:   |
    #  |Last Disconnection:|
    #  |From:              |
    #  |To:                |

    #Then I set chrome "iPhone" mode
    #Then I check the presence of ConnectivityHistoryPage.titlePageConnectivityHistory
    #Then I check the presence of ConnectivityHistoryPage.dateTimesCalendar
    #Then I check the presence of ConnectivityHistoryPage.downloadIcon
    #Then I check the presence of ConnectivityHistoryPage.meanConnectionGraph
    #Then I check the presence of ConnectivityHistoryPage.connectivityHistoryGraph
    #Then I check all the label into the info section of Connectivity History page
    #  |Connections:       |
    #  |Disconnections:    |
    #  |Last Connection:   |
    #  |Last Disconnection:|
    #  |From:              |
    #  |To:                |