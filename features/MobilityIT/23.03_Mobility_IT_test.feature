@Mobility_IT_Test_23.3
  Feature: Mobility_IT

  #STEP 0 - Login and set Language english as default
    Background:

      Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
      Then I click LoginPage.loginBtn
      Then I perform login as "admin" user
      And I click HomePage.infoUserLoggedIn
      Then I click HomePage.languageSubOption
      When I click HomePage.buttonEnglishSubOption

  #GOAL The table and the title of the page is correctly shown
  Scenario: Test 23.3
    #uguale 23.1 e 23.2:
    #STEP 1 Choose a project, open the sidebar menu, click on Devices section
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #poi ho visto in altre features così:
    ## Click on Sidebar menu then on "Devices" section.
    #And I check the presence of SidebarPage.devicesOption Element and then i click it
    #va bene la mia scelta?, cosa fare?
    # STEP 2 Choose a Gateway, go on tab Things and click, on Action button of a single Thing
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #confirm search's filter (from test 05.10)
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
    Then I click on more info icon of the row with DeviceID "Test_Concept-01_thing1"
    # STEP 3 Check the presence of the new Show Logs button and CLICK
    Then I check the presence of DevicesDetailsPage.showLogsThing Element and then i click it
    #STEP 4 Check if links to the Thing's log page
    Then I check the presence of ShowLogsDeviceDetailPage.titleShowLogsPage
    #STEP 5 (qua iniziano le novità rispetto 23.02. corrisponde al 2a della Test Guide: The table has to be like the following screen) verificare se ci sono tutti gli elementi? titolo, filter box? tabella? quanto nel detagli andare in questo test?
    And I check the presence of ShowLogsDeviceDetailPage.timestampColumnHeader
    And I check the presence of ShowLogsDeviceDetailPage.messageColumnHeader
    And I check the presence of ShowLogsDeviceDetailPage.actionColumnHeader
    # STEP 6 (corrisponde al 2b della Test Guide: Also the Title of the page must be: "Show Logs - <device_numberthing> (SN: <serial_number>)")
    # Check the title, strings to check: device numberthing and serial number
    #Then I check if ShowLogsDeviceDetailPage.titleShowLogsPage contains "Test_Concept-01_thing1"

  #da decidere se uso un indice sul cpath o se provo faccio prende il primo di questi elementi