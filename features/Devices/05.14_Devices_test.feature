@Devices_Test_5.14
Feature: Devices
#GOAL: After the working flows is successfully ended, the new Direct Thing is in the list
  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Verify the activity is correctly executed
  Scenario: Test 5.14

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    #Go on Devices page and click on "+" on the botton right of the page:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    #And I type "testConcept5" into the element DevicesPage.searchBox
    And I type "DirectThingConcept91" into the element DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    And If Element DevicesPage.directThingConcept91Details is present I click it
    And If Element DevicesDetailsPage.deactivateAthingBTN is present I click it
    And If Element DevicesDetailsPage.deleteCertificate is present I click it
    And If Element DevicesDetailsPage.forceDelete is present I click it
    And If Element DevicesDetailsPage.deleteConfirm is present I click it
    #Then I wait 30 seconds
    Then I check the presence of DevicesPage.newDevice Element and then i click it
    And I wait the progress bar
    #Step 3
    #Fill all the required fields:
    #Check Campi non inseriti- Activate button deve essere Disabilitato
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled

    #Inserisco solo ude campi obbligatori
    Then I type "DirectThingConcept91" into the element DevicesPage.idDirectThingBox
    Then I type "DirectThingConcept91" into the element DevicesPage.makerBox
      #Step 4
    #The Update button is enabled only when ALL required Standard fields are correctly filled:
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled

    Then I type "DirectThingConcept91" into the element DevicesPage.radioTypeBox
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled
    Then I type "DirectThingConcept91" into the element DevicesPage.serialNumberBox
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled
    Then I type "DirectThingConcept91" into the element DevicesPage.deviceTypeBox
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled
    Then I type "DirectThingConcept91" into the element DevicesPage.modelBox
    And I check that the DevicesPage.confirmActivationDirectThing element is disabled
    And I click DevicesPage.dropDownArrow
    And I click DevicesPage.interactionMode

    #And I check that the DevicesPage.confirmActivationDirectThing element is not disabled
    #Step 5
    #Click on Activate Button then wait for the call response
    #Search on Devices for the new dummy direct thing
    And I check the presence of DevicesPage.confirmActivationDirectThing Element and then i click it
    And I wait 60 seconds
    And If Element DevicesPage.toastMessageClose is present I click it
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I check the presence of DevicesPage.directThingConcept91
    Then I wait 180 seconds

    #Step 6
    #Open Diagnostic - Step Function section and verify the step function is completed with success
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    Then I wait the progress bar
    And I check the presence of StepFunctionPage.lastStepFunctionDirectThingConcept91_created Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #Deactivating the created device
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.directThingConcept91Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.deactivateAthingBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I wait 30 seconds

    #Logout Step
    Then I click on the user icon and log out.