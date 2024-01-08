@E2EMonitoring_Test_15.17
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login on DMC and go in E2E - Device Configuration page"
    # - The first step to access the DMC is logging in using the Enel email account or service number and password
    # - After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail
    #   or service number in the format shown in the imag
    # - After this step, you are redirected to sts.enel.com to login into the system
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.17

    ## ---------- GOAL ---------- ##
    ## Create E2E rule with:
    #    - perimeter: GW
    #    - Rule: Telemetry
    #    - No aggregation, max Frequency
    #    - Continuos
    #    - Notifications: all
    ## ----------      ---------- ##

    # STEP 1
    # "Login on DMC and go in E2E - Device Configuration page"
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    Then I wait the progress bar
    #STEP 2
    # Click on the Wizard Button to create an alarm
    #------------------------------------ Alarm and Notifications Alarm creation --------------------------------------- #

    Then I check the presence of DeviceAlarmsConfigurationPage.wizardBTN Element and then i click it
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
    Then I type "Test_Concept-02" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I cancel a letter from the input box element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I wait 10 seconds
    And I check the presence of DeviceAlarmsConfigurationPage.testConcept02Device Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    # In Low Threshold and High Threshold click "Next" without configuration a rule
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
    # Cellphone
    #Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
    #And I type "+393270376141" into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
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

#------------------------------------Remove configuration to restore changes End---------------------------------------

    Then I click on the user icon and log out.