@Industry_Test_28.3
Feature: Industry
#GOAL: In the Update Thing is been added the new Serial number string. Also it's possible to change it.
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.3
    #Click on "Show Detail" and then on "More Info". The User is able to see the new added Serial Number string.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    #2a. Click on Show Detail:
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-61" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept61Details Element and then i click it

     #---Precondition: delete thing if already present---#
    And I click DevicesDetailsPage.enterToThingsList
    And If the thing "Test_Concept-61_thing1" in the project "esol_ap29551_qa" is present I remove it through "job"
    #--------------------------------------------End Precondition-------------------------------------------------#
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-61", in the project "esol_ap29551_qa"

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I clear the search Box in the Device Page
    Then I input "Test_Concept-61" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept61Details Element and then i click it

    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN
    And I click ActivateThingPage.inputField
    # 6 - Select other
    And I click ActivateThingPage.otherOption
    # 7 - Use this payload (or similar based on the specific device software implementation) in order to Send Thing Activation command on selected Gateway:
    And I input the payload into DevicesDetailsPage.firstRowIntTextarea for apm "esol_ap29551_qa"
    """
      {
        "outbound_communication_modes": ["topic"],
        "inbound_communication_mode": ["topic"],
        "interaction_mode": "gateway",
        "environment_prefix": "%s",
        "radio_type": "eth",
        "device_type": "mqtts",
        "serial_number": "12345",
        "model": "emulate_modbus",
        "maker": "Fibaro",
        "filter_tag": [{
          "id": 1,
          "period": 10,
          "tag": "topic/test"
        }]
      }
    """
    Then I check the presence of ActivateThingPage.activateThingBTN Element and then i click it
    # 8 – Wait for the job notify. In case that the message isn’t received within 10 seconds, the test is FAILED.
    Then I save the job ID from the job document received and I verify that the inbound message is received in three minutes have the specified format

    # 13 -  Run registration script
    Then I launch command "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-61 thing1 ./payloadTest2_5_1.txt" on shell
    # 14a – Wait for the registration message: the inbound message must match payload file.
    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-61 thing1" in the project "esol_ap29551_qa"

    Then I wait 2 minutes after script

    And I clear the search Box in the Device Page
    And I type "Test_Concept-61_thing1" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.thingDetails Element and then i click it

    #2b.Click on Update:
    Then I check the presence of ThingsPage.update Element and then i click it
    Then I check the presence of ThingsPage.updateThingTitle

    #3a. Check the presence of Serial Number string:
    Then I check the presence of ThingsPage.modelFormTitle
    Then I cancel text from the input box element ThingsPage.modelFormInput
    And I type the random string into the element ThingsPage.modelFormInput - field "Model"

    Then I check the presence of ThingsPage.makerFormTitle
    Then I cancel text from the input box element ThingsPage.makerFormInput
    Then I type "Dell" into the element ThingsPage.makerFormInput

    Then I check the presence of ThingsPage.latitudeFormTitle
    Then I cancel text from the input box element ThingsPage.latitudeFormInput
    Then I type "15.22" into the element ThingsPage.latitudeFormInput

    Then I check the presence of ThingsPage.longitudeFormTitle
    Then I cancel text from the input box element ThingsPage.longitudeFormInput
    Then I type "35.11" into the element ThingsPage.longitudeFormInput

    Then I check the presence of ThingsPage.aliasFormTitle
    Then I cancel text from the input box element ThingsPage.aliasFormInput
    And I type the random string into the element ThingsPage.aliasFormInput - field "Alias"

    Then I check the presence of ThingsPage.serialNumberFormTitle
    #4a Change the value of the Serial Number page and save.
    Then I cancel text from the input box element ThingsPage.serialNumberFormInput
    And I type the random number into the element ThingsPage.serialNumberFormInput - field "Serial Number"

    And I click ThingsPage.updatedBTN
    And I click ThingsPage.startButton

    Then I save the job ID from the job document received and I verify that the inbound message have the specified format
    And I run the script "close_job_update", with the job Id retrieved, on "Test_Concept-61" in the project "esol_ap29551_qa"
    Then I save current timestamp to check time

    Then I check the presence of DevicesDetailsPage.backUpdateBTN Element and then i click it
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    Then I check the presence of SidebarPage.stepFunctionSubOption Element and then i click it

    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    Then I input with enter "Test_Concept-61" in DevicesPage.searchBox

    Then I wait last step function to be succeeded in 120 seconds for device "thing"
    Then I click on the details of the last step function of "Test_Concept-61"
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #4b The Serial Number string is correctly updated.:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    And I clear the search Box in the Device Page
    Then I input "Test_Concept-61" in DevicesPage.searchBox
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept61Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
    Then I check the presence of ThingsPage.titleSectionThings
    And I type "Test_Concept-61_thing1" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.thingDetails Element and then i click it
    Then I check the presence of DevicesDetailsPage.infoThingIcon Element and then i click it
    And I verify the update into the element ThingsPage.serialNumberDetail - field "Serial Number"

    And I click on the user icon and log out.