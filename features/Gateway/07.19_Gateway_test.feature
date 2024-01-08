@Gateway_Test_7.19
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
    #Verify that the minimum time range is 1 day

  Scenario: Test 7.19
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #Go to device page and select a gateway
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #Step 4
    #Click on Firmware Update:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it

    #Step 5
    #Check the possibility to add/remove packages clicking on the "Add new package" and "delete" buttons".
    Then I check the presence of DevicesDetailsPage.trashIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.addNewPackageBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.appNameForm
    Then I check the presence of DevicesDetailsPage.versionForm