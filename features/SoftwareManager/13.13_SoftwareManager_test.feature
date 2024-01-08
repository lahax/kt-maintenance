@Software_manager_Test_13.13
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

  Scenario: Software_manager_Test_13.13

    Then I enter on "esol-ap29551-qa" project

    ## STEP 2  Access to DMC, open sidemenu then click on Software Manager
      # and click on Gateways Campaign Management submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle

    ## STEP 3 - Check that in the top right of the page there is a refresh button:
    #Then I check the presence of CampaignManagementPage.refreshBtn
    Then I check that the refresh button works properly in the Campaign Management page