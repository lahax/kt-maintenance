@Gateway_Test_7.15
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
    #Verify that every change of status is caused by the connection/disconnection to the IoT broker

  Scenario: Test 7.15
    #PROCEDURE
    #Step 1
    #Login on DMC

    #Step 2
    #Select more the project "EGIP - QA"
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
    #Step 3
    #Go to device page
    Then I click SidebarPage.devicesOption

    #Step 4
    #Select the test gateway
    Then I input "Test_Concept-02" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it

    #Step 5 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"

    #Step 6
    #Click on reboot
    Then I check the presence of DevicesDetailsPage.rebootBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.rebootConfirmBTN Element and then i click it

    #Step 7 - optional
    #If device is simulated through script
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_reboot", with the job Id retrieved, on "Test_Concept-02" in the project "esol_ap29551_qa"
    #Step 8
    #Check the gateway's connection status is changed
     #NB not possible because gateway simulated through script is not affected by reboot

      #Default to clean dmc
    Then I kill the notify_job command still opened
    Then I click on the user icon and log out.