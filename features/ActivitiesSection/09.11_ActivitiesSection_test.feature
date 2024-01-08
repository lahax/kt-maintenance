@ActivitiesSection_Test_9.11
Feature: ActivitiesSection

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Verify the activity is correctly executed
  Scenario: Test 9.11
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 3
    #Click on Edit button for the activity created on test 9.9 and insert the test gatewayID where there is the placeholder
    Then I click SidebarPage.activitiesOption
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    Then If Element ActivitiesPage.deleteActivityTestConcept9 is present I click it
    Then If Element ActivitiesPage.confirmDeleteButton is present I click it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
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

    #Step 4
    #Run the activity
    Then I clear ActivitiesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.runActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmRunActivityButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose

    #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    #Close Job Script : ./close_job.sh <host> <apm> <device_id> <job_id>
    Then I save the job ID from the job document received
    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-01 thing1" in the project "esol_ap29551_qa"

    #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    And I wait 4 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionActivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #Step 7
    #Open the gateway's device page and scroll until the activity section to check the activity (specific for that gateway) is present.
    Then I kill the notify_job command still opened
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    And I cancel text from the input box element DevicesPage.searchBox
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabActivities Element and then i click it
    Then I check the presence of DevicesDetailsPage.activityTestConcept9

    #Default to clean dmc
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

    # Logout Step
    Then I click on the user icon and log out.