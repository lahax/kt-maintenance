@E2EMonitoring_Test_15.7
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

  Scenario: Test 15.7

    ## ---------- GOAL ---------- ##
    ## Notifications Configurations page presents the refresh button and the wizard. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select  Notifications Configurations page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.notificationsConfigurationSubOption

    # STEP 3
    # - Check if in the bottom right of the page there is a wizard.
    # - Try to click on it and verify that a new window is open:
    Then I check the presence of NotificationsConfigurationsPage.wizardBTN
    When I click NotificationsConfigurationsPage.wizardBTN
    Then I check the presence of NotificationsConfigurationsPage.notificationsConfigurationsWizardPageTitle
    And I click NotificationsConfigurationsPage.backBTN

    # STEP 4
    # Check if in the top right of the page there is a refresh button. Verify that it works properly:

    # ---------- DESKTOP ----------- #
    And I check that the refresh button works properly in Notifications Configurations

    # ---------- TABLET ----------- #
    ##Then I set chrome "iPad pro" mode
    ##And I check that the refresh button works properly in Notifications Configurations
    ##When I click NotificationsConfigurationsPage.wizardBTN
    ##Then I check the presence of NotificationsConfigurationsPage.notificationsConfigurationsWizardPageTitle
    ##And I click NotificationsConfigurationsPage.backBTN
    # ---------- TABLET End ----------- #

    # STEP 5
    # - Access AWS Console with role IoTSupport or DMC role (according to the test environment)
    #     Open DynamoDB table esol_ap27611_<env>_ddb_devices_monitoring
    #     Click on Filer and add the filter project_id equal to the APM selected
    # - Check the total number of notification configuration is coherent with the list showed on DMC FrontEnd
    Then I count all the Notifications are present into the page
    And I check the table "esol_ap27611_test_ddb_notification_configuration" in order to verify the number of "notifications" present into the project "esol-ap29551-qa"

    #------------------------------------Remove configuration to restore changes---------------------------------------  #
     # If alarm is created is already deleted in the refresh methos
    Then I click on the user icon and log out.