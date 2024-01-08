@Devices_Test_5.16
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.16

    #STEP 1 - Login on DMC and go in Devices page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I click DevicesPage.filterBox

    #Step 2
    #Click on User Section, on the top right of the page, near the notification bell
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    #Step 3
    #Go with the pointer on "Language" and choose a language:
    When I click HomePage.buttonItalianoSubOption
    #Step 4
    #Check that the Page is translated in the language chosen
    And I check that the Devices page is correctly translated in italian

    # Logout Step
    And I click on the user icon and log out.