@Projects_menu_test_1.11
Feature: Projects Menu

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.11

      #Check that the logout works properly
    Then I click on the user icon and log out.
    Then I check the presence of LoginPage.loginBtn
