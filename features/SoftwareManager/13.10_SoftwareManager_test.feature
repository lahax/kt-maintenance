@Software_manager_Test_13.10
Feature: Software Manager

  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.10

    Then I enter on "esol-ap29551-qa" project

    ## STEP 1
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it

    And I check the presence of DeploymentsHistoryPage.checkableRow
    And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    And I check the presence of DeploymentsHistoryPage.subtitlePopup
    And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    Then I reload the page

    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.gatewayOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it

    And I check the presence of DeploymentsHistoryPage.checkableRow
    And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    And I check the presence of DeploymentsHistoryPage.subtitlePopup
    And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    Then I reload the page

    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.thingsOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    And I check the presence of DeploymentsHistoryPage.checkableRow
    And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    And I check the presence of DeploymentsHistoryPage.subtitlePopup
    And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    Then I reload the page

    #Then I set chrome "IPad pro" mode
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    #Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.checkableRow
    #And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    #And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    #And I check the presence of DeploymentsHistoryPage.subtitlePopup
    #And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    #And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    #And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    #And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    #Then I reload the page
    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.gatewayOptionFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.checkableRow
    #And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    #And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    #And I check the presence of DeploymentsHistoryPage.subtitlePopup
    #And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    #And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    #And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    #And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    #Then I reload the page
    #Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.thingsOptionFilter Element and then i click it
    #Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.checkableRow
    #And I select 3 element of list identified by DeploymentsHistoryPage.checkableRow
    #And I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    #And I check the presence of DeploymentsHistoryPage.deploySoftwareTitlePopup
    #And I check the presence of DeploymentsHistoryPage.subtitlePopup
    #And I check the presence of DeploymentsHistoryPage.greengrassDeployButton
    #And I check the presence of DeploymentsHistoryPage.greengrassResetButton
    #And I check the presence of DeploymentsHistoryPage.otaUpdateButton
    #And I check the presence of DeploymentsHistoryPage.firmwareUpdateButton
    #Then I reload the page

    And I click on the user icon and log out.