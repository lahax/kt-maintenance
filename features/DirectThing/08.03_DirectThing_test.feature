@DirectThing_Test_8.3
Feature: Direct Thing
#TODO: check confluence
  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.3
    Then I enter on "esol-ap29551-qa" project
    # Step 2 - Go to the page of Devices and select a IoT Direct Thing.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "Direct-Concept-4" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then If direct thing "Direct-Concept-4" is not present I run register_direct.sh
    Then I check the presence of DevicesPage.directConcept4Det Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #The device is simulated through script NOTIFY_JOB
    Then I kill the notify_job command still opened
    #Then I run the notify_job script on "DirectConceptDec3", in the project "esol_ap29551_qa"
    Then I run the notify_job script on "Direct-Concept-4", in the project "esol_ap29551_qa"
    #---------------------------------Step 3
    #Open the direct thing detail page and click on "deactivate":
    And I check the presence of DevicesDetailsPage.deactivateBTN Element and then i click it
    And I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    And I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
    #TO DO check on spunte presenti
    And I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it

    #--------------------------------Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    #Then I save the job ID
    Then I save the job ID from the job document received
    And I run the script "close_job_deactivate_direct", with the job Id retrieved, on "Direct-Concept-4" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #--------------------------------Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    And I wait 2 minutes after script
    #Check elimination
    And I clear the search Box in the Device Page
    Then I input "Direct-Concept-4" in DevicesPage.searchBox
    #Then I check the absence of DevicesPage.directConcept1Det

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I click HomePage.hamburgerMenuIcon
    #Go to step function
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDTConcept4 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #register the Direct to get the initial status
    #Then I launch command "bash ./register_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa DirectConceptDec3 ./payload_direct_thing.txt" on shell
    Then I launch command "bash ./register_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Direct-Concept-4 ./payload_direct_thing.txt" on shell
#    #Step 7
#    #Repeat steps 1 - 6 selecting the flags "Delete Certificate". Verify the flags are present in the job description on step 5  (already Done)
#
#    #Step 8
#    #Repeat steps 1 - 6 selecting the flags "Force Delete". Verify the device is deactivated with success
#    Then I click HomePage.hamburgerMenuIcon
#    Then I click SidebarPage.devicesOption
#    Then I wait the progress bar
#    And I clear the search Box in the Device Page
#    Then I input "Direct-Concept-1" in DevicesPage.searchBox
#    Then I check the presence of DevicesPage.directConcept1Det Element and then i click it
#    #If the device is simulated through script
#    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
#    Then I kill the notify_job command still opened
#    Then I run the notify_job script on "Direct-Concept-1", in the project "esol_ap29551_qa"
#    #Open a gateway detail page and click on "deactivate": flag Delete certificate and Force Delete
#    Then I check the presence of DevicesDetailsPage.deactivateBTN Element and then i click it
#    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
#    Then I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
#    #Click on confirm
#    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
#    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
#    #Close Job and check elimination
#    Then I save the job ID
#    #And I run the script "close_job_deactivate_direct", with the job Id retrieved, on "DirectConceptDec3" in the project "esol_ap29551_qa"
#    And I run the script "close_job_deactivate_direct", with the job Id retrieved, on "Direct-Concept-1" in the project "esol_ap29551_qa"
#    Then I kill the notify_job command still opened
#    Then I wait 2 minutes after script
#    Then I cancel text from the input box element DevicesPage.searchBox
#    Then I input "Direct-Concept-1" in DevicesPage.searchBox
#    Then I check the absence of DevicesPage.directConcept1Det
#
#    #Then I check the presence of DevicesPage.filterBox Element and then i click it
#    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
#    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
#
#    #Go to step function
#    Then I click HomePage.hamburgerMenuIcon
#    Then I click SidebarPage.diagnosticOption
#    And I click SidebarPage.stepFunctionSubOption
#    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
#    And I check the presence of StepFunctionPage.lastStepFunctionWithDTConcept1 Element and then i click it
#    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
#
#   #register the Direct to get the initial status---------------
#    #Then I launch command "bash ./register_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa DirectConceptDec3 ./payload_direct_thing.txt" on shell
#    Then I launch command "bash ./register_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Direct-Concept-1 ./payload_direct_thing.txt" on shell

    Then I click on the user icon and log out.