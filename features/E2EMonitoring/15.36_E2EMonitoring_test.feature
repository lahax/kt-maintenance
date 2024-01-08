@E2EMonitoring_Test_15.36
Feature: E2EMonitoring

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.36

    # STEP 1
    # Login on DMC, Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    # STEP 2
    # Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
    # Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Disservice
    Then I check the presence of DeviceAlarmsConfigurationPage.widespreadDisserviceAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    Then I type "Test_Concept-01" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And If Element DeviceAlarmsConfigurationPage.testConcept01Device is present I click it
    #And I check the presence of DeviceAlarmsConfigurationPage.testConcept01Device Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    # Insert 3 as number of alarms
    And I type "3" into the element DeviceAlarmsConfigurationPage.numberOfAlarmsLabelInput
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    # Insert 2 mins in Short time window and 4 mins in Long time window
    And I type "2" into the element DeviceAlarmsConfigurationPage.shortTimeWindowInput
    And I type "4" into the element DeviceAlarmsConfigurationPage.longTimeWindowInput
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    # Review the configuration and save
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
    # Review the summary of the configuration and click Next to proceed
    Then I check the presence of DeviceAlarmsConfigurationPage.alarmConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab4 Element and then i click it
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
    Then I compare the structure of json disservice alarm for "Test_Concept-01" device in the table "esol_ap27611_test_ddb_devices_monitoring" of DynamoDB for "esol-ap29551-qa" apm

    # STEP 4
    #
    # Open DynamoDB table esol_ap27611_<env>_ddb_device_monitoring
    # Click on Filer and add the filter project_id equal to the APM selected
    # Open the notification configured through the test and check the structure is coherent with the JSON below
    Then I check the "email" notification data for device "Test_Concept-01" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm
    #Then I check the "telephone" notification data for device "Test_Concept-01" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm
    Then I check the general information like projectid "esol-ap29551-qa" scope target "Test_Concept-01" and scope type "disservice" on "esol_ap27611_test_ddb_notification_configuration" DynamoDb table for project "esol-ap29551-qa" apm

    #------------------------------------Remove configuration to restore changes---------------------------------------
    # remove Device Alarms Configurations
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept1 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it

    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept01Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it

    #------------------------------------Remove configuration to restore changes---------------------------------------