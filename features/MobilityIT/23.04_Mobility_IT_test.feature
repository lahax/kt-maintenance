@Mobility_IT_Test_23.4
  Feature: Mobility_IT

    #STEP 0 - Login and set Language english as default
    Background:

      Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
      Then I click LoginPage.loginBtn
      Then I perform login as "admin" user
      And I click HomePage.infoUserLoggedIn
      Then I click HomePage.languageSubOption
      When I click HomePage.buttonEnglishSubOption

    #GOAL The Log detail page is correctly shown
    Scenario: Test 23.4
      #uguale 23.1, 23.2 e 23.3:
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
      # How to confirm from test if the showing page is correct? the presence of the title in the logs page?
      Then I check the presence of ShowLogsDeviceDetailPage.titleShowLogsPage
      #STEP 7 (QUA inizia l'obiettivo del test 4 di fatto)
      # 2a Click on Log detail and check that the json is correctly shown (OBBIETIVO 23.4)
      Then I check the presence of ShowLogsDeviceDetailPage.showDetailsFirstIcon Element and then i click it