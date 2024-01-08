@Industry_Test_28.5
Feature: Industry
#GOAL: The user Add a new activity in the Gateway's Activities section
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.5
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
    #3a. Click on Fab button - Add Activity at the bottom left of the page:
    Then I check the presence of DevicesDetailsPage.tabActivitiesTitle

    #4a. The user create successfully an activity in the Gateway's Activities section:
    Then I input "test2805" in ActivitiesPage.searchBox
    And If the activity "test2805" is present I delete it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I check the presence of DevicesDetailsPage.newActivityButton Element and then i click it

    And I type "test2805" into the element ActivitiesPage.activityIdInputLabel
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
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    And I check the presence of ActivitiesPage.test2805Activity

    And I check the presence of ActivitiesPage.deleteActivityTest2805 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

    And I click on the user icon and log out.