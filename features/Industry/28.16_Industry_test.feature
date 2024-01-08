@Industry_Test_28.16
Feature: Industry
#GOAL: Check the presence of the new Note string in Add page, Edit page, Copy page and Show Detail
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.16
    #and go on Activities page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption

    #Prerequisite: activity is present
    Then I input "test2816" in ActivitiesPage.searchBox
    And If the activity "test2816" is present I delete it
    Then If Element ActivitiesPage.toastMessageClose is present I click it

    #4a. Click on the + button on the bottom right of the page
    #4b. Check the presence of the new Note field:
    #4c. Click on the back button on the top left of the page
    Then I check the presence of DevicesDetailsPage.newActivityButton Element and then i click it
    And I type "test2816" into the element ActivitiesPage.activityIdInputLabel
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
    Then I input "test2816" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2816Activity

    #2a. Click on the Edit icon
    Then I check the presence of ActivitiesPage.editActivity Element and then i click it
    #2b. Check the presence of the new Note field:
    Then I check the presence of ActivitiesPage.notesInputLabel
    #2c. Click on the back button on the top left of the page
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    And I clear the search Box in the Device Page
    Then I input "test2816" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2816Activity

    #3a. Click on the Copy icon
    Then I check the presence of ActivitiesPage.copyActivity Element and then i click it
    #3b. Check the presence of the new Note field:
    Then I check the presence of ActivitiesPage.notesInputLabel
    #3c. Click on the back button on the top left of the page
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    And I clear the search Box in the Device Page
    Then I input "test2816" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2816Activity

    #5a. Click on Show Detail button
    Then I check the presence of ActivitiesPage.showDetailsActivity Element and then i click it
    #5b. Check the presence of the new Note field:
    Then I check the presence of ActivitiesPage.notes

    And I click on the user icon and log out.