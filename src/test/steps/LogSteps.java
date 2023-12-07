package test.steps;

import Util.UtilFunctions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.testng.CucumberFeatureWrapper;
import gherkin.ast.Scenario;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.common.CommonTest;
import ta.entities.Util;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LogSteps {

    public static String getSourceToBeCheck() {
        return sourceToBeCheck;
    }

    public static void setSourceToBeCheck(String sourceToBeCheck) {
        LogSteps.sourceToBeCheck = sourceToBeCheck;
    }

    private static String sourceToBeCheck;

    public static PageElement getDateTimeFirstRow() {return dateTimeFirstRow;}
    public static void setDateTimeFirstRow(PageElement dateTimeFirstRow) {LogSteps.dateTimeFirstRow = dateTimeFirstRow;}
    private static PageElement dateTimeFirstRow;


    public static String getStatusFilter() {
        return statusFilter;
    }

    public static void setStatusFilter(String statusFilter) {
        LogSteps.statusFilter = statusFilter.trim().replace(" ", "_");
    }

    public static String getTypeFilter() {
        return typeFilter;
    }

    public static void setTypeFilter(String typeFilter) {
        LogSteps.typeFilter = typeFilter.trim().replace(" ", "_");;
    }

    private static String statusFilter;
    private static String typeFilter;

    public static String getRowsPresent() {
        return rowsPresent;
    }

    public static void setRowsPresent(String rowsPresent) {
        LogSteps.rowsPresent = rowsPresent;
    }

    private static String rowsPresent;

    @Then("I verify the documents and tickets icons present on each rows")
    public static void verifyIconActionInEachRow(){
       List<WebElement> tableRows = CommonPage.getDriver().findElements(LogPage.getTableRowsPresent().getBy());
       String locator = null;
       PageElement pe = null;
       if(tableRows != null && !tableRows.isEmpty()){
           for(int i = 1; i<= tableRows.size() ; i ++ ){
               locator = String.format(LogPage.tableRows+"["+i+"]" +"//td"+LogPage.iconDocuments);
               pe = UtilFunctions.createNewPageElement("icon document of row "+i , locator);
               pe.scrollTo();
               pe.isPresent();
               locator = String.format(LogPage.tableRows+"["+i+"]" +"//td"+LogPage.iconTickets);
               pe = UtilFunctions.createNewPageElement("icon ticket of row "+i , locator);
               pe.isPresent();
           }
       }else{
           Assert.fail("No Rows present in the table");
       }
    }

    @Then("I select the day {string} in the {string} TAB")
    public static void selectEndDay(String day, String tab){
        String locator = null;
        if(tab.equalsIgnoreCase("from")){
            LogPage.getFromTabsIntoCalendar().click();
            locator = String.format(LogPage.dayInTheFROMCalendar, day);
        }else if(tab.equalsIgnoreCase("to")){
            LogPage.getToTabsIntoCalendar().click();
            locator = String.format(LogPage.dayInTheToCalendar, day);
        }else{
            Assert.fail("No valid option. Please choice FROM or TO option");
        }
        PageElement pe = UtilFunctions.createNewPageElement("The Element "+day + "in the TO calendar", locator);
        Assert.assertTrue(pe.tryClick(false,true), "The Element "+pe.getText()+" is not clicable");
    }

    @Then("I select the yesterday as day in the {string} TAB")
    public static void selectEndDay( String tab) throws ParseException {
        PageElement pe = null;
        if(tab.equalsIgnoreCase("from")){
            LogPage.getFromTabsIntoCalendar().click();
            pe = LogPage.getPreviuosDayInTheFROMCalendar();
        }else if(tab.equalsIgnoreCase("to")){
            LogPage.getToTabsIntoCalendar().click();
            pe = LogPage.getPreviuosDayInTheTOCalendar();
        }else{
            Assert.fail("No valid option. Please choice FROM or TO option");
        }
        Assert.assertTrue(pe.tryClick(false,false), "The Element "+pe.getText()+" is not clicable");
    }

    @Then("I check for at least one row into the table")
    public static void checkTableRow(){
        List<WebElement> we = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(we== null || we.isEmpty()){
            Assert.fail("No row into the table");
        }
    }

    @Then("I type random source in Source SearchBox")
    public static void typeRandomSourceIntheSourceSearchBox(){
        String source = LogPage.getRandomSource();
        setSourceToBeCheck(source);
        WebElement we = CommonPage.getDriver().findElement(LogPage.getSearchInputBox().getBy());
        we.sendKeys(source);
    }

    @Then("I check that all row contains the source searched previously")
    public static void checkFilteredRows() throws InterruptedException {
        Thread.sleep(2000);
        String locator = String.format(LogPage.rowFilteredBySource, getSourceToBeCheck());
        PageElement pe = null;
        try{
            pe = UtilFunctions.createNewPageElement("first row", "(//tbody/tr)[1]");
            Assert.assertTrue(pe.isPresent(10),"No row present in 10sec");
        }catch(Exception ignored){
        }

        System.out.println(locator);
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

    @Then("I check that the table do not contains any rows")
    public static void checkThatTableDoNotContainsAnyRows(){
        PageElement pe = UtilFunctions.createNewPageElement("first row", "(//tbody/tr)[1]");
        Assert.assertFalse(pe.isPresent(10),"No row present in 10sec");
    }

    @Then("^I Save the filter set in (\\w+).(\\w+)$")
    public static void savefilterSetDuringTheTest(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(fieldName.contains("status")){
            setStatusFilter(elem.getText());
        }else if(fieldName.contains("type")){
            setTypeFilter(elem.getText());
        }else{
            Assert.fail("Option not valid. Insert only variable related to the filter 'status' or 'type'");
        }
    }

    @Then("I check that all rows contains only entries with the specified filter")
    public static void checkRowsSpecificFilter(){
        String locator = String.format(LogPage.rowsWithSpecificFilters, getTypeFilter(), getStatusFilter());
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
                pe.scrollTo();
                Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            }
        }else{
            Assert.fail("The filter by source do not work properly");
        }

    }

    private String iCheckTheNumberOfTotalRows() {

        String number_of_rows_tot = LogPage.numberOfRows.getText();
        String number_of_rows_tot_parse = number_of_rows_tot.substring(number_of_rows_tot.indexOf("of"));
//        String numberTot = number_of_rows_tot_parse.substring(3, number_of_rows_tot_parse.length() - 1);
        String numberTot = number_of_rows_tot_parse.substring(3, number_of_rows_tot_parse.length());

        return numberTot;
    }

    public static String numeroRighe = "";

    @Then("I check the number of total rows on popUp on LogPage")
    public void iCheckTheNumberOfTotalRowsOnPopUp() {

        String numberOnTheTable = iCheckTheNumberOfTotalRows();
        String messageOnPopUpAlert = LogPage.textOnPopUpAlarmExport.getText();
        Assert.assertTrue(messageOnPopUpAlert.contains(numberOnTheTable));
        numeroRighe = numberOnTheTable;
    }

    @Then("I check that the Log page is correcty translated in Italiano")
    public static void CheckLogPageTranslatedInItaliano() throws IOException {
        String [] tree  = new String[]{"controlRoom"};
        //*Check options*//
        PageElement pe = UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div");
        Assert.assertTrue(pe.tryClick(false, false), "Unable to click on Filter box ");
        CommonSteps.jsonReader(tree, "filters", pe.getText(),null);

        tree  = new String[]{"filters"};
        pe = UtilFunctions.createNewPageElement("status label", "//dmc-form-field-label[contains(., 'Stato')]");
        CommonSteps.jsonReader(tree, "deviceState", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("status label", "//dmc-form-field-label[contains(.,'Intervallo di Tempo')]");
        CommonSteps.jsonReader(tree, "dateRange", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("status label", "//dmc-form-field-label[contains(., 'Tipo')]");
        CommonSteps.jsonReader(tree, "type", pe.getText(),null);

        tree  = new String[]{"components", "multiSelect"};
        pe = UtilFunctions.createNewPageElement("status filter", "//dmc-form-field-label[contains(., 'Stato')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Seleziona opzioni...')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("type filter", "//dmc-form-field-label[contains(., 'Tipo')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-label' and contains(., 'Seleziona opzioni...')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);

        tree  = new String[]{"components", "date-range-picker"};
        pe = UtilFunctions.createNewPageElement("date filter", "//dmc-form-field-label[contains(.,'Intervallo di Tempo')]//following-sibling::dmc-datetime-range-picker//div[@class='-input' and contains(.,'Seleziona date')]");
        CommonSteps.jsonReader(tree, "select", pe.getText().replace("...", " ").trim(),null);


        pe = UtilFunctions.createNewPageElement("Clear button", "//div[@class='dmc-card']/div[.='Filtri']//following-sibling::form/div/button[contains(text(), 'Pulisci')]");
        CommonSteps.jsonReader(null, "Reset", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Clear button", "//div[@class='dmc-card']/div[.='Filtri']//following-sibling::form/div/button[contains(text(), 'Conferma')]");
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

        //locator =  String.format(LogPage.tableHeaderGeneric, "Stato");
        tree  = new String[]{"components", "table"};
        pe = UtilFunctions.createNewPageElement("Label Rows per page", "//span[@class='-page-sizes-label']");
        pe.scrollTo();
        CommonSteps.jsonReader(tree, "rowsPerPage", pe.getText(),null);

        pe = UtilFunctions.createNewPageElement("Label Page of pages", "//div[@class='-rows-counters']");
        Assert.assertTrue(pe.getText().contains("di"), "The Element: "+pe+ " do not contains the String \"di\"");

        pe = UtilFunctions.createNewPageElement("Label Page counter", "//div[contains(@class,'-pages-counters')]");
        Assert.assertTrue(pe.getText().contains("Pagina"), "The Element: "+pe+ " do not contains the String \"Pagina\"");

        pe = UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div");
        pe.scrollTo();

    }

    @Then("I check if the order is from most recent")
    public void iCheckIfTheOrderIsFromMostRecent() {
        //Method to check if the first entry is the most recent
        if (LogPage.getOldestDateTimeArrowUp().isPresent()){
            LogPage.getOldestDateTimeArrowUp().click();
        }
        Assert.assertTrue(LogPage.getMostRecentArrowDown().isPresent(), "The right arrow is not present");
    }





    @Then("I check that the dateTime Lof filter works properly")
    public static void checkdateLogFilter() throws InterruptedException {

        List<WebElement> filteredRow = CommonPage.getDriver().findElements(LogPage.getAllCellOfFirstRow().getBy());
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

    @Then("I Save the dateTime before the filter of the first row")
    public void iSaveTheDateTimeBeforeTheFilterOfTheFirstRow() {
        setDateTimeFirstRow(LogPage.getAllCellOfFirstRow());
    }

    @Then("I execute the query below and check the result for the apm \"(.+)\" - Test \"(.+)\"")
    public static void executeQueryOnKibana(String apm, String test, String query ) throws InterruptedException {
        logInOnKibana();
        WebElement we = CommonPage.getDriver().findElement(By.xpath("//div[@class='conApp__editor']//textarea"));
        Thread.sleep(2000);
        if(we.isEnabled()){
            we.clear();
            we.sendKeys(Keys.CONTROL+"a");
            we.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(2000);
            String text = prepareQuery(test, query, apm);
            we.sendKeys(text);
            UtilFunctions.addScreenshot(text);
        }else{
            Assert.fail("Unable to locate the text are where insert the query");
        }
    }

    @Then("I set the Timestamp for the From date setted before")
    public static void setTimestampFrom() throws ParseException {
        LogPage.setTimestampDateFrom(LogPage.getdateFROM().getText());
    }

    @Then("I set the Timestamp for the To date setted before")
    public static void setTimestampTo() throws ParseException {
        LogPage.setTimestampDateTo(LogPage.getdateTo().getText());
    }

    @Then("I verify the response from kibana")
    public static void verifyResponse() throws InterruptedException, IOException, UnsupportedFlavorException {
        Thread.sleep(2000);
        List<String> timestamps = new ArrayList<>();
        String myText = retrieveResponseFromKibana();
        JsonObject job_notification = new JsonParser().parse(myText).getAsJsonObject();
        Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");

        JsonArray arrayOfResponse = job_notification.get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        for(int i = 0; i< arrayOfResponse.size(); i++){
            JsonObject jo =  arrayOfResponse.get(i).getAsJsonObject();
            String timestamp = jo.getAsJsonObject().get("_source").getAsJsonObject().get("timestamp").getAsString();
            timestamps.add(timestamp);
        }
        long now = System.currentTimeMillis();
        for (String t : timestamps){
            Assert.assertTrue(now > Long.parseLong(t), "The timestamp: "+ t +" is greater respect to the actual timestamp: "+now);
            Assert.assertTrue(Long.parseLong(LogPage.getTimestampDateFrom()) <= Long.parseLong(t), "The timestamp: "+ t +" is lower respect to the start timestamp: "+LogPage.getTimestampDateFrom());
        }

    }

    public static void logInOnKibana() throws InterruptedException {
        PageElement pe = UtilFunctions.createNewPageElement("kibana loader", "//*[@class='kibanaLoader']");
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("http://127.0.0.1:9200/_plugin/kibana/");
        if(pe.isPresent()){
            Assert.assertTrue(pe.isInvisible(120), "The kibana loader still present after 120 sec");
        }
        Thread.sleep(2000);
        Assert.assertTrue(KibanaPage.getKibanaLogo().isPresent(120), "Unable to land on Kibana page in 30 sec");
        Assert.assertTrue(KibanaPage.getDevToolsOption().tryClick(), "Unable to click on Dev tools option in the kibana sidebar menu");
        Assert.assertTrue(KibanaPage.getEditor().isPresent(), "Unable to find the editor console ");
        try{
            Assert.assertTrue(KibanaPage.getButtonGetToWork().tryClick(), "Button get to work not present! Unable to click.");
        }catch(Exception ignored){}
    }

    public static String prepareQuery(String test, String query, String apm) {
        String text = "";
        switch (test){
            case "12.8":
                text = String.format(query, AlarmsSteps.getTypeFilter(), AlarmsSteps.getMessageFilter(), AlarmsSteps.getStatusFilter(), LogPage.getTimestampDateFrom(), "now", apm);
                break;
            case "11.9":
                text = String.format(query, LogSteps.getStatus().replace(" ", "_"), LogPage.getTimestampDateFrom(), "now", LogSteps.getType().replace(" ", "_"), apm);
                break;
            case "11.6":
            case "12.5":
                text = String.format(query, LogPage.getTimestampDateFrom(), "now", apm);
                break;
            case "3.4":
            case "11.3":
                text = String.format(query, apm);
                break;
            default:
                break;
        }
        System.out.println(text);
        return text;
    }

    @Then("I retrieve the total number of the rows")
    public static void retrieveNumberOfRows(){
        String label = LogPage.getRowsPresent().getText();
        String []row = label.split(" of ");
        setRowsPresent(row[1].trim());
        System.out.println(getRowsPresent());
    }

    public static String retrieveResponseFromKibana() throws InterruptedException, IOException, UnsupportedFlavorException {
        Assert.assertTrue(KibanaPage.getOutputConsole().isPresent(), "Unable to find the output console");
        WebElement we = CommonPage.getDriver().findElement(By.xpath("//div[@class='conApp__output']//textarea"));
        we.sendKeys(Keys.CONTROL+"a");
        we.sendKeys(Keys.CONTROL+"c");
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        UtilFunctions.addScreenshot(myText);
        myText = myText.replace("\"\"\"", "");
        return myText;
    }

    @Then("I verify if the filters works properly for the log page")
    public static void checkFiltersWorks(){
        CommonSteps.waitProgressBar();
        String text = "";
        List<WebElement> els = CommonPage.getDriver().findElements(By.xpath("//tbody/tr/td[4]"));
        if(els != null && !els.isEmpty()){
            for(WebElement we:els){
                text = we.getText().replace("_", " ");
                if(!text.equalsIgnoreCase(getType())){
                    Assert.fail("The filters Type do not work properly");
                }
            }
        }

        els = CommonPage.getDriver().findElements(By.xpath("//tbody/tr/td[6]"));
        if(els != null && !els.isEmpty()){
            for(WebElement we:els){
                text = we.getText().replace("_", " ");
                if(!text.equalsIgnoreCase(getStatus())){
                    Assert.fail("The filters Status do not work properly");
                }
            }
        }

    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        LogSteps.status = status;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        LogSteps.type = type;
    }

    private static String status = "";
    private static String type = "";

    @Then("I retrieve the filter \"(.+)\" set before")
    public static void setTheFilter(String filter){

        String locator = "//*[contains(.,'%s')]/following-sibling::dmc-multi-select//div[@class='dmc-facade-label']";
        locator = String.format(locator, filter);
        PageElement pe = UtilFunctions.createNewPageElement(filter+" filter", locator);
        Assert.assertTrue(pe.isPresent(), "Unable to locate the element "+pe);

        switch (filter){
            case "Status":
                setStatus(pe.getText());
                break;
            case "Type":
                setType(pe.getText());
                break;
            default:
                break;
        }
    }


    @Then("I verify the response from kibana - Test 11.3 - project \"(.+)\"")
    public static void verifyResponseTest113(String project) throws InterruptedException, IOException, UnsupportedFlavorException {
        Thread.sleep(2000);
        String myText = retrieveResponseFromKibana();
        System.out.println(myText);
        JsonObject job_notification = new JsonParser().parse(myText).getAsJsonObject();
        Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
        JsonArray arrayOfResponse = job_notification.get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        String total =  job_notification.get("hits").getAsJsonObject().get("total").getAsString();
        Assert.assertTrue(total.equalsIgnoreCase(getRowsPresent()), "The Rows found in Kibana are different. Are present: "+total+". In DMC the total are: "+getRowsPresent());

        for(int i = 0; i< arrayOfResponse.size(); i++){
            JsonObject jo =  arrayOfResponse.get(i).getAsJsonObject();
            String projectId = jo.getAsJsonObject().get("_source").getAsJsonObject().get("project_id").getAsString();
            Assert.assertTrue(projectId.equalsIgnoreCase(project));
        }
        UtilFunctions.addScreenshot(myText);
    }

    @Then("I verify the response from kibana - Test 11.9 - project \"(.+)\"")
    public static void verifyResponseTest119(String project) throws InterruptedException, IOException, UnsupportedFlavorException {
        Thread.sleep(2000);
        List<String> timestamps = new ArrayList<>();
        String myText = retrieveResponseFromKibana();
        System.out.println(myText);
        JsonObject job_notification = new JsonParser().parse(myText).getAsJsonObject();
        Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
        JsonArray arrayOfResponse = job_notification.get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        String total =  job_notification.get("hits").getAsJsonObject().get("total").getAsString();
        Assert.assertTrue(total.equalsIgnoreCase(getRowsPresent()), "The Rows found in Kibana are different. Are present: "+total+". In DMC the total are: "+getRowsPresent());

        for(int i = 0; i< arrayOfResponse.size(); i++){
            JsonObject jo =  arrayOfResponse.get(i).getAsJsonObject();
            String projectId = jo.getAsJsonObject().get("_source").getAsJsonObject().get("project_id").getAsString();
            Assert.assertTrue(projectId.equalsIgnoreCase(project), "Project Id different. Should be: "+project+ "but found: "+projectId);
            String status = jo.getAsJsonObject().get("_source").getAsJsonObject().get("status").getAsString();
            Assert.assertTrue(status.equalsIgnoreCase(LogSteps.getStatus().replace(" ", "_")), "Status different. Should be: "+LogSteps.getStatus() +" but found: "+status);
            String type = jo.getAsJsonObject().get("_source").getAsJsonObject().get("notification_type").getAsString();
            Assert.assertTrue(type.equalsIgnoreCase(LogSteps.getType().replace(" ", "_")), "Type different. Should be: "+LogSteps.getType()+" But found: "+type);

            String timestamp = jo.getAsJsonObject().get("_source").getAsJsonObject().get("timestamp").getAsString();
            timestamps.add(timestamp);
        }

        long now = System.currentTimeMillis();
        for (String t : timestamps){
            Assert.assertTrue(now > Long.parseLong(t), "The timestamp: "+ t +" is greater respect to the actual timestamp: "+now);
            Assert.assertTrue(Long.parseLong(LogPage.getTimestampDateFrom()) <= Long.parseLong(t), "The timestamp: "+ t +" is lower respect to the start timestamp: "+LogPage.getTimestampDateFrom());
        }
        UtilFunctions.addScreenshot(myText);
    }

}
