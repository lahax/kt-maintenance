@E2EMonitoring_Test_15.38
Feature: E2EMonitoring

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption


  Scenario: Test 15.38

    Then I enter on "esol-ap29551-qa" project

    #requirements
   #------------------------------------ DMC NRT Test Case 15.26----------------------------------------------------------
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    #-----------------------------------Step 2
    #Click on the + Button to create an custom group
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    #-----------------------------------Step 3
    # Insert a group name,
    And I type "Test_15.26" into the element CustomGroupsPage.addGroupName
    # then add:
    # A thing
    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I input "Test_Concept" in CustomGroupsPage.addThingBox
    Then I check the presence of CustomGroupsPage.testConcept01thing1 Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A direct thing
    Then I type "DirectXX" into the element CustomGroupsPage.addDirectThingBox
    Then I cancel a letter from the input box element CustomGroupsPage.addDirectThingBox
    #Then I check the presence of CustomGroupsPage.addDirectThingBox Element and then i click it
    And I check the presence of CustomGroupsPage.directThingXX Element and then i click it
    And I check the presence of CustomGroupsPage.addDirectThingBTN Element and then i click it
    # A gateway with all it things (you should be able to simulate this gateway)
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    Then I cancel a letter from the input box element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A gateway without things
    Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
    Then I cancel a letter from the input box element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Save
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it

   #------------------------------------------15.26 END----------------------------------------------------------

   #------------------------------------------15.38 Start STEPS----------------------------------------------------------
   #STEP 2
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.deviceAlarmsConfigurationSubOption Element and then i click it
    Then I wait the progress bar
    # - Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
   #Step 3
   #Create an alarm with scope the custom group created on DMC NRT Test Case 15.26 , following the same configuration as DMC NRT Test Case 15.36
   #Use a different channel endpoint, for at least one channel type. This will help you verify the alarms are segregated according to the scope
   #Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Disservice
    Then I check the presence of DeviceAlarmsConfigurationPage.widespreadDisserviceAlarmRadioBTN Element and then i click it
     #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.customGroupDeviceOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    Then I type "Test_15.26" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I check the presence of DeviceAlarmsConfigurationPage.groupTest15_26 Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #Insert 3 as number of alarms
    And I cancel text from the input box element DeviceAlarmsConfigurationPage.numberOfAlarmsLabelInput
    And I type "3" into the element DeviceAlarmsConfigurationPage.numberOfAlarmsLabelInput
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    #Insert 2 mins in Short time window and 4 mins in Long time window
    And I cancel text from the input box element DeviceAlarmsConfigurationPage.shortTimeWindowInput
    And I type "2" into the element DeviceAlarmsConfigurationPage.shortTimeWindowInput
    And I cancel text from the input box element DeviceAlarmsConfigurationPage.longTimeWindowInput
    And I type "4" into the element DeviceAlarmsConfigurationPage.longTimeWindowInput
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
    #Review the configuration and save
    And I check the presence of DeviceAlarmsConfigurationPage.finalExitButton2 Element and then i click it
    #BUG -------------------------------> infinite loading ----------------------------------------------
    # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Insert a Channel for each type then click on Save
    # Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    Then I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
    # Cellphone
    #Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
    #Then I save telephone number
    #Then I type the telephone number saved into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
    # Topic
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelTopicOptionToSelect Element and then i click it
    And I type "testtest" into the element DeviceAlarmsConfigurationPage.topicToInsertBox
    # RDE ALARM
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelRdeAlarmOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Controll Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it

    # Step 3
    #
    #-------------------------------------------------------------------------------------------------------------------
    # Access AWS Console with role IoTSupport or DMC role (according to the test environment)
    # Open DynamoDB table esol_ap27611_<env>_ddb_device_monitoring
    # Click on Filer and add the filter project_id equal to the APM selected
    # Open the alarm created and check the disservice alarm configuration is as expected:
    Then I compare the structure of json disservice alarm for "Test_15.26" device in the table "esol_ap27611_test_ddb_devices_monitoring" of DynamoDB for "esol-ap29551-qa" apm

    # STEP 4
    #
    # Open DynamoDB table esol_ap27611_<env>_ddb_device_monitoring
    # Click on Filer and add the filter project_id equal to the APM selected
    # Open the notification configured through the test and check the structure is coherent with the JSON below
    Then I check the "email" notification data for device "Test_15.26" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm
    #Then I check the "telephone" notification data for device "Test_15.26" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm
    Then I check the general information like projectid "esol-ap29551-qa" scope target "Test_15.26" and scope type "disservice" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm
    
#------------------------------------Remove configuration to restore changes---------------------------------------
    # remove Device Alarms Configurations
    And I check the presence of DeviceAlarmsConfigurationPage.deleteTest15_26 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it
    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTest15_26 Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it

    # ----------------------------------- Delete Custom Group  ----------------------------------- #
    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    And I check the presence of CustomGroupsPage.deleteTest15_26 Element and then i click it
    And I check the presence of CustomGroupsPage.confirmDelete Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    # ----------------------------------- Delete Custom Group  ----------------------------------- #

#------------------------------------Remove configuration to restore changes---------------------------------------