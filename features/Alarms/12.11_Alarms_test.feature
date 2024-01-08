@Alarms_Test_12.11
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.11

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    Then I check the presence of HomePage.infoUserLoggedIn Element and then i click it
    Then I check the presence of HomePage.languageSubOption Element and then i click it
    Then I check the presence of HomePage.buttonItalianoSubOption Element and then i click it

    Then I check that the Alarm Page is correctly translated in Italiano

