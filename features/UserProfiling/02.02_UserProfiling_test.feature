@User_Profiling_Test_2.2
Feature: User Profiling

  Background:

    #Step 1
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 2.2
    #STEP 2
    #Ensure that the two projects are listed and can be selected.
    Then I check the presence of HomePage.projectEsolPerf
    Then I check the presence of HomePage.projectEsolTest
    #Step 3
    #Check that for both projects you can access the landing-page and the other pages of the app.
    #Entro nel progetto esol test che ha tutti gli accessi e controllo la landing page
    #Then I enter on esol - test project
    Then I enter on "esol-ap29551-test" project
    Then I check the presence of ProjectPage.devicePreviewTitleSection

    #Per ogni sezione controllo la landing page

    #Devices
    And I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.devicesLandingPageTitle

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.iconDetailsFirstRow Element and then i click it
    Then I check the presence of DevicesPage.titleDeviceDetailsPage
    Then I check the presence of DevicesPage.mapDeviceDetailsPage
    Then I check the presence of DevicesPage.labelSystemCommandsDeviceDetailsPage
#    # Activities;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.activitiesOption
#    Then I check the presence of ActivitiesPage.activitiesLandingPageTitle
#
#    # Diagnostic:
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.diagnosticOption
#     # Lambda
#    And I click SidebarPage.lambdasSubOption
#    Then I check the presence of LambdasPage.lambdaLandingPageTitle
#    # Mqtt Client,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.mqttSubOption
#    Then I check the presence of MqttClientPage.mqttClientLandingPageTitle
#
#    # Step Function,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.stepFunctionSubOption
#    Then I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
#
#    # Load Certificate,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.loadCertificateSubOption
#    Then I check the presence of LoadCertificatePage.loadCertificateLandingPageTitle
#
#    # Api Invocation
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.apiInvocationSubOption
#    Then I check the presence of APIInvocationPage.apiInvocationLandingPageTitle
#
#    # Logs;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.logOption
#    Then I check the presence of LogPage.logsLandingPageTitle
#
#     # Alarms;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.alarmsOption
#    Then I check the presence of AlarmsPage.alarmsLandingPageTitle
#
#    # Software Manager
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.softwareManagerOption
#
#    #Software Catalogue
#    And I click SidebarPage.softwareCatalogueOption
#    Then I check the presence of SoftwareCataloguePage.sofwareCatalogueLandingPageTitle
#
#    #Deployments History
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.deploymentsHistoryOption
#    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
#
#    #Campaign Management
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.campaignManagementOption
#    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
#
#    # Rule & Dispatch Engine;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.rdeOption
#    Then I check the presence of RDEPage.rdeLandingPageTitle
#
#    # E2E Monitoring:
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.e2eMonitoringOption
#
#    # Device Alarms Configurations
#    And I click SidebarPage.deviceAlarmsConfigurationSubOption
#    Then I check the presence of DeviceAlarmsConfigurationPage.deviceAlarmsConfigurationPageTitle
#
#    #Notification Configurations
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.notificationsConfigurationSubOption
#    Then I check the presence of NotificationsConfigurationsPage.notificationsConfigurationsPageTitleENG
#
#     # Custom Groups
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.customGroupsSubOption
#    Then I check the presence of CustomGroupsPage.customGroupsPageTitle
#
#    # Usage Statistics
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.usageStatisticOption
#    Then I check the presence of UsageStatisticsPage.usageStatisticsLandingPageTitle
#
#    # Ticket Management
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.ticketsManagementOption
#    Then I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle

#--------------------------------------------------------------------------------------------
    #Then I come back to HomePage from the project page
    Then I click ProjectPage.logoEnel
#--------------------------------------------------------------------------------------------

    #Entro nel progetto esol Perf e controllo le landing page solo delle seziona a cui ha accesso
    #Then I enter on esol - perf project
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of ProjectPage.devicePreviewTitleSection

    #Per ogni sezione controllo la landing page

    #Devices
    And I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.devicesLandingPageTitle
    Then I check the presence of DevicesPage.iconDetailsFirstRow Element and then i click it
    Then I check the presence of DevicesPage.titleDeviceDetailsPage
    Then I check the presence of DevicesPage.mapDeviceDetailsPage
    Then I check the presence of DevicesPage.labelSystemCommandsDeviceDetailsPage

#    # Activities;
#
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.activitiesOption
#    Then I check the presence of ActivitiesPage.activitiesLandingPageTitle
#
#    # Diagnostic:
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.diagnosticOption
#     # Lambda
#    And I click SidebarPage.lambdasSubOption
#    Then I check the presence of LambdasPage.lambdaLandingPageTitle
#    # Mqtt Client,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.mqttSubOption
#    Then I check the presence of MqttClientPage.mqttClientLandingPageTitle
#
#    # Step Function,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.stepFunctionSubOption
#    Then I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
#
#    # Load Certificate,
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.loadCertificateSubOption
#    Then I check the presence of LoadCertificatePage.loadCertificateLandingPageTitle
#
#    # Api Invocation
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.apiInvocationSubOption
#    Then I check the presence of APIInvocationPage.apiInvocationLandingPageTitle
#
#    # Logs;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.logOption
#    Then I check the presence of LogPage.logsLandingPageTitle
#
#     # Alarms;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.alarmsOption
#    Then I check the presence of AlarmsPage.alarmsLandingPageTitle
#
#    # Software Manager
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.softwareManagerOption
#
#    #Software Catalogue
#    And I click SidebarPage.softwareCatalogueOption
#    Then I check the presence of SoftwareCataloguePage.sofwareCatalogueLandingPageTitle
#
#    #Deployments History
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.deploymentsHistoryOption
#    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
#
#    #Campaign Management
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.campaignManagementOption
#    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
#
#    # Rule & Dispatch Engine;
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.rdeOption
#    Then I check the presence of RDEPage.rdeLandingPageTitle
#
#    # E2E Monitoring:
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.e2eMonitoringOption
#
#    # Device Alarms Configurations
#    And I click SidebarPage.deviceAlarmsConfigurationSubOption
#    Then I check the presence of DeviceAlarmsConfigurationPage.deviceAlarmsConfigurationPageTitle
#
#    #Notification Configurations
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.notificationsConfigurationSubOption
#    Then I check the presence of NotificationsConfigurationsPage.notificationsConfigurationsPageTitleENG
#
#     # Custom Groups - Issue with perf - doesnt have access custom groups
#    # And I click HomePage.hamburgerMenuIcon
#    # And I click SidebarPage.customGroupsSubOption
#    # Then I check the presence of CustomGroupsPage.customGroupsPageTitle
#
#    # Usage Statistics
#    And I click HomePage.hamburgerMenuIcon
#    And I click SidebarPage.usageStatisticOption
#    Then I check the presence of UsageStatisticsPage.usageStatisticsLandingPageTitle

    # Ticket Management Issue with perf - doesnt have access tickets management
      # I click HomePage.hamburgerMenuIcon
      # And I click SidebarPage.ticketsManagementOption
      # Then I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle