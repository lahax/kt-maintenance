@Gateway_Test_7.16
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
    #The gateway is forced to reboot

  Scenario: Test 7.16
    #Step1
    #Repeat test DMC NRT Test Case 7.15

     #Login on DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I input with enter "Test_Concept-02" in DevicesPage.searchBox
    Then I close all the step functions in progress
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    And I check the absence of StepFunctionPage.deleteButtonEnabled
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.diagnosticDropDownOption Element and then i click it


    #Go to device page
    Then I click SidebarPage.devicesOption

    #Select the test gateway
    Then I input "Test_Concept-02" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it




    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"



#     #2. Click on reboot.
     #Click on reboot
    Then I check the presence of DevicesDetailsPage.rebootBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.rebootConfirmBTN Element and then i click it

    Then I save the job ID from the job document received
    And I run the script "close_job_reboot", with the job Id retrieved, on "Test_Concept-02" in the project "esol_ap29551_qa"


    #Step 2
    #Open Diagnostic - Step function
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle

    #Step 3
    #Check the Step function status is "SUCCEEDED"
    And I wait 2 minutes after script
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I kill the notify_job command still opened

    #Logout Step
    Then I click on the user icon and log out.