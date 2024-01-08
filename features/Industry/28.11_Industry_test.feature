@Industry_Test_28.11
Feature: Industry
#GOAL: Check that is set a limit of 1000 characters in the Note field
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC,
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.11
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

    #3a.Click on Edit Activity
    Then I check the presence of ActivitiesPage.editActivitytest2806B Element and then i click it
    #3b.Input in note field and verify Save Changes is disabled, if not TEST IS FAILED
    Then I type "NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjjd" into the element ActivitiesPage.notesInputLabel
    Then I check that the ActivitiesPage.confirmSaveEditButton element is disabled
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    #4a.Click on Add Activity
    Then I check the presence of DevicesDetailsPage.newActivityButton Element and then i click it
    #4b.Input in note field and verify Confirm is disabled, if not TEST IS FAILED
    And I type "test2811" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "Test_Concept-01",
    "command": "activate-thing",
    "parameters": {
        "device_type": "epiSensor",
        "interaction_mode": "gateway",
        "authentication_mode": "gateway",
        "radio_type": "Eth",
        "filter_tag": [
            {
                "tag": "Test",
                "id": 2000,
                "period": 60
            },
            {
                "tag": "CommunicationCode",
                "trendType": "CommCodeValue",
                "id": 2001,
                "period": 60
            }
        ],
        "inbound_communication_modes": [
            "shadow",
            "topic"
        ],
        "outbound_communication_modes": "shadow",
        "serial_number": "000D6F000D7EF1F8",
        "model": "ZDR",
        "maker": "EPISENSOR"
    }
}
    """
    Then I type "NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjjd" into the element ActivitiesPage.notesInputLabel
    Then I check that the ActivitiesPage.confirmNewActivityButton element is disabled
    Then I check the presence of ActivitiesPage.activityBackButton Element and then i click it

    #Final logout step
    And I click on the user icon and log out.