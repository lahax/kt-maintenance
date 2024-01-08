@User_Profiling_Test_2.1
Feature: User Profiling

  Scenario: Test case 2.1

    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project
    # Click on menu button
    #and check that the only the Home and Devices items are clickable, the other sections are disabled.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.homeOption is active.
    Then I check that the element SidebarPage.devicesOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is not active.
    Then I check that the element SidebarPage.activitiesOption is not active.
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    #Then I check that the element SidebarPage.diagnosticOption is not active.
    Then I check that the element SidebarPage.lambdasSubOption is not active.
    Then I check that the element SidebarPage.mqttSubOptionEntry is not active.
    Then I check that the element SidebarPage.stepFunctionSubOption is not active.
    Then I check that the element SidebarPage.loadCertificateSubOption is not active.
    Then I check that the element SidebarPage.apiInvocationSubOption is not active.
    Then I check that the element SidebarPage.logOption is not active.
    Then I check that the element SidebarPage.activitiesOption is not active.
    Then I check that the element SidebarPage.alarmsOption is not active.
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    #Then I check that the element SidebarPage.softwareManagerOption is not active.
    Then I check that the element SidebarPage.softwareCatalogueOption is not active.
    Then I check that the element SidebarPage.deploymentsHistoryOption is not active.
    Then I check that the element SidebarPage.campaignManagementOption is not active.
    Then I check that the element SidebarPage.rdeOption is not active.
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    #Then I check that the element SidebarPage.e2eMonitoringOption is not active.
    Then I check that the element SidebarPage.deviceAlarmsConfigurationSubOption is not active.
    Then I check that the element SidebarPage.notificationsConfigurationSubOption is not active.
    Then I check that the element SidebarPage.customGroupsSubOption is not active.
    #Then I check that the element SidebarPage.usageStatisticOption is not active.
    Then I check that the element SidebarPage.trendIdRegistryOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is not active.
    Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    Then I click on the user icon and log out.

    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I check the presence of LoginPage.loginBtn Element and then i click it
    Then I perform login as "basic_CompacF_false" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project
    # Click on menu button
    #and check that the only the Home and Devices items are clickable, the other sections are disabled.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.homeOption is active.
    Then I check that the element SidebarPage.devicesOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is active.
    Then I check that the element SidebarPage.activitiesOption is active.
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    #Then I check that the element SidebarPage.diagnosticOption is not active.
    Then I check that the element SidebarPage.lambdasSubOption is active.
    Then I check that the element SidebarPage.mqttSubOptionEntry is active.
    Then I check that the element SidebarPage.stepFunctionSubOption is active.
    Then I check that the element SidebarPage.loadCertificateSubOption is active.
    Then I check that the element SidebarPage.apiInvocationSubOption is active.
    Then I check that the element SidebarPage.logOption is active.
    Then I check that the element SidebarPage.activitiesOption is active.
    Then I check that the element SidebarPage.alarmsOption is active.
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    #Then I check that the element SidebarPage.softwareManagerOption is not active.
    Then I check that the element SidebarPage.softwareCatalogueOption is active.
    Then I check that the element SidebarPage.deploymentsHistoryOption is active.
    Then I check that the element SidebarPage.campaignManagementOption is active.
    Then I check that the element SidebarPage.rdeOption is active.
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    #Then I check that the element SidebarPage.e2eMonitoringOption is not active.
    Then I check that the element SidebarPage.deviceAlarmsConfigurationSubOption is active.
    Then I check that the element SidebarPage.notificationsConfigurationSubOption is active.
    Then I check that the element SidebarPage.customGroupsSubOption is active.
    #Then I check that the element SidebarPage.usageStatisticOption is active.
    Then I check that the element SidebarPage.trendIdRegistryOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is active.