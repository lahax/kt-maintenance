@User_Profiling_Test_2.11
Feature: User Profiling

  Background:

    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 2.11
    #Step 1
    #Select two project:

    #for the first project you have Basic role
    #for the second you have Admin role
    #Configure PostMan following the instruction listed here: Bearer authentication
    Then I enter on "esol-ap29551-qa" project
    And I click HomePage.infoUserLoggedIn
    And I click HomePage.profileSubOption
    Then I retrieve token from dmc
    Given Header "Authorization"

    #Step 2
    #Try invoking the following API:
    #POST crossproject/alarms/search?size=20 with payload like
    #{project_ids: ["esol-ap29551-dev", "esol-ap2955108-dev"], size: 20, custom_query: {,…}}
    Then I make a custom "POST" request to https://1wmcqub4mi.execute-api.eu-central-1.amazonaws.com/test/crossproject/alarms/search?size=20 using
    """
    {
      "project_ids": [
        "esol-ap29551-qa"
      ],
      "paginationToken": "string",
      "order_by": "string",
      "order_desc": "string"
    }
    """
    #Verify the API returns an error message
    Then Status custom code should be 403

    #Step 3
    #In the esol_ap27611_<env>_user_data DynamoDB table,
    # look for the row associated to the user and switch the compac flag from true to false for a specific project.
      #NB. We have not the grant to change the field so we perform login as a user with compac flag false
    Then I click on the user icon and log out.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project
    And I click HomePage.infoUserLoggedIn
    And I click HomePage.profileSubOption

    #Step 4
    #Repeat step 2
    Then I retrieve token from dmc
    Given Header "Authorization"
    #Verify now the API is correctly answering
    Then I make a custom "POST" request to https://1wmcqub4mi.execute-api.eu-central-1.amazonaws.com/test/crossproject/alarms/search?size=20 using
    """
    {
      "project_ids": [
        "esol-ap29551-qa"
      ],
      "paginationToken": "string",
      "order_by": "string",
      "order_desc": "string"
    }
    """

    Then I click on the user icon and log out.
    Then Status custom code should be 200