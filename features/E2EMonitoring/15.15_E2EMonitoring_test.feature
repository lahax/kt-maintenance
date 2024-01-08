@E2EMonitoring_Test_15.15
Feature: E2EMonitoring
#HIGHER_THRESHOLD e LOWER_THRESHOLD
  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.15

    # Background for the test case: alarm of Test 15.11 Repeat----------------------------------
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
    Then I check and clear if "Test_Concept-03" alarm all type is present
    Then I wait 5 minutes after script

   #STEP 2
   # - Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
   #Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Telemetry or Threshold
    Then I check the presence of DeviceAlarmsConfigurationPage.telemetryOfThresholdAlarmRadioBTN Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I type "Test_Concept-03" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I wait 20 seconds
    And If Element DeviceAlarmsConfigurationPage.testConcept03Device is present I click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #In Low Threshold click on Add Theshold and insert 3 as number of messages and 300 s as time window
    And If Element DeviceAlarmsConfigurationPage.visibleResetOptionsBTN is present I click it
    And I check the presence of DeviceAlarmsConfigurationPage.addThresholdBTN Element and then i click it
    And I type "3" into the element DeviceAlarmsConfigurationPage.numberOfMessagesToWrite
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.threeHundredsecondsTimeSelectionLowThreshold Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
   #In High Threshold click on Add Theshold and insert 5 as number of messages and 300 s as time window
    And If Element DeviceAlarmsConfigurationPage.visibleResetOptionsBTN is present I click it
    Then I check the presence of DeviceAlarmsConfigurationPage.addThresholdBTN Element and then i click it
    And I type "5" into the element DeviceAlarmsConfigurationPage.numberOfMessagesToWrite2
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowDropDown2 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.threeHundredsecondsTimeSelectionHighThreshold Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
   #Do not add a telemetry rule and click directly on Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab4 Element and then i click it
   #Review the summary of the configuration and click Next to proceed
    Then I check the presence of DeviceAlarmsConfigurationPage.alarmConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab5 Element and then i click it
   #Click Yes to proceed with the configuration
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
   #Do not select Aggregation and click Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification2 Element and then i click it
   #Do not select Max Frequency and click Next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
   #Review and click Save to continue
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   #Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Insert a Channel for each type then click on Save
   #Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    Then I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
   #Cellphone
    #Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
    #Then I save telephone number
    #Then I type the telephone number saved into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
   #Topic
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelTopicOptionToSelect Element and then i click it
    And I type "testtest" into the element DeviceAlarmsConfigurationPage.topicToInsertBox
   #RDE ALARM
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelRdeAlarmOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   #Controll Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it
#
    Then I check the mail boxes

     #---- creazione regola RDE ----#
    Then I click HomePage.hamburgerMenuIcon
    # New rule wizard button
    # Bug Action option, do not scroll down
    Then I click SidebarPage.rdeOption
    #Then I wait the progress bar
    #Then If the rule for "Test_Concept-03" is present I delete it
    Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Filter Type --->  Thing_group
    Then I click RDEPage.filterTypeOptions
    Then I click RDEPage.thingGroupOptionAddRUle
    # Filter ID: the test gateway
    Then I click RDEPage.filterIdInsertBox
    Then I input "Test_Concept-03" in RDEPage.filterIdBox
    Then I click RDEPage.plusConditionAddRuleOption
    # Then  I click RDEPage.testConcept04Device
    # And Condition:
    Then  I click RDEPage.plusConditionAddRuleOption
    Then  I click RDEPage.attributeNameAddRuleOption
    Then  I click RDEPage.metadataDataTypeAddRuleOption
    # Value: E2E_MONITORING_CONFIGURATION
    Then  I click RDEPage.dropDownValueAndConditions
    Then  I click RDEPage.e2eMonitoringNotificationAddRuleOption
    # Actions:
    Then I click RDEPage.actionsDropDown
    Then I check the presence of RDEPage.mqttAwsTypeAddRuleOption Element and then i click it
    # formatter: None
    Then I check the presence of RDEPage.formatterAddRuleOption Element and then i click it
    Then I check the presence of RDEPage.noneFormatterAddRuleOption Element and then i click it
    And I type "eu-central-1" into the element RDEPage.regionAddRuleOption
    And I type "rde_test_topic" into the element RDEPage.topicActionsAddRuleOption
    Then I check the presence of RDEPage.saveRuleBTN Element and then i click it
    Then I check the presence of RDEPage.toastMessageClose Element and then i click it
   #-------------------------------Alarm test case 15.11 created -----------------------------------

    #--------------------------------Test Case 15.15 Start Steps------------------------------------
    # - Click on the Wizard Button to create an alarm
    Then I click HomePage.hamburgerMenuIcon
    Then If SidebarPage.deviceAlarmsConfigurationSubOption Element is not visible I click on E2E Monitoring option
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardBTN Element and then i click it
    #Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Add notification for existing alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.addNotificationForExistingAlarmRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Telemetry or Threshold
    Then I check the presence of DeviceAlarmsConfigurationPage.telemetryOfThresholdAlarmRadioBTN Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Device Group dropdown
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    #Mappato existing device group
    #Then I check the presence of DeviceAlarmsConfigurationPage.existingDeviceGroup Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.testConcept03ToSelect Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    #Set scheduled as Notification window. The time period chosen should let you have just a subset of alarms created during this period of time
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.scheduledOption Element and then i click it
    #WEEKDAY FROM:
    Then I click on the current day
    Then I select the current hour window plus "10" minutes
    #Then I select the current hour window plus "10" min
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
   #Click on Save BTN
   Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   Then I check the presence of DeviceAlarmsConfigurationPage.exitBTN Element and then i click it

   #
   #-------------------------------------------------------------------------------------------------------------------
   # Access AWS Console with role IoTSupport or DMC role (according to the test environment)
   # Open DynamoDB table esol_ap27611_<env>_ddb_notification_configuration
   # Click on Filer and add the filter project_id equal to the APM selected

    #Then I check the trigger data and the trigger type configuration in DynamoDB 'esol_ap27611_test_ddb_notification_configuration' in the project 'esol-ap29551-perf'
    # Step3
    #Repeat DMC NRT Test Case 15.12 during the time window indicated
     #Verify alarms created during the time window indicated are received:
      #on DMC page there are all alarms
        # on SMS, email, MQTT Topic the alarm notification is received
        #Listen to MQTT Topic
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption

            #-----------------Step 3.4
    #Then I kill the notify_job command still opened
    #Then I launch command "bash ./send_telemetry_thing_concept03.sh 1" on shell
    #Then I wait 5 minutes after script
    #-----------------Step 3
      #Listen to MQTT Topic (The listener should be set before the telemetry operation)
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-03", in the project "esol_ap29551_qa"
    Then I launch command "bash ./send_telemetry_thing_concept03.sh 10" on shell
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption
    Then I wait 5 minutes after script
    # And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    Then I input "Test_Concept-03_thing1" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    Then I wait 20 seconds
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept03IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #After around 5 minutes verify there is a High Threshold Device Defender alarm:
    Then I check the presence of AlarmsDetailsPage.higherThresholdInDetails
    #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-03_thing1\""
    #Check Email
    Then I check message of "higher" notification in mail object, from device "Test_Concept-03" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-03" is in sms boxes body

  # Step 4
    # Repeat DMC NRT Test Case 15.12 outside the time window indicated: more than 22 minutes are passed,
    # so wait 8 to go outside the time window
    Then I wait 10 minutes to be outside the notification window
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-03", in the project "esol_ap29551_qa"
    # Verify alarms created during the time window indicated are NOT received:
    # on DMC page there are all alarms
    # on SMS, email, MQTT Topic the alarm notification is NOT received
    Then I launch command "bash ./send_telemetry_thing_concept03.sh 10" on shell
    Then I wait 1 minutes after script
    Then I save current number of emails
    Then I wait 1 minutes after script
    #And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    Then I input "Test_Concept-03_thing1" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    Then I wait 60 seconds
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept03IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #--> After around 5 minutes verify there is a High Threshold Device Defender alarm:
    Then I check the presence of AlarmsDetailsPage.higherThresholdInDetails
    #Email Check no notification
    Then I check there are no more mail notifications
     #Check MQTT
    And I check that MQTT is not receiving a notification message with field "\"environment_prefix\": \"esol_ap29551_qa\"" from device "\"thing_id\": \"Test_Concept-03_thing1\""


    #------------------------------------Remove configuration to restore changes---------------------------------------
  # remove rde rule
    Then I click HomePage.hamburgerMenuIcon
    Then  I click SidebarPage.rdeOption
    Then I wait the progress bar
    Then If the rule for "Test_Concept-03" is present I delete it

          # remove Device Alarms Configurations
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept3 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it

    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept03Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it