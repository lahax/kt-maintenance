@ActivitiesSection_Test_9.9
Feature: ActivitiesSection

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Is it possible to copy an activity

  Scenario: Test 9.9
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

    #Step 3
    #create an activity to copy
    #click on Copy button of the specific activity
   ##############CANCEL ACTIVITY CREATED#############
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And If the activity "TestConcept9" is present I delete it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then If Element ActivitiesPage.deleteActivityTestConcept9Copy is present I click it
    Then If Element ActivitiesPage.confirmDeleteButton is present I click it
    Then If Element ActivitiesPage.toastMessageClose is present I click it

    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "test-copy",
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
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox

    And I check the presence of ActivitiesPage.copyActivityTestConcept9 Element and then i click it
    And I type "TestConcept9Copy" into the element ActivitiesPage.activityIdInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    #Step 4
    #Verify that the activity has been correctly duplicated
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox

    And I check the presence of ActivitiesPage.editActivityTestConcept9Copy Element and then i click it
    And I compare the payload ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "test-copy",
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
    And I check the presence of ActivitiesPage.confirmSaveEditButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9Copy Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose


    # Logout Step
    Then I click on the user icon and log out.
