@E2EMonitoring_Test_15.4
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login To DMC"
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

  Scenario: Test_15.4

    ## ---------- GOAL ---------- ##
    ## Device alarms configuration action column is correctly shown. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    Then I wait the progress bar
    # STEP 3
    # Check that actions columns has 3 buttons:
    #   More info (page button)
    #   Edit (pencil button)
    #   Delete (bin button)
    #
    # NOTE -> Before the check, we create an alarm

    # ------------------------------------ Alarm Creation --------------------------------------- #
     Then If there is not at least one alarm I create one
    # ------------------------------------ Alarm Creation End --------------------------------------- #

    Then I check the presence of DeviceAlarmsConfigurationPage.iconDocumentFirstRow
    Then I check the presence of DeviceAlarmsConfigurationPage.iconPencilFirstRow
    Then I check the presence of DeviceAlarmsConfigurationPage.iconTrashFirstRow

    And I click on DeviceAlarmsConfigurationPage.iconDocumentFirstRow action icon and check the landing page or pop up

    #And I check the presence of ProjectPage.logoEnel

    And I click on DeviceAlarmsConfigurationPage.iconPencilFirstRow action icon and check the landing page or pop up
    And I navigate to "https://dmc-iot-test.enel.com/#/projects/devices-configurations"
    And I click on DeviceAlarmsConfigurationPage.iconTrashFirstRow action icon and check the landing page or pop up

    # STEP 4
    # Also check in tablet mode the correct view of all details pages.
    Then I set chrome "iPad pro" mode
    #And I click on DeviceAlarmsConfigurationPage.iconDocumentFirstRow action icon and check the landing page or pop up
    #And I click on DeviceAlarmsConfigurationPage.iconPencilFirstRow action icon and check the landing page or pop up
    #And I click on DeviceAlarmsConfigurationPage.iconTrashFirstRow action icon and check the landing page or pop up

    # ------------------------------------ Remove configuration to restore changes --------------------------------------- #

    # Remove Device Alarms Configurations
     Then If I created an Alarm I delete it
