@DirectThing_Test_8.19
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.19
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Clicking on details button, it will show the direct thing detail.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    #Step 3
    #3a. Click on "direct thing detail" in actions column:
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.historyIcon Element and then i click it
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