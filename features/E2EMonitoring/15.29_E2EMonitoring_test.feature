@E2EMonitoring_Test_15.29
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


  Scenario: Test case 15.29

    ## ---------- GOAL ---------- ##
    ## Modify custom group ##
    ## ----------      ---------- ##

    # --------- DESKTOP ---------- #

    # STEP 1 "Login on DMC and go in E2E - Custom Group page"
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    And I wait the progress bar
    Then If "Test_15.26" is present I delete it
    # -------------------- REPEAT THE PROCEDURE of 15.26 to create a custom group  --------------------#
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    # Click on the + Button to create an custom group
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
    Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Save
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    Then I wait the progress bar
    # -------------------- REPEAT THE PROCEDURE of 15.26 to create a custom group End  --------------------#

    # STEP 2
    # Click on the Edit button for the custom group created on DMC NRT Test Case 15.26:
    Then I reload the page
    Then I check the presence of CustomGroupsPage.pencilTest15_26 Element and then i click it

    # STEP 3
    # Modify the group:
    #  - Remove a thing and a gateway
    #  - Add a thing and a gateway
    Then I check the presence of CustomGroupsPage.cancelConcept01Thing1 Element and then i click it
    Then I check the presence of CustomGroupsPage.cancelGatewayConcept02 Element and then i click it
    # Add a thing
    # Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I input "Test_Concept-03" in CustomGroupsPage.addGatewaySvd
    Then I type " " into the element CustomGroupsPage.addGatewaySvd
    Then I check the presence of CustomGroupsPage.testConcept03Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBoxSvd Element and then i click it
    Then I check the presence of CustomGroupsPage.testConcept03thing1 Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # And a gateway
    Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I type "Test_Concept-03" into the element CustomGroupsPage.addGatewaySvd
    Then I type " " into the element CustomGroupsPage.addGatewaySvd
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I check the presence of CustomGroupsPage.testConcept03Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBoxSvd Element and then i click it
    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Then save
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    Then I wait the progress bar
    # Close and reopen the group to verify changes are applied:
    And I reload the page
    Then I check the presence of CustomGroupsPage.pencilTest15_26 Element and then i click it
    And  I check the presence of CustomGroupsPage.concept03Thing1box
    And  I check the presence of CustomGroupsPage.conceptGateway03box
    And  I check the presence of CustomGroupsPage.concept01Thing2box
    And  I check the presence of CustomGroupsPage.directXXBox
    And  I check the presence of CustomGroupsPage.conceptGateway01box
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    Then I wait the progress bar
    Then If "Test_15.26" is present I delete it
    # ----------------------------------- Delete Custom Group ----------------------------------- #

    # ---------- TABLET ---------- #

    #Then I set chrome "iPad pro" mode

    # -------------------- REPEAT THE PROCEDURE of 15.26 to create a custom group --------------------#
    #Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    # Click on the + Button to create an custom group
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
    #Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Save
    #Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    #And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    #Then I wait the progress bar
    # -------------------- REPEAT THE PROCEDURE of 15.26 to create a custom group End  --------------------#

    # STEP 2
    # Click on the Edit button for the custom group created on DMC NRT Test Case 15.26:
    #And I reload the page
    #Then I check the presence of CustomGroupsPage.pencilTest15_26 Element and then i click it

    # STEP 3
    # Modify the group:
    #  - Remove a thing and a gateway
    #  - Add a thing and a gateway
    #Then I check the presence of CustomGroupsPage.cancelConcept01Thing1 Element and then i click it
    #Then I check the presence of CustomGroupsPage.cancelGatewayConcept02 Element and then i click it
    # Add a thing
    # Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I input "Test_Concept-03" in CustomGroupsPage.addGateway
    #Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.testConcept03Device Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I check the presence of CustomGroupsPage.testConcept03thing1 Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # And a gateway
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I type "Test_Concept-03" into the element CustomGroupsPage.addGateway
    #Then I type " " into the element CustomGroupsPage.addGateway
    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    #Then I check the presence of CustomGroupsPage.testConcept03Device Element and then i click it
    #Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    #And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # Then save
    #Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    #And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    #Then I wait the progress bar
    #And I reload the page

    # Close and reopen the group to verify changes are applied:
    #Then I check the presence of CustomGroupsPage.pencilTest15_26 Element and then i click it
    #And  I check the presence of CustomGroupsPage.concept03Thing1box
    #And  I check the presence of CustomGroupsPage.conceptGateway03box
    #And  I check the presence of CustomGroupsPage.concept01Thing2box
    #And  I check the presence of CustomGroupsPage.directXXBox
    #And  I check the presence of CustomGroupsPage.conceptGateway01box

    # ----------------------------------- Delete Custom Group ----------------------------------- #
    #Then If "Test_15.24" is present I delete it
    # ----------------------------------- Delete custom group ----------------------------------- #

