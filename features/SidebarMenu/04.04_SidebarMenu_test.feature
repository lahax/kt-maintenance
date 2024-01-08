@Sidebar_menu_Test_4.4
Feature: Projects Menu
  Background:

    #STEP 1- Login and set Language english as default
    # Click on User Section, on the top right of the page, near the notification bell
    # Go with the pointer on "Language" and choose a language
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 4.4

    #Step 2
    #Select more than one project
    And I enter first two projects

    #Step 3
    #Click on the sidebar menu and check that you are not able to click on some sections:
    Then I click HomePage.hamburgerMenuIcon
    And I check that the element SidebarPage.activitiesOption is not active.
    Then I click SidebarPage.softwareManagerDropDownOption
    And I check that the element SidebarPage.lambdasSubOption is not active.
    And I check that the element SidebarPage.stepFunctionSubOption is not active.
     And I check that the element SidebarPage.loadCertificateSubOption is not active.
     Then I click SidebarPage.softwareManagerDropDownOption
     And I check that the element SidebarPage.softwareCatalogueOption is not active.
     And I check that the element SidebarPage.deploymentsHistoryOption is not active.
     And I check that the element SidebarPage.campaignManagementOption is not active.
     And I check that the element SidebarPage.rdeOption is not active.
     Then I click SidebarPage.e2eMonitoringDropDownOption
     And I check that the element SidebarPage.deviceAlarmsConfigurationSubOption is not active.
     And I check that the element SidebarPage.notificationsConfigurationSubOption is not active.
     And I check that the element SidebarPage.customGroupsSubOption is not active.
     And I check that the element SidebarPage.ticketsManagementOption is not active.



    #Tablet mode:
    #Then I set chrome 'iPad pro' mode
    #And I check that the element SidebarPage.activitiesOption is not active.
    #And I click SidebarPage.diagnosticDropDownOption
    #And I check that the element SidebarPage.lambdasSubOption is not active.
    #And I check that the element SidebarPage.stepFunctionSubOption is not active.
    #And I check that the element SidebarPage.loadCertificateSubOption is not active.
    #Then I click SidebarPage.softwareManagerDropDownOption
    #And I check that the element SidebarPage.softwareCatalogueOption is not active.
    #And I check that the element SidebarPage.deploymentsHistoryOption is not active.
    #And I check that the element SidebarPage.campaignManagementOption is not active.
    #And I check that the element SidebarPage.rdeOption is not active.
    #Then I click SidebarPage.e2eMonitoringDropDownOption
    #And I check that the element SidebarPage.deviceAlarmsConfigurationSubOption is not active.
    #And I check that the element SidebarPage.notificationsConfigurationSubOption is not active.
    #And I check that the element SidebarPage.customGroupsSubOption is not active.
    #And I check that the element SidebarPage.usageStatisticOption is not active.
    #And I check that the element SidebarPage.ticketsManagementOption is not active.

    #Smartphone mode: the sections in smartphone mode are only 6 and only 2 of them are visible but not cliccable
    #Then I set chrome 'iPhone' mode
    #And I check that the element SidebarPage.activitiesOption is not active.
    #And I check that the element SidebarPage.softwareCatalogueOption is not active.
