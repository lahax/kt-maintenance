@29.16_DeploymentHistory_test
Feature: Deployment History
  #https://jira.springlab.enel.com/browse/EXEGIP2-1268

  #Goal:The only Info icons (tooltip) present in DH detail page are for Custom Status, Packages To Install, Installed Packages and Current Stack fields.





  Background:
    #1a. Login on the DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.16

    # STEP 2
    #2a. Click on Sidebar and then on Software Manager -> Deployment History
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerOption
    Then I click SidebarPage.deploymentsHistoryOption
    And I wait the progress bar
    #2a. Click on detail button of any deployment record
    Then I check the presence of DeploymentsHistoryPage.detailBtn Element and then i click it
    #2b. Verify there are no Info icons (tooltip) in this page (already present in the table), expect for Custom Status, Installation outcome and Current Stack:
    Then I check for info icon others than expected
    #2c. Also verify the description of each tootlip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.customStatusTP Element and then i click it
    Then I check information in Deployment Details tab "Custom Status" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.packageInOutcomeTP Element and then i click it
    Then I check information in Deployment Details tab "Packages Installations Outcome" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.currentStackTP Element and then i click it
    Then I check information in Deployment Details tab "Current Stack" tooltip

    #Logout
    Then I click on the user icon and log out.