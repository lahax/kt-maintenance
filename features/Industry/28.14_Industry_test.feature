@Industry_Test_28.14
Feature: Industry
#GOAL: Check the presence and functionality of the search bar
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.14
    #go on Devices page and choose a Gateway.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    #2a. Click on Gateway Detail:
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #2b.Click on Activities Tab:
    Then I check the presence of DevicesDetailsPage.tabActivities Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabActivitiesTitle

    #Prerequisite: activity is present
    And If the activity "test2814" for device "Test_Concept-01" is not present I create it with note "testing"

    #3. Check that the user is able ONLY to search by Activity ID:
     #search by ID
    Then I input "test2814" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the presence of ActivitiesPage.test2814Activity

    #search by Date
    And I clear the search Box in the Device Page
    Then I input "2023" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the absence of ActivitiesPage.test2814Activity

    #search by Note
    And I clear the search Box in the Device Page
    Then I input "testing" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the absence of ActivitiesPage.test2814Activity

    And I click on the user icon and log out.