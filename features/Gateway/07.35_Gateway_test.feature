@Gateway_Test_7.35
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
      #This test will verify the Monitor Gateway Functionality

    #STEP 2 - Select Device Project
  Scenario: Test 7.35

    Then I enter on "esol-ap29551-qa" project

    #STEP 3 - From left menu Go to Devices and search for a gateway and go to the detail page

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it

    #STEP 4 - If the device is simulated through script
    #
    #      Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>

    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-02", in the project "esol_ap29551_qa"
    And I wait 5 seconds

    #STEP 5 - select the flag "monitor"

    #Then I check the presence of DevicesDetailsPage.monitoringFlag Element and then i click it
    Then I click DevicesDetailsPage.monitoringFlag


    #STEP 6 - Wait for the job notify and Run close job script using jobId contained in the previous message

    Then I save the job ID from the job document received
    And I run the script "close_job_monitoring", with the job Id retrieved, on "Test_Concept-02" in the project "esol_ap29551_qa"


    #STEP 7 - Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"


    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I wait 2 minutes after script
    And I wait 5 seconds
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I kill the notify_job command still opened

    #Logout step
    Then I click on the user icon and log out.


