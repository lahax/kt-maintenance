@E2EMonitoring_Test_15.18
Feature: E2EMonitoring

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.18

  #Background for the test case: alarm of Test 15.17
    #STEP 1 - Login on DMC, Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
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

    #------------------------------------ Alarm and Notifications Alarm creation --------------------------------------- #
   #STEP 2
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
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I type "Test_Concept-04" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I wait 30 seconds
    And I check the presence of DeviceAlarmsConfigurationPage.testConcept04Device Element and then i click it
    # Click on next
    # In Low Threshold and High Threshold click "Next" without configuration a rule
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
    # On Telemetry rules set:
    And I check the presence of DeviceAlarmsConfigurationPage.addRuleTelemetryBTN Element and then i click it
    # ALL things
    And I check the presence of DeviceAlarmsConfigurationPage.targetTelemetryDropDown Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.allThingsOptionTelemetryRule Element and then i click it
    # TrendId value: 3000
    And I type "3000" into the element DeviceAlarmsConfigurationPage.trendIdTelemetryLabel
    # type: number
    And I check the presence of DeviceAlarmsConfigurationPage.typeTelemetryDropDown Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.numberTelemetryOption Element and then i click it
    # operator: =
    And I check the presence of DeviceAlarmsConfigurationPage.operatorTelemetryDropDown Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.equalOperatorTelemetryOption Element and then i click it
    # value: 10
    And I type "10" into the element DeviceAlarmsConfigurationPage.valueTelemetryLabel
    # Review the summary of the configuration and click Next to proceed
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab4 Element and then i click it
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
    Then I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
    ## Cellphone
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
    #------------------------------------ Alarm and Notifications Alarm creation End --------------------------------------- #

    Then I check the mail boxes

    #-----------------Step 3:
    # Create the new scripts with new value 10
    # Verify the alarm is received:
        #Listen to MQTT Topic
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-04", in the project "esol_ap29551_qa"
    Then I save current timestamp to check alarm
    Then I launch command "bash ./send_telemetry_thing_concept04_10.sh 1" on shell
    Then I wait 5 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption

    # Wait for receive alarms
    #And I wait 30 seconds
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption
    Then I input "Test_Concept-04_thing2" in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept04IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    Then I check the alarm was created successfully
    And I save alarm timestamp to check next alarm not created
    And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"environment_prefix\": \"esol_ap29551_qa\"" and "\"thing_id\": \"Test_Concept-04_thing2\""
    And I kill the notify_job command still opened
    #Check Email
    Then I check message of "telemetry" notification in mail object, from device "Test_Concept-04" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-04" is in sms boxes body

          #-----------------Step 4:
    #Modify the telemetry message, indicating as value 11 and verify the alarm is not created
    #And I wait 5 minutes after script
    Then I launch command "bash ./send_telemetry_thing_concept04_11.sh 1" on shell
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I check the presence of AlarmsPage.lastStatusInAlarmWithTestConcept04IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    Then I check that alarm was not created

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