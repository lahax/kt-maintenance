@Devices_Test_5.15
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #A new Ticket Managment is created for its device.
  Scenario: Test 5.15

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    #Go on Devices page and click on "Ticket Management" button on the action column:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I wait the progress bar
    #Then I check the presence of DevicesPage.ticketManagement111 Element and then i click it
    Then I check the presence of the ticket management icon for the device "Test_Concept-01" and I click it

    #Step 3
    #Check if you are redirected to the ticket management page for that device and if all tickets opened for the device are shown:
    And I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle
    And I check the content of Target Name column according to "Test_Concept-01"

    #Step 4
    #Click on "+" button in the bottom right for add a new ticket.
    And I check the presence of TicketsManagementPage.addNewTicket Element and then i click it
    And I wait the progress bar

    #Step 5
    #Will be open a new page with field "Required" and "Optional":
    And I check the presence of TicketsManagementPage.requiredFields
    And I check the presence of TicketsManagementPage.optionalFields

    #Step 6:
    #When you fill all the sections, you'll  be able to click the "Add" button to create a new ticket
    And I check the presence of TicketsManagementPage.subcategory Element and then i click it
    And I check the presence of TicketsManagementPage.otherSubcategory Element and then i click it
    And I wait the progress bar
    And I check the presence of TicketsManagementPage.issue Element and then i click it
    And I check the presence of TicketsManagementPage.cannotAccessIssue Element and then i click it
    And I type "test" into the element TicketsManagementPage.shortDescription
    And I type "test" into the element TicketsManagementPage.affectedCi
    And I check the presence of TicketsManagementPage.environment Element and then i click it
    And I check the presence of TicketsManagementPage.development Element and then i click it
    And I check the presence of TicketsManagementPage.impactedUsers Element and then i click it
    And I check the presence of TicketsManagementPage.low Element and then i click it
    And I check the presence of TicketsManagementPage.degradationType Element and then i click it
    And I check the presence of TicketsManagementPage.notDegraded Element and then i click it
    And I check the presence of TicketsManagementPage.impact Element and then i click it
    And I check the presence of TicketsManagementPage.impactNumber3 Element and then i click it
    And I check the presence of TicketsManagementPage.urgency Element and then i click it
    And I check the presence of TicketsManagementPage.urgencyNumber3 Element and then i click it
    And I type "test" into the element TicketsManagementPage.description
    And I check the presence of TicketsManagementPage.saveNewTicket Element and then i click it
    And I wait the ticket progress bar
    And I retrieve the number of the opened tickets so far
    And I check the presence of TicketsManagementPage.backBTN Element and then i click it
    And I check the presence of ticket number in the list

    #Logout Step
    Then I click on the user icon and log out.