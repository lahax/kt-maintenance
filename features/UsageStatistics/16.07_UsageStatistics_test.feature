@UsageStatistics_Test_16.7
Feature: UsageStatistics

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 16.7

    #Step 1
    #Access to DMC, select one project and open the sidemenu, then click on Usage Statistics (new menu item)
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.usageStatisticOption Element and then i click it
    And I check the presence of UsageStatisticsPage.usageStatisticsLandingPageTitle

    #Check translation of the page
    #Go with the pointer on "Language" and choose a language:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    #Check that the Page is translated in the language chosen
    And I check that the Usage Statistics page is correctly translated in italian