@Mobility_IT_Test_23.5
Feature: Mobility_IT

  #STEP 0 - Login and set Language english as default
  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  #GOAL The filter shows logs with the data range setted.
  Scenario: Test 23.5
    #uguale 23.1, 23.2, 23.3 e 23.4
    #STEP 1 Choose a project, open the sidebar menu, click on Devices section
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    # STEP 2 Choose a Gateway, go on tab Things and click on Action button of a single Thing
    Then I input "veig-ha-test-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.iconDetailsFirstRow Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
    Then I click on more info icon of the row with DeviceID "veig-ha-test-01_thing14"
    # STEP 3 Check the presence of the new Show Logs button and CLICK:
    Then I check the presence of DevicesDetailsPage.showLogsThing Element and then i click it
    #STEP 4 Check if links to the Thing's log page.
    # devo fare sempre questa conferma di atterraggio alla pagina giusta?
    Then I check the presence of ShowLogsDeviceDetailPage.titleShowLogsPage
    #STEP 5 TROVARE FEATURE CHE VERIFICA CALENDAR FILTER (teste 17.04)
    #check se c'è il box con le date e poi il click
    Then I check the presence of ShowLogsDeviceDetailPage.timeFilterBox
    Then I click Element ShowLogsDeviceDetailPage.timeFilterBox using Javascript
    #check se apre il box con calendar
    Then I check the presence of ShowLogsDeviceDetailPage.calendarFilter Element and then i click it
    And I check the presence of ShowLogsDeviceDetailPage.fromButton
    And I check the presence of ShowLogsDeviceDetailPage.fromDay Element and then i click it
    And I check the presence of ShowLogsDeviceDetailPage.inputHour Element and then i click it
    #Non risco a impostare l'ora che voglio
    And I type "0" hours into the element ShowLogsDeviceDetailPage.inputHour
    #Non risco a impostare i minuti che voglio
    And I check the presence of ShowLogsDeviceDetailPage.inputMinute
    And I type "1" minutes into the element ShowLogsDeviceDetailPage.inputMinute
    And I check the presence of ShowLogsDeviceDetailPage.toButton Element and then i click it
    And I check the presence of ShowLogsDeviceDetailPage.toDay Element and then i click it
    And I check the presence of ShowLogsDeviceDetailPage.inputHour Element and then i click it
    #Non risco a impostare l'ora che voglio
    And I type "0" hours into the element ShowLogsDeviceDetailPage.inputHour
    #Non risco a impostare i minuti che voglio
    And I check the presence of ShowLogsDeviceDetailPage.inputMinute
    And I type "1" minutes into the element ShowLogsDeviceDetailPage.inputMinute
    #And I check the presence of

    #non sto raggionando bene, perché poi cambia il mese e faccio cosa? meglio usare now, await 1 o 2 minuti then now o come viene fatto nel test 11.04 in cui prendi now then 15 giorni precedenti




