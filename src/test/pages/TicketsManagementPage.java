package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class TicketsManagementPage {

    @Element(xpath = "//h2[contains(text(), 'Tickets Management')]", desc = "Tickets Management lending page title ")
    private static PageElement ticketsManagementLandingPageTitle;

    @Element(xpath = "//h2[contains(text(), 'Gestione Ticket')]", desc = "Tickets Management lending page title IT")
    private static PageElement ticketsManagementLandingPageTitleIT;

    public static PageElement getticketsManagementLandingPageTitleIT() {
        return ticketsManagementLandingPageTitleIT;
    }

    public static PageElement getAticketsManagementLandingPageTitle() {return ticketsManagementLandingPageTitle;}

    @Element(xpath = "//dmc-table/table", desc = "Tickets Management DMC table ")
    private static PageElement ticketsManagementTable;

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Target Name') and @class='-header']", desc = "Tickets Management target name column ")
    private static PageElement ticketsManagementTargetNameColumn;

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Target') and @class='-header']", desc = "Tickets Management target name column ")
    private static PageElement ticketsManagementTargetNameColumnIT;

    public static PageElement getTicketsManagementTargetNameColumnIT() {
        return ticketsManagementTargetNameColumnIT;
    }

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'User ID') and @class='-header']", desc = "Tickets Management user id column ")
    private static PageElement ticketsManagementUserIdColumn;

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'ID Utente') and @class='-header']", desc = "Tickets Management user id column ")
    private static PageElement ticketsManagementUserIdColumnIT;

    public static PageElement getTicketsManagementUserIdColumnIT() {
        return ticketsManagementUserIdColumnIT;
    }

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Timestamp Created') and @class='-header']", desc = "Tickets Management timestamp created column")
    private static PageElement ticketsManagementTimestampCreatedColumn;

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Data di Creazione') and @class='-header']", desc = "Tickets Management timestamp created column")
    private static PageElement ticketsManagementTimestampCreatedColumnIT;

    public static PageElement getTicketsManagementTimestampCreatedColumnIT() {
        return ticketsManagementTimestampCreatedColumnIT;
    }

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Incident Number') and @class='-header']", desc = "Tickets Management incident number column ")
    private static PageElement ticketsManagementIncidentNumberColumn;

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Numero Cartellino') and @class='-header']", desc = "Tickets Management incident number column ")
    private static PageElement ticketsManagementIncidentNumberColumnIT;

    public static PageElement getTicketsManagementIncidentNumberColumnIT() {
        return ticketsManagementIncidentNumberColumnIT;
    }

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh button")
    private static PageElement refreshBTN;

    @Element(xpath = "//dmc-filters-section//div[@class='dmc-card-header']", desc = "Filter box on the page")
    private static PageElement filterBox;

    public static PageElement getFilterBox() {
        return filterBox;
    }

    @Element(xpath = "//dmc-filters-section/div/form/div/div/dmc-form-field-label", desc = "timestamp created in filter")
    private static PageElement timeStampCreatedInFilters;

    public static PageElement getTimeStampCreatedInFilters() {
        return timeStampCreatedInFilters;
    }

    @Element(xpath = "//dmc-filters-section/div/form/div/div//dmc-dummy-input/div", desc = "select datetime in filter")
    private static PageElement selectDateTimeInFilters;

    public static PageElement getSelectDateTimeInFilters() {
        return selectDateTimeInFilters;
    }

    @Element(xpath = "//div[contains(@class, 'form-footer')]//button[contains(@color, 'accent')]", desc = "confirm in filter")
    private static PageElement confirmInFilters;

    public static PageElement getConfirmInFilters() {
        return confirmInFilters;
    }

    @Element(xpath = "//div[contains(@class, 'form-footer')]//button[contains(@color, 'primary')]", desc = "clear in filter")
    private static PageElement clearInFilters;

    public static PageElement getClearInFilters() {
        return clearInFilters;
    }

    @Element(xpath = "//i[@dmcicon='table-columns']", desc = "select column icon")
    private static PageElement selectColumnsIcon;

    public static PageElement getSelectColumnsIcon() {
        return selectColumnsIcon;
    }

    @Element(xpath = "//li/button[contains(., 'Reimposta larghezza colonne')]", desc = "resize columns option")
    private static PageElement resizeColumnsIT;

    public static PageElement getResizeColumnsIT() {
        return resizeColumnsIT;
    }

    @Element(xpath = "//li/button/span", desc = "close button columns")
    private static PageElement closeColumnsBTN;

    public static PageElement getCloseColumnsBTN() {
        return closeColumnsBTN;
    }

    @Element(xpath = "//li/div[contains(., 'NUMERO CARTELLINO')]", desc = "NUMERO CARTELLINO")
    private static PageElement selectIncidentNumberIT;

    public static PageElement getSelectIncidentNumberIT() {
        return selectIncidentNumberIT;
    }

    @Element(xpath = "//li/div[contains(., 'DATA DI CREAZIONE')]", desc = "DATA DI CREAZIONE")
    private static PageElement selectTimestampCreatedIT;

    public static PageElement getSelectTimestampCreatedIT() {
        return selectTimestampCreatedIT;
    }

    @Element(xpath = "//li/div[contains(., 'ID UTENTE')]", desc = "ID UTENTE")
    private static PageElement selectUserIdIT;

    public static PageElement getSelectUserIdIT() {
        return selectUserIdIT;
    }

    @Element(xpath = "//li/div[contains(., 'TARGET')]", desc = "TARGET")
    private static PageElement selectTargetNameIT;

    public static PageElement getSelectTargetNameIT() {
        return selectTargetNameIT;
    }

    @Element(xpath = "(//i[contains(@class, 'document')])[1]", desc = "detail icon first row")
    private static PageElement detailsIconOfTableFirstRow;

    @Element(xpath = "//h2[contains(text(), 'Ticket management Detail')]", desc = "ticket management detail title")
    private static PageElement ticketManagementDetailPageTitle;

    @Element(xpath = "//h2[contains(text(), 'Ticket management Detail')]", desc = "ticket detail section card")
    private static PageElement ticketDetailSectionCard;

    @Element(xpath = "//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'To')]", desc = "previous day from today in FROM tab active")
    private static PageElement toTabsIntoCalendar;
    @Element(xpath = "(//dmc-calendar//div[@class='-days']/div[contains(@class, '--today')]//preceding-sibling::div[1])[1]", desc = "previous day from today in FROM tab active")
    private static PageElement previousDayInTheFROMCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Now')]" , desc= "button Now into calendar")
    public static PageElement buttonNowIntoCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Confirm')]" , desc= "button Confirm into calendar")
    public static PageElement buttonConfirmIntoCalendar;
    @Element(xpath = "//div[@class='-dropdown']" , desc = "Calendar")
    private static PageElement calendar;
    @Element(xpath = "(//div[@class='-picker-date']//div[@class='-prev']/i[@dmcicon='chevron-left'])[1]", desc = "Left btn on month selection date ")
    private static PageElement leftMonthBTNFrom;
    @Element(xpath = "(//div[@class='-days']//div[text()= ' 1 '])[1]", desc = "Pick the day 1 of the previous month")
    private static PageElement firstDayPreviousMonthFrom;
    @Element(xpath = "//i[@dmcicon='plus']", desc = " + button in the bottom right for add a new ticket")
    private static PageElement addNewTicket;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Subcategory')]//following-sibling::dmc-select", desc = " selectable subcategory field")
    private static PageElement subcategory;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Issue ')]//following-sibling::dmc-select", desc = " selectable Issue field")
    private static PageElement issue;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Short Description')]//following-sibling::input", desc = " input short description field")
    private static PageElement shortDescription;
    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(., ' Other ')]", desc = " select other option in subcategory field")
    private static PageElement otherSubcategory;
    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(., ' Cannot Access ')]", desc = " select cannot access option in issue field")
    private static PageElement cannotAccessIssue;
    @Element(xpath = "//h3[contains(., 'Required')]", desc = "Required fields")
    private static PageElement requiredFields;
    @Element(xpath = "//h3[contains(., 'Optional')]", desc = "Optional fields")
    private static PageElement optionalFields;
    @Element(xpath = "//button[contains(., ' Add ')]", desc = "saving new ticket")
    private static PageElement saveNewTicket;
    @Element(xpath = "//button[contains(., 'Back')]", desc = "go back button in adding new ticket in ticket management page")
    private static PageElement backBTN;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Affected Ci ')]/following-sibling::input", desc = "Affected Ci field of the optional fields")
    private static PageElement  affectedCi ;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Environment ')]//following-sibling::dmc-select", desc = " selectable Environment  field")
    private static PageElement  environment ;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Impacted Users ')]//following-sibling::dmc-select", desc = " selectable Impacted Users field")
    private static PageElement  impactedUsers ;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Degradation Type ')]//following-sibling::dmc-select", desc = " selectable Degradation Type  field")
    private static PageElement  degradationType ;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Impact ')]//following-sibling::dmc-select", desc = " selectable Impact field")
    private static PageElement  impact ;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Urgency ')]//following-sibling::dmc-select", desc = " selectable Urgency field")
    private static PageElement  urgency ;
    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(., ' development ')]", desc = " select cannot access option in issue field")
    private static PageElement development;
    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(., ' low (IUs<=10) ')]", desc = " select cannot access option in issue field")
    private static PageElement low;
    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(., ' not degraded ')]", desc = " select cannot access option in issue field")
    private static PageElement notDegraded;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Impact')]//following-sibling::dmc-select/div[@class='-select --open']/div[@class='-dropdown']/div[@class='-option --last ng-star-inserted']/div[contains(.,'3')]"
            , desc = " setting number 3 in impact field ")
    private static PageElement impactNumber3;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Urgency ')]//following-sibling::dmc-select//child::div[@class='-dropdown']/child::div[contains(.,'3')]"
            , desc = " setting number 3 in urgency field ")
    private static PageElement urgencyNumber3;
    @Element(xpath = "(//dmc-form-field-label[contains(., ' Description ')]/following-sibling::input)[2]", desc = " select cannot access option in issue field")
    private static PageElement description;




}
































































