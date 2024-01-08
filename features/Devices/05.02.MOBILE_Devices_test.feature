@Devices_Test_5.2.MOBILE
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.2.MOBILE
    #GOAL
    #Items are correctly shown in mobile view.
    #
    Then I set chrome "iPhone" mode
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    And I input "DRC-TEST-00" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I Check that the table contains the following filter 'DRC-TEST-00'

    #Logout Step
    Then I click on the user icon and log out.