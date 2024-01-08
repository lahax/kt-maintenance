@Industry_Test_28.1
Feature: Industry
#GOAL: Verify the presence of the new SERIAL column in Things table and the functionality of the search bar by SERIAL NUMBER.
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.1
    #Go on Devices page and choose a Thing.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it

    Then I check the presence of ThingsPage.titleSectionThings

    #2a On Things tab verify the addition of the new Serial column.
    Then I check the presence of ThingsPage.thingIDColumn
    Then I check the presence of ThingsPage.softwareTypeColumn
    Then I check the presence of ThingsPage.serialColumn
    Then I check the presence of ThingsPage.typeColumn
    Then I check the presence of ThingsPage.modelColumn
    Then I check the presence of ThingsPage.certificateColumn
    Then I check the presence of ThingsPage.aliasColumn
    Then I check the presence of ThingsPage.statusColumn
    Then I check the presence of ThingsPage.manageColumn

    #2b. Also verify the correct functionality of the search bar:
    #It's possible to search by ID, Serial Number and Alias
    Then I check the presence of ThingsPage.searchbox
    #by Thing ID
    And I type "Test_Concept-01_thing1" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.testConcept01thing1

    #by Software Thing Type
    And I clear the search Box in the Device Page
    And I type "THING_GENERIC" into the element ThingsPage.searchbox
    And I wait the progress bar
    And I check the absence of ThingsPage.things

    #by Serial Number
    And I clear the search Box in the Device Page
    And I type "12345" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.testConcept01thing1

    #by Type
    And I clear the search Box in the Device Page
    And I type "mqtts" into the element ThingsPage.searchbox
    And I wait the progress bar
    And I check the absence of ThingsPage.things

    #by Model
    And I clear the search Box in the Device Page
    And I type "emulate_modbus" into the element ThingsPage.searchbox
    And I wait the progress bar
    And I check the absence of ThingsPage.things

    #by Certificate
    And I clear the search Box in the Device Page
    And I type "2024" into the element ThingsPage.searchbox
    And I wait the progress bar
    And I check the absence of ThingsPage.things

    #by Alias
    And I clear the search Box in the Device Page
    And I type "Test" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.testConcept01thing1

    #by Status
    And I clear the search Box in the Device Page
    And I type "disconnected" into the element ThingsPage.searchbox
    And I wait the progress bar
    And I check the absence of ThingsPage.things

    And I click on the user icon and log out.