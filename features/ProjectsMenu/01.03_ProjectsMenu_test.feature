@Projects_menu_test_1.3
Feature: Projects Menu
#GOAL: It will be possibile to press the "Confirm" and "clear" button.
  Background:

    #STEP 1 - Login to DMC
      # and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.3
    #STEP 2 - Check the presence of the Confirm and Clear button:
    Then If enter or clear button not present i click on a project
    Then I check the presence of HomePage.clearBTN
    Then I check the presence of HomePage.enterBTN
    #STEP 3 - Verify that you can clear the previous selection project by pressing the "clear" button.
    Then I control Enter and if Clear Button works