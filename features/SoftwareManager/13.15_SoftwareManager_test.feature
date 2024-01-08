@Software_manager_Test_13.15
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

  Scenario: Software_manager_Test_13.15

    Then I enter on "esol-ap29551-qa" project

    # STEP 2 Access to DMC, open sidemenu then click on Software Manager
      # and click on Gateways Campaign Management submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it

    And I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    Then I check the presence of SoftwareCataloguePage.infoUserLoggedIn Element and then i click it
    Then I check the presence of SoftwareCataloguePage.languageSubOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.buttonItalianoSubOption Element and then i click it

    And I check that the Software Catalogue is correctly translated in italian

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOptionIT Element and then i click it
    And I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitleIT
    Then I check that the Deployment History Page is correctly translated in italian

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOptionIT Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitleIT

    Then I check that the Campaign Management Page is correctly translated in italian


    #LOGOUT
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption
    Then I click on the user icon and log out.
    #Then I check the presence of LoginPage.loginBtn







