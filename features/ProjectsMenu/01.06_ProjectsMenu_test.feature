@Projects_menu_test_1.6
Feature: Projects Menu

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.6

    #Step 2
    #Select a project and select enter, click on the project button:
    Then I enter on "esol-ap29551-qa" project
    And I click ProjectPage.iconChooseProject

    #Step 3
    #Verify if by clicking on the "back" button you are redirected to the previous page:
    Then I click HomePage.backBTN
    Then I check I'm on the Project Page again