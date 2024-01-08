@Industry_Test_28.4
Feature: Industry
#GOAL: Verify the presence of the buttons:
    #Show Detail
    #Copy
    #Edit
    #Delete
    #Fab button - Add Activity
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.4
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

    #3. Verify the presence of the buttons:
    #Show Detail
    #Run
    #Copy
    #Edit
    #Delete
    #Fab button - Add Activity
    Then I check the presence of DevicesDetailsPage.showDetailsActivity
    Then I check the presence of DevicesDetailsPage.playActivity
    Then I check the presence of DevicesDetailsPage.copyActivity
    Then I check the presence of DevicesDetailsPage.editActivity
    Then I check the presence of DevicesDetailsPage.deleteActivity
    Then I check the presence of DevicesDetailsPage.newActivityButton

    And I click on the user icon and log out.