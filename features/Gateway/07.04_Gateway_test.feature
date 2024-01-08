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
    #Check that on the gateway page there is a button that allows the opening of a detail page for the related info in the register.

  Scenario: Test 7.4
    #PROCEDURE
    #Step 1
    #Access to DMC and then open the sidemenu:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #Access to a Gateway detail
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    #Step 3
    #Find the button "Connectivity History" close to gateway connection status:
    #Step 4
    #Click on the button
    Then I check the presence of DevicesDetailsPage.historyIcon Element and then i click it

    #Step 5
    #Verify if the graph component is correctly displayed and responsive (also check the mobile view)
    Then I check the presence of DevicesDetailsPage.pieChart
    Then I scroll to DevicesDetailsPage.barGraph
    Then I check the presence of DevicesDetailsPage.barGraph
    Then I scroll to DevicesDetailsPage.graphDetails
    Then I check the presence of DevicesDetailsPage.graphDetails

    #Mobile:
    #Then I set chrome "iPhone" mode
    #Then I check the presence of DevicesDetailsPage.pieChart
    #Then I scroll to DevicesDetailsPage.barGraph
    #Then I check the presence of DevicesDetailsPage.barGraph
    #Then I scroll to DevicesDetailsPage.graphDetails
    #Then I check the presence of DevicesDetailsPage.graphDetails

    #Tablet:
    #Then I set chrome "ipad Pro" mode
    #Then I scroll to DevicesDetailsPage.pieChart
    #Then I check the presence of DevicesDetailsPage.pieChart
    #Then I scroll to DevicesDetailsPage.barGraph
    #Then I check the presence of DevicesDetailsPage.barGraph
    #Then I scroll to DevicesDetailsPage.graphDetails
    #Then I check the presence of DevicesDetailsPage.graphDetails

    Then I click on the user icon and log out.