@Gateway_Test_7.36
Feature: Gateway

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 7.36
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Clicking on details button, it will show the direct thing detail.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait the progress bar
        #Step 3
    #3a. Click on "gateway detail" in actions column:
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #STEP 4 - Check that it is translated in the language chosed IT
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    Then I check that the Gateway details page is correctly translated