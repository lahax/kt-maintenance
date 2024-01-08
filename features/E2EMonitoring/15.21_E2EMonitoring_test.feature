@E2EMonitoring_Test_15.21
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login on DMC"
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

  Scenario: Test 15.21

    ## ---------- GOAL ---------- ##
    ## Custom groups page presents the correct table. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open sidemenu then click on E2E Monitoring and then select Custom Groups page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.customGroupsSubOption

    # STEP 3
    # Verify that the table presents these columns:
    #   Alarm Target
    #   Business
    #   Widespread Disservice
    #   Low Msg Rates THLD
    #   High Msg Rates THLD
    #   Telemetry Rules
    #   Actions --> This Column is not present. In the portal is an empty String.

    # ---------- DESKTOP ---------- #

    Then I check that user land on Custom Groups Page
    Then I check that all columns are present
    |GROUP NAME           |
    |PROJECT NAME         |
    |                     |

    # ---------- TABLET ---------- #

    #Then I set chrome "iPad pro" mode
    #Then I check that all columns are present
    #  |GROUP NAME           |
    #  |PROJECT NAME         |
    #  |                     |

    And I click on the user icon and log out.