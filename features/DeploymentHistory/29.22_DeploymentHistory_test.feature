@29.22_DeploymentHistory_test
Feature: Deployment History

  #script

  #https://jira.springlab.enel.com/browse/EXEGIP2-1276

  #GOAL: The new software package is correctly shown in the Package Version filter.


  #1a. The test 29.21 have to be SUCCEDEED
  #1b. Go on the detail page of the Gateway used before
  #2a. Click on Deactivate button
  #2b. Click on both flags and then confirm:
  #3a. Go on Devices page and open the filter bar
  #3b. Verify that the Package Version of the Device deactivated before, is not present:

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.22

    Then I enter on "esol-ap29551-qa" project

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
    Then I check the presence of SoftwareCataloguePage.deviceTypeDropdown Element and then i click it
    Then I check the presence of SoftwareCataloguePage.gatewayOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareTypeInput Element and then i click it
    And I input "regression-eig" in SoftwareCataloguePage.softwareTypeInput
    Then I check the presence of SoftwareCataloguePage.appnameInput Element and then i click it
    And I input "test_2913" in SoftwareCataloguePage.appnameInput
    Then I check the presence of SoftwareCataloguePage.versionInput Element and then i click it
    And I input "1.0" in SoftwareCataloguePage.versionInput
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
    Then The "Gateway29-Concept1" should not present in the table. If Present Then I remove it.

    Then  I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Gateway29-Concept1 ./payload_gateway_software29_21.txt" on shell
    Then I wait 30 seconds
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I wait the progress bar
    And I clear the search Box in the Device Page
    Then I input "Gateway29-Concept1 " in DevicesPage.searchBox
    Then I check the presence of DevicesPage.refreshBTN Element and then i click it
    Then I wait the progress bar
    Then The table should contains the "Gateway29-Concept1" row
    Then I remove the device "Gateway29-Concept1"

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I reload the page
    Then I check the presence of DevicesPage.filterBox Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput Element and then i click it
    Then I check the absence of DevicesPage.testSoftware21

    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    And I wait the progress bar
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    And I input "test_2913" in SoftwareCataloguePage.searchBar
    And I wait the progress bar
    And The "test_2913" software should not present. If Present Then I remove it.

    Then I click on the user icon and log out.