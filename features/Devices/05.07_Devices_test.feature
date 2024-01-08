@Device_Test_5.7
Feature: Devices
#GOAL: Check that the table showing: Icon, ID, Serial number, Project, Device Type, Maker, CERTIFICATE EXPIRATION, Device, Model, Software Version, Status and Actions.
  Background:
    # STEP 0 - Login and set Language english as default
    # Step 1 Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.7

    Then I enter on "esol-ap29551-qa" project
    # STEP 2 - Click on Sidebar menu then on "Devices" section.
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.devicesOption Element and then i click it
    # STEP 3 - Check that the Section is shown by design, using the right icons for the devices and the indentation for the things, under the main gateway:
    Then I check the alignment and the correct presence of thing and gateway with icon
    #Table header
    And I check the presence of DevicesPage.deviceIDColumn
    And I check the presence of DevicesPage.serialNumberColumn
    And I check the presence of DevicesPage.projectColumn
    And I check the presence of DevicesPage.deviceTypeColumn
    And I check the presence of DevicesPage.makerColumn
    And I check the presence of DevicesPage.certificateColumn
    And I check the presence of DevicesPage.deviceColumn
    And I check the presence of DevicesPage.modelColumn
    And I check the presence of DevicesPage.softwareVersionColumn
    And I check the presence of DevicesPage.statusColumn
    And I check the presence of DevicesPage.manageColumn
    # STEP 4 - Click on the tooltip next to Software Version and check that info is displayed as shown:
    Then I check the presence of DevicesPage.softwareVersionTooltipIcon Element and then i click it
    And I check the presence of DevicesPage.softwareVersionTooltipTitle
    And I check the presence of DevicesPage.softwareVersionTooltipText
    And I check the presence of DevicesPage.closeTooltipButton Element and then i click it
    # Logout Step
    Then I click on the user icon and log out.