@Devices_Test_5.4.MOBILE
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.4.MOBILE
    Then I set chrome "iPhone" mode
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Go to the page of Devices.
    Then I click SidebarPage.devicesOption

    ## Step 3
    #Near the refresh button, there is the Align Status button
    And I check the presence of DevicesPage.alignStatusIcon
    And I type "Test_Concept-01" into the element DevicesPage.searchBox
    And I check the presence of DevicesPage.testConcept01StatusDisconnected

    #Step 4
    #Change a device's connection status:
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"
    And I check the presence of DevicesPage.alignStatusIcon Element and then i click it
    And I check the presence of DevicesPage.confirmAlignBTN Element and then i click it
    And I check the presence of DevicesPage.toastMessageClose Element and then i click it
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait 60 seconds
    And I check the presence of DevicesPage.testConcept01StatusConnected
    Then I kill the notify_job command still opened

    # Logout Step
    Then I click on the user icon and log out.

