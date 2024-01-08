@Industry_Test_28.6
Feature: Industry
#GOAL: The user copy an activity in the Gateway's Activities section
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project

  Scenario: Test 28.6
    #go on Devices page and choose a Gateway.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption
    Then I input "test2806" in DevicesPage.searchBox
    And If the activity "test2806A" for device "Test_Concept-01" is not present I create it
    And If the activity "test2806B" is present I delete it

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
    #3a. Click on Copy button
    Then I input "test2806A" in ActivitiesPage.searchBox
    Then I check the presence of DevicesDetailsPage.copyActivity Element and then i click it
    #4a. Copy the activity select by inserting an Activity ID and click Confirm:
    And I type "test2806B" into the element ActivitiesPage.activityIdInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    And I clear the search Box in the Device Page
    Then I input "test2806" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2806AActivity
    And I check the presence of ActivitiesPage.test2806BActivity

    And I click on the user icon and log out.