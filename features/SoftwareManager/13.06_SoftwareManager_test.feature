@Software_manager_Test_13.6
Feature: Software Manager
#GOAL: In Deployment history page the table has the correct columns.
  Background:
    # STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.6

    Then I enter on "esol-ap29551-qa" project
    # STEP 2 - Access to DMC, open sidemenu then click on Software Manager and click on Deployment History submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    # STEP 3 - Check that the table has 11 columns:Device ID, Thing ID, Device Type, Software type, Deploy Type, Start, Duration, Software Version, Latest, Status and Actions.
    Then I check the presence of DeploymentsHistoryPage.deviceIdColumnHeader
    Then I check the presence of DeploymentsHistoryPage.thingIdColumnHeader
    Then I check the presence of DeploymentsHistoryPage.deviceTypeColumnHeader
    Then I check the presence of DeploymentsHistoryPage.softwareTypeColumnHeader
    Then I check the presence of DeploymentsHistoryPage.deployTypeColumnHeader
    Then I check the presence of DeploymentsHistoryPage.startColumnHeader
    Then I check the presence of DeploymentsHistoryPage.durationColumnHeader
    Then I check the presence of DeploymentsHistoryPage.softwareVersionColumnHeader
    Then I check the presence of DeploymentsHistoryPage.latestColumnHeader
    Then I check the presence of DeploymentsHistoryPage.statusColumnHeader
    Then I check the presence of DeploymentsHistoryPage.actionColumnHeader
    # STEP 4 - Click on the detail button to retrieve the detailed page for the specific deployment and check the information shown are as expected
    Then I check the presence of DeploymentsHistoryPage.detailBtn Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentDetailsPageTitle
    Then I check the presence of DeploymentsHistoryPage.deploymentStatusBannerOnDeploymentDetails
    Then I check the presence of DeploymentsHistoryPage.latestVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.deployTypeVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.softwareTypeVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.deviceIdVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.durationVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.environmentPrefixVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.currentStackVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.packagesInstallOutcomeVoiceOnDetailPage
    Then I check the presence of DeploymentsHistoryPage.customStatusVoiceOnDetailPage
    And I click DeploymentsHistoryPage.backBtn
  #STEP 5 - For each column in the table the has an information panel (Software type, Deploy type, Start, Duration, Software Version, Latest, Status), click on the "i" icon and verify that information is displayed as follows
    #Software Type
    Then I check the presence of DeploymentsHistoryPage.softwareTypeTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.softwareTypeTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.softwareTypeTooltipText
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
    #Deploy Type
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGatewaySoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGreengrassSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGreengrassDeployment
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextDirectThingSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGatewayThingSoftware
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
    #Start
    Then I check the presence of DeploymentsHistoryPage.startTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.startTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.startTooltipText
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
  #Duration
    Then I check the presence of DeploymentsHistoryPage.durationTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.durationTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.durationTooltipText
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
  #Software Version
    Then I check the presence of DeploymentsHistoryPage.softwareVersionTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.softwareVersionTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.softwareVersionTooltipText
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
  #Latest
    Then I check the presence of DeploymentsHistoryPage.latestTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.latestTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.latestTooltipText
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it
  #Status
    Then I check the presence of DeploymentsHistoryPage.statusTooltipIcon Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.statusDeployTypeListTitle
    Then I check the presence of DeploymentsHistoryPage.deployTypeGreengrassSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeGreengrassDeployment
    Then I check the presence of DeploymentsHistoryPage.deployTypeGatewaySoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeDirectThingSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeGatewayThingSoftware
    Then I check the presence of DeploymentsHistoryPage.statusStatusListTitle
    Then I check the presence of DeploymentsHistoryPage.statusTimeout
    Then I check the presence of DeploymentsHistoryPage.statusCompleted
    Then I check the presence of DeploymentsHistoryPage.statusInProgress
    Then I check the presence of DeploymentsHistoryPage.statusFailed
    Then I check the presence of DeploymentsHistoryPage.statusPartial
    Then I check the presence of DeploymentsHistoryPage.closeTooltipButton Element and then i click it