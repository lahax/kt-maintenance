@Industry_Test_28.13
Feature: Industry
#GOAL: It's introduced the paging for Gateway's Activity section
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.13
    #go on Devices page and choose a Gateway.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    # Click on Gateway Detail:
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #2.Click on Activities Tab:
    Then I check the presence of DevicesDetailsPage.tabActivities Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabActivitiesTitle

    #3. Check the presence of the paginator:
    Then I check the presence of ActivitiesPage.paginator

    #4.Test if the paginator works properly
    Then I check the presence of ActivitiesPage.paginatorSelectRows Element and then i click it
    Then I check the presence of ActivitiesPage.paginator100Rows Element and then i click it

    #Prerequisite: at least 6 activities
    Then I check the number of rows present in the table
    Then I check the presence of ActivitiesPage.paginatorSelectRows Element and then i click it
    Then I check the presence of ActivitiesPage.paginator5Rows Element and then i click it
    Then I check the presence of ActivitiesPage.nextPage Element and then i click it
    Then I check the presence of ActivitiesPage.showDetailsActivity

    #Final logout step
    And I click on the user icon and log out.