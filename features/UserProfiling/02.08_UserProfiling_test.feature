@User_Profiling_Test_2.8
Feature: User Profiling

  Scenario: Test case 2.8

        #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
     # Access to DCM with a user which has different roles for at least two projects,
    # here we assume the user has the Basic role for a project and the Admin role for another.
    #---------------------------------------------------------------- Step 2
    # #Choose the project with the Basic role, check that only the Basic role pages and functionalities are accessible,
      # e.g. only the Home and Devices items are available in the sidebar menu:
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.homeOption is active.
    Then I check that the element SidebarPage.devicesOption is active.
    Then I check that the element SidebarPage.activitiesOption is not active.
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    #Then I check that the element SidebarPage.diagnosticOption is not active.
    Then I check that the element SidebarPage.lambdasSubOption is not active.
    Then I check that the element SidebarPage.mqttSubOptionEntry is not active.
    Then I check that the element SidebarPage.stepFunctionSubOption is not active.
    Then I check that the element SidebarPage.loadCertificateSubOption is not active.
    Then I check that the element SidebarPage.apiInvocationSubOption is not active.
    Then I check that the element SidebarPage.logOption is not active.
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
    Then I check that the element SidebarPage.trendIdRegistryOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is not active.
    Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    Then I click on the user icon and log out.

    #---------------------------------------------------------------- Step 3
    #Then change the selected project by choosing the project with the Admin role, check that all functionalities are accessible,
    # e.g. all items are available in the sidebar menu:
        #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.homeOption is active.
    Then I check that the element SidebarPage.devicesOption is active.
    Then I check that the element SidebarPage.ticketsManagementOption is active.
    Then I check that the element SidebarPage.activitiesOption is active.
    Then I check that the element SidebarPage.diagnosticOption is active.
    Then I check that the element SidebarPage.logOption is active.
    Then I check that the element SidebarPage.activitiesOption is active.
    Then I check that the element SidebarPage.alarmsOption is active.
    Then I check that the element SidebarPage.softwareManagerOption is active.
    Then I check that the element SidebarPage.rdeOption is active.
    Then I check that the element SidebarPage.e2eMonitoringOption is active.
    Then I check that the element SidebarPage.trendIdRegistryOption is active.
    Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    Then I click on the user icon and log out.


    #---------------------------------------------------------------- Step 4
      # Change again the selected project, this time choose both projects, check that only the Basic pages and functionaties are accessible.


    #Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    #Then I check the presence of ProjectPage.buttonToReturnHomePage Element and then i click it
    #Then I enter on esol-ap29551-qa project and esol-ap29551-test project
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check that the element SidebarPage.homeOption is active.
    #Then I check that the element SidebarPage.devicesOption is active.
    #Then I check that the element SidebarPage.ticketsManagementOption is not active.
    #Then I check that the element SidebarPage.activitiesOption is not active.
    #Then I check that the element SidebarPage.diagnosticOption is not active.
    #Then I check that the element SidebarPage.logOption is not active.
    #Then I check that the element SidebarPage.activitiesOption is not active.
    #Then I check that the element SidebarPage.alarmsOption is not active.
    #Then I check that the element SidebarPage.softwareManagerOption is not active.
    #Then I check that the element SidebarPage.rdeOption is not active.
    #Then I check that the element SidebarPage.e2eMonitoringOption is not active.
    #Then I check that the element SidebarPage.usageStatisticOption is not active.

  # non possibile perché tutti i progetti hanno le stesse grant! Non esistono
  # progetti nella stessa utenza con grant differenti
