@E2EMonitoring_Test_15.24
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

  Scenario: Test_15.24

    ## ---------- GOAL ---------- ##
    ## Custom groups page presents the refresh button. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open sidemenu then click on E2E Monitoring and then select Custom Groups page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.customGroupsSubOption
    Then I wait the progress bar
    # ------------------------------ Requirement - AT least one row of custom group ------------------------------ #
    Then If no custom group is present I create one
    # ------------------------------ Requirement End ------------------------------ #

    # STEP 3
    # Verify that in the top right of the page there is a refresh button and it works properly:
    Then I check in Custom Group that the refresh button works properly


    # ------------------------------ Remove Custom Group ------------------------------ #
    Then If I created a custom group I delete it
    # ------------------------------ Remove Custom Group ------------------------------ #