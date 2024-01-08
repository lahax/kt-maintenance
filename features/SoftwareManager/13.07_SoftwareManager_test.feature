@Software_manager_Test_13.7
Feature: Software Manager
#GOAL: In Deployment history page there is a filter toolbox.
  Background:
    # STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.7
    #STEP 2 - Access to DMC, open sidemenu then click on Software Manager and click on Deployment History submenu item.
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle

    # STEP 3 - Check that on top of the page there is a filter toolbox. Check the functionality of all filters.
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it

    #DEVICE TYPE

    #BY STATUS
    Then I check the presence of DeploymentsHistoryPage.statusDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.completedOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "completed" for "status"

    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.statusDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.failedOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "failed" for "status"

    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.statusDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.timeoutOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "timeout" for "status"

    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.statusDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.partialOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "partial" for "status"

    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.statusDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.inProgressOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "pending" for "status"

    #BY LATEST
    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.latestDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.YesOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "yes" for "latest"

    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.latestDropdown Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.NoOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check if filtered only "no" for "latest"

    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it