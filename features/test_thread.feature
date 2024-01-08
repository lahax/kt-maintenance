@test_thread
Feature: test_thread

  Scenario: test_thread

    And I start listen on topic esol_ap29551_qa/Test_Concept-02/mqtts/Test_Concept-02_thing1/data
    And I wait 20 seconds
    And I interrupt the MQTT listener
    And I read the topic esol_ap29551_qa/Test_Concept-02/mqtts/Test_Concept-02_thing1/data file expecting "SOME" values