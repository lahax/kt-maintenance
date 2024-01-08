@E2EMonitoring_Test_15.26
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login on DMC and go in E2E - Custom Group page"
    # - The first step to access the DMC is logging in using the Enel email account or service number and password
    # - After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail
    #   or service number in the format shown in the imag
    # - After this step, you are redirected to sts.enel.com to login into the system
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project

  Scenario: Test case 15.26

    ## ---------- GOAL ---------- ##
    ## Crea custom group. ##
    ## ----------      ---------- ##

    # --- Commented code that can serve in the future to create a gateway, a thing and a direct thing --- #

      # BACKGROUND FOR THE TEST CASE: CREATE 2 GATEWAYS, A THING AND A DIRECT THING
      # Register the gateway Concept-01, its thing1 and Concept-02
      # Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_perf Test_Concept-01 ./payload_gateway_greengrass.txt" on shell
      # Then I activate the "thing1" on "Test_Concept-01", in the project "esol_ap29551_perf".
      # Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_perf Test_Concept-02 ./payload_gateway_greengrass.txt" on shell
      # Add a direct thing (from DMC):
      # And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
      # Then I check the presence of SidebarPage.devicesOption Element and then i click it
      # Then I check the presence of DevicesPage.iconActivateDirect Element and then i click it
      # And I type "DirectThing_Test15_26" into the element DevicesPage.idDirectThingBox
      # And I type "Test15_26" into the element DevicesPage.makerBox
      # And I type "Test15_26" into the element DevicesPage.radioTypeBox
      # And I type "Test15_26" into the element DevicesPage.serialNumberBox
      # Then I check the presence of DevicesPage.dropDownArrowTAB Element and then i click it
      # Then I check the presence of DevicesPage.directInteraction Element and then i click it
      # And I type "Test15_26" into the element DevicesPage.deviceTypeBox
      # And I type "Test15_26" into the element DevicesPage.modelBox
      # Then I check the presence of DevicesPage.confirmActivationDirectThing Element and then i click it

    # --- Commented code that can serve in the future to create a gateway, a thing and a direct thing --- #

    # STEP 1
    # Login on DMC and go in E2E - Custom Group page
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it


    # ---------- DESKTOP ---------- #
    Then If "Test_15.26" is present I delete it

     # STEP 2
    # Click on the + Button to create an custom group
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it

    # STEP 3
    # Insert a group name,
    And I type "Test_15.26" into the element CustomGroupsPage.addGroupName
    # then add:
    # A thing
    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I input "Test_Concept" in CustomGroupsPage.addThingBox
    Then I check the presence of CustomGroupsPage.testConcept01thing1 Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A direct thing
    Then I type "DirectXX" into the element CustomGroupsPage.addDirectThingBox
    Then I cancel a letter from the input box element CustomGroupsPage.addDirectThingBox
    #Then I check the presence of CustomGroupsPage.addDirectThingBox Element and then i click it
    And I check the presence of CustomGroupsPage.directThingXX Element and then i click it
    And I check the presence of CustomGroupsPage.addDirectThingBTN Element and then i click it
    # A gateway with all it things (you should be able to simulate this gateway)
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A gateway without things
    Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
    Then I click Element DeviceAlarmsConfigurationPage.outsideDiv using Javascript
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Save
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    And If Element CustomGroupsPage.toastMessageClose is present I click it
    #Then I wait the progress bar
    #Then If Element CustomGroupsPage.toastMessageClose is present I click it
    # ----------------------------------- Delete Custom Group  ----------------------------------- #

    Then If "Test_15.26" is present I delete it

    # ----------------------------------- Delete Custom Group  ----------------------------------- #
    Then I click on the user icon and log out.
    # ---------- TABLET ---------- #

    #Then I set chrome "iPad pro" mode

    # STEP 2
    # Click on the + Button to create an custom group (REPEAT)
    #Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    # STEP 3
    # Insert a group name,
    #And I type "Test_15.26" into the element CustomGroupsPage.addGroupName
    # then add:
    # A thing
    #Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    #Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I input "Test_Concept" in CustomGroupsPage.addThingBox
    #Then I check the presence of CustomGroupsPage.testConcept01thing1 Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A direct thing
    #Then I type "DirectXX" into the element CustomGroupsPage.addDirectThingBox
    #Then I cancel a letter from the input box element CustomGroupsPage.addDirectThingBox
    #Then I check the presence of CustomGroupsPage.addDirectThingBox Element and then i click it
    #And I check the presence of CustomGroupsPage.directThingXX Element and then i click it
    #And I check the presence of CustomGroupsPage.addDirectThingBTN Element and then i click it
    # A gateway with all it things (you should be able to simulate this gateway)
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
    #Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A gateway without things
    #Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
    #Then I click Element DeviceAlarmsConfigurationPage.outsideDiv using Javascript
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Save
    #Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    #And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    #---------------------------------- Delete Custom Group ---------------------------------- #
    #not working because the last custom group delete btn is hidden behind the add Custom Group BTN
    #Then If "Test_15.26" is present I delete it

    #---------------------------------- Delete Custom Group ---------------------------------- #

    #--------------RESET PART FOR THE TEST CASE: DELETE THE GATEWAYS, THE THING AND THE DIRECT THING