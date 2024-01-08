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
    And I wait 15 seconds

    #Step 4
    Then If the rule for "Test_Concept-04" is present I delete it

    And I click on the user icon and log out.