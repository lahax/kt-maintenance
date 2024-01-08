@ThingFirmwareUpdate_Test_25.3
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.3
   # GOAL: ACTIVATE OCPP THING (with software NOT registered in SW Catalog)
   # Step 1
    #Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: ThingFirmwareUpdate_Test_25.3
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList

    And If the thing "Test_Concept-51_thing1" in the project "esol_ap29551_qa" is present I remove it through "job"
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-51", in the project "esol_ap29551_qa"
    And I wait 30 seconds

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList

    Then I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.activateThingsBTN Element and then i click it
    Then I check the presence of ActivateThingPage.inputField Element and then i click it
    Then I check the presence of ActivateThingPage.otherOption Element and then i click it
    And I input the payload into DevicesDetailsPage.firstRowIntTextarea for apm "esol_ap29551_qa"
    """
{
    "model": "MODEL",
    "maker": "MARKER",
    "alias": "ALIAS",
    "radio_type": "RADIO_TYPE",
    "interaction_mode": "gateway",
    "ipaddress": "10.0.0.41",
    "port_num": "8020",
    "serial_number": "01020304",
    "device_type": "DEVICE_TYPE",
    "filter_tag": [{"FILTER_TAG":"text"}],
    "environment_prefix": "esol_ap29551_qa",
    "sw_thing_type": "WrongSWThingType",
    "thing_software":[
        {
            "name": "WrongApp",
            "version": "100.0",
            "required": true
        }
    ]
}
    """
    Then I check the presence of ActivateThingPage.activateThingBTN Element and then i click it
    #Then I check the presence of ThingsPage.toasterError
    #Then I check the presence of ThingsPage.toasterDismiss Element and then i click it
    Then I wait 10 seconds
    And If Element ThingsPage.toasterDismiss is present I click it

    Then I check the absence of ThingsPage.TestConcept51Thing1



    Then I click on the user icon and log out.