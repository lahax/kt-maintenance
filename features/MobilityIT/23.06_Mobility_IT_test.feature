@Mobility_IT_Test_23.6
Feature: Mobility_IT

  #STEP 0 - Login and set Language english as default
  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  #GOAL The table is filtred by the values you setted before in the search bar
  Scenario: Test 23.6
    #uguale 23.1, 23.2, 23.3, 23.4 e 23.5
    #STEP 1 Choose a project, open the sidebar menu, click on Devices section
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Prima vedere se c'è la filter bar (test 5.9):
    ## Check that the filter bar is on top of the page:
    Then I check the presence of DevicesPage.filterBox Element and then i click it

    # gateway type (from test 05.10)
    Then I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it
    Then I select "gateway" in drop down menu in filter box on Device Page
    Then I check the presence of DevicesPage.multiSelectDeviceTypeOption Element and then i click it

    # STEP 2 Choose a Gateway, go on tab Things and click on Action button of a single Thing
    Then I input "veig-ha-test-01" in DevicesPage.searchBox

    #confirm search's filter (from test 05.10)
    Then I check the presence of DevicesPage.confirmFilterBtn Element and then i click it
    Then I check the presence of DevicesPage.iconDetailsFirstRow Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it

    Then I click on more info icon of the row with DeviceID "veig-ha-test-01_thing14"

    # STEP 3 Check the presence of the new Show Logs button and CLICK:
    Then I check the presence of DevicesDetailsPage.showLogsThing Element and then i click it
    #STEP 4 Check if links to the Thing's log page.
    #devo fare sempre questa conferma di atterraggio alla pagina giusta?
    Then I check the presence of ShowLogsDeviceDetailPage.titleShowLogsPage
    Then I input "INFO" in ShowLogsDeviceDetailPage.filterShowLogsPage

    #scroll durante il test automatico non mi faceva cliccare sul pulsante di conferma, cosa fare, per poter provare il prossimo step o modificato la funzione di check e click, ma non mi sembra la soluzione più corretta
    #Then I verify the presence of ShowLogsDeviceDetailPage.filterPatternConfirm Element and then i click it
    #Then I check the presence of ShowLogsDeviceDetailPage.filterPatternConfirm
    #Then I click ShowLogsDeviceDetailPage.filterPatternConfirm
    #Then I wait 10 seconds
    # STEP 5 (2a) Write a text on search bar and verify that the message string contain the text:
    #Then I check the presence of ShowLogsDeviceDetailPage.showMoreLogsButton

    Then I click Element ShowLogsDeviceDetailPage.filterPatternConfirm using Javascript

    Then I wait 10 seconds
    Then I keep clicking Element ShowLogsDeviceDetailPage.showMoreLogsButton using Javascript
    #Then I scroll to Element ShowLogsDeviceDetailPage.tabFooter
    #Then I scroll to last Element? how
    Then I wait 5 seconds
    Then I check if all records contain "INFO" in "Message" column