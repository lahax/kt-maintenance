@Projects_menu_test_1.8
Feature: Projects Menu

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test_1.8

    #Step 1 - Login on DMC
    #Step 2 - Click on User Section, on the top of the page:
    And I click HomePage.infoUserLoggedIn

    #Step 3 - Go with the pointer on "Language" and choose a language:
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    #Step 4 - Check that the page is translated in the language chosed
    And I check that the Project Menu correctly translated