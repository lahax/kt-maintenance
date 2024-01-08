@Industry_Test_28.12
Feature: Industry
#GOAL: The note is correctly added/updated on the Gateway's Activity table and on DynamoDB
  #Verify that the edit and/or add of the value on the Note string, is repoted on the Gateway's Activity table, under the Note column;
  #Verify the correct view of the note in the table.
  #Check on DynamoDB that the note is present as in DMC
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.12
    #go on Devices page and choose a Gateway.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    #2a. Click on Gateway Detail:
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #2b.Click on Activities Tab:
    Then I check the presence of DevicesDetailsPage.tabActivities Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabActivitiesTitle

    #Prerequisite:activity is present?
    And If the activity "test2812" for device "Test_Concept-01" is not present I create it
    #3a.Add a value of an empty Activity Note string:
    And I check the presence of ActivitiesPage.test2812Activity
    Then I check the presence of ActivitiesPage.editActivitytest2812 Element and then i click it
    And I clear ActivitiesPage.notesInputLabel
    Then I type "prova" into the element ActivitiesPage.notesInputLabel
    Then I check the presence of ActivitiesPage.confirmSaveEditButton Element and then i click it
    #3b.Verify the correct view of the note in the table:
    Then I check the presence of ActivitiesPage.test2812NoteField

    #3c.Edit an Activity note string with 1000 charts.
    Then I check the presence of ActivitiesPage.editActivitytest2812 Element and then i click it
    And I clear ActivitiesPage.notesInputLabel
    Then I type "NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjj" into the element ActivitiesPage.notesInputLabel
    Then I check the presence of ActivitiesPage.confirmSaveEditButton Element and then i click it
    #3d.Verify the correct view of the note in the table:
    Then I check the presence of ActivitiesPage.test2812NoteFieldEdited

    #4a.User access AWS Console with IoT support role.
    #And I launch the Assume role request
    #4b.Open DynamoDB and search the table esol_ap27611_test_ddb_activities:
    #4c.Click it and then click on "Explore Table Items":
    #4d.Do a search by op_id: <eso_ap29551-esol_<env>_<activityID>:
    #4e. Click on the result and verify the field Note is correctly validated:
    Then I check the notes of activity "test2812" in DynamoDB table "esol_ap27611_test_ddb_activities" in the project "esol-ap29551-qa"

    Then I input "test2812" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.test2812Activity
    Then I check the presence of DevicesDetailsPage.deleteActivity Element and then i click it
    Then I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it

    #Final logout step
    And I click on the user icon and log out.