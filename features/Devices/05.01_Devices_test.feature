@Devices_Test_5.1
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.1

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    Then I wait 5 seconds
    Then I check the content of type column

    Then I move the resize bar to coordinate '100' '0' of column number '1'
    And I remove the resize bar to coordinate '-100' '0' of column number '1'

    Then I check the alignment of things

    Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    Then I check the absence of DevicesPage.serialNumberColumn

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    Then I check the absence of DevicesPage.serialNumberColumn

    Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    Then I check the presence of DevicesPage.serialNumberColumn

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    # ----------- Tablet ---------- #
    #Then I set chrome 'ipad pro' mode
    Then I check the content of type column
    ## Then I move the resize bar to coordinate '10' '0' of column number '1'
    ## And I remove the resize bar to coordinate '-10' '0' of column number '1'
    #Then I check the alignment of things
    #Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    #Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    #Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    #Then I check the absence of DevicesPage.serialNumberColumn
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.logOption
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.devicesOption
    #Then I check the absence of DevicesPage.serialNumberColumn
    #Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    #Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    #Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    #Then I check the presence of DevicesPage.serialNumberColumn

    # ----------- PHONE ---------- #
    #Then I set chrome "iPhone" mode
    #Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    #Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    #Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    #Then I check the absence of DevicesPage.serialNumberColumnMobile
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.homeOption
    #Then I click HomePage.hamburgerMenuIcon
    #Then I click SidebarPage.devicesOption
    #Then I check the absence of DevicesPage.serialNumberColumnMobile
    #Then I check the presence of DevicesPage.tableColumnsSelectorBtn Element and then i click it
    #Then I check the presence of DevicesPage.dropdownSerialNumberVoice Element and then i click it
    #Then I check the presence of DevicesPage.closeDropdownBTN Element and then i click it
    #Then I check the presence of DevicesPage.serialNumberColumnMobile