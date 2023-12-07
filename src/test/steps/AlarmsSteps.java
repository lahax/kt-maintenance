package test.steps;

import Util.UtilFunctions;
import com.aventstack.extentreports.model.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import ta.common.CommonPage;
import ta.common.CommonTest;
import ta.entities.elements.PageElement;
import ta.formatters.ReportFormatter;
import ta.utilities.ReflectionUtils;
import test.pages.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class AlarmsSteps {

    public static String getSourceToBeCheck() {
        return sourceToBeCheck;
    }

    public static void setSourceToBeCheck(String sourceToBeCheck) {
        AlarmsSteps.sourceToBeCheck = sourceToBeCheck;
    }

    private static String sourceToBeCheck;

    private static String statusFilter;
    private static String typeFilter;
    private static String messageFilter;
    private static long timestampAlarm;

    public static long getTimestampAlarm() {
        return timestampAlarm;
    }

    public static void setTimestampAlarm(long timestampAlarm) {
        AlarmsSteps.timestampAlarm = timestampAlarm;
    }

    public static void setStatusFilter(String statusFilter) {
        AlarmsSteps.statusFilter = statusFilter.trim().replace(" ", "-");
    }

    public static void setTypeFilter(String typeFilter) {
        AlarmsSteps.typeFilter = typeFilter.trim().replace(" ", "_");;
    }

    public static void setMessageFilter(String messageFilter) {
        AlarmsSteps.messageFilter = messageFilter.trim().replace(" ", "_");
    }

    public static String getTypeFilter() {
        return typeFilter;
    }

    public static String getStatusFilter() {
        return statusFilter;
    }

    public static String getMessageFilter() {
        return messageFilter;
    }

    public static PageElement getDateTimeFirstRow() {return dateTimeFirstRow;}
    public static void setDateTimeFirstRow(PageElement dateTimeFirstRow) {AlarmsSteps.dateTimeFirstRow = dateTimeFirstRow;}
    private static PageElement dateTimeFirstRow;

    @Then("I check that all row contains the source searched previously on AlarmsPage")
    public static void checkFilteredRows(){
        String locator = String.format(AlarmsPage.rowFilteredBySource, getSourceToBeCheck());
        PageElement pe = null;
        try{
            pe = UtilFunctions.createNewPageElement("first row", "(//tbody/tr)[1]");
            Assert.assertTrue(pe.isPresent(10),"No row present in 10sec");
        }catch(Exception ignored){
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath(locator));
        if(rows!= null && !rows.isEmpty()){
            for(int i=1; i<=rows.size();i++){
                pe = UtilFunctions.createNewPageElement("row "+i +"into the table", "("+locator+")["+i+"]");
                Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            }
        }else{
            Assert.fail("The filter by source do not work properly");
        }
    }

    @Then("I type random source in Source SearchBox on AlarmsPage")
    public static void typeRandomSourceIntheSourceSearchBox(){
        String source = AlarmsPage.getRandomSource();
        setSourceToBeCheck(source);
        WebElement we = CommonPage.getDriver().findElement(AlarmsPage.getSearchInputBox().getBy());
        we.sendKeys(source);
    }

    @Then("I check for at least one row into the table on AlarmsPage")
    public static void checkTableRow(){
        List<WebElement> we = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(we== null || we.isEmpty()){
            Assert.fail("No row into the table");
        }
    }

    @Then("^I Save the filter set in (\\w+).(\\w+) on AlarmPages")
    public static void savefilterSetDuringTheTest(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(fieldName.contains("status")){
            setStatusFilter(elem.getText());
            System.out.println("Status filter: "+getStatusFilter());
        }else if(fieldName.contains("type")) {
            setTypeFilter(elem.getText());
            System.out.println("Type filter: "+getTypeFilter());
        } else if (fieldName.contains("message")) {
            setMessageFilter(elem.getText());
            System.out.println("Message filter: "+getMessageFilter());
        }else{
            Assert.fail("Option not valid. Insert only variable related to the filter 'status' or 'type'");
        }
    }

    @Then("I check if the number of rows present in the table is in accordion with the pagination number on AlarmsPage")
    public static void checkNumberOfRowPagination(){
        CommonSteps.waitProgressBar();
        int numberOfPagination = Integer.parseInt(AlarmsPage.getPaginationTableButton().getText());
        try{
            PageElement pe = UtilFunctions.createNewPageElement("All rows present in the table", "//tbody/tr");
            pe.isPresent(20);
        }catch(Exception e){
            Assert.fail("No rows showed in 20 sec");
        }
        CommonSteps.waitProgressBar();
        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(rows.size() != numberOfPagination){
            Assert.fail("The row present in the table are different from the expected ones. Table: "+rows.size()+" Expected: "+numberOfPagination);
        }else{
            AlarmsPage.getPaginationTableButton().scrollTo();
        }
    }


    @Then("I check that all rows contains only entries with the specified filter on AlarmsPage")
    public static void checkRowsSpecificFilter(){
        CommonSteps.waitProgressBar();
        String locator = String.format(AlarmsPage.rowsWithSpecificFilters, getTypeFilter(), getMessageFilter(), getStatusFilter());
        System.out.println("Locator: " + locator);
        PageElement pe = null;
        try{
            pe = UtilFunctions.createNewPageElement("first row", "(//tbody/tr)[1]");
            Assert.assertTrue(pe.isPresent(10),"No row present in 10sec");
        }catch(Exception ignored){
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath(locator));
        if(rows!= null && !rows.isEmpty()){
            for(int i=1; i<=rows.size();i++){
                pe = UtilFunctions.createNewPageElement("row "+i +"into the table", "("+locator+")["+i+"]");
                System.out.println("PageElement: "+ pe);
                pe.scrollTo();
                Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            }
        }else{
            Assert.fail("The filter by source do not work properly");
        }
    }

    private String iCheckTheNumberOfTotalRows() {

        String number_of_rows_tot = AlarmsPage.numberOfRows.getText();
        String number_of_rows_tot_parse = number_of_rows_tot.substring(number_of_rows_tot.indexOf("of"));
        String numberTot = number_of_rows_tot_parse.substring(3, number_of_rows_tot_parse.length() - 1);

        return numberTot;
    }

    @Then("I check the number of total rows on popUp")
    public void iCheckTheNumberOfTotalRowsOnPopUp() {

        String numberOnTheTable = iCheckTheNumberOfTotalRows();
        String messageOnPopUpAlert = AlarmsPage.textOnPopUpAlarmExport.getText();

        Assert.assertTrue(messageOnPopUpAlert.contains(numberOnTheTable));
    }

    @Then("I check that the Alarm Page is correctly translated in Italiano")
    public static void checkAlarmPageTranslated() throws IOException {
        String [] tree  = new String[]{"detailsWindow"};
        PageElement pe = UtilFunctions.createNewPageElement("Alarm page title", "//h2[@class='-header-title dmc-header-title']");
        CommonSteps.jsonReader(tree, "alarms", pe.getText(),null);


        tree  = new String[]{"pages", "logs"};
        pe = UtilFunctions.createNewPageElement("Alarm page title", "//input[@placeholder='Cerca per origine']");
        CommonSteps.jsonReader(tree, "search", pe.getAttribute("placeholder").trim(),null);


        tree  = new String[]{"controlRoom"};
        //*Check options*//
        pe = UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div");
        Assert.assertTrue(pe.tryClick(false, false), "Unable to click on Filter box ");
        CommonSteps.jsonReader(tree, "filters", pe.getText(),null);

        tree  = new String[]{"filters"};

        pe = UtilFunctions.createNewPageElement("type label", "//dmc-form-field-label[contains(., 'Tipo')]");
        CommonSteps.jsonReader(tree, "type", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("message label", "//dmc-form-field-label[contains(., 'Messaggio')]");
        CommonSteps.jsonReader(tree, "message", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("status label", "//dmc-form-field-label[contains(., 'Stato')]");
        CommonSteps.jsonReader(tree, "deviceState", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("date range label", "//dmc-form-field-label[contains(.,'Intervallo di Tempo')]");
        CommonSteps.jsonReader(tree, "dateRange", pe.getText(),null);

        tree  = new String[]{"components", "multiSelect"};

        pe = UtilFunctions.createNewPageElement("type filter", "//dmc-form-field-label[contains(., 'Tipo')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Seleziona opzioni...')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Message filter", "//dmc-form-field-label[contains(., 'Messaggio')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Seleziona opzioni...')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("status filter", "//dmc-form-field-label[contains(., 'Stato')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Seleziona opzioni...')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);

        tree  = new String[]{"components", "date-range-picker"};
        pe = UtilFunctions.createNewPageElement("date filter", "//dmc-form-field-label[contains(.,'Intervallo di Tempo')]//following-sibling::dmc-datetime-range-picker//div[@class='-input' and contains(.,'Seleziona date')]");
        CommonSteps.jsonReader(tree, "select", pe.getText().replace("...", " ").trim(),null);

        pe = UtilFunctions.createNewPageElement("Clear button", "//div[@class='dmc-card']/div[.='Filtri']//following-sibling::form/div/button[contains(text(), 'Pulisci')]");
        CommonSteps.jsonReader(null, "Reset", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Confirm button", "//div[@class='dmc-card']/div[.='Filtri']//following-sibling::form/div/button[contains(text(), 'Conferma')]");
        CommonSteps.jsonReader(null, "Confirm", pe.getText(),null);

        tree  = new String[]{"fields"};
        String locator =  String.format(LogPage.tableHeaderGeneric, "Data");
        pe = UtilFunctions.createNewPageElement("Date Table Header", locator);
        CommonSteps.jsonReader(tree, "timestamp", pe.getText(),null);

        locator =  String.format(LogPage.tableHeaderGeneric, "Progetto");
        pe = UtilFunctions.createNewPageElement("Project Table Header", locator);
        CommonSteps.jsonReader(tree, "project", pe.getText(),null);

        locator =  String.format(LogPage.tableHeaderGeneric, "Origine");
        pe = UtilFunctions.createNewPageElement("Source Table header", locator);
        CommonSteps.jsonReader(tree, "source", pe.getText(),null);

        locator =  String.format(LogPage.tableHeaderGeneric, "Tipo");
        pe = UtilFunctions.createNewPageElement("Type Table header", locator);
        CommonSteps.jsonReader(tree, "type", pe.getText(),null);

        locator =  String.format(LogPage.tableHeaderGeneric, "Messaggio");
        pe = UtilFunctions.createNewPageElement("Message Table header", locator);
        CommonSteps.jsonReader(tree, "message", pe.getText(),null);

        locator =  String.format(LogPage.tableHeaderGeneric, "Stato");
        pe = UtilFunctions.createNewPageElement("Status Table header", locator);
        CommonSteps.jsonReader(tree, "status", pe.getText(),null);

        // click on action columns
        Assert.assertTrue(UtilFunctions.createNewPageElement("column actions", "//i[@dmcicon='table-columns']").tryClick(), "Unable to click on: "+UtilFunctions.createNewPageElement(null, "//i[@dmcicon='table-columns']").getText());
        UtilFunctions.addScreenshot("column actions");
        String [] tree_reset = new String[]{"components", "table"};
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", DeploymentsHistoryPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", DeploymentsHistoryPage.getCloseColumnsBTN().getText(),null);
        Assert.assertTrue(UtilFunctions.createNewPageElement("closing the column actions", "//span[contains(.,' Chiudi ')]").tryClick(), "Unable to retrieve the element");


        //locator =  String.format(LogPage.tableHeaderGeneric, "Stato");
        tree  = new String[]{"components", "table"};
        pe = UtilFunctions.createNewPageElement("Label Rows per page", "//span[@class='-page-sizes-label']");
        pe.scrollTo();
        CommonSteps.jsonReader(tree, "rowsPerPage", pe.getText(),null);

        pe = UtilFunctions.createNewPageElement("Label Page of pages", "//div[@class='-rows-counters']");
        Assert.assertTrue(pe.getText().contains("di"), "The Element: "+pe+ " do not contains the String \"di\"");

        pe = UtilFunctions.createNewPageElement("Label Page counter", "//div[contains(@class,'-pages-counters')]");
        Assert.assertTrue(pe.getText().contains("Pagina"), "The Element: "+pe+ " do not contains the String \"Pagina\"");

        CommonSteps.jsonReader(tree_reset, "pageCounters", AlarmsPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+AlarmsPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);

        pe = UtilFunctions.createNewPageElement("Alarm page title", "//input[@placeholder='Cerca per Origine']");
        pe.scrollTo();
    }


    @Then("I check if the order is from most recent in Alarms")
    public void iCheckIfTheOrderIsFromMostRecentAlarm() {
        //Method to check if the first entry is the most recent
        if (AlarmsPage.getOldestDateTimeArrowUp().isPresent()){
            AlarmsPage.getOldestDateTimeArrowUp().click();
        }
        Assert.assertTrue(AlarmsPage.getMostRecentArrowDown().isPresent(), "The right arrow is not present");
    }


    @Then("I check that the dateTime Alarm filter works properly")
    public static void checkdateAlarmFilterAlarm() throws InterruptedException {

        List<WebElement> filteredRow = CommonPage.getDriver().findElements(AlarmsPage.getAllCellOfFirstRow().getBy());
        List<WebElement> oldRow = CommonPage.getDriver().findElements(getDateTimeFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();


        for (WebElement we : oldRow) {
            origin.add(we.getText().toLowerCase());
        }

        for (WebElement we : filteredRow) {
            updated.add(we.getText().toLowerCase());
        }

        Assert.assertEquals(origin, updated, "The filter cause a mismatch with the most recent row");

    }

    @Then("I Save the dateTime before the filter of the first row in Alarms")
    public void iSaveTheDateTimeBeforeTheFilterOfTheFirstRow() {
        setDateTimeFirstRow(AlarmsPage.getAllCellOfFirstRow());
    }

    @Then("I check that alarm was not created")
    public void iCheckThatAlarmWasNotCreated() {
        //Use this method with a previous alarm timestamp variable saved
        // I Save the dateTime before the filter of the first row in Alarms
        long alarmSavedPreviously = getTimestampAlarm();
        long actualAlarmTimestamp = Long.parseLong(AlarmsDetailsPage.getAlarmTimestamp().getText());
        System.out.println("Actual Timestamp  "+actualAlarmTimestamp);
        System.out.println("Previous Alarm Timestamp  "+alarmSavedPreviously);
        Assert.assertEquals(actualAlarmTimestamp, alarmSavedPreviously, "Error in alarm creation, alarm was created unproperly");
    }

    @And("I save alarm timestamp to check next alarm not created")
    public void iSaveTimestampToCheckNextAlarmNotCreated() {
       long time =  Long.parseLong(AlarmsDetailsPage.getAlarmTimestamp().getText());
        setTimestampAlarm(time);
        System.out.println("Timestamp  "+AlarmsDetailsPage.getAlarmTimestamp().getText());
    }

    @And("I save current timestamp to check alarm")
    public void iSaveTimestampToCheckAlarm() throws Exception {
        Date timestamp = DeviceAlarmsConfigurationSteps.getCurrentUtcTime();
        System.out.println(timestamp.getTime());
        setTimestampAlarm(timestamp.getTime());
    }



    @Then("I check the alarm was created successfully")
    public void iCheckTheAlarmWasCreatedsuccessfully() {
        long runActivityTime = getTimestampAlarm();
        long alarmTimestampJson = Long.parseLong(AlarmsDetailsPage.getAlarmTimestamp().getText());
        System.out.println("runActivityTime - " +runActivityTime);
        System.out.println("alarmTimestampJson - " +alarmTimestampJson);

        Assert.assertTrue(alarmTimestampJson > runActivityTime, "The alarm was not created successfully, last dmc alarm timestamp is not greater than the timestamp saved  previously. Found: "+alarmTimestampJson+" - previous: "+runActivityTime);
    }

    @Then("I check and clear if alarm all type is present")
    public void iCheckAndClearIfAlarmAllTypeIsPresent() throws Exception {

        PageElement elem = ReflectionUtils.getPageElementByString("DeviceAlarmsConfigurationPage", "iconTrashAlarmAll");
        // check if alarm with "all" type is present (in this case check the presence of icon trash of the same row
        // and then it click the icon
        if (elem.isPresent()) {
            CommonSteps.clickElementWithJS("DeviceAlarmsConfigurationPage", "iconTrashAlarmAll");
            // complete the steps to remove the alarm, it tap on delete button and on toast message
            CommonSteps.checkAndClickElementPresent("DeviceAlarmsConfigurationPage", "deleteButton");
            CommonSteps.checkAndClickElementPresent("DeviceAlarmsConfigurationPage", "toastMessageClose");
            // go to notification confiiguration page to remove the notification on "all" alarm
            CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
            CommonSteps.checkAndClickElementPresent("SidebarPage", "notificationsConfigurationSubOption");
            // complete the steps to remove the notification, it tap on delete button and on toast message
            CommonSteps.checkAndClickElementPresent("NotificationsConfigurationsPage", "deleteAllNotification");
            CommonSteps.checkAndClickElementPresent("NotificationsConfigurationsPage", "confirmDeleteButton");
            CommonSteps.checkAndClickElementPresent("NotificationsConfigurationsPage", "toastMessageClose");

            CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
            CommonSteps.checkAndClickElementPresent("SidebarPage", "deviceAlarmsConfigurationSubOption");
        } else {
            ReportFormatter.addInfo("The Alarm \"all\" type is not present");
        }
    }

    @Then("I check and clear if {string} alarm all type is present")
    public void iCheckAndClearIfAlarmAllTypeIsPresent(String thing) throws Exception {
        PageElement pe = UtilFunctions.createNewPageElement("delete icon for specific gateway", "//strong[contains(text(), '"+thing+"')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]");
       // check if alarm with "string name"  is present (in this case check the presence of icon trash of the same row
        // and then it click the icon
        if (pe.isPresent()) {
            pe.tryClick();
            // complete the steps to remove the alarm, it tap on delete button and on toast message
            CommonSteps.checkAndClickElementPresent("DeviceAlarmsConfigurationPage", "deleteButton");
            CommonSteps.checkAndClickElementPresent("DeviceAlarmsConfigurationPage", "toastMessageClose");
            // go to notification confiiguration page to remove the notification on "all" alarm
            CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
            CommonSteps.checkAndClickElementPresent("SidebarPage", "notificationsConfigurationSubOption");
            // complete the steps to remove the notification, it tap on delete button and on toast message
            PageElement pe2 = UtilFunctions.createNewPageElement("delete icon for specific gateway", "//td[contains(., '"+thing+"')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]");
            // check if notifiation with "string name"  is present (in this case check the presence of icon trash of the same row
            // and then it click the icon
            if (pe2.isPresent()) {
                pe2.tryClick();
                CommonSteps.checkAndClickElementPresent("NotificationsConfigurationsPage", "confirmDeleteButton");
                CommonSteps.checkAndClickElementPresent("NotificationsConfigurationsPage", "toastMessageClose");
            }
            CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
            CommonSteps.checkAndClickElementPresent("SidebarPage", "deviceAlarmsConfigurationSubOption");
        } else {
            ReportFormatter.addInfo("The Alarm \"all\" type is not present");
        }
    }
 }
