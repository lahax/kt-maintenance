package test.steps;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
//import com.amazonaws.services.macie2.model.Page;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.Util;
import Util.UtilFunctions;
import ta.entities.elements.PageElement;
//import ta.utilities.ReflectionUtils;
//import ta.utilities.StepUtils;
import test.pages.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StepFunctionSteps {

    String date;
    static Timestamp ts;

    private static String stringToCheck;
    private static String stypeToCheck;

    public static String getStringToCheck() {
        return stringToCheck;
    }

    public static void setStringToCheck(String stringToCheck) {
        StepFunctionSteps.stringToCheck = stringToCheck;
    }

    public static String getStypeToCheck() {
        return stypeToCheck;
    }

    public static void setStypeToCheck(String stypeToCheck) {
        StepFunctionSteps.stypeToCheck = stypeToCheck;
    }

    @Then("if needed I create a step function")
    public void ifNeededICreateAStepFunction() {
        boolean nextPage=true;
        boolean atLeastOneInProgress=false;
        //while next page arrow is enabled
        //while(nextPage){
            List<WebElement> tableRows = CommonPage.getDriver().findElements(StepFunctionPage.getTableRows().getBy());
            //Check the column action for all rows
            for (int i = 0; i < tableRows.size(); i++) {
                System.out.println("row: " + i);
                if(tableRows.get(i).findElement(By.xpath("//tr//td[contains(., 'Test_Concept-02')]//following-sibling::td[contains(., 'PROGRESS')]")).getText().contains("PROGRESS")){
                    atLeastOneInProgress = true;
                    break;
                }
            }


        if(!atLeastOneInProgress){
            Assert.assertTrue(HomePage.getHamburgerMenuIcon().tryClick());
            Assert.assertTrue(SidebarPage.getDevicesOption().tryClick());
            Util.Wait(1000);
            CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy()).sendKeys("Test_Concept-02");
            Util.Wait(2000);
            Assert.assertTrue(DevicesPage.getDetailsButton().tryClick());
            Assert.assertTrue(DevicesPage.getRebootButton().tryClick());
            Assert.assertTrue(DevicesPage.getConfirmRebootBtn().tryClick());
            Util.Wait(60000);
        }

    }

    @And("I retrieve the date of the In Progress step")
    public void iRetrieveTheDateOfTheInProgressStep() {
        date = StepFunctionPage.getInProgressDate().getText();
    }

    @Then("I verify that the In progress step is updated for the gateway")
    public void iVerifyThatTheInProgressStepIsUpdated() {
        Assert.assertTrue(StepFunctionPage.getFailedDate().getText().contains(date));
    }

    @And("I retrieve the date of the In Progress step for Gateway \"(.+)\"")
    public void iRetrieveTheDateOfTheInProgressStep(String gateway) {
        String locator = String.format("//tr//td[contains(., '%s')]//following-sibling::td[contains(., 'PROGRESS')]//preceding-sibling::td[1]", gateway);
        date = CommonPage.getDriver().findElement(By.xpath(locator)).getText();
        UtilFunctions.addScreenshot("Il Gateway "+gateway+" con stato  in progress presenta la data "+date);
    }

    @Then("I verify that the In progress step is updated for the gateway for the Gateway \"(.+)\"")
    public void iVerifyThatTheInProgressStepIsUpdated(String gateway) {
        StepFunctionPage.setInProgressFailedDate(gateway, date, "FAILED");
        PageElement pe = UtilFunctions.createNewPageElement("updated steps function for gateway "+gateway, StepFunctionPage.getInProgressFailedDate());
        Assert.assertTrue(pe.isPresent(), "Unable to find the updated step function for gateway "+gateway);
    }

    @Then("if needed I create a step function on \"(.+)\"")
    public static void createStepFunction(String gateway){
        boolean atLeastOneInProgress = false;
        CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy()).sendKeys(gateway);
        //CommonSteps.waitProgressBar();
        String locator = String.format("//tr//td[contains(., '%s')]//following-sibling::td[contains(., 'PROGRESS')]", gateway);
        try{
            Assert.assertTrue(CommonPage.getDriver().findElement(By.xpath(locator)).isDisplayed(), "Unable to find step function with status in progress for the gateway "+gateway);
            atLeastOneInProgress = true;
            CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy()).sendKeys(Keys.CONTROL+"a");
            CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy()).sendKeys(Keys.BACK_SPACE);
        }catch(Exception ignored){
        }

        if(!atLeastOneInProgress){
            PageElement pe = new PageElement("gateway details button", By.xpath("//strong[contains(text(), '" + gateway + "')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']"));
            Assert.assertTrue(HomePage.getHamburgerMenuIcon().tryClick());
            Assert.assertTrue(SidebarPage.getDevicesOption().tryClick());
            Util.Wait(1000);
            UtilFunctions.addScreenshot("creo una step function In PROGRESS sul Gateway: "+gateway);
            Assert.assertTrue(DevicesPage.getFilterBox().tryClick());
            Util.Wait(1000);
            Assert.assertTrue(DevicesPage.getCheckboxNeverConnected().tryClick());
            Util.Wait(1000);
            Assert.assertTrue(DevicesPage.getConfirmFilters().tryClick());
            Util.Wait(2000);
            CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy()).sendKeys(gateway);
            Util.Wait(2000);
            Assert.assertTrue(pe.tryClick());
            Assert.assertTrue(DevicesPage.getRebootButton().tryClick());
            Assert.assertTrue(DevicesPage.getConfirmRebootBtn().tryClick());
            UtilFunctions.addScreenshot("Bottone Reboot cliccato. Adesso aspetto 60 sec.");
            Util.Wait(60000);
            retrieveTheCurrentTimestamp();
            Util.Wait(3000);
            Assert.assertTrue(HomePage.getHamburgerMenuIcon().tryClick());
            Util.Wait(3000);
            Assert.assertTrue(SidebarPage.getStepFunctionSubOption().tryClick());
        }
    }

    @Then("I check if AWS step function for the gateway \"(.+)\" and apm \"(.+)\" is set to \"(.+)\"")
    public static void checkOnStepFunctionAWS(String gateway, String apm, String status){
        /*
         * The ProfileCredentialsProvider will return your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         *
         * It is possible to use another profile with:
         *  credentialsProvider = new ProfileCredentialsProvider("your-profile")
         */

        ProfileCredentialsProvider credentialsProvider =
                new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
            System.out.println(credentialsProvider.getCredentials());
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles " +
                            "file. Please make sure that your credentials file is " +
                            "at the correct location (~/.aws/credentials), and is " +
                            "in valid format.",
                    e);
        }

        Regions region = Regions.EU_CENTRAL_1;
        AWSStepFunctions sfnClient = AWSStepFunctionsClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(region)
                .build();

        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon Step Functions");
        System.out.println("===========================================\n");

        try {
            System.out.println("Listing state machines");
            ListStateMachinesResult listStateMachinesResult = sfnClient.
                    listStateMachines(new ListStateMachinesRequest());

            List<StateMachineListItem> stateMachines = listStateMachinesResult
                    .getStateMachines();

            System.out.println("State machines count: " + stateMachines.size());
            if (!stateMachines.isEmpty()) {
                for (StateMachineListItem sm : stateMachines){
                    if(!sm.getName().contains(apm+"_sfsm_commandmanager")){
                        continue;
                    }else{
                        System.out.println("State machine: "+sm.getName());
                        ListExecutionsRequest listRequest = new
                                ListExecutionsRequest().withStateMachineArn(sm
                                .getStateMachineArn());
                        ListExecutionsResult listExecutionsResult = sfnClient
                                .listExecutions(listRequest);
                        List<ExecutionListItem> executions = listExecutionsResult
                                .getExecutions();
                        for(ExecutionListItem ex : executions){
                            if(!ex.getName().contains(gateway)){
                                continue;
                            }else{
                                Timestamp start = new Timestamp(ex.getStartDate().getTime());
                                Timestamp stop = new Timestamp(ex.getStopDate().getTime());
                                if(start.before(ts) && stop.after(ts) ){
                                    System.out.println("\t\t-Name: " + ex.getName());
                                    Assert.assertTrue(ex.getStatus().equalsIgnoreCase(status));
                                    System.out.println("\t\t-The StepFunction for the gateway: "+gateway+" is correctly set to: "+status+ " as expected" );
                                    UtilFunctions.addScreenshot("The StepFunction for the gateway: "+gateway+"is correctly set to :" +status+ " as expected");
                                    break;
                                }

                            }
                        }
                    }
                }


//                stateMachines.forEach(sm -> {
//
//                    System.out.println("\t- Name: " + sm.getName());
//                    System.out.println("\t- Arn: " + sm.getStateMachineArn());
//
//                    ListExecutionsRequest listRequest = new
//                            ListExecutionsRequest().withStateMachineArn(sm
//                            .getStateMachineArn());
//                    ListExecutionsResult listExecutionsResult = sfnClient
//                            .listExecutions(listRequest);
//                    List<ExecutionListItem> executions = listExecutionsResult
//                            .getExecutions();
//
//                    System.out.println("\t- Total: " + executions.size());
//                    executions.forEach(ex -> {
//                        System.out.println("\t\t-Start: " + ex.getStartDate());
//                        System.out.println("\t\t-Stop: " + ex.getStopDate());
//                        System.out.println("\t\t-Name: " + ex.getName());
//                        System.out.println("\t\t-Status: " + ex.getStatus());
//                        System.out.println();
//                    });
//                });
            }

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means" +
                    " your request made it to Amazon Step Functions, but was" +
                    " rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means " +
                    "the client encountered a serious internal problem while " +
                    "trying to communicate with Step Functions, such as not " +
                    "being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    }

    public static void retrieveTheCurrentTimestamp(){
        Date date = new Date();
        ts = new Timestamp(date.getTime());
        System.out.println("Actual timestamp: "+ts);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(formatter.format(ts));
    }
    @Then("I check that the StepFunction page is correctly translated in italian")
    public static void checkTranslationStepFunctionPage() throws IOException {
        String [] tree = new String[]{"controlRoom"};
        String [] tree_incidents = new String[]{"controlRoom","incidents"};
        String [] tree_swManager = new String[]{"controlRoom","swManager"};
        String [] tree_reset = new String[]{"components", "table"};
        String [] tree_multiSelect = new String[]{"components", "multiSelect"};
        String [] tree_SelezionaDate = new String[]{"components", "datetime-range-picker"};


        CommonSteps.jsonReader(tree,"searchJobPlaceholder", UtilFunctions.createNewPageElement("Search box at the top right", "//input[@type='search' and @placeholder= 'Cerca per ID dispositivo/ID oggetto (ID,SN,Alias)']").getAttribute("placeholder").trim(), null );
        CommonSteps.jsonReader(tree,"diagnostic", UtilFunctions.createNewPageElement("landing page title", "//span[contains(.,'Diagnostica')]").getText().trim().replace("/",""), null );
        //expanding filter box
        Assert.assertTrue(UtilFunctions.createNewPageElement("search filters","//div[@class='dmc-card-header']//i[@dmcicon='chevron-down']").tryClick(), "Unable to click on search filters tab");
        UtilFunctions.addScreenshot("filter box");
        CommonSteps.jsonReader(tree,"command", UtilFunctions.createNewPageElement("command field in the filter box", "//dmc-form-field-label[contains(.,' Comando')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_incidents,"tsCreated", UtilFunctions.createNewPageElement("creation date in the filter box", "//dmc-form-field-label[contains(.,' Data di creazione')]").getText().trim(), null );
        CommonSteps.jsonReader(tree,"status", UtilFunctions.createNewPageElement("status in the filter box", "//dmc-form-field-label[contains(.,' Stato')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_multiSelect,"defaultLabel", UtilFunctions.createNewPageElement("select options in dropdown field", "//dmc-form-field-label[contains(.,' Comando')]/following-sibling::dmc-multi-select/div/dmc-multi-select-facade/div[contains(.,' Seleziona opzioni... ')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_multiSelect,"defaultLabel", UtilFunctions.createNewPageElement("select options in dropdown field", "//dmc-form-field-label[contains(.,'Stato')]/following-sibling::dmc-multi-select/div/dmc-multi-select-facade/div[contains(.,' Seleziona opzioni... ')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_SelezionaDate,"select", UtilFunctions.createNewPageElement("select options in dropdown field", "//dmc-form-field-label[contains(.,' Data di creazione')]/following-sibling::dmc-datetime-range-picker/div/div/dmc-dummy-input/div[contains(.,' Seleziona date... ')]").getText().trim().replace("...",""), null );

        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("clear btn", "//div[@class='col-12 mt-3 dmc-form-footer d-flex justify-content-end']/button[(text()= ' Pulisci ')]").getText().trim(),null);
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("confirm btn", "//div[@class='col-12 mt-3 dmc-form-footer d-flex justify-content-end']/button[(text()= ' Conferma ')]").getText().trim(),null);

        CommonSteps.jsonReader(tree_swManager, "deviceId", UtilFunctions.createNewPageElement("header id dispositivo", "//div[@class='-header']/div[contains(.,'ID Dispositivo')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "commandType", UtilFunctions.createNewPageElement("header tipo comando", "//div[@class='-header']/div[contains(.,' Tipo comando ')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Date Creation", UtilFunctions.createNewPageElement("header creation date", "//div[@class='-header']/div[contains(.,' Data creazione ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "status", UtilFunctions.createNewPageElement("header Stato", "//div[@class='-header']/div[contains(.,'Stato')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "statusDate", UtilFunctions.createNewPageElement("header Stato", "//div[@class='-header']/div[contains(.,'Data Stato')]").getText().trim(), null);
        // click on action columns
        Assert.assertTrue(UtilFunctions.createNewPageElement("column actions", "//i[@dmcicon='table-columns']").tryClick(), "Unable to click on: "+UtilFunctions.createNewPageElement(null, "//i[@dmcicon='table-columns']").getText());
        UtilFunctions.addScreenshot("column actions");
        CommonSteps.jsonReader(tree_swManager, "deviceId", UtilFunctions.createNewPageElement("column action id dispositivo", "//li/div[contains(.,' ID DISPOSITIVO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "commandType", UtilFunctions.createNewPageElement("column action tipo comando", "//li/div[contains(.,' TIPO COMANDO ')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Date Creation", UtilFunctions.createNewPageElement("column action creation date", "//li/div[contains(.,' DATA CREAZIONE ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "status", UtilFunctions.createNewPageElement("column action Stato", "//li/div[contains(.,' STATO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "statusDate", UtilFunctions.createNewPageElement("column action  DATA STATO ", "//li/div[contains(.,' DATA STATO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", DeploymentsHistoryPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", DeploymentsHistoryPage.getCloseColumnsBTN().getText(),null);
        Assert.assertTrue(UtilFunctions.createNewPageElement("closing the column actions", "//span[contains(.,' Chiudi ')]").tryClick(), "Unable to retrieve the element");
        //check the pagination
        CommonSteps.jsonReader(tree_reset, "rowsPerPage", DeploymentsHistoryPage.getRowsPerPageIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "pageCounters", DeploymentsHistoryPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+DeploymentsHistoryPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);
        DeploymentsHistoryPage.getPageCountersIT().scrollTo();
    }
    @Then("I close all the step functions in progress of device {string}")
    public static void iCloseAllStepFunctions(String device) throws Exception {
        //the method goes from the apm to step function page then return to apm
        //PageElement pe = ReflectionUtils.getPageElementByString("StepFunctionPage", "deleteButtonEnabled");
        long startTime = System.currentTimeMillis();
        long timePassed = 0;
        CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
        CommonSteps.checkAndClickElementPresent("SidebarPage", "diagnosticOption");
        CommonSteps.checkAndClickElementPresent("SidebarPage", "stepFunctionSubOption");
        CommonSteps.fillInputBox(device, "DevicesPage","searchBox");
        CommonSteps.waitProgressBar();

        List<WebElement> trash_to_click = CommonPage.getDriver().findElements(StepFunctionPage.getDeleteButtonEnabled().getBy());

        while(!(trash_to_click.isEmpty()) && timePassed < 31 * 60000) {

            WebElement we = trash_to_click.get(0);
            we.click();
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "confirmButton");
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "dismissBTN");
            Util.Wait(1000);
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "refreshBtn");
            trash_to_click = CommonPage.getDriver().findElements(StepFunctionPage.getDeleteButtonEnabled().getBy());
            timePassed = System.currentTimeMillis() - startTime;
        }
        CommonSteps.checkAndClickElementPresent("StepFunctionPage", "refreshBtn");
        CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
        CommonSteps.checkAndClickElementPresent("SidebarPage", "diagnosticDropDownOption");
        CommonSteps.checkAndClickElementPresent("SidebarPage", "homeOption");

    }
    @Then("I close all the step functions in progress")
    public static void iCloseAllStepFunctions() throws Exception {
        //PageElement pe = ReflectionUtils.getPageElementByString("StepFunctionPage", "deleteButtonEnabled");
        long startTime = System.currentTimeMillis();
        long timePassed = 0;

        List<WebElement> trash_to_click = CommonPage.getDriver().findElements(StepFunctionPage.getDeleteButtonEnabled().getBy());

        while(!(trash_to_click.isEmpty()) && timePassed < 31 * 60000) {

            WebElement we = trash_to_click.get(0);
            we.click();
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "confirmButton");
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "dismissBTN");
            Util.Wait(1000);
            CommonSteps.checkAndClickElementPresent("StepFunctionPage", "refreshBtn");
            trash_to_click = CommonPage.getDriver().findElements(StepFunctionPage.getDeleteButtonEnabled().getBy());
            timePassed = System.currentTimeMillis() - startTime;
        }
    }

    @Then("I type \"(.+)\" to search by \"(.+)\"")
    public static void typeInTheSearchBox(String source, String type){
        setStringToCheck(source);
        setStypeToCheck(type);
        WebElement we = CommonPage.getDriver().findElement(StepFunctionPage.getInputFieldStepFunction().getBy());
        we.sendKeys(source);
    }

    private static long timestampAlarm;

    public static long getTimestampAlarm() {
        return timestampAlarm;
    }

    public static void setTimestampAlarm(long timestampAlarm) {
        StepFunctionSteps.timestampAlarm = timestampAlarm;
    }
    @And("I save current timestamp to check time")
    public void iSaveTimestampToCheckAlarm() throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.getTime());
        setTimestampAlarm(timestamp.getTime());
    }
    @Then("I check that all rows contains the source searched previously on StepFunctionPage")
    public static void checkFilteredRowsonStepFunctionPage() {
        String source = getStringToCheck();
        String type = getStypeToCheck();
        String locator = null;

        switch (type) {
            case "gatewayID":
                locator ="//tr[@class='ng-star-inserted']/td[@class='--align-left ng-star-inserted' and normalize-space(text())='"+source+"']";
                break;
            case "thingID":
                locator ="//tr[@class='ng-star-inserted']/td[@class='--align-left ng-star-inserted' and contains(.,'"+source+"')]";
                break;
            case "thingSN":
                locator ="//tr[@class='ng-star-inserted']/td[@class='--align-left ng-star-inserted' and contains(.,'"+source+"')]";
                break;
            case "serial number":
                locator ="//tr[@class='ng-star-inserted']/td[@class='--align-left ng-star-inserted' and normalize-space(text())='"+source+"']";
                break;
            case "alias":
                locator ="//tr[@class='ng-star-inserted']/td[@class='--align-left ng-star-inserted' and normalize-space(text())='"+source+"']";
                break;
            default:
                Assert.fail("Type of search input is not correct");
        }

        PageElement pe = null;
        try {
            pe = UtilFunctions.createNewPageElement("first row", "(//tbody/tr)[1]");
            Assert.assertTrue(pe.isPresent(10), "No row present in 10sec");
        } catch (Exception ignored) {
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath(locator));
        if (rows != null && !rows.isEmpty()) {
            for (int i = 1; i <= rows.size(); i++) {
                System.out.println(i);
                pe = UtilFunctions.createNewPageElement("row " + i + "into the table", "(" + locator + ")[" + i + "]");
                Assert.assertTrue(pe.isPresent(), "The Element " + pe + " is not present");
            }
        } else {
            Assert.fail("The filter by source do not work properly");
        }
    }
    @Then("I wait last step function to be succeeded in {int} seconds for device {string}")
    public static void clickOnDetailsOfLastStepFunctionOfDevice(long elapsingTime, String deviceType) throws Exception {
        //DO NOT USE THIS METHOD FOR TOO RAPID PROCESS LIKE DELETE AND FORCE DELETE
        boolean isSuccess= false;
        boolean isToastMessage= false;
        boolean isProgress = false;
        //get the timestamp set earlier
        long startTime = getTimestampAlarm();
        long timePassed = 0;
        PageElement toastMessage= null;
        //last step function
        PageElement pe = UtilFunctions.createNewPageElement("Status of last step function ", "(//td//span)[1]");
        switch (deviceType) {
            case "gateway":
                toastMessage = UtilFunctions.createNewPageElement("Toast messsage succeeded ", "//dmc-toaster/div/span[contains(text(), 'SUCCEEDED')]");
                break;
            case "direct_thing":
                toastMessage = UtilFunctions.createNewPageElement("Toast messsage succeeded ", "//div[contains(., ' Direct Thing ')]");
                break;
            case "thing":
                toastMessage = UtilFunctions.createNewPageElement("Toast messsage succeeded ", "//dmc-toaster/div/span");
                break;
            case "firmware":
                toastMessage = UtilFunctions.createNewPageElement("Toast messsage succeeded ", "//snack-bar-container");
                break;
            case "no_toast_msg":
                toastMessage = UtilFunctions.createNewPageElement("Status of last step function ", "(//td//span[contains(text(), 'IN_PROGRESS')])[1]");;
                break;
            default:
                Assert.fail("Invalid input in the step");
        }
        //wait 10 seconds to have at least the in progress step
        Thread.sleep(10000);
        //refresh button
        Assert.assertTrue(StepFunctionPage.getRefreshBtn().tryClick(), "The refresh button is not clickable");

        //I give double of timeout to check how much it takes
        while (elapsingTime * 2000L > System.currentTimeMillis() - startTime && !isSuccess) {
            StepFunctionPage.getRefreshBtn().tryClick();
            Thread.sleep(700);
            timePassed = System.currentTimeMillis() - startTime;

            if (!isToastMessage) {
                if (toastMessage.isPresent(0)) {
                    UtilFunctions.addScreenshot("Toast Message appeared after " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
                    isToastMessage = true;
                    System.out.println("Toast message is present? " + isToastMessage);
                }
            }

            if(isToastMessage){
                if(pe.getText().trim().equals("IN_PROGRESS")) {
                    //while the step function is in progress I refresh and retry
                    System.out.println("Step function still in progress after " + timePassed / 1000 + " seconds");
                    isProgress = true;
                }

                if (pe.getText().trim().equals("SUCCEEDED")) {
                    UtilFunctions.addScreenshot("Step Function Succeeded in " + timePassed / 1000 + " seconds");
                    isSuccess = true;
                }

            }
        }
        System.out.println("Time passed from close job: "+timePassed/1000);
        Assert.assertFalse((elapsingTime * 1000L) < timePassed && isSuccess, "Step function became successfull after: "+timePassed/1000 +" seconds instead of: "+ elapsingTime + " seconds");
        Assert.assertTrue(isSuccess, "Step function didn't succeed in: "+timePassed/1000 + " seconds");
        Assert.assertTrue(isProgress, "Step function in progress never created");

    }

    @Then("I click on the details of the last step function of {string}")
    public static void clickOnDetailsOfLastStepFuncionOfDevice(String device_id) throws Exception {
        String locator = "((//tbody/tr/td[contains(., '%s')]/parent::tr)[1])//dmc-table-action[@class='ng-star-inserted']";
        String row = String.format(locator, device_id);
        PageElement pe = UtilFunctions.createNewPageElement("Details icon of last step function of device " + device_id, row);
        Thread.sleep(1000);
        if(pe.isPresent())
            pe.scrollTo();
        Assert.assertTrue(pe.isPresent(), "The Element is not present");
        Assert.assertTrue(pe.tryClick(true, false), "The details of the step function of "+ device_id +" is not clickable");
        Thread.sleep(500);
    }


}