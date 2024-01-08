@Sidebar_menu_Test_4.2
Feature: Projects Menu

  Background:

    #STEP 1 - Login and set Language english as default

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 4.2

    #STEP 2 - After login, select one project.
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon

    # STEP 3 - Click on the sidebar button and verify the following visualization:
    #Desktop -----------------------------------START----------------------------------------------------
    And I click HomePage.hamburgerMenuIcon
    # Home;
    And I check the presence of SidebarPage.homeOption
    # Devices;
    And I check the presence of SidebarPage.devicesOption
    # Activities;
    And I check the presence of SidebarPage.activitiesOption
    # Diagnostic: Lambdas, Jobs, Mqtt client, Step function,
    And I check the presence of SidebarPage.diagnosticOption
    # Click on Diagnostic to open up all buttons
    Then I click SidebarPage.diagnosticDropDownOption
    And I check the presence of SidebarPage.lambdasSubOption
    And I check the presence of SidebarPage.mqttSubOption
    And I check the presence of SidebarPage.stepFunctionSubOption
    And I check the presence of SidebarPage.loadCertificateSubOption
    And I check the presence of SidebarPage.apiInvocationSubOption
    Then I click SidebarPage.diagnosticDropDownOption
    # Logs;
    And I check the presence of SidebarPage.logOption
    # Alarms;
    And I check the presence of SidebarPage.alarmsOption
    # Software Manager: Software Catalogue,Deployments History,Campaign Management
    And I check the presence of SidebarPage.softwareManagerOption
    Then I click SidebarPage.diagnosticDropDownOption
    And I check the presence of SidebarPage.softwareCatalogueOption
    And I check the presence of SidebarPage.deploymentsHistoryOption
    And I check the presence of SidebarPage.campaignManagementOption
    Then I click SidebarPage.diagnosticDropDownOption
    # Rule & Dispatch Engine;
    And I check the presence of SidebarPage.rdeOption
    # E2E Monitoring: Device Alarms Configurations, Notification Configurations, Custom Groups
    And I check the presence of SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.e2eMonitoringOption
    And I check the presence of SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of SidebarPage.notificationsConfigurationSubOption
    And I check the presence of SidebarPage.customGroupsSubOption
    Then I click SidebarPage.e2eMonitoringDropDownOption
    # Trend ID Registry
    And I check the presence of SidebarPage.trendIdRegistryOption
    # Ticket Management
    And I check the presence of SidebarPage.ticketsManagementOption
    And I click SidebarPage.backButtonSideBar
    Then I click on the user icon and log out.
    #Desktop -----------------------------------END----------------------------------------------------

    # Tablet mode:-----------------------------------START----------------------------------------------------
    #NOTA: In test case description tablet mode not specified. If we use width = 768 height = 1024 aka tablet or Ipad mode
      # the window shrinks and sections hide like phone mode. So I use ipad Pro, which is in line with test description screenshot
    #Then I set chrome 'iPad Pro' mode

    #STEP 2 - After login, select one project.
    #Then I enter on "esol-ap29551-qa" project
    #Then I check the presence of HomePage.hamburgerMenuIcon

    # STEP 3 - Click on the sidebar button and verify the following visualization:
    #And I click HomePage.hamburgerMenuIcon
    # Home;
    #And I check the presence of SidebarPage.homeOption
    # Devices;
    #And I check the presence of SidebarPage.devicesOption
    # Activities;
    #And I check the presence of SidebarPage.activitiesOption
    # Diagnostic: Lambdas, Mqtt client, Step function, Load Certificate, Api Invocation
    #And I check the presence of SidebarPage.diagnosticOption
    #Then I click SidebarPage.diagnosticDropDownOption
    #And I check the presence of SidebarPage.lambdasSubOption
    #And I check the presence of SidebarPage.mqttSubOption
    #And I check the presence of SidebarPage.stepFunctionSubOption
    #And I check the presence of SidebarPage.loadCertificateSubOption
    #And I check the presence of SidebarPage.apiInvocationSubOption
    #Then I click SidebarPage.diagnosticDropDownOption
    # Logs;
    #And I check the presence of SidebarPage.logOption
    # Alarms;
    #And I check the presence of SidebarPage.alarmsOption
    # Software Manager: Software Catalogue,Deployments History,Campaign Management
    #And I check the presence of SidebarPage.softwareManagerOption
    #Then I click SidebarPage.softwareManagerDropDownOption
    #And I check the presence of SidebarPage.softwareCatalogueOption
    #And I check the presence of SidebarPage.deploymentsHistoryOption
    #And I check the presence of SidebarPage.campaignManagementOption
    #Then I click SidebarPage.softwareManagerDropDownOption
    # Rule & Dispatch Engine;
    #And I check the presence of SidebarPage.rdeOption
    # E2E Monitoring: Device Alarms Configurations, Notification Configurations, Custom Groups
    #And I check the presence of SidebarPage.e2eMonitoringOption
    #Then I click SidebarPage.e2eMonitoringDropDownOption
    #And I check the presence of SidebarPage.deviceAlarmsConfigurationSubOption
    #And I check the presence of SidebarPage.notificationsConfigurationSubOption
    #And I check the presence of SidebarPage.customGroupsSubOption
    #Then I click SidebarPage.e2eMonitoringDropDownOption
    # Usage Statistics
    #And I check the presence of SidebarPage.usageStatisticOption
    # Ticket Management
    #And I check the presence of SidebarPage.ticketsManagementOption
    # Tablet mode:-----------------------------------END----------------------------------------------------

    # Phone mode:-----------------------------------START----------------------------------------------------
    #And I click SidebarPage.backButtonSideBar
    #Then I click ProjectPage.buttonToReturnHomePage

    #Then I set chrome 'iPhone' mode

    #STEP 2 - After login, select one project.
    #Then I enter on "esol-ap29551-qa" project
    #Then I check the presence of HomePage.hamburgerMenuIcon

    # STEP 3 - Click on the sidebar button and verify the following visualization:
    #And I click HomePage.hamburgerMenuIcon
    # Home
    #And I check the presence of SidebarPage.homeOption
    # Devices
    #And I check the presence of SidebarPage.devicesOption
    # Activities
    #And I check the presence of SidebarPage.activitiesOption
    #And I check the presence of SidebarPage.diagnosticOption
    # Clic on Diagnostic to open up all buttons
    #Then I click SidebarPage.diagnosticOption
    #And I check the presence of SidebarPage.mqttSubOption

    # Software Manager: Software Catalogue,Deployments History,Campaign Management
    #And I check the presence of SidebarPage.softwareManagerOption
    #Then I click SidebarPage.softwareManagerOption
    #And I check the presence of SidebarPage.softwareCatalogueOption
    # Phone mode:-----------------------------------END----------------------------------------------------