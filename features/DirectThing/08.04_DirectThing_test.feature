@DirectThing_Test_8.4
Feature: Direct Thing

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption


  Scenario: Test 8.4
    #PROCEDURE
    #Step 1
    #Login on DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Go to the page of Devices and select a IoT Direct Thing.
    Then I click SidebarPage.devicesOption
    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept1Details Element and then i click it

    #Step 3
    #the device is simulated through script
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "DirectThingConcept1", in the project "esol_ap29551_qa"

    #Step 4
    #Click on reboot.
    Then I check the presence of DevicesDetailsPage.rebootBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.rebootConfirmBTN Element and then i click it

    #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_reboot", with the job Id retrieved, on "DirectThingConcept1" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
    #Open Diagnostic - Step function
    #Wait for the DMC response
    And I wait 3 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept1 Element and then i click it
    #Step 8
    #Check the Step function status is "SUCCEEDED"
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction