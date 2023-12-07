@Projects_menu_test_1.9
Feature: Projects Menu

  Background:

    #STEP 1 - Login and set Language english as default

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.9

    #STEP 2 - Check that the filter bar is on top of the page

    Then I check if filter box is on top
