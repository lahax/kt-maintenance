@Industry_Test_28.8
Feature: Industry
#GOAL: The user delete an activity in the Gateway's Activities section.
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.8
    #go on Devices page and choose a Gateway.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    #2a. Click on Show Detail:
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #2b.Click on Activities Tab:
    Then I check the presence of DevicesDetailsPage.tabActivities Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabActivitiesTitle

    #Prerequisite: activity is present
    And If the activity "test2808" for device "Test_Concept-01" is not present I create it
    Then I input "test2808" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2808Activity

    #3a. Click on Delete button
    Then I check the presence of DevicesDetailsPage.deleteActivity Element and then i click it
    #4. Click on confirm
    Then I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it

    Then I check the absence of ActivitiesPage.test2808Activity
    And I click on the user icon and log out.