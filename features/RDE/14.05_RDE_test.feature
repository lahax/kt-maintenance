@RDE_Test_14.5
Feature: RDE

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 14.5

    #STEP 1 - Login on DMC and go in RDE page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption

    #Step 3
    #Go with the pointer on "Language" and choose a language:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    #Step 4
    #Check that the RDE Page is translated in the language chosed
    And I check that the RDE page is correctly translated in italian

    And I click on the user icon and log out.