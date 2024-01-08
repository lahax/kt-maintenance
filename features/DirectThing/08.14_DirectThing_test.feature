@DirectThing_Test_8.14
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.14
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Clicking on details button, it will show the direct thing detail.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    #Step 3
    #3a. Click on "direct thing detail" in actions column:
    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #STEP 4 - Check that it is translated in the language chosed IT
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    Then I check that the Direct Thing details page is correctly translated