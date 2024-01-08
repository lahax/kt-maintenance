@E2EMonitoring_Test_15.6
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

  Scenario: Test 15.6

    ## ---------- GOAL ---------- ##
    ## Notifications Configurations page presents the correct table. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select  Notifications Configurations page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.notificationsConfigurationSubOption

    # STEP 3
    # Check there are these columns in the table:
    #   Alarm Source
    #   Scope Target
    #   Scope Type
    #   Notifications Schedule
    #   Subscriptions
    #   Actions --> This Column is not present. In the portal is an empty String.

    # ---------- DESKTOP ---------- #

    Then I check that user land on  Notifications Configurations page
    Then I check that all columns are present
    |ALARM SOURCE           |
    |SCOPE TARGET           |
    |SCOPE TYPE             |
    |NOTIFICATIONS SCHEDULE |
    |SUBSCRIPTIONS          |
    |                       |

    # ---------- TABLET ---------- #

    #Then I set chrome "iPad pro" mode
    #Then I check that all columns are present
    #  |ALARM SOURCE           |
    #  |SCOPE TARGET           |
    #  |SCOPE TYPE             |
    #  |NOTIFICATIONS SCHEDULE |
    #  |SUBSCRIPTIONS          |
    #  |                       |