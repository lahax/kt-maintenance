@UsageStatistics_Test_16.4
Feature: UsageStatistics

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 16.4

    #Step 1
    #Access to DMC, select one project and open the sidemenu, then click on Usage Statistics (new menu item)
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.usageStatisticOption Element and then i click it

   #Step 2
   #In the bottom left of the graph select a date and verify if data are correctly shown:
   And I check the presence of UsageStatisticsPage.usageStatisticsLandingPageTitle
   Then I check the presence of UsageStatisticsPage.buttonSixMonth Element and then i click it
   And I check if the graph show "6" month as expected

   Then I check the presence of UsageStatisticsPage.buttonThreeMonth Element and then i click it
   And I check if the graph show "3" month as expected


   Then I click on the user icon and log out.