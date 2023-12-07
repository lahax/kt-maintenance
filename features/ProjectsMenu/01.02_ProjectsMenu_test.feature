@Projects_menu_test_1.2
Feature: Projects Menu
#GOAL: The bar is filled with project names previously selected.
  Background:

    #STEP 1 - Login to DMC
      # Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.2

    #STEP 2 - I click on one project
    And I click HomePage.firstCardProject
    #STEP 3 - On top of the page, there is the "Select one or more projects" section. Check that the bar is filled with project names:
    Then I check bar is filled with project name