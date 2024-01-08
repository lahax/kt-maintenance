@Gateway_Test_7.42
Feature: Gateway

  Scenario: Test 7.42
    #https://confluence.springlab.enel.com/display/EXEGIPL/DMC+NRT+Test+Case+7.42
    #GOAL: Verify the correct functionality for new export in the gateway > Things Page.

    #STEP 1 - Login on DMC
      # Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #STEP 2 - Select the Device Page and on Devices Page choose a gateway on the list of Devices, then go on the Gateway Details Page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    #Step 3 - On the menu of the Gateway detail page, select Things and verify the new export button
    Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it
    And I check the presence of DevicesPage.downloadExportIcon

    # Logout step
    Then I click on the user icon and log out.