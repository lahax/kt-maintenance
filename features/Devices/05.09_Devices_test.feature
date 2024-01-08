@Device_Test_5.9
Feature: Devices

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: test 5.9

    And I enter on "esol-ap29551-qa" project
    And I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Click on Sidebar menu then on "Devices" section
    Then I check the presence of SidebarPage.devicesOption Element and then i click it

    ## STEP 3
    ## Check that the filter bar is on top of the page:
    Then I check the presence of DevicesPage.filterBox

        # Logout Step
    Then I click on the user icon and log out.