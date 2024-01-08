@Industry_Test_28.9
Feature: Industry
#GOAL: Verify the presence of the new column: NOTE.
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.9
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
    And If the activity "test2809" for device "Test_Concept-01" is not present I create it
    Then I input "test2809" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2809Activity

    #3. Verify the presence of the new column Note:
    Then I check the presence of ActivitiesPage.labelActivityIdColumn
    Then I check the presence of ActivitiesPage.labelCreationDateColumn
    Then I check the presence of ActivitiesPage.labelNotesColumn
    Then I check the presence of ActivitiesPage.manageColumn

    And I click on the user icon and log out.