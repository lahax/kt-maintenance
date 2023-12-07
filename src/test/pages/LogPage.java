package test.pages;

import Util.UtilFunctions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.annotations.elements.Element;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.steps.CommonSteps;

import javax.print.DocFlavor;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LogPage<allSourceInTheTable> {

    public static PageElement getLogsLandingPageTitle() {return logsLandingPageTitle;}

    @Element(xpath = "//h2[contains(text(), 'Log')]", desc = "Logs lending page title ")
    private static PageElement logsLandingPageTitle;

    public static PageElement getSearchInputBox() {
        return searchInputBox;
    }

    @Element(xpath = "//input[@placeholder='Search by source']", desc = "Search input box")
    private static PageElement searchInputBox;

    public static PageElement getFiltersBox() {
        return filtersBox;
    }

    @Element(xpath = "//div[@class='dmc-card-header']/h2[.='Filters']/parent::div", desc = "Filters box")
    private static PageElement filtersBox;
    @Element(xpath = "//div[@class='dmc-card-header']/h2[.='Filters']/following-sibling::i", desc = "dropdown icon of the filters box")
    private static PageElement dropdownIconFilterBox;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Status')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., '')]", desc = "Status Filter box")
    private static PageElement statusFilterBox;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Status')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., '')]//following-sibling::div/i[@dmcicon='chevron-down']", desc = "dropdown icon Status Filter box")
    private static PageElement dropdownStatusFilterBox;
    @Element(xpath = "//dmc-form-field-label[contains(.,'Date Range')]//following-sibling::dmc-datetime-range-picker//div[@class='-input' and contains(.,'Select datetimes')]", desc = "Datetimes filter box")
    private static PageElement dateTimeFilterBox;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Type')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., '')]", desc = "Status Filter box")
    private static PageElement typeFilterBox;
    @Element(xpath = "//dmc-form-field-label[contains(., 'Type')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., '')]//following-sibling::div/i[@dmcicon='chevron-down']", desc = "dropdown icon Status Filter box")
    private static PageElement dropdownTypeFilterBox;
    @Element(xpath = "//div[@class='dmc-card']/div[.='Filters']//following-sibling::form/div/button[contains(text(), 'Clear')]", desc = "Clear button into Filter section")
    private static PageElement clearButtonFilterSection;
    @Element(xpath = "//div[@class='dmc-card']/form/div/div/button[contains(text(), 'Confirm')]", desc = "Confirm button into Filter section")
    private static PageElement confirmButtonFilterSection;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Confirm')]", desc = "Confirm button into Calendar")
    private static PageElement confirmButtonCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Clear')]", desc = "Clear button into Calendar")
    private static PageElement clearButtonCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Now')]", desc = "Now button into Calendar")
    private static PageElement nowButtonCalendar;

    @Element(xpath = "//div[@class='-rows-counters']", desc = "number of rows")
    public static PageElement numberOfRows;

    @Element(xpath = "//span[contains(text(), 'ENELINT')]", desc = "info user logged in")
    private static PageElement infoUserLoggedIn;
    @Element(xpath = "//span[contains(text(), 'Language') or contains(text(), 'Lingua')]", desc = "Language sub option into info user button")
    private static PageElement languageSubOption;
    @Element(xpath = "//button[contains(text(), 'English')]", desc = "Button English sub option")
    private static PageElement buttonEnglishSubOption;

    @Element(xpath = "//*[contains(text(),'Number of logs to be exported:')]", desc = "Text present on Alarms Export popup")
    public static PageElement textOnPopUpAlarmExport;

    /*----------------------------------------- Table Header --------------------------------------------*/
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Timestamp')]", desc = "Timestamp column header")
    private static PageElement timestampColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Project')]", desc = "Project column header")
    private static PageElement projectColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Source')]", desc = "Source column header")
    private static PageElement sourceColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Type')]", desc = "Type column header")
    private static PageElement typeColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Message')]", desc = "Message column header")
    private static PageElement messageColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Status')]", desc = "Status column header")
    private static PageElement statusColumnHeader;
    @Element(xpath = "//th[@class='--align-right ng-star-inserted']", desc = "Actions column header")
    private static PageElement actionColumnHeader;
    @Element(xpath = "(//dmc-calendar//div[@class='-days']/div[contains(@class, '--today')]//preceding-sibling::div[1])[1]", desc = "previous day from today in FROM tab active")
    private static PageElement previuosDayInTheFROMCalendar;

    public static PageElement getPreviuosDayInTheFROMCalendar() {
        return previuosDayInTheFROMCalendar;
    }

    public static PageElement getPreviuosDayInTheTOCalendar() {
        return previuosDayInTheTOCalendar;
    }

    @Element(xpath = "(//dmc-calendar//div[@class='-days']/div[contains(@class, '--today')]//preceding-sibling::div[1])[2]", desc = "previous day from today in FROM tab active")
    private static PageElement previuosDayInTheTOCalendar;
    @Element(xpath = "(//dmc-calendar//div[@class='-days']/div[contains(@class, '--today')]//following-sibling::div[1])[2]", desc = "following day from today in TO tab active")
    private static PageElement followingDayInTheTOCalendar;

    public static PageElement getToTabsIntoCalendar() {
        return toTabsIntoCalendar;
    }

    public static PageElement getFromTabsIntoCalendar() {
        return fromTabsIntoCalendar;
    }

    @Element(xpath = "//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'To')]", desc = "previous day from today in FROM tab active")
    private static PageElement toTabsIntoCalendar;
    @Element(xpath = "//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'From')]", desc = "previous day from today in FROM tab active")
    private static PageElement fromTabsIntoCalendar;
    @Element(xpath = "(//dmc-form-field-label[contains(., 'Status')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Select options...')]/../following-sibling::dmc-multi-select-dropdown//div[@class='dmc-option-label'])[1]", desc = "first option of status dropdown filter")
    private static PageElement firstOptionOfStatusFilter;
    @Element(xpath = "(//dmc-form-field-label[contains(., 'Type')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Select options...')]/../following-sibling::dmc-multi-select-dropdown//div[@class='dmc-option-label'])[1]", desc = "first option of status dropdown filter")
    private static PageElement firstOptionOfTypeFilter;

    @Element(xpath = "//div[@class='-dropdown']" , desc = "Calendar")
    private static PageElement calendar;
    public static PageElement getTableRowsPresent() {
        return tableRowsPresent;
    }

    /*---------------------------------------------------------------------------------------------------*/
    @Element(xpath = "//tbody/tr", desc = "table rows present in the page")
    private static PageElement tableRowsPresent;

    public static String tableRows  = "//tbody/tr";
    public static String iconDocuments = "//i[contains(@class,'dmc-icon__document')]";
    public static String iconTickets = "//i[contains(@class,'dmc-icon__ticket-rotated')]";
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Clear')]" , desc= "button Clear into calendar")
    public static PageElement buttonClearIntoCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Now')]" , desc= "button Now into calendar")
    public static PageElement buttonNowIntoCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Confirm')]" , desc= "button Confirm into calendar")
    public static PageElement buttonConfirmIntoCalendar;
    @Element(xpath = "//tr/td[contains(., '')][3]" , desc= "button Confirm into calendar")
    public static PageElement allSourcesInTheTableFirstPage;
    @Element(xpath = "(//mat-option/span[@class='mat-option-text' and contains(text(),'5')])[1]" , desc= "button Confirm into calendar")
    public static PageElement firstOptionPaginationTable;

    @Element(xpath = "//i[@dmcicon='download']/ancestor::button", desc = "export icon")
    private static PageElement exportIcon;

    public static PageElement getPaginationTableButton() {
        return paginationTableButton;
    }

    @Element(xpath = "//*[@id='mat-select-value-1']/span/span" , desc= "button Confirm into calendar")
    public static PageElement paginationTableButton;
    @Element(xpath = "//div[@class='-navigation']/i[@dmcicon='chevron-right']" , desc= "button Confirm into calendar")
    public static PageElement buttonNextPageTable;

    public static String dayInTheFROMCalendar = "(//dmc-calendar//div[@class='-days']/div[contains(.,'%s')])[1]";
    public static String dayInTheToCalendar = "(//dmc-calendar//div[@class='-days']/div[contains(.,'%s')])[2]";
    public static String rowFilteredBySource = "//tbody/tr/td[contains(., '%s')]/parent::tr";
    public static String rowsWithSpecificFilters = "//tbody/tr/td[contains(.,'%s')]/following-sibling::td[contains(.,'%s')]/parent::tr";
    public static String tableHeaderGeneric = "//th//div[contains(@class, 'ng-star-inserted') and contains(., '%s')]";

    public static String getRandomSource(){
        List<WebElement> listSources = CommonPage.getDriver().findElements(allSourcesInTheTableFirstPage.getBy());
        List<String> sources = new ArrayList<>();
        if(listSources!= null && !listSources.isEmpty()){
            for(WebElement we: listSources){
                if(!sources.contains(we.getText())){
                    sources.add(we.getText());
                }
            }

            Random r = new Random();
            int n = r.nextInt(sources.size());
            return sources.get(n);
        }
        return "";
    }

    @Element(xpath = "(//div[@class='-picker-date']//div[@class='-prev']/i[@dmcicon='chevron-left'])[1]", desc = "Left btn on month selection date in Connectivity History ")
    private static PageElement leftMonthBTNFrom;
    @Element(xpath = "(//div[@class='-days']//div[contains(text(), ' 15 ')])[1]", desc = "fifteenth day on previous month selection date  ")
    private static PageElement fifteenthDayPreviousMonthFrom;
    @Element(xpath = "//i[contains(@class, 'dmc-icon__arrow-small-down')]", desc = "most recent arrow dateTime")
    private static PageElement mostRecentArrowDown;
    @Element(xpath = "//i[contains(@class, 'dmc-icon__arrow-small-up')]", desc = "oldest arrow dateTime")
    private static PageElement oldestDateTimeArrowUp;

    @Element(xpath = "(//tbody/tr/td)[1]", desc = "first entry date description ")
    private static PageElement firstDateTimeRow;
    @Element(xpath = "//tr[1]/td[contains(@class,'--align-left')]", desc = "all cell of first row in the table")
    private static PageElement allCellOfFirstRow;

    @Element(xpath = "(//td[contains(., 'commandto')]//following-sibling::td//*[@icon='document'])[1]", desc= "icon details of alarm")
    public static PageElement lastLogwithCommandDtoDetailIcon;


    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh button")
    private static PageElement refreshBTN;

    @Element(xpath = "//h2[text()= 'Log details']", desc = "Logs lending page title ")
    private static PageElement logsDetailsLandingPageTitle;

    @Element(xpath = "(//span[contains(text(), 'source')]//parent::section//span[contains(text(), 'commandto')])[1]", desc= "alarm detail business")
    public static PageElement commandDtoInDetails;

    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button Device Alarm configuration page")
    private static PageElement backBTN;

    public static PageElement getOldestDateTimeArrowUp() {return oldestDateTimeArrowUp;}
    public static PageElement getMostRecentArrowDown() {return mostRecentArrowDown;}
    public static PageElement getAllCellOfFirstRow() {return allCellOfFirstRow;}

    @Element(xpath = "//*[contains(text(),'Number of logs to be exported:')]/following-sibling::div//button[contains(.,'Confirm')]", desc = "Confirm Button")
    private static PageElement confirmButton;

    public static PageElement getdateFROM() {
        return dateFROM;
    }

    @Element(xpath = "//div[contains(.,'From')]/small", desc="timestamp From")
    private static PageElement dateFROM;



    public static String getTimestampDateFrom() {
        return timestampDateFrom;
    }

    public static void setTimestampDateFrom(String dateTime) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("dateTime to parse: "+dateTime);
        Date date = dateFormat.parse(dateTime);
        long time = date.getTime();
        timestampDateFrom = String.valueOf(time);
        System.out.println("#### - "+timestampDateFrom);
    }

    private static String timestampDateFrom = "";


    public static PageElement getdateTo() {
        return dateFROM;
    }

    @Element(xpath = "//div[contains(.,'To')]/small", desc="timestamp To")
    private static PageElement dateTo;



    public static String getTimestampDateTo() {
        return timestampDateTo;
    }

    public static void setTimestampDateTo(String dateTime) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("dateTime to parse: "+dateTime);
        Date date = dateFormat.parse(dateTime);
        long time = date.getTime();
        timestampDateTo = String.valueOf(time);
        System.out.println("#### - "+timestampDateTo);
    }

    private static String timestampDateTo = "";

    public static PageElement getRowsPresent() {
        return rowsPresent;
    }

    @Element(xpath = "//div[@class='-rows-counters']", desc = "rows present")
    private static PageElement rowsPresent;

    @Element(xpath = "(//mat-option/span[contains(.,5)])[1]", desc = "5 rows per page ")
    private static PageElement fiveRowsPerPage ;

    @Element(xpath = "(//mat-option/span[contains(.,10)])[1]", desc = "10 rows per page ")
    private static PageElement tenRowsPerPage ;

    @Element(xpath = "//mat-option/span[contains(.,20)]", desc = "20 rows per page")
    private static PageElement twentyRowsPerPage ;

        @Element(xpath = "//mat-option/span[contains(.,50)]", desc = "50 rows per page")
    private static PageElement fiftyRowsPerPage ;

    @Element(xpath = "//mat-option/span[contains(.,100)]", desc = "100 rows per page ")
    private static PageElement hundredRowsPerPage ;
}
