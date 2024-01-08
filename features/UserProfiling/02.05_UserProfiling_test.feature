@User_Profiling_Test_2.5
Feature: User Profiling

  Background:

    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 2.5
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Click the Devices item in the side menu, the Basic role can navigate to the corresponding page.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    #Check that the table of devices is visible
    Then I check the presence of DevicesPage.tableDevicesPage
    #----------------------------------Step 3
      # The Basic role can only see the devices map or refresh the list.
    Then I check that the element DevicesPage.refreshDevicesBTN is active.
    Then I check the presence of DevicesPage.countryDevicesBTN Element and then i click it
    Then I check the presence of DevicesPage.countryMapDevices
    #In the Devices page, there is no more a fab-button. Only Activate Direct button it's present in the botton right of the page.
    #Activate Direct thing button is disabled.
    Then I check the presence of DevicesPage.listDevicesBTN Element and then i click it
    Then I check that the element DevicesPage.iconActivateDirect is not active.
