@Devices_Test_5.6.MOBILE
Feature: Devices

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.6.MOBILE

    ## STEP 2
    ## Select project in the project list selection.
    Then I set chrome "iPhone" mode
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    ## STEP 3
    ## Go to Device page and click on a Gateway/Direct Thing/Thing detail.
    ## The only way to access to details is by clicking on the detail button:
    Then I check the presence of SidebarPage.devicesOption Element and then i click it

    Then I click icon details of a device of type 'direct'
    Then I check the presence of DevicesDetailsPage.systemCommandsHeader
    Then I check the presence of DevicesDetailsPage.backBTN Element and then i click it

    Then I click icon details of a device of type 'gateway'
    Then I check the presence of DevicesDetailsPage.systemCommandsHeader
    Then I check the presence of DevicesDetailsPage.backBTN Element and then i click it

    Then I click icon details of a device of type 'thing'
    Then I check the presence of DevicesDetailsPage.thingTypedDeviceLandingPage
    Then I check the presence of DevicesDetailsPage.backBTN Element and then i click it

    #Logout Step
    Then I click on the user icon and log out.