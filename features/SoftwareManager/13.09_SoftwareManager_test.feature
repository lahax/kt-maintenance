@Software_manager_Test_13.9
Feature: Software Manager

  # Step 1
  # Login on DMC
  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.9

    Then I enter on "esol-ap29551-qa" project

    ## STEP 2Access to DMC, open sidemenu then click on Software Manager
      # and click on Deployment History submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    And I save the name of the first record


    ## STEP 3 Click on "custom query" and check if
      # you are able to filter by a costumquery:
    Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it
    And I input the custom query into CampaignManagementView.firstRowIntTextarea
    Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    And I check if filter for "Custom Query"
