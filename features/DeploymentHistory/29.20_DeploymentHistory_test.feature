@29.20_DeploymentHistory_test
Feature: Deployment History
  #https://jira.springlab.enel.com/browse/EXEGIP2-1273

  #Goal:The functionality of new Software Version filter with more than one project selected works as by design





  Background:
    #1a. Login on the DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.20

    Then I check the presence of the project "esol-ap29551-qa" and then i click it
    Then I check the presence of the project "esol-ap29551-test" and then i click it
    Then I check the presence of HomePage.multipleWhiteBar
    Then I click HomePage.enterBTN
    And I wait the progress bar

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.filterBox Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput Element and then i click it
    And I check the presence of DevicesPage.esol_ap29551_testSoftware
    And I check the presence of DevicesPage.esol_ap29551_qaSoftware

    Then I click on the user icon and log out.