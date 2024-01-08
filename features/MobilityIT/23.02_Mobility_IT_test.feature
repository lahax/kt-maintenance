@Mobility_IT_Test_23.2
  Feature: Mobility_IT

    #STEP 0 - Login and set Language english as default
    Background:

      Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
      Then I click LoginPage.loginBtn
      Then I perform login as "admin" user
      And I click HomePage.infoUserLoggedIn
      Then I click HomePage.languageSubOption
      When I click HomePage.buttonEnglishSubOption

    #GOAL The Show Logs page of a Thing it's correctly shown
    Scenario: Test 23.2
      #USO QUELLO CHE HO FATTO NEL 23.1 DI QUA E ALLO STEP 3 AGGIUNGENCO IL CLICK
      #STEP 1 Choose a project, open the sidebar menu, click on Devices section
      Then I enter on "esol-ap29551-qa" project
      Then I click HomePage.hamburgerMenuIcon
      Then I click SidebarPage.devicesOption

      # STEP 2 Choose a Gateway, go on tab Things and click on Action button of a single Thing
      Then I input "Test_Concept-01" in DevicesPage.searchBox
      Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
      Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
      Then I click on more info icon of the row with DeviceID "Test_Concept-01_thing1"
      # STEP 3 Check the presence of the new Show Logs button and CLICK:
      #xpath corretto trovato nel progetto
      #Then I check the presence of DevicesDetailsPage.showLogsBTNLaraTest Element and then i click it
      Then I check the presence of DevicesDetailsPage.showLogsThing Element and then i click it
      #DI QUA INIZIANO LE NOVITà RISPETTO IL TEST 23.01:
      #come un test conferma che si è caricata una nuova pagina?, verificare che elementi? solo il titolo? oppure titulo + filter box + tabella? Tabella viene verificata nel test 23.03 e la funzionalità dei filter nei test 23.5 e 23.6, allora qua verificare i tre elementi o solo il titolo?
      #STEP 4 Check if links to the Thing's log page.
    # How to confirm from test if the showing page is correct? the presence of the title in the logs page?
      Then I check the presence of ShowLogsDeviceDetailPage.titleShowLogsPage
      #provando da sola, devo creare una funzione che fa questa verifica o riesco a trovare qualcosa sul progetto?, ma la verifica della correteza del titolo viene fatta nel test 23.03, boh non è meglio agiungere un passaggio al 23.01 e non avere il 23.02?
      # Then I check if ShowLogsDeviceDetailPage.titleShowLogsPage contains "Test_Concept-01_thing1" viene fatta nel prossimo test