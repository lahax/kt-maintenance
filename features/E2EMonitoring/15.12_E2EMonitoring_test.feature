@E2EMonitoring_Test_15.12
Feature: E2EMonitoring

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.12

    # Background for the test case: alarm of Test 15.11
    # STEP 1 - Login on DMC, Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption

    ## ############################################################################################
    ## Step to check the presence of alarm all type
    ## if the alarm is present, this step remove the alarm on Device Alarm Configuration Page
    ## and then remove the notification of this all alarm
    ##
    ## Reason: If there's an alarm of "all" type, the test receive different type of notification
    ## an example the test expect a lower_threshold but the alarm all send lifecycle
    ## ###########################################################################################
    Then I check and clear if alarm all type is present
    Then I check and clear if "Test_Concept-04" alarm all type is present

    Then I wait 5 minutes after script

    # STEP 2
    # - Click on the Wizard Button to create an alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardBTN Element and then i click it
    # Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
    #  Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #  Telemetry or Threshold
    Then I check the presence of DeviceAlarmsConfigurationPage.telemetryOfThresholdAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I type "Test_Concept-04" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I cancel a letter from the input box element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    # Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    And If Element DeviceAlarmsConfigurationPage.testConcept04Device is present I click it
    #And I check the presence of DeviceAlarmsConfigurationPage.testConcept04Device Element and then i click it
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
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    # And I type "testconceptreplyenelx@gmail.com" into the element DeviceAlarmsConfigurationPage.emailToInsertBox
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
    # Check Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it

    Then I check the mail boxes

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
    Then I input "Test_Concept-04" in RDEPage.filterIdBox
    Then  I check the presence of RDEPage.plusConditionAddRuleOption Element and then i click it
    # Then  I click RDEPage.testConcept04Device
    # And Condition:
    Then  I check the presence of RDEPage.plusConditionAddRuleOption Element and then i click it
    Then  I check the presence of RDEPage.attributeNameAddRuleOption Element and then i click it
    Then  I check the presence of RDEPage.metadataDataTypeAddRuleOption Element and then i click it
    # Value: E2E_MONITORING_CONFIGURATION
    Then I check the presence of RDEPage.dropDownValueAndConditions Element and then i click it
    Then  I check the presence of RDEPage.e2eMonitoringNotificationAddRuleOption Element and then i click it
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
      #Listen to MQTT Topic (The listener should be set before the telemetry operation)
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-04", in the project "esol_ap29551_qa"
    Then I launch command "bash ./send_telemetry_thing_concept04.sh 10" on shell
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption

    #-----------------Step 7
    Then I wait 6 minutes after script
    # And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    Then I input "Test_Concept-04_thing2" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept04IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #--> After around 5 minutes verify there is a High Threshold Device Defender alarm:
    Then I check the presence of AlarmsDetailsPage.higherThresholdInDetails
    #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-04_thing2\""
    #Check Email
    Then I check message of "higher" notification in mail object, from device "Test_Concept-04" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-04" is in sms boxes body

    #-----------------Step 8
    # Use send_telemetry script to send 3 message in a 5 minutes period: execute the script three times, then wait for 5 minutes
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-04", in the project "esol_ap29551_qa"
    Then I launch command "bash ./send_telemetry_thing_concept04.sh 3" on shell
    Then I wait 6 minutes after script
    # And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    Then I input "Test_Concept-04_thing2" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I wait 5 seconds
    And I check the presence of AlarmsPage.lastAlarmClearedWithTestConcept04IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #--> After around 5 minutes verify there is a Device Defender alarm cleared:
    Then I wait 10 seconds
    Then I check the presence of AlarmsDetailsPage.alarmClearedInDetails
    And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-04_thing2\""
    #Then I kill the notify_job command still opened
    #Check Email
    Then I check message of "alarm-cleared" notification in mail object, from device "Test_Concept-04" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-04" is in sms boxes body
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-04", in the project "esol_ap29551_qa"
    Then I launch command "bash ./send_telemetry_thing_concept04.sh 1" on shell
    Then I wait 6 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption

    #-----------------Step 4:
    # Check that the right alarm is created according to the test case, at the right time
    Then I input "Test_Concept-04_thing2" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept04IconDetailLowerTh Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #--> After around 5 minutes verify there is a Device Defender Low Threshold alarm:
    Then I check the presence of AlarmsDetailsPage.lowerThresholdInDetails
    #Check Email
    Then I check message of "lower" notification in mail object, from device "Test_Concept-04" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-04" is in sms boxes body
    #Check MQTT
    #The first field indicated should be the second showed in the document retrieved
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-04_thing2\""

    Then I wait 10 seconds
    # remove rde rule
    Then I click HomePage.hamburgerMenuIcon
    Then  I click SidebarPage.rdeOption
    Then I check the presence of RDEPage.testConcept04ruleDeleteIcon Element and then i click it
    Then I check the presence of RDEPage.deleteConfirmBtn Element and then i click it

    # remove Device Alarms Configurations
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept4 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it


    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept04Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.toastMessageClose Element and then i click it
