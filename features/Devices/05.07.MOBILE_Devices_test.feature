@Device_Test_5.7.MOBILE
Feature: Devices

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.7.MOBILE
    Then I set chrome "iPhone" mode
    And I enter on "esol-ap29551-qa" project
    And I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Click on Sidebar menu then on "Devices" section.
    And I check the presence of SidebarPage.devicesOption Element and then i click it

    ## STEP 3
    ## Check that the Section is shown by design, using the right icons for the devices and the indentation for the things,
    ## under the main gateway:
    And I check the alignment and the correct presence of thing and gateway with icon

    #Logout Step
    Then I click on the user icon and log out.