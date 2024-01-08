@UsageStatistics_Test_16.2
Feature: UsageStatistics

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 16.2

    #Step 1
    #Access to DMC, select one project and open the sidemenu, then click on Usage Statistics (new menu item)
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.usageStatisticOption Element and then i click it
    And I check the presence of UsageStatisticsPage.usageStatisticsLandingPageTitle

    #Step 2
    #Check if the UAM graph has 1) Impact section in the right side and 2) Equivalent Usage section in the left side:
    And I check the presence of UsageStatisticsPage.usageStatisticsGraph
    And I check the presence of UsageStatisticsPage.graphImpactSection
    And I check the presence of UsageStatisticsPage.graphEquivalentUsageSection

    #Ipad:
    And I set chrome "iPad pro" mode
    And I check the presence of UsageStatisticsPage.usageStatisticsGraph
    And I check the presence of UsageStatisticsPage.graphImpactSection
    And I check the presence of UsageStatisticsPage.graphEquivalentUsageSection

    Then I click on the user icon and log out.





