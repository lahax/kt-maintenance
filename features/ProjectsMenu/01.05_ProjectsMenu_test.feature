@Projects_menu_test_1.5
Feature: Projects Menu

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.5
    #STEP 2
    #After the login verify that you can choose more than a project:
    Then I scroll to HomePage.lastProject
    Then I select all the projects and then I check presence of these at the top of the page
    #Step 3
    And I check the presence of HomePage.multipleWhiteBar



