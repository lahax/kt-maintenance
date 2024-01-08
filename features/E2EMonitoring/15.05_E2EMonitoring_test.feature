@E2EMonitoring_Test_15.5
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

  Scenario: Test_15.5

    ## ---------- GOAL ---------- ##
    ## Device alarms configuration is correctly translated. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption

    # STEP 3
    # On the top right of the page, near the notification bell:
    And I click HomePage.infoUserLoggedIn

    # STEP 4
    # Go with the pointer on "Language" and choose a language:
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    # STEP 5
    # Check that the page is translated in the language chosed
    And I check that the Device Configuration Alarm Page is correctly translated



