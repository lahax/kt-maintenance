@Logs_Test_11.12
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.12

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    Then I check the presence of HomePage.infoUserLoggedIn Element and then i click it
    Then I check the presence of HomePage.languageSubOption Element and then i click it
    Then I check the presence of HomePage.buttonItalianoSubOption Element and then i click it

    Then I check that the Log page is correcty translated in Italiano
