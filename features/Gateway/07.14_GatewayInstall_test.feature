@Gateway_Test_7.14Intall
Feature: Gateway
#GOAL:Clicking on details button, it will show the gateway detail.
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
  Scenario: Intall test
    #PROCEDURE
    #Step 1
    #Access to DMC, open the sidemenu and click on Devices:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #Step 2
    #Choose a Gateway record and click on "gateway detail" in actions column:
    Then I install mosquitto

    Then I input "Test_Concept-02" in DevicesPage.searchBox

    Then I check the presence of DevicesPage.filterBox Element and then i click it
    And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
      #Step 3
    #Change a device's connection status

    Then I kill the notify_job command still opened
    Then I wait 10 seconds after script
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I check the presence of DevicesPage.testConcept02DisconnectedStatus
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"

    #Step 4
    #Click on the Align Status button in the top right of the page and verify that devices status are updated.
    Then I check the presence of DevicesPage.alignStatusIcon Element and then i click it
    Then I check the presence of DevicesPage.confirmAlignBTN Element and then i click it
    Then I wait 10 seconds after script
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I check the presence of DevicesPage.testConcept02ConnectedStatus
    Then I kill the notify_job command still opened

    Then I uninstall mosquitto

    #Logout step?
    Then I click on the user icon and log out.