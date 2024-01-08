@Sidebar_menu_Test_4.3
Feature: Projects Menu

  Scenario: Test case 4.3

    #STEP 1 - Login and set Language english as default
    #STEP 2 - Click on User Section, on the top right of the page, near the notification bell
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon

    #STEP 3 - Go with the pointer on "Language" and choose a language
    #STEP 4 - Check that the Sidebar menu is translated in the language chosed IT
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    Then I click HomePage.hamburgerMenuIcon
    And I check that the Sidebar is correctly translated