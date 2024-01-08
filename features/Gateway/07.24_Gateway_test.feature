@Gateway_Test_7.24
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
    #All the desired packages are configured and installed.

  Scenario: Test 7.24
    #PROCEDURE
    #Step 1
    #Login on DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "TestConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    #BackGround
    Then If gateway "TestConcept1" is not present I run register.sh
    And I wait 30 seconds
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I check the presence of DevicesPage.testConcept1NoThingDetails Element and then i click it

    #Step 2 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "TestConcept1", in the project "esol_ap29551_qa"

    #Step 3
    #Open a gateway detail page and click on "deactivate":
    Then I check the presence of DevicesDetailsPage.deactivateBTN Element and then i click it

    #Step 4
    #Click on confirm without selecting any flag - NOT POSSIBLE we would lost the certificate
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it

    #Step 7
    #    #Repeat steps 1 - 6 selecting the flags "Delete Certificate". Verify the flags are present in the job description on step 5
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it

    #Step 5
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    #Verify the flags are present in the job description
    Then I save the job ID from the job document received and check the attribute force delete: "false"
    And I run the script "close_job_deactivate_gateway", with the job Id retrieved, on "TestConcept1" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 6
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    And I wait 4 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.deactivateGatewayTestConcept1Details Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
    #--------------riregister the gateway to test second case---------------
    Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa TestConcept1 ./payload_gateway_greengrass.txt" on shell
    And I wait 2 minutes after script
    #--------------riregister the gateway to test second case---------------


    #Step 8
    #Repeat steps 1 - 6 selecting the flags "Force Delete". Verify the device is deactivated with success
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I reload the page
    Then I wait the progress bar
    Then I input "TestConcept1" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept1NoThingDetails Element and then i click it

    #Step 2 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "TestConcept1", in the project "esol_ap29551_qa"

    #Step 3
    #Open a gateway detail page and click on "deactivate": flag Delete certificate and Force Delete
    Then I check the presence of DevicesDetailsPage.deactivateBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
    Then I check the presence of DevicesDetailsPage.forceDelete Element and then i click it
    #Step 4
    #Click on confirm
    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
    Then I kill the notify_job command still opened
    Then I wait 1 minutes after script
    Then I input "TestConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the absence of DevicesPage.testConcept1NoThingDetails

    #--------------riregister the gateway to get the initial status---------------
    Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa TestConcept1 ./payload_gateway_greengrass.txt" on shell
    And I wait 1 minutes after script

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I clear the search Box in the Device Page
    Then I input "TestConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept1NoThingDetails
    #--------------riregister the gateway to get the initial status---------------

    #Default to clean dmc
    Then I click on the user icon and log out.