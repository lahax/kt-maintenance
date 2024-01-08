@Logs_Test_11.6
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.6

    #STEP 1 - Login on DMC

   Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Select a "START TIME" date and the "END TIME" date and check if the search button will be enable:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    Then I check the presence of LogPage.filtersBox Element and then i click it
    And I check the presence of LogPage.dateTimeFilterBox Element and then i click it
    Then I check the presence of LogPage.calendar

    Then I select the yesterday as day in the "FROM" TAB
    And I set the Timestamp for the From date setted before
    Then I check the presence of LogPage.toTabsIntoCalendar Element and then i click it
    Then I check the presence of LogPage.buttonNowIntoCalendar Element and then i click it

    Then I check that the element LogPage.buttonConfirmIntoCalendar is active.

    #Step 3 - Click on "Confirm" and check the values reported by the filters.

    Then I check the presence of LogPage.buttonConfirmIntoCalendar Element and then i click it
    Then I check the presence of LogPage.confirmButtonFilterSection Element and then i click it


  #Step 4
  #
  #Go on Opensearch (ex Elasticsearch) and launch the following query,
  #in order to extract numerical values ​​presented in the pages from with respect to the number of items:

  And I execute the query below and check the result for the apm "esol_ap29551_qa" - Test "11.6"
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
   "check":[
   "custom_logger"
   ]
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
   "should":[],
   "must_not":[]
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