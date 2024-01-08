@Gateway_Test_7.38
Feature: Gateway

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

          #GOAL
      #Update the thing's information

    #STEP 2 - If the device is simulated through script
    #
    #      Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
  Scenario: Test 7.38

    Then I enter on "esol-ap29551-qa" project
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"

    #STEP 3 - Access to Devices  Section then select a connected Gateway, enter the thing detail section and select the desired thing.
    #
    #Click on the button on the right and click Edit
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I input with enter "Test_Concept-02" in DevicesPage.searchBox
    Then I close all the step functions in progress
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    And I check the absence of StepFunctionPage.deleteButtonEnabled
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.diagnosticDropDownOption Element and then i click it
    Then I click SidebarPage.devicesOption
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Thing1Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.firstIdButtonConcept02Thing01 Element and then i click it
    Then I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.editThingsBTN Element and then i click it
    Then I cancel text from the input box element DevicesDetailsPage.updateModel
    And I type the random string into the element DevicesDetailsPage.updateModel - field "Model"
    Then I cancel text from the input box element DevicesDetailsPage.updateAlias
    And I type the random string into the element DevicesDetailsPage.updateAlias - field "Alias"
    Then I cancel text from the input box element DevicesDetailsPage.inputBoxMaker
    Then I type "Dell" into the element DevicesDetailsPage.inputBoxMaker
    Then I cancel text from the input box element DevicesDetailsPage.inputBoxLatitude
    Then I type "15.222" into the element DevicesDetailsPage.inputBoxLatitude
    Then I cancel text from the input box element DevicesDetailsPage.inputBoxLongitude
    Then I type "35.111" into the element DevicesDetailsPage.inputBoxLongitude
    Then I check the presence of DevicesDetailsPage.confirmUpdateBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.startUpdateBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.backUpdateBTN Element and then i click it

    #Step 4 - Wait for the job notify, then execute the close job script
    And I save the job ID from the job document received
    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-02 thing1" in the project "esol_ap29551_qa"

    #Step 5 - Verify the thing information are correctly updated on Thing section, selecting the thing and then clicking on More Info
    And I wait 5 minutes after script
    Then I check the presence of DevicesDetailsPage.showDetailsConcept02Thing01BTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.infoThingIcon Element and then i click it
    And I verify the update into the element DevicesDetailsPage.modelDetail - field "Model"
    And I verify the update into the element DevicesDetailsPage.aliasDetail - field "Alias"


    #Step 6 - Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I kill the notify_job command still opened

    #Logout step
    Then I click on the user icon and log out.