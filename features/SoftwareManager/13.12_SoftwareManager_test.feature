@Software_manager_Test_13.12
Feature: Software Manager

  # Step 1
  # Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.12

    Then I enter on "esol-ap29551-qa" project

    # STEP 2 Access to DMC, open sidemenu then click on Software Manager
      # and click on Gateways Campaign Management submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
    # STEP 3 Check that the page presents a table with 4 columns:
    #ALL, Device ID, Device Software type and Actions.
    Then I check the presence of CampaignManagementPage.allSelectorColumnHeader
    Then I check the presence of CampaignManagementPage.deviceIdColumnHeader
    Then I check the presence of CampaignManagementPage.deviceTypeColumnHeader

    Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of CampaignManagementView.clearButton Element and then i click it

    And I save the name of the first record
    And I save the name of the first type record
    And I input the name previously saved into CampaignManagementView.gatewayIdInput
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    Then I check if the results has only the name previously saved

    #Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    Then I check the presence of CampaignManagementView.gatewaySoftwareType Element and then i click it
    And I click the option saved previously
#    Then I check the presence of CampaignManagementView.listOptionGatewaySoftware
#    And I save the text of the first option of the list CampaignManagementView.listOptionGatewaySoftware
#    Then I check the presence of CampaignManagementView.listOptionGatewaySoftware Element and then i click it
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    And I check if filter for "Gateway Software Type"

   # Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it

    #STEP 4 You should also be able to perform a custom query
    And I input the custom query into CampaignManagementView.firstRowIntTextarea
    Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    And I check if filter for "Custom Query"

    #Step 5
    #You should also be able to perform a custom query in the Direct Thing Management section:
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementSwitchBtn Element and then i click it
    And I save the name of the first record
    And I save the name of the first type record
    Then I check the presence of CampaignManagementPage.chevronDownFilterBox Element and then i click it
    And I input the name previously saved into CampaignManagementView.thingIDInputBox
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    Then I check if the results has only the name previously saved
    Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    Then I check the presence of CampaignManagementView.ThingSoftwareType Element and then i click it
    And I click the option saved previously
    Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    And I check if filter for "Thing Software Type"

    Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it
    And I save the name of the first record

    And I input the custom query into CampaignManagementView.firstRowIntTextarea for direct things
    Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    And I check if filter for "Custom Query"

    #Step 5 For Tablet mode
    #Then I set chrome "IPad Pro" mode

     # STEP 2 Access to DMC, open sidemenu then click on Software Manager
      # and click on Gateways Campaign Management submenu item.
    #Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    #Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    #Then I check the presence of CampaignManagementPage.gatewayCampaignManagementSwitchBtn Element and then i click it
    #Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
    # STEP 3 Check that the page presents a table with 4 columns:
    #ALL, Device ID, Device Software type and Actions.
    #Then I check the presence of CampaignManagementView.searchingFilter Element and then i click it
    #Then I check the presence of CampaignManagementPage.allSelectorColumnHeader
    #Then I check the presence of CampaignManagementPage.deviceIdColumnHeader
    #Then I check the presence of CampaignManagementPage.deviceTypeColumnHeader

    #Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it

    #And I save the name of the first record
    #And I save the name of the first type record
    #And I input the name previously saved into CampaignManagementView.gatewayIdInput
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #Then I check if the results has only the name previously saved

    #Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    #Then I check the presence of CampaignManagementView.gatewaySoftwareType Element and then i click it
    #And I click the option saved previously
#    Then I check the presence of CampaignManagementView.listOptionGatewaySoftware
#    And I save the text of the first option of the list CampaignManagementView.listOptionGatewaySoftware
#    Then I check the presence of CampaignManagementView.listOptionGatewaySoftware Element and then i click it
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #And I check if filter for "Gateway Software Type"

    #Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    #Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it

    #STEP 4 You should also be able to perform a custom query
    #And I input the custom query into CampaignManagementView.firstRowIntTextarea
    #Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    #And I check if filter for "Custom Query"

    #Step 5
    #You should also be able to perform a custom query in the Direct Thing Management section:
    #Then I check the presence of CampaignManagementPage.directThingsCampaignManagementSwitchBtn Element and then i click it

    #Then I check the presence of CampaignManagementView.searchingFilter Element and then i click it

    #And I save the name of the first record
    #And I save the name of the first type record
    #Then I check the presence of CampaignManagementPage.chevronDownFilterBox Element and then i click it
    #And I input the name previously saved into CampaignManagementView.thingIDInputBox
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #Then I check if the results has only the name previously saved
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #Then I check the presence of CampaignManagementView.ThingSoftwareType Element and then i click it
    #And I click the option saved previously
    #Then I check the presence of CampaignManagementView.confirmButton Element and then i click it
    #And I check if filter for "Thing Software Type"

    #Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    #Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it
    #Then I check the presence of CampaignManagementView.clearButton Element and then i click it
    #And I save the name of the first record

    #And I input the custom query into CampaignManagementView.firstRowIntTextarea for direct things
    #Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    #And I check if filter for "Custom Query"