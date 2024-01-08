@DirectThing_Test_8.1
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.1
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Clicking on details button, it will show the direct thing detail.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    #Step 3
    #3a. Click on "direct thing detail" in actions column:
    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #3b. Check Direct Thing detail page:
    Then I check the presence of DevicesDetailsPage.aboveTitleDirectThing
    Then I check the presence of DevicesDetailsPage.directThingPageTitle
    Then I check the presence of DevicesDetailsPage.directThingStatusAlert
    Then I check the presence of DevicesDetailsPage.deviceLastLogsText
    Then I check the presence of DevicesDetailsPage.deviceLocalizationMap
    Then I check the presence of DevicesDetailsPage.infoIcon
    Then I check the presence of DevicesDetailsPage.historyIcon
    Then I check the presence of DevicesDetailsPage.systemCommandsHeader
    Then I check the presence of DevicesDetailsPage.rebootBTN
    Then I check the presence of DevicesDetailsPage.firmwareUpdateBTN
    Then I check the presence of DevicesDetailsPage.deactivateBTN
    Then I check the presence of DevicesDetailsPage.updateBTN
    Then I check the presence of DevicesDetailsPage.renewCertificatesBTN
    Then I check the presence of DevicesDetailsPage.remoteControlBTN
    Then I check the presence of DevicesDetailsPage.showLogsBTN
    Then I check the presence of DevicesDetailsPage.getHistoryLogsBTN
    Then I check the presence of DevicesDetailsPage.enableCollectLogsBTN
    Then I check the presence of DevicesDetailsPage.downloadFileBTN
    Then I check the presence of DevicesDetailsPage.uploadFileBTN
    Then I check the presence of DevicesDetailsPage.TelemetryBTN

    #Tablet view:
    #Then I check the presence of DevicesDetailsPage.backBTN Element and then i click it
    #Then I set chrome "tablet" mode
#    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    #And I check the presence of DevicesDetailsPage.directThingPageTitle
    #Then I check the presence of DevicesDetailsPage.aboveTitleDirectThing
    #Then I check the presence of DevicesDetailsPage.directThingPageTitle
    #Then I check the presence of DevicesDetailsPage.directThingStatusAlert
    #Then I check the presence of DevicesDetailsPage.deviceLocalizationMap
    #Then I check the presence of DevicesDetailsPage.infoIcon
    #Then I check the presence of DevicesDetailsPage.historyIcon
    #Then I check the presence of DevicesDetailsPage.systemCommandsHeader
    #Then I check the presence of DevicesDetailsPage.rebootBTN
    #Then I check the presence of DevicesDetailsPage.firmwareUpdateBTN
    #Then I check the presence of DevicesDetailsPage.deactivateBTN
    #Then I check the presence of DevicesDetailsPage.updateBTN
    #Then I check the presence of DevicesDetailsPage.renewCertificatesBTN
    #Then I check the presence of DevicesDetailsPage.remoteControlBTN
    #Then I check the presence of DevicesDetailsPage.showLogsBTN
    #Then I check the presence of DevicesDetailsPage.getHistoryLogsBTN
    #Then I check the presence of DevicesDetailsPage.enableCollectLogsBTN
    #Then I check the presence of DevicesDetailsPage.downloadFileBTN
    #Then I check the presence of DevicesDetailsPage.uploadFileBTN
    #Then I check the presence of DevicesDetailsPage.TelemetryBTN

    #Mobile view:
    #Then I check the presence of DevicesDetailsPage.backBTN Element and then i click it
    #Then I set chrome "iPhone" mode
#    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    #And I check the presence of DevicesDetailsPage.directThingPageTitle
    #Then I check the presence of DevicesDetailsPage.aboveTitleDirectThing
    #Then I check the presence of DevicesDetailsPage.directThingPageTitle
    #Then I check the presence of DevicesDetailsPage.directThingStatusAlert
    #Then I check the presence of DevicesDetailsPage.deviceLocalizationMap
    #Then I check the presence of DevicesDetailsPage.infoIcon
    #Then I check the presence of DevicesDetailsPage.historyIcon
    #Then I check the presence of DevicesDetailsPage.systemCommandsHeader
    #Then I check the presence of DevicesDetailsPage.rebootBTN
    #Then I check the presence of DevicesDetailsPage.deactivateBTN
    #Then I check the presence of DevicesDetailsPage.renewCertificatesBTN