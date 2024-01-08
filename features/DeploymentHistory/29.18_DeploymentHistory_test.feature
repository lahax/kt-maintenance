@29.18_DeploymentHistory_test
Feature: Deployment History
  #https://jira.springlab.enel.com/browse/EXEGIP2-1271

  #Goal:All section of Deployment History page are correctly translated in Italian





  Background:
    #1a. Login on the DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.18

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerOption
    Then I click SidebarPage.deploymentsHistoryOption

    #2a. Click on User Section, on the top right of the page, near the notification bell:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    # Deployment History tab and page are correctly translated in Italian.
    And I check that the Deployment History Page is correctly translated in italian

    #Logout
    Then I click on the user icon and log out.