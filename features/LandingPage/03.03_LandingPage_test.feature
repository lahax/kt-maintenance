@LandingPage_Test_3.3
Feature: LandingPage
#GOAL: The Aggregated Data Section on the landing page are correctly shown.
  Background:
# STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 3.3
# STEP 2 - On Landing Page check the presence oh Devices section (1). It must have values of Gateway / Direct Thing / Thing / Totals (2):
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.devicePreviewTitleSection

    And I click ProjectPage.checkboxNeverConnected

    Then I check the presence of ProjectPage.labelGatewayDeviceSection
    Then I check the presence of ProjectPage.labelDirectThingDeviceSection
    Then I check the presence of ProjectPage.labelThingDeviceSection
    Then I check the presence of ProjectPage.labelTotalsDeviceSection
# STEP 3 - Check the presence of Alarms section (1) with the graphic. It must have 6 Months/3 Months filter (2) and Gateway/Direct Thing/ Thing/ Custom Group / All Devices:
    Then I check the presence of ProjectPage.labelAlarms
    Then I check the presence of ProjectPage.sixMonthsAlarm
    Then I check the presence of ProjectPage.threeMonthsAlarm
    Then I check the presence of ProjectPage.gatewayFilterAlarm
    Then I check the presence of ProjectPage.directThingFilterAlarm
    Then I check the presence of ProjectPage.thingFilterAlarm
    Then I check the presence of ProjectPage.customGroupFilterAlarm
    Then I check the presence of ProjectPage.targetAllFilterAlarm
# STEP 4 - Click on the tooltip ("i" icon) next to the title of Alarms Graph in order to see the legend description:
    Then I check the presence of ProjectPage.alarmsTooltipIcon Element and then i click it
    Then I check the presence of ProjectPage.alarmsTooltipTitle
    And I check the presence of ProjectPage.alarmsTooltipTextGateway
    And I check the presence of ProjectPage.alarmsTooltipTextThing
    And I check the presence of ProjectPage.alarmsTooltipTextDirectThing
    And I check the presence of ProjectPage.alarmsTooltipTextCustomGroup
    And I check the presence of ProjectPage.alarmsTooltipTextTargetAll
    And I check the presence of ProjectPage.alarmsTooltipTextAlarmsDevices
    Then I check the presence of ProjectPage.closeTooltipButton Element and then i click it

#STEP 5 - Check the presence of Devices & Activation section (1) with the graphic. It must have 6 Months/3 Months filter (2) and Gateway/Direct Thing/ Thing (3):
    Then I check the presence of ProjectPage.labelDeviceAndActivation
    Then I check the presence of ProjectPage.sixMonthsDevicesActivations
    Then I check the presence of ProjectPage.threeMonthsDevicesActivations
    Then I check the presence of ProjectPage.gatewayFilterDevicesActivations
    Then I check the presence of ProjectPage.directThingFilterDevicesActivations
    Then I check the presence of ProjectPage.thingFilterDevicesActivations
#Step 6 - Click on a bar and you'll be able to see the data for that month:
    #NOT POSSIBLE: graphs are not predictable

#Step 7 (Optional) - You can also check if device numbers are correct, by copying the cURL of the Aggregations API and pasting it in yuor shell:
    Then I retrieve token from dmc
    Given Header "Authorization"
    Then I make a custom "POST" request to https://1wmcqub4mi.execute-api.eu-central-1.amazonaws.com/test/projects/esol-ap29551-qa/data/aggregations using
    """
{"projectIds":["esol-ap29551-qa"],"index":"things","body":{"query":{"terms":{"environment_prefix":["esol_ap29551_qa"]}},
"size":0,"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}},"by_thing_type":{"terms":{"field":"searchable_thing_type.keyword"},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}},"by_state":{"terms":{"field":"device_state.state.keyword"},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_connected":{"filter":{"term":{"device_state.state.keyword":"connected"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_disconnected":{"filter":{"term":{"device_state.state.keyword":"disconnected"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_activated":{"filter":{"term":{"device_state.state.keyword":"activated"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_connected_percentage":{"bucket_script":{"buckets_path":{"num":"by_state_connected>_count","den":"_count"},"script":"params.num/params.den"}},"by_state_disconnected_percentage":{"bucket_script":{"buckets_path":{"num":"by_state_disconnected>_count","den":"_count"},"script":"params.num/params.den"}},"by_state_activated_percentage":{"bucket_script":{"buckets_path":{"num":"by_state_activated>_count","den":"_count"},"script":"params.num/params.den"}}}},"by_state":{"terms":{"field":"device_state.state.keyword"},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_connected":{"filter":{"term":{"device_state.state":"connected"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_disconnected":{"filter":{"term":{"device_state.state":"disconnected"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}},"by_state_activated":{"filter":{"term":{"device_state.state":"activated"}},
"aggs":{"by_environment_prefix":{"terms":{"field":"environment_prefix"}}}}}}}
    """
    Then Status custom code should be 200
    Then I check if values devices numbers are correct