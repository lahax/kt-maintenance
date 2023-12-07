@Projects_menu_test_1.10
Feature: Projects Menu

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.10
    #Click on "filters" and set some filters:
    Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    #I choose the filter to select a specific project with its ID
    Then I check the presence of HomePage.boxForIdInFilter Element and then i click it
    Then I check the presence of HomePage.selectPerfInIdFilterBox Element and then i click it
    Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the ID filter works
    And I check that I properly apply the filter on ESOL-perf project.
    #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    #I choose the Name filter to select a specific project
    Then I check the presence of HomePage.boxForNameInFilter Element and then i click it
    Then I check the presence of HomePage.selectPerfInNameFilterBox Element and then i click it
    Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the Name filter works
    And I check that I properly apply the filter on ESOL-perf project.
    #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    #I choose the Region filter to select a specific project
    Then I check the presence of HomePage.boxForRegionInFilter Element and then i click it
    Then I check the presence of HomePage.selectEuCentral1InFilterBox Element and then i click it
    Then I check the presence of HomePage.outAfterRegionSelection Element and then i click it
    #Click out for permit confirmation
    Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the Region filter works
    And I check that I properly apply the EU Region 1 filter.
     #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    And I check the presence of HomePage.confirmFilterBTN Element and then i click it
    # Click on the Search bar and search a specific project:
    Then I type "egip - perf" into the element HomePage.searchProjectsBarElements
    #Check that the search bar works
    And I check that I properly apply the filter on ESOL-perf project.
    Then I cancel text from the input box element HomePage.searchProjectsBarElements

    #Check that the filter and search works also in tablet mode
    #Then I set chrome "iPad pro" mode
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    #I choose the filter to select a specific project with its ID
    #Then I check the presence of HomePage.boxForIdInFilter Element and then i click it
    #Then I check the presence of HomePage.selectPerfInIdFilterBox Element and then i click it
    #Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the ID filter works
    #And I check that I properly apply the filter on ESOL-perf project.
    #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    #Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    #I choose the Name filter to select a specific project
    #Then I check the presence of HomePage.boxForNameInFilter Element and then i click it
    #Then I check the presence of HomePage.selectPerfInNameFilterBox Element and then i click it
    #Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the Name filter works
    #And I check that I properly apply the filter on ESOL-perf project.
    #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    #Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    #I choose the Region filter to select a specific project
    #Then I check the presence of HomePage.boxForRegionInFilter Element and then i click it
    #Then I check the presence of HomePage.selectEuCentral1InFilterBox Element and then i click it
    #Then I check the presence of HomePage.outAfterRegionSelection Element and then i click it
    #Click out for permit confirmation
    #Then I check the presence of HomePage.confirmFilterBTN Element and then i click it
    #Check that the Region filter works
    #And I check that I properly apply the EU Region 1 filter.
     #I clear the filter
    #Then I check the presence of HomePage.filterBoxBelowSelectedProjects Element and then i click it
    #Then I check the presence of HomePage.clearFilterBTN Element and then i click it
    #And I check the presence of HomePage.confirmFilterBTN Element and then i click it
    # Click on the Search bar and search a specific project:
    #Then I type "egip - perf" into the element HomePage.searchProjectsBarElements
    #Check that the search bar works
    #And I check that I properly apply the filter on ESOL-perf project.
    #Then I cancel text from the input box element HomePage.searchProjectsBarElements