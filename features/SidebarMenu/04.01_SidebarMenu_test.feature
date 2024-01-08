@Sidebar_menu_Test_4.1
Feature: Projects Menu

  Background:

    #STEP 1 - Login and set Language english as default

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 4.1

    #STEP 2 - After login, select one project.
    Then I enter on "esol-ap29551-qa" project

    # STEP 3 - Click on the sidebar button on the top left of the page:
    Then I check the presence of HomePage.hamburgerMenuIcon
    And I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.backButtonSideBar
    Then I click on the user icon and log out.

    # Tablet mode:
    #Then I set chrome 'tablet' mode
    #Then I enter on "esol-ap29551-qa" project
    #Then I check the presence of HomePage.hamburgerMenuIcon
    #And I click HomePage.hamburgerMenuIcon
    #And I click SidebarPage.backButtonSideBar
    #Then I click ProjectPage.buttonToReturnHomePage

    # Smartphone Mode
    #Then I set chrome "iPhone" mode
    #Then I wait 5 seconds
    #Then I enter on "esol-ap29551-qa" project
    #Then I check the presence of HomePage.hamburgerMenuIcon
    #And I click HomePage.hamburgerMenuIcon