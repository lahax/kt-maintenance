@Projects_menu_test_1.7
Feature: Projects Menu

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.7
    #Step 2
    #The user can choose his own favorities by assign them:
    #Selecting a particular project, control that if it is set as favourite the card moves above a divider.
    Then I check that the favourites option moves the Project card correctly.

    #Step 3
    #Verify that the selected projects are shown above the others.
    #Tablet:
    #Then I set chrome "iPhone" mode
    #And I check that the favourites option moves the Project card correctly.
    #Mobile:
    #Then I set chrome "iPad pro" mode
    #And I check that the favourites option moves the Project card correctly.