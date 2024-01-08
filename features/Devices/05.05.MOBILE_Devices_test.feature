@Device_Test_5.5.MOBILE
Feature: Devices

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.5.MOBILE
    Then I set chrome "iPhone" mode
    And I enter on "esol-ap29551-qa" project
    And I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Go to device page and verify that status must be "connected" or "disconnected".
    And I check the presence of SidebarPage.devicesOption Element and then i click it
    And I verify the correct value of the voices in the status column

    #Logout Step
    Then I click on the user icon and log out.