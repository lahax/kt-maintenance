@Software_manager_Test_13.2
Feature: Software Manager

  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.2

    Then I enter on "esol-ap29551-qa" project

    ## STEP 1
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    Then I wait 5 seconds
    ## STEP 2

    Then I check the presence of SoftwareCataloguePage.iconFunctionsSoftware Element and then i click it
    Then I check the presence of SoftwareCataloguePage.detailFunctionOnSoftwareCard Element and then i click it
    Then I check the "9" input box are only read mode
    Then I check the presence of SoftwareCataloguePage.backBtn Element and then i click it

    Then I check the presence of SoftwareCataloguePage.iconFunctionsSoftware Element and then i click it
    Then I check the presence of SoftwareCataloguePage.editFunctionOnSoftwareCard Element and then i click it
    Then I check the input box are on edit mode
    Then I check the presence of SoftwareCataloguePage.saveBtn
    Then I check the presence of SoftwareCataloguePage.backBtn Element and then i click it

    Then I check the presence of SoftwareCataloguePage.iconFunctionsSoftware Element and then i click it
    Then I check the presence of SoftwareCataloguePage.downloadFunctionOnSoftwareCard Element and then i click it
    Then I check the presence of SoftwareCataloguePage.popupDownloadSoftwareCatalogue
    Then I check the presence of SoftwareCataloguePage.iconFunctionsSoftware Element and then i click it
    Then I check the presence of SoftwareCataloguePage.deleteFunctionOnSoftwareCard Element and then i click it
    Then I check the presence of SoftwareCataloguePage.popupDeleteSoftwareCatalogue

