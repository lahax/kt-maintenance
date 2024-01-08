@Mobility_IT_Test_23.1
  Feature: Mobility_IT

    #STEP 0 - Login and set Language english as default
    Background:

      Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
      Then I click LoginPage.loginBtn
      Then I perform login as "admin" user
      And I click HomePage.infoUserLoggedIn
      Then I click HomePage.languageSubOption
      When I click HomePage.buttonEnglishSubOption

    #GOAL The new Show Logs button it's present on Thing commands
    Scenario: Test 23.1

    #STEP 1 Choose a project, open the sidebar menu, click on Devices section
      #5.1
      #1a Login to DMC and choose a project.
      Then I enter on "esol-ap29551-qa" project
      #1b Open the sidebar menu,
      Then I click HomePage.hamburgerMenuIcon
      #1b click on Devices section and
      Then I click SidebarPage.devicesOption

    # STEP 2 Choose a Gateway, go on tab Things and click on Action button of a single Thing.
      #7.1
      #1b choose a Gateway.
      Then I input "Test_Concept-01" in DevicesPage.searchBox
      #1c Go on Things section and click on Action button of a single Thing. (the step's order is not correct: first details' button then Things tab)
      Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
      #7.5 (come imaginavo:Then I check the presence of DevicesPage.Things? Element and then I click it) come c'era in 7.5:
      Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
      Then I click on more info icon of the row with DeviceID "Test_Concept-01_thing1"
    # STEP 3 (1c 2)Check the presence of the new Show Logs button:
      #Then I check the presence of DevicesDetailsPage.showLogsBTN ho provato a usare i path che c'eranno già (showLogsBTN e showLogsBTNToClick), ma non sono riuscita, perché? Perché non sono di questi log, poi trovato il path
      #Per questo ho "creato" un nuovo xpath
      #Then I check the presence of DevicesDetailsPage.showLogsBTNLaraTest
      # path giusto trovato! infatti uguale a quello che ho provato a fare
      Then I check the presence of DevicesDetailsPage.showLogsThing
    # Logout Step fare?