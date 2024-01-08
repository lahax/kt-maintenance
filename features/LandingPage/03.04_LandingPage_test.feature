@LandingPage_Test_3.4
Feature: LandingPage

  Background:

    # STEP 1
    # Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 3.4
    #GOAL
    #The Aggregated Data Section on the landing page are correctly shown.

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the values displayed are correct:
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.totalDevicesNumber
    Then I check the presence of ProjectPage.totalDevicesPercentage
    Then I check the presence of ProjectPage.totalDevicesOnlineNumber

    #Step 3
    #Open a shell and execute the following command:
    #aws-adfs login --adfs-host=sts.enel.com --profile default-enel
    #Insert user and password, then select the role related to DMC (i.e. GG-SH-AWS-IOT-E-Solution-DevQa-esol-ap27611-test)

    #Step 4
    #On Kibana click on Dev Tools and execute the following query to retrieve the data showed:

    Then I execute the query below and check the result for the apm "esol_ap29551_qa" - Test "3.4"
    """
    GET _search
{
"query":{
"terms":{
"environment_prefix":[
"%s"
]
}
},
"size":0,
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
},
"by_thing_type":{
"terms":{
"field":"searchable_thing_type.keyword"
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
},
"by_state":{
"terms":{
"field":"device_state.state.keyword"
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_connected":{
"filter":{
"term":{
"device_state.state.keyword":"connected"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_disconnected":{
"filter":{
"term":{
"device_state.state.keyword":"disconnected"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_activated":{
"filter":{
"term":{
"device_state.state.keyword":"activated"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_connected_percentage":{
"bucket_script":{
"buckets_path":{
"num":"by_state_connected>_count",
"den":"_count"
},
"script":"params.num/params.den"
}
},
"by_state_disconnected_percentage":{
"bucket_script":{
"buckets_path":{
"num":"by_state_disconnected>_count",
"den":"_count"
},
"script":"params.num/params.den"
}
},
"by_state_activated_percentage":{
"bucket_script":{
"buckets_path":{
"num":"by_state_activated>_count",
"den":"_count"
},
"script":"params.num/params.den"
}
}
}
},
"by_state":{
"terms":{
"field":"device_state.state.keyword"
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_connected":{
"filter":{
"term":{
"device_state.state":"connected"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_disconnected":{
"filter":{
"term":{
"device_state.state":"disconnected"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
},
"by_state_activated":{
"filter":{
"term":{
"device_state.state":"activated"
}
},
"aggs":{
"by_environment_prefix":{
"terms":{
"field":"environment_prefix"
}
}
}
}
}
}
    """

    Then I check the presence of KibanaPage.playButton Element and then i click it
    And I verify the response from kibana and check the info about the devices: total, connected, disconnected and percentage


    #Step 5 (Optional)
    #You can also check if device numbers are correct, by copying the cURL of the Aggregations API and pasting it in yuor shell:
    Then I retrieve token from dmc with "admin" user
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
    Then I check if values of "totals" in devices section are correct
        #Logout Step

    Then I click on the user icon and log out.