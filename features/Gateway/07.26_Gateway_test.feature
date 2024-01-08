@Gateway_Test_7.26
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
    #Performs a firmware update with the "Options" flag setted. It will be possible to add installation options to the package.

  Scenario: Test 7.26
    #PROCEDURE
    #Step 1
    #Access to DMC, open the sidemenu and click on Devices
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #Step 2
    #If the device is simulated through script
    #
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    #
    #     es: ./notify_job.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test
    #
    #     It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #Step 3 - Open a gateway detail page and click on "renew certificates":
    Then I check the presence of DevicesDetailsPage.renewCertificatesBTN Element and then i click it

    #Step 4
    #Select a thing and check the button Renew is clickable
    Then I check the presence of DevicesDetailsPage.renewThing1RadioBTN Element and then i click it
    Then I check that the element DevicesDetailsPage.renewBTN is active.

    #Select multiple things and check the button Renew is clickable
    Then I check the presence of DevicesDetailsPage.renewThing2RadioBTN Element and then i click it
    Then I check that the element DevicesDetailsPage.renewBTN is active.

    #Select all things by clicking on "all things" button and click to "renew".
    Then I check the presence of DevicesDetailsPage.renewDevicesRadioBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.renewBTN Element and then i click it

    #Step 5
    #Wait for the job notify
    #Execute the renew script. es: ./renew.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev GatewayID
    #
    #Then Run close job script using jobId contained in the job notify message es: ./close_job.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev GatewayID jobID

    Then I launch command "bash ./renew_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-01" on shell
    Then I save the job ID from the job document received
    And I run the script "close_job_multiple_thing", with the job Id retrieved, on "Test_Concept-01 thing1" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #STEP 6 - Check the Step function status is "SUCCEEDED" and certificate data on DMC is updated

    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept01 Element and then i click it
    #For Test Automation we are not capable of create new certificates, to prove the entire flow of this test add new certificates of Test_Concept-02 in the certs folder
    #And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    #And I check the presence of StepFunctionPage.failedInDetailsStepFunction

    #logout STEP

    Then I click on the user icon and log out.