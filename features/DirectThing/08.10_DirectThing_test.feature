@DirectThing_Test_8.10
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.10
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Go to device page and select a direct thing
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #Step3
    #The device is simulated through script NOTIFY_JOB
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "DirectThingConcept2", in the project "esol_ap29551_qa"
    #Step 4
    #Click on  Renew Certificate:
    Then I check the presence of DevicesDetailsPage.renewCertificatesBTN Element and then i click it
    #Step 5
    #In the new window click on renew
    Then I check the presence of DevicesDetailsPage.renewBTN Element and then i click it
    #Step 6
    #Wait for the job notify
    Then I save the job ID from the job document received
    #Execute the renew script.
    Then I launch command "bash ./renew_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa DirectThingConcept2" on shell
    #Then Run close job script
    And I run the script "close_job_renew_direct", with the job Id retrieved, on "DirectThingConcept2" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 7
    #  Check the Step function status is "SUCCEEDED" and certificate data on DMC is updated
      #Wait for the DMC response
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept2 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

