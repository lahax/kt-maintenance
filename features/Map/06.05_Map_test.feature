@Map_Test_6.5
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 6.5

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.devicesOption Element and then i click it
    Then I check the presence of DevicesMapPage.tabCountry Element and then i click it

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption

    #Step 3
    When I click HomePage.buttonItalianoSubOption

    #Step 4
    Then I check that the Map page is correctly translated in italiano

