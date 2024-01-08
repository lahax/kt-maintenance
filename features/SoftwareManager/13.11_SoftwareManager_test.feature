@Software_manager_Test_13.11
Feature: Software Manager
#GOAL: In Gateways Campaign Management page the table has the correct columns.
  # STEP 1 - Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.11

    Then I enter on "esol-ap29551-qa" project

    # STEP 2 - Access to DMC, open sidemenu then click on Software Manager
      # and click on Gateways Campaign Management submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle

    # STEP 3 - Check that the page presents a table with 4 columns:
    #ALL, Device ID, Device Software type and Software Version.
    Then I check the presence of CampaignManagementPage.allSelectorColumnHeader
    Then I check the presence of CampaignManagementPage.deviceIdColumnHeader
    Then I check the presence of CampaignManagementPage.deviceTypeColumnHeader
  #TODO 4 COL - Click on the tooltip "i" icon next to the columns Device Software Type and Software Version and check that the popup windows are displayed as shown:
    #https://confluence.springlab.enel.com/display/EXEGIPL/DMC+NRT+Test+Case+13.11
    # TODO 2 TOOLTIP
    # STEP 5 Click on the details button to retrieve a deployment detailed page and check the information shown are as expected
    #TODO CONTROLLARE SE CI SONO TUTTI GLI ELEMENTI
    Then I check the presence of CampaignManagementPage.detailBtn Element and then i click it
    Then I check the presence of CampaignManagementPage.deploymentDetailPageTitle
#    Then I check the presence of CampaignManagementPage.latestVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.deployTypeVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.softwareTypeVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.deviceIdVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.durationVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.environmentPrefixVoiceDeploymentDetailPage
#    Then I check the presence of CampaignManagementPage.installedPackagesVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.currentStackVoiceDeploymentDetailPage
    Then I check the presence of CampaignManagementPage.packagesInstallOutcomeVoiceOnDetailPage