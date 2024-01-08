@Devices_Test_5.3.MOBILE
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.3.MOBILE
    Then I set chrome "iPhone" mode
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    ## STEP 2
    ## Go to the page of Devices.
    Then I click SidebarPage.devicesOption

    ## STEP 3
    ## On the top of the page, next to the search bar, there is the refresh button:
    Then I check the presence of DevicesPage.refreshBTN

    #Step 4
    ## Click on Refresh button and check the functionality.
    Then I check that the refresh button works properly in the device page

    #Logout Step
    Then I click on the user icon and log out.