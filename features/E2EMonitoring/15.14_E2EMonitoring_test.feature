@E2EMonitoring_Test_15.14
Feature: E2EMonitoring
#lifecycled lower #TTL ISSUE
  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.14
    #--------------------------------Test 15.11 Repeat----------------------------------
    # in order to -Choose the alarm created on DMC NRT Test Case 15.11-
    # we recreate it and perform other tasks

    #STEP 1 - Login on DMC, Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    Then I wait the progress bar

    ## ############################################################################################
    ## Step to check the presence of alarm all type
    ## if the alarm is present, this step remove the alarm on Device Alarm Configuration Page
    ## and then remove the notification of this all alarm
    ##
    ## Reason: If there's an alarm of "all" type, the test receive different type of notification
    ## an example the test expect a lower_threshold but the alarm all send lifecycle
    ## ###########################################################################################
    Then I check and clear if alarm all type is present
    Then I check and clear if "Test_Concept-02" alarm all type is present
    Then I wait 5 minutes after script

    # STEP 2 (CREATE ALARM AS Test Case 15.11)
    # - Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
    # Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Telemetry or Threshold
    Then I check the presence of DeviceAlarmsConfigurationPage.telemetryOfThresholdAlarmRadioBTN Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I type "Test_Concept-02" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I wait 20 seconds
    And I check the presence of DeviceAlarmsConfigurationPage.testConcept02Device Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    # In Low Threshold click on Add Theshold and insert 3 as number of messages and 300 s as time window
    And If Element DeviceAlarmsConfigurationPage.visibleResetOptionsBTN is present I click it
    And I check the presence of DeviceAlarmsConfigurationPage.addThresholdBTN Element and then i click it
    And I type "3" into the element DeviceAlarmsConfigurationPage.numberOfMessagesToWrite
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.threeHundredsecondsTimeSelectionLowThreshold Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    # In High Threshold click on Add Theshold and insert 5 as number of messages and 300 s as time window
    And If Element DeviceAlarmsConfigurationPage.visibleResetOptionsBTN is present I click it
    Then I check the presence of DeviceAlarmsConfigurationPage.addThresholdBTN Element and then i click it
    And I type "5" into the element DeviceAlarmsConfigurationPage.numberOfMessagesToWrite2
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowDropDown2 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.threeHundredsecondsTimeSelectionHighThreshold Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
    # Do not add a telemetry rule and click directly on Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab4 Element and then i click it
    # Review the summary of the configuration and click Next to proceed
    Then I check the presence of DeviceAlarmsConfigurationPage.alarmConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab5 Element and then i click it
    # Click Yes to proceed with the configuration
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    # Do not select Aggregation and click Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification2 Element and then i click it
    # Do not select Max Frequency and click Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
    # Review and click Save to continue
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Insert a Channel for each type then click on Save
    # Email
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
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
    Then I check the mail boxes
    #-------------------------------Alarm test case 15.11 created -----------------------------------

    #--------------------------------Test Case 15.14 Start Steps------------------------------------
    # Step 1
    # Login on DMC and go in E2E - Device Configuration page
    # - Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
    # Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Add notification for existing alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.addNotificationForExistingAlarmRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Telemetry or Threshold
    Then I check the presence of DeviceAlarmsConfigurationPage.telemetryOfThresholdAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Device Group dropdown
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    # Mappato existing device group
    Then I check the presence of DeviceAlarmsConfigurationPage.testConcept02ToSelect Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro1 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro2 Element and then i click it
    # Click on next:
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification2 Element and then i click it
    # Remove the aggregation and on Notification Time Window set 10 minutes as max frequency
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB3 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.tenMinutesMaxFrequency Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
    # Click on Save BTN
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.exitBTN Element and then i click it

    Then I wait 5 seconds

        #---- creazione regola RDE ----#
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    # New rule wizard button
    # Bug Action option, do not scroll down
    Then  I check the presence of SidebarPage.rdeOption Element and then i click it
    Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Filter Type --->  Thing_group
    Then  I check the presence of RDEPage.filterTypeOptions Element and then i click it
    Then  I check the presence of RDEPage.thingGroupOptionAddRUle Element and then i click it
    # Filter ID: the test gateway
    Then  I check the presence of RDEPage.filterIdInsertBox Element and then i click it
    Then I input "Test_Concept-02" in RDEPage.filterIdBox
    Then I check the presence of RDEPage.plusConditionAddRuleOption Element and then i click it
    # Then  I click RDEPage.testConcept04Device
    # And Condition:
    Then I check the presence of RDEPage.plusConditionAddRuleOption Element and then i click it
    Then I check the presence of RDEPage.attributeNameAddRuleOption Element and then i click it
    Then I check the presence of RDEPage.metadataDataTypeAddRuleOption Element and then i click it
    # Value: E2E_MONITORING_CONFIGURATION
    Then I check the presence of RDEPage.dropDownValueAndConditions Element and then i click it
    Then I check the presence of RDEPage.e2eMonitoringNotificationAddRuleOption Element and then i click it
    # Actions:
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.mqttAwsTypeAddRuleOption Element and then i click it
    # formatter: None
    Then I check the presence of RDEPage.formatterAddRuleOption Element and then i click it
    Then I check the presence of RDEPage.noneFormatterAddRuleOption Element and then i click it
    And I type "eu-central-1" into the element RDEPage.regionAddRuleOption
    And I type "rde_test_topic" into the element RDEPage.topicActionsAddRuleOption
    Then I check the presence of RDEPage.saveRuleBTN Element and then i click it

    #-----------------Step 3
    #Listen to MQTT Topic
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-02", in the project "esol_ap29551_qa"
    Then I launch command "bash ./send_telemetry_thing02.sh 10" on shell
    Then I wait 6 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption

            #-----------------Step 7
    #And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    Then I input "Test_Concept-02_thing1" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept02IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #--> After around 5 minutes verify there is a High Threshold Device Defender alarm:
    Then I check the presence of AlarmsDetailsPage.higherThresholdInDetails
    #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-02_thing1\""

    Then I wait 10 minutes after script
    #Check Email
    Then I check message of "lifecycle" notification in mail object, from device "Test_Concept-02" in the project "esol-ap29551-qa"
    Then I check message of "higher" notification in mail object, from device "Test_Concept-02" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-02" is in sms boxes body

    #on email, the last alarm over a period of 10 minutes (3 notification: subscription, lifecycle, higher threshold)
   # Then I check the number of emails received and expect 3 notification
    And I kill the notify_job command still opened


    #------------------------------------Remove configuration to restore changes---------------------------------------

    # Remove Device Alarms Configurations
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept2 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it

    # Remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept02Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it

    # ------------------------------------Remove configuration to restore changes---------------------------------------