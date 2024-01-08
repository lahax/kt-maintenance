@Devices_Test_5.13
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.13

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    #Go on Devices page and set up some filters (gateway typed devices).
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.filterBox Element and then i click it

    And I click Element DevicesPage.multiSelectDeviceTypeOption using Javascript
    #And I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it

    And I click Element DevicesPage.selectGatewayDeviceType using Javascript
    #And I check the presence of DevicesPage.selectGatewayDeviceType Element and then i click it

    And I click Element DevicesPage.multiSelectDeviceTypeOption using Javascript
    #And I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it

    And I click Element DevicesPage.multiSelectStatusOption using Javascript
    #And I check the presence of DevicesPage.multiSelectStatusOption Element and then i click it

    And I click Element DevicesPage.selectConnectedDeviceType using Javascript
    #And I check the presence of DevicesPage.selectConnectedDeviceType Element and then i click it

    #And I click Element DevicesPage.checkboxNeverConnected using Javascript
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it

    And I click Element DevicesPage.confirmFilters using Javascript
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    And I wait the progress bar

    #Step 3
    #Click the Export Data button:
    And I check the presence of DevicesPage.downloadExportIcon Element and then i click it
    And I check the presence of DevicesPage.confirmExportButton Element and then i click it

    #And I wait the progress bar
    #Then I wait 10 seconds
    And I confirm file download
    #Step 3+
    #Click the button and check the file dowloaded. The file must have only the filtered components.
    #Then I read the devices exported file and check the rows and device type columns are as expected
    Then I read the devices exported csv file and check the rows and device type columns are as expected

    #Logout Step
    Then I click on the user icon and log out.