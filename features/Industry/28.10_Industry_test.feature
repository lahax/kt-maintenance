@Industry_Test_28.10
Feature: Industry
#GOAL: Check the presence of the new Note string in Add page, Edit Page, Copy page and Show Detail page
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.10
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
    Then I input "test2810" in ActivitiesPage.searchBox
    And If the activity "test2810" is present I delete it
    Then If Element ActivitiesPage.toastMessageClose is present I click it

    #6a. Click on the + button on the bottom right of the page
    Then I check the presence of DevicesDetailsPage.newActivityButton Element and then i click it

    #6b. Check the presence of the new Note field:
    And I type "test2810" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "Test_Concept-01",
    "command": "activate-thing",
    "parameters": {
        "device_type": "epiSensor",
        "interaction_mode": "gateway",
        "authentication_mode": "gateway",
        "radio_type": "Eth",
        "filter_tag": [
            {
                "tag": "Test",
                "id": 2000,
                "period": 60
            },
            {
                "tag": "CommunicationCode",
                "trendType": "CommCodeValue",
                "id": 2001,
                "period": 60
            }
        ],
        "inbound_communication_modes": [
            "shadow",
            "topic"
        ],
        "outbound_communication_modes": "shadow",
        "serial_number": "000D6F000D7EF1F8",
        "model": "ZDR",
        "maker": "EPISENSOR"
    }
}
    """
    And I type "testing note" into the element ActivitiesPage.notesInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    And I clear the search Box in the Device Page
    Then I input "test2810" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2810Activity

    #4a. Click on the Edit icon
    Then I check the presence of ActivitiesPage.editActivity Element and then i click it
    #4b. Check the presence of the new Note field:
    Then I check the presence of ActivitiesPage.notesInputLabel
    #4c. Click on the back button on the top left of the page
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    And I clear the search Box in the Device Page
    Then I input "test2816" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2816Activity

    #5a. Click on the Copy icon
    Then I check the presence of ActivitiesPage.copyActivity Element and then i click it
    #5b. Check the presence of the new Note field:
    Then I check the presence of ActivitiesPage.notesInputLabel
    #5c. Click on the back button on the top left of the page
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    And I clear the search Box in the Device Page
    Then I input "test2816" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2816Activity

    #3a. Click on the Show Detail icon.
    Then I check the presence of ActivitiesPage.showDetailsActivity Element and then i click it
    #3b. Check the presence of the new Note string:
    Then I check the presence of ActivitiesPage.notes

    And I click on the user icon and log out.