@Devices_Test_5.10
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.10

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    Then I check the presence of DevicesPage.filterBox Element and then i click it

    Then I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it
    #Then I check the presence of DevicesPage.directThingDeviceTypeOption Element and then i click it
    #And I click Element DevicesPage.directThingDeviceTypeOption using Javascript
    Then I select "direct thing" in drop down menu in filter box on Device Page using Javascript
    #Then I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it

    Then I check the presence of DevicesPage.inputModelBox Element and then i click it
    Then I type "666" into the element DevicesPage.inputModelBox
    Then I select "666" in input option box

    Then I check the presence of DevicesPage.multiSelectStatusOption Element and then i click it
    Then I select "disconnected" in drop down menu in filter box on Device Page using Javascript
    #Then I check the presence of DevicesPage.multiSelectStatusOption Element and then i click it

    Then I check the presence of DevicesPage.multiSelectCertificateExpirationOption Element and then i click it
    Then I select "N/A" in drop down menu in filter box on Device Page using Javascript
    #Then I check the presence of DevicesPage.multiSelectCertificateExpirationOption Element and then i click it

    Then I check the presence of DevicesPage.inputMakerBox Element and then i click it
    Then I type "222" into the element DevicesPage.inputMakerBox
    Then I select "222" in input option box

    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check if the all row contain "direct" in "Device Type" column
    Then I check if the all row contain "666" in "Model" column
    Then I check if the all row contain "N/A" in "Certificate Expiration" column
    Then I check if the all row contain "222" in "Maker" column
    Then I check if the all row contain "disconnected" in "Status" column

    # Logout Step
    Then I click on the user icon and log out.