@Gateway_Test_7.34
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
    #Test that as DMC user I want to select the option "Delete Certificate" and "Force Delete" when deactivate a thing.


  Scenario: Test 7.34
    #PROCEDURE
    #Step 1
    #Login on DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    #Step2
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01_thing1" in DevicesPage.searchBox
    Then If thing "thing1" is not present I run register_thing.sh with gateway "Test_Concept-01"
    Then I check the presence of DevicesPage.testConcept01thing1Details Element and then i click it

    #Step 3
    #Go to AWS to see in IoT Core the thing and the certificate connected to the thing

    #Step 4 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 5
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I check the presence of DevicesDetailsPage.showDetailsConcept01Thing1BTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deactivateThingsBTN Element and then i click it

    #In the confirm form, flag "Delete certificate", then confirm:
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    #Then I wait 30 seconds

    #Step 6
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID
    And I run the script "close_job_deactivate_thing", with the job Id retrieved, on "Test_Concept-01" in the project "esol_ap29551_qa"

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Gateway connesso / Thing disconnesso: andare a buon fine (step function va in SUCCEEDED)
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionDeactivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I kill the notify_job command still opened
#--------------------------------------------------Retry with disconnected GW------------------------------------------------------------------
    Then I click HomePage.hamburgerMenuIcon

    #Step2
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01_thing1" in DevicesPage.searchBox
    Then If thing "thing1" is not present I run register_thing.sh with gateway "Test_Concept-01"
    Then I check the presence of DevicesPage.testConcept01thing1Details Element and then i click it

    #Step 3
    #Go to AWS to see in IoT Core the thing and the certificate connected to the thing

    #Step 5
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I check the presence of DevicesDetailsPage.showDetailsConcept01Thing1BTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deactivateThingsBTN Element and then i click it

    #In the confirm form, flag "Force Delete" or/and "Delete certificate", then confirm:
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "FAIL"
    #Gateway disconnesso / Thing disconnesso → la step function va in FAIL dopo 30 min (job aspetta la risposta dal Gateway) e non viene cancellata la Thing
    And I wait 30 minutes after script
    Then If present i click on Enter Button
    #Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionDeactivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.failedInDetailsStepFunction


#-------------------------------------------------Retry with flag with Delete Certificate and Force delete--------------------------------------------------

    Then I click HomePage.hamburgerMenuIcon

    #Step2
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01_thing1" in DevicesPage.searchBox
    Then If thing "thing1" is not present I run register_thing.sh with gateway "Test_Concept-01"
    Then I check the presence of DevicesPage.testConcept01thing1Details Element and then i click it

    #Step 3
    #Go to AWS to see in IoT Core the thing and the certificate connected to the thing

    #Step 4 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 5
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I check the presence of DevicesDetailsPage.showDetailsConcept01Thing1BTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deactivateThingsBTN Element and then i click it

    #In the confirm form, flag "Force Delete" or/and "Delete certificate", then confirm:
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I wait 30 seconds

    #Step 6
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID
    And I run the script "close_job_deactivate_thing", with the job Id retrieved, on "Test_Concept-01" in the project "esol_ap29551_qa"

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Gateway connesso / Thing disconnesso: andare a buon fine (step function va in SUCCEEDED)
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    #Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionDeactivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I kill the notify_job command still opened

#-------------------------------------------------Retry with flag with Delete Certificate and Force delete (DISCONNECTED GW)--------------------------------------

    Then I click HomePage.hamburgerMenuIcon

    #Step2
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01_thing1" in DevicesPage.searchBox
    Then If thing "thing1" is not present I run register_thing.sh with gateway "Test_Concept-01"
    Then I check the presence of DevicesPage.testConcept01thing1Details Element and then i click it

    #Step 5
    #Access to Devices Section, select a connected Gateway and enter on the details section. Click on Actions column (3 points):
    Then I check the presence of DevicesDetailsPage.showDetailsConcept01Thing1BTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deactivateThingsBTN Element and then i click it

    #In the confirm form, flag "Force Delete" or/and "Delete certificate", then confirm:
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Gateway disconnesso / Thing disconnessa - la step function rimane in progress per 30 min e poi se il
      # GW non si connette per 30 min viene comunque cancellata la thing e step function va in SUCCEEDED

    And I wait 30 minutes after script
    Then If present i click on Enter Button
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionDeactivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction


    #Step 8
    #After the command successfully ends, go to IoT Core on AWS Platform then check that the certificate has been deleted correctly
    #Default to clean dm
      # --------------riregister the thing to get the initial status---------------
    Then I launch command "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-01 thing1 ./payload_register_thing.txt" on shell
    #--------------riregister the thing to get the initial status---------------

    #Default to clean dmc
    Then I click on the user icon and log out.