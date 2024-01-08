@Software_manager_Test_13.5
Feature: Software Manager

  Background:
    #STEP 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.5

    #STEP 2
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle

    #STEP 3
    Then I check the presence of SoftwareCataloguePage.uploadBtn Element and then i click it
    Then I check the presence of SoftwareCataloguePage.newSoftwarePackage

    #STEP 4
    Then I check the presence of SoftwareCataloguePage.deviceTypeDropdown Element and then i click it
    Then I check the presence of SoftwareCataloguePage.gatewayOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareTypeInput Element and then i click it
    And I input timestamp after the word test_ into SoftwareCataloguePage.softwareTypeInput
    Then I check the presence of SoftwareCataloguePage.appnameInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.appnameInput
    Then I check the presence of SoftwareCataloguePage.versionInput Element and then i click it
    And I input timestamp after the word test_ into SoftwareCataloguePage.versionInput
    Then I check the presence of SoftwareCataloguePage.softwareExtensionAccordion Element and then i click it
    Then I check the presence of SoftwareCataloguePage.zipOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.descriptionInput
    And I input rightZip.zip file into SoftwareCataloguePage.fileInput
    Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueSuccessfullyUploaded Element and then i click it

    #STEP 5
    #INSERT STEP CHECK S3

#    Then I check that on Amazon S3 there is the file correctly uploaded
#    #DELETING UPDATE JUST CREATED IN ORDER TO NOT FILL THE ENTIRE DATABASE
#    And I delete the update just created
    #STEP 6
    Then I check the presence of SoftwareCataloguePage.uploadBtn Element and then i click it
    Then I check the presence of SoftwareCataloguePage.newSoftwarePackage
    Then I check the presence of SoftwareCataloguePage.deviceTypeDropdown Element and then i click it
    Then I check the presence of SoftwareCataloguePage.gatewayOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareTypeInput Element and then i click it
    And I input timestamp after the word test_ into SoftwareCataloguePage.softwareTypeInput
    Then I check the presence of SoftwareCataloguePage.appnameInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.appnameInput
    Then I check the presence of SoftwareCataloguePage.versionInput Element and then i click it
    And I input timestamp after the word test_ into SoftwareCataloguePage.versionInput
    Then I check the presence of SoftwareCataloguePage.softwareExtensionAccordion Element and then i click it
    Then I check the presence of SoftwareCataloguePage.zipOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.descriptionInput
    And I input wrongZip.rar file into SoftwareCataloguePage.fileInput
    Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    Then I check the presence of the toast message SoftwareCataloguePage.wrongTypeMessage

    #TABLET VIEW
    #And I set chrome "iPad pro" mode
    #Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    #Then I check the presence of the toast message SoftwareCataloguePage.wrongTypeMessage

    #MOBILE VIEW
    #And I set chrome "iPhone" mode
    #Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    #Then I check the presence of the toast message SoftwareCataloguePage.wrongTypeMessage