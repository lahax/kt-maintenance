@Logs_Test_11.3
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.3

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Check that on the top of the page is shown a filter toolbox:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    #Step 2
    Then I check the presence of LogPage.filtersBox

    Then I check the presence of LogPage.filtersBox Element and then i click it
    Then I check the presence of LogPage.statusFilterBox Element and then i click it
    Then I check the presence of LogPage.firstOptionOfStatusFilter Element and then i click it
    Then I click Element LogPage.dropdownStatusFilterBox using Javascript
    Then I retrieve the filter "Status" set before

    And I check the presence of LogPage.dateTimeFilterBox Element and then i click it
    And I check the presence of LogPage.leftMonthBTNFrom Element and then i click it
    And I check the presence of LogPage.fifteenthDayPreviousMonthFrom Element and then i click it
    And I check the presence of LogPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of LogPage.nowButtonCalendar Element and then i click it
    And I check the presence of LogPage.confirmButtonCalendar Element and then i click it

    Then I check the presence of LogPage.typeFilterBox Element and then i click it
    Then I check the presence of LogPage.firstOptionOfTypeFilter Element and then i click it
    Then I click Element LogPage.dropdownTypeFilterBox using Javascript
    And I retrieve the filter "Type" set before
    Then I check the presence of LogPage.confirmButtonFilterSection Element and then i click it
    Then I wait the progress bar for a maximum of "180" seconds

    Then I verify if the filters works properly for the log page
    Then I check the presence of LogPage.filtersBox Element and then i click it
    Then I check the presence of LogPage.clearButtonFilterSection Element and then i click it
    Then I check the presence of LogPage.confirmButtonFilterSection Element and then i click it

    #Step 3
    Then I retrieve the total number of the rows
    And I execute the query below and check the result for the apm "esol_ap29551_qa" - Test "11.3"
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
  "project_id":[
  "%s"
  ]
  }
  },
  {
  "terms":{
  "check":[
  "custom_logger"
  ]
  }
  }
  ],
  "should":[

  ],
  "must_not":[

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
  Then I verify the response from kibana - Test 11.3 - project "esol_ap29551_qa"




