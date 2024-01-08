@Alarms_Test_12.8
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.8

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    ## STEP 2
    Then I check the presence of AlarmsPage.filtersBox
    Then I check the presence of AlarmsPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.typeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfTypeFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownTypeFilterBox using Javascript

    Then I check the presence of AlarmsPage.messageFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfMessageFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownMessageFilterBox using Javascript

    Then I check the presence of AlarmsPage.statusFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfStatusFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownStatusFilterBox using Javascript

    Then I check the presence of AlarmsPage.dateTimeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.calendar

    And I check the presence of AlarmsPage.leftMonthBTNFrom Element and then i click it
    Then I click Element AlarmsPage.fifteenthDayPreviousMonthFrom using Javascript
    And I set the Timestamp for the From date setted before
    And I check the presence of AlarmsPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.nowButtonCalendar Element and then i click it
    And I check the presence of AlarmsPage.confirmButtonCalendar Element and then i click it


    Then I Save the filter set in AlarmsPage.typeFilterBox on AlarmPages
    Then I Save the filter set in AlarmsPage.messageFilterBox on AlarmPages
    Then I Save the filter set in AlarmsPage.statusFilterBox on AlarmPages

    ## STEP 3
    Then I check the presence of AlarmsPage.confirmButtonFilterSection Element and then i click it
    Then I check that all rows contains only entries with the specified filter on AlarmsPage

    And I execute the query below and check the result for the apm "esol_ap29551_qa" - Test "12.8"
    """
  GET alarms*/_search
  {
  "query":{
  "bool":{
  "filter":{
  "bool":{
  "must":[
  {
  "terms":{
  "notification_type":[
  "%s"
  ]
  }
  },
  {
  "terms":{
  "check":[
  "%s"
  ]
  }
  },
  {
  "terms":{
  "status":[
  "%s"
  ]
  }
  },
  {
  "range":{
  "timestamp":{
  "gte":"%s",
  "lte":"%s"
  }
  }
  },
  {
  "terms":{
  "project_id":[
  "%s"
  ]
  }
  }
  ],
  "should":[

  ],
  "must_not":[
  {
  "terms":{
  "check":[
  "custom_logger"
  ]
  }
  }
  ]
  }
  }
  }
  },
  "from":0,
  "size":20,
  "sort":[
  {
  "timestamp":"desc"
  }
  ]
  }
  """

    Then I check the presence of KibanaPage.playButton Element and then i click it
    And I verify the response from kibana