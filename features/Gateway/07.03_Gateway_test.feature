@Gateway_Test_7.3
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Test Alaign Status button in the gateway page. Devices status has to be align with the iot registry
    #Opera sullo stato delle things del gateway in questione

  Scenario: Test 7.3
    #PROCEDURE
    #Step 1
    #Login on DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Go to device page
    Then I click SidebarPage.devicesOption

    #Step 3
    #Click on details button  of a Gateway
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it

    #Step 4
    #Change the device's connection status:
      #If you are simulating the device through script, execute/stop the script notify_job
      #If you are using an EC2 with VEIG/EIG stop it
      #If you are using a gateway simulator, stop it
     Then I kill the notify_job command still opened
     Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 5 - Check DMC
     #1. Gateway connected
     Then I check the presence of DevicesDetailsPage.deviceConnectedStatus
     #2. Click on reboot.
     Then I check the presence of DevicesDetailsPage.rebootBTN Element and then i click it
     Then I check the presence of DevicesDetailsPage.confirmRebootBTN Element and then i click it
     #3. Check the status is now disconnected.
      #Not possible - reboot doesnt affect simulated devises
     #Then I check the presence of DevicesDetailsPage.deviceDisconnectedStatus
     #4. Wait for up to 5 minutes
     Then I wait up to 1 minutes after reboot
     #5.Check the status is now connected again
     Then I check the presence of DevicesDetailsPage.deviceConnectedStatus

    #Step 6 - Check platform
      #Click on Alaign Status and check that the status of devices are align on IoT platform.
     Then I check the presence of DevicesDetailsPage.alignStatusIcon Element and then i click it
     Then I check the presence of DevicesDetailsPage.confirmAlignBTN Element and then i click it
      #curl --request GET \
      #--url https://1wmcqub4mi.execute-api.eu-central-1.amazonaws.com/test/projects/esol-ap29551-qa/gateways/EVO22 \
      #--header 'Authorization: Bearer <TOKEN>
    Then I retrieve token from dmc
      Given Header "Authorization"
      Then I make a custom "GET" request to https://1wmcqub4mi.execute-api.eu-central-1.amazonaws.com/test/projects/esol-ap29551-qa/gateways/Test_Concept-01
      Then I check that the status "connected" of device is align

      And I wait 30 seconds
      Then I kill the notify_job command still opened
      Then I click on the user icon and log out.