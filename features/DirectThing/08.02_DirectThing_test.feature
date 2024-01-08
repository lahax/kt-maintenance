@DirectThing_Test_8.2
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.2
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Go to the page of Devices and select a IoT Direct Thing.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "DirectThingConcept1" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #---------------------------------Step 3 - optional
    #The device is simulated through script NOTIFY_JOB
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "DirectThingConcept1", in the project "esol_ap29551_qa"
    #---------------------------------Step 4
    #Click on Update button in the System Commands section:
    Then I check the presence of DevicesDetailsPage.infoIcon Element and then i click it
    Then I check if the Custom Communication is enabled or not
    Then I check the presence of DevicesDetailsPage.moreInformationTitle
    Then I check the presence of DevicesDetailsPage.backBTNMoreInfoDirect Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.showMoreDirectBTN Element and then i click it
    Then I cancel text from the input box element DevicesDetailsPage.customCommunicationEnabledBox
    And I change the status of the Custom Communication
    Then I check the presence of DevicesDetailsPage.confirmUpdateBTN Element and then i click it
    #--------------------------------Step 5
    #At this point you should be able to update some properties of the direct thing:

    #Step 6
    #Wait for the job notify and Run close job script using jobId contained in the previous message
    Then I save the job ID from the job document received
    And I run the script "close_job_direct", with the job Id retrieved, on "DirectThingConcept1" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    #Wait for the DMC response
    And I wait 4 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithDirectConcept1 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #Step 8
    #Verify that by clicking on "show more", new custom field are displayed:
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "DirectThingConcept1" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.directConcept1Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    Then I check the presence of DevicesDetailsPage.infoIcon Element and then i click it
#    Then I check the presence of DevicesDetailsPage.updateBTN Element and then i click it
#    Then I check the presence of DevicesDetailsPage.showMoreDirectBTN Element and then i click it
    And I check if the Custom Communication status is changed

    Then I click on the user icon and log out.

