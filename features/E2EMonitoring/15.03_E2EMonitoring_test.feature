@E2EMonitoring_Test_15.3
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

  Scenario: Test 15.3

    ## ---------- GOAL ---------- ##
    ## Device alarms configuration table columns have informations. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption

    # STEP 3
    # Check that next the columns Alarm Target. Business, Widespread Disservice, Low Msg Rates THLD, High Msg Rates THLD, Telemetry Rules there is a info button:
    Then I check that there is the info icon close to each column name

    # STEP 4
    # Click on the info button for each column and verify the presence of the pop up:
    And I check each pop up after click on info icon

    # Step 5
    # Check also in Tablet mode.
    #Then I set chrome "ipad Pro" mode
    #And I check each pop up after click on info icon