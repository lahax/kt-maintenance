@Map_Test_6.2
Feature: Logs
#TODO aggiornare confluence
  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 6.2

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.devicesOption Element and then i click it
    Then I check the presence of DevicesMapPage.tabCountry Element and then i click it

    #Step 3
    And I check the presence of DevicesMapPage.refreshButton
    And I check the presence of DevicesMapPage.fitBoundsButton

    And I check the presence of DevicesMapPage.fullscreenButton
    And I check the presence of DevicesMapPage.zoomInButton
    And I check the presence of DevicesMapPage.zoomOutButton

    Then I check the presence of DevicesMapPage.closePanelButton Element and then i click it

    Then I check that the Zoom "In" button works correctly
    Then I check that the Zoom "Out" button works correctly
    Then I check that the button fullScreen work properly
    And I check that the refresh button into the map page works properly
    And I check that the fit bounds button works correctly

    Then I check the presence of DevicesMapPage.openPanelButton Element and then i click it

    #Step 4
   #Then I check the presence of DevicesMapPage.onlineDevicesButton
   #Then I check the presence of DevicesMapPage.offlineDevicesButton
   #Then I check the presence of DevicesMapPage.gatewayViewButton
   #Then I check the presence of DevicesMapPage.thingsViewButton
   #Then I check the presence of DevicesMapPage.directThingViewButton

    Then I check the presence of DevicesMapPage.onlineDevicesIcon
    Then I check the presence of DevicesMapPage.offlineDevicesIcon
    Then I check the presence of DevicesMapPage.gatewayViewIcon
    Then I check the presence of DevicesMapPage.thingsViewIcon
    Then I check the presence of DevicesMapPage.directThingViewIcon

    #Step 5
    #Then I set chrome "iPad pro" mode
    #Then I check that the Zoom "In" button works correctly
    #Then I check that the Zoom "Out" button works correctly
    #Then I check that the button fullScreen work properly
    #And I check that the refresh button into the map page works properly
    #And I check that the fit bounds button works correctly
    #Then I check the presence of DevicesMapPage.onlineDevicesButton
    #Then I check the presence of DevicesMapPage.offlineDevicesButton
    #Then I check the presence of DevicesMapPage.gatewayViewButton
    #Then I check the presence of DevicesMapPage.thingsViewButton
    #Then I check the presence of DevicesMapPage.directThingViewButton

    #Then I set chrome "iPhone" mode
    #Then I check the presence of DevicesMapPage.chevronIconInfoPanel Element and then i click it
    #Then I check that the Zoom "In" button works correctly
    #Then I check that the Zoom "Out" button works correctly
    #Then I check that the button fullScreen work properly
    #And I check that the refresh button into the map page works properly
    #And I check that the fit bounds button works correctly
    #Then I check the presence of DevicesMapPage.chevronIconInfoPanel Element and then i click it
    #Then I check the presence of DevicesMapPage.onlineDevicesButton
    #Then I check the presence of DevicesMapPage.offlineDevicesButton
    #Then I check the presence of DevicesMapPage.gatewayViewButton
    #Then I check the presence of DevicesMapPage.thingsViewButton
    #Then I check the presence of DevicesMapPage.directThingViewButton