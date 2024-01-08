@29.21_DeploymentHistory_test
Feature: Deployment History

  #script

  #https://jira.springlab.enel.com/browse/EXEGIP2-1275

  #GOAL: The new software package is correctly shown in the Package Version filter.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.21

    Then I enter on "esol-ap29551-qa" project

    #1a. Login on DMC
    Then I click HomePage.hamburgerMenuIcon

    #1b. Open sidemenu, click on Software Manager and then click on Software Catalogue submenu item.
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    And I wait the progress bar
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    And I input "test_2913" in SoftwareCataloguePage.searchBar
    And I wait the progress bar
    And The "test_2913" software should not present. If Present Then I remove it.

    #2a. Click on the upload button on the right- down of the page:
    Then I check the presence of SoftwareCataloguePage.uploadBtn Element and then i click it
    Then I check the presence of SoftwareCataloguePage.newSoftwarePackage

    #2b. Fill the data field and upload the compressed file, then click Save:
    Then I check the presence of SoftwareCataloguePage.deviceTypeDropdown Element and then i click it
    Then I check the presence of SoftwareCataloguePage.gatewayOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareTypeInput Element and then i click it
    And I input "regression-eig" in SoftwareCataloguePage.softwareTypeInput
    #Then I check the presence of SoftwareCataloguePage.testConceptOption Element and then i click it

    #And I input timestamp after the word test_ into SoftwareCataloguePage.softwareTypeInput
    Then I check the presence of SoftwareCataloguePage.appnameInput Element and then i click it
    And I input "test_2913" in SoftwareCataloguePage.appnameInput
    #And I input timestamp after the word test_ into SoftwareCataloguePage.appnameInput
    Then I check the presence of SoftwareCataloguePage.versionInput Element and then i click it
    And I input "1.0" in SoftwareCataloguePage.versionInput
    #And I input timestamp after the word test_ into SoftwareCataloguePage.versionInput
    Then I check the presence of SoftwareCataloguePage.softwareExtensionAccordion Element and then i click it
    Then I check the presence of SoftwareCataloguePage.zipOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.descriptionInput
    And I input rightZip.zip file into SoftwareCataloguePage.fileInput
    Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueSuccessfullyUploaded Element and then i click it

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I wait the progress bar



    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    Then I input "Gateway29-Concept1" in DevicesPage.searchBox
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar

    #Then The table should contains the "Gateway29-Concept1" row
    Then The "Gateway29-Concept1" should not present in the table. If Present Then I remove it.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I clear the search Box in the Device Page
    And I wait the progress bar
    Then I input "Gateway29-Concept1 " in DevicesPage.searchBox
    Then  I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Gateway29-Concept1 ./payload_gateway_software29_21.txt" on shell
    And I wait 30 seconds
    Then I kill the notify_job command still opened
    Then I wait 15 seconds
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I wait the progress bar
    Then I run the notify_job script on "Gateway29-Concept1", in the project "esol_ap29551_qa"

    Then I click the details icon for the "Gateway29-Concept1"

    And I click DevicesDetailsPage.firmwareUpdateBTN
    And I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    And I check the presence of DevicesDetailsPage.test_2913ptionToSelect Element and then i click it
    And I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    And I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it

    And I check the presence of DevicesDetailsPage.confirmUpdateBTN Element and then i click it


    Then I save the job ID from the job document received and I verify that the inbound message have the specified format
    And I run the script "close_job_software_29_21", with the job Id retrieved, on "Gateway29-Concept1" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened
    And I wait 120 seconds after script

    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I clear the search Box in the Device Page
    Then I input "Gateway29-Concept1 " in DevicesPage.searchBox
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I click the details icon for the "Gateway29-Concept1"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    And I wait 5 seconds
    And I check the presence of DevicesDetailsPage.iconComplete
    And I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    And I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusBar
    And I check the presence of DeploymentHistoryDeviceDetailsPage.packageInstallationOutcome2921

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.lastStepFunctionUpdateWithGateway29Concept1 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerDropDownOption
    And I click SidebarPage.deploymentsHistoryOption
    And I check the presence of DeploymentsHistoryPage.iconComplete
    And I check the presence of DeploymentsHistoryPage.lastDeployWithGateway29Concept1

    And I click DeploymentsHistoryPage.detailBtn
    And I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusBar
    And I check the presence of DeploymentHistoryDeviceDetailsPage.packageInstallationOutcome2921

    #Then I wait 10 minutes after script

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I reload the page
    And I wait the progress bar
    Then I check the presence of DevicesPage.filterBox Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput Element and then i click it
    Then I input "test_2913" in DevicesPage.softwareVersionInput
    Then I check the presence of DevicesPage.testSoftware21

    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    And I wait the progress bar
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    And I input "test_2913" in SoftwareCataloguePage.searchBar
    And I wait the progress bar
    And The "test_2913" software should not present. If Present Then I remove it.

    Then I click on the user icon and log out.