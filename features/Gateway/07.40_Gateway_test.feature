@Gateway_Test_7.40
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
    #Check if is possible to search and the refresh the things list.

  Scenario: Test 7.40
    #PROCEDURE
    #Step 1
    #Login on DMC

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon


    #Step 2
    #Access to Devices  Section then select a Gateway, enter the detail section then go the things list
    Then I click SidebarPage.devicesOption
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it


    #Step 3
    #Verify that in the top right there is a search bar and try the functionality:
    Then I check the presence of DevicesDetailsPage.searchThingLabel Element and then i click it
    Then I check for at least one row into the table on ThingListPage
    Then I type random source in Source SearchBox on ThingListPage
    Then I check that all row contains the source searched previously on ThingListPage

    #Step 4
    #Click on the floating button in bottom right and then select "refresh". Verify that it works properly:
     Then I check that the refresh button works properly in the device details page
