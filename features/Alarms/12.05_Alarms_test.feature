@Alarms_Test_12.5
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.5

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle
    Then I check if the order is from most recent in Alarms
    Then I Save the dateTime before the filter of the first row in Alarms
    ## STEP 2
    Then I check the presence of AlarmsPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.dateTimeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.calendar

    And I check the presence of AlarmsPage.leftMonthBTNFrom Element and then i click it
    Then I click Element AlarmsPage.fifteenthDayPreviousMonthFrom using Javascript
    And I set the Timestamp for the From date setted before
    And I check the presence of AlarmsPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of AlarmsPage.nowButtonCalendar Element and then i click it
    And I check the presence of AlarmsPage.confirmButtonCalendar Element and then i click it

    Then I check the presence of AlarmsPage.confirmButtonFilterSection Element and then i click it

    Then I check if the order is from most recent in Alarms
    Then I check that the dateTime Alarm filter works properly

    #Step 4
    #
    #Go on Opensearch (ex Elasticsearch) and launch the following query, in order to extract numerical values ​​presented in the pages from with respect to the number of items:
    And I execute the query below and check the result for the apm "esol_ap29551_qa" - Test "12.5"
   """
   GET alarms*/_search
   {
   "query":{
   "bool":{
   "filter":{
   "bool":{
   "must":[
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