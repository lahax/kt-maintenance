package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import software.amazon.awssdk.services.iot.IotClient;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.steps.UISteps;
import ta.utilities.ReflectionUtils;
import test.pages.DeploymentHistoryDeviceDetailsPage;
import test.pages.DevicesDetailsPage;
import test.pages.DirectThingLogsPage;
import test.pages.DevicesPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class DevicesDetailsSteps {

    private static String day;
    private static String hour;
    private static String minute;

    public String getDay()    { return day; }
    public String getHour()   { return hour; }
    public String getMinute() { return minute; }

    public static void setDay(String newDay) { day = newDay; }
    public static void setHour(String newHour) { hour = newHour; }
    public static void setMinute(String newMinute) { minute = newMinute; }

    public static String getSourceToBeCheck() { return sourceToBeCheck;}
    public static void setSourceToBeCheck(String sourceToBeCheck) {DevicesDetailsSteps.sourceToBeCheck = sourceToBeCheck;}
    private static String sourceToBeCheck;
    public static String getExpirationDateRetrieved() {
        return expirationDateRetrieved;
    }

    public static void setExpirationDateRetrieved(String expirationDateRetrieved) {
        DevicesDetailsSteps.expirationDateRetrieved = expirationDateRetrieved;
    }

    private static String expirationDateRetrieved;

    @Then("I check that the Direct Thing details page is correctly translated")
    public void checkTranslationDirectDetails() throws IOException {
//        //*Check options not traduced*//
        String [] tree  = new String[]{"controlRoom"};
        String [] tree_direct  = new String[]{"controlRoom", "directThing"};
        String [] tree_files  = new String[]{"controlRoom", "fileTransfers"};
        String textLogs = DevicesDetailsPage.getDeviceLastLogsText().getText();
        String textLogsCut = textLogs.substring(0, textLogs.indexOf(":")) + ":";
        //*Check options*//
        CommonSteps.jsonReader(null, "Back", DevicesDetailsPage.getBackBTN().getText(),null);
        CommonSteps.jsonReader(tree_direct, "theDirectThingIs", DevicesDetailsPage.getDirectThingStatusAlert().getText().split("d")[0],null);
        CommonSteps.jsonReader(null, "lastCollectLogs", textLogsCut,null);
        CommonSteps.jsonReader(tree, "tooltipMaker", DevicesDetailsPage.getMakerIT().getText(),null);
        CommonSteps.jsonReader(tree, "serialNumber", DevicesDetailsPage.getSerialNumberIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipEnvPref", DevicesDetailsPage.getEnvironmentPrefixIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipGeoLocalization", DevicesDetailsPage.getGeolocalizationIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipType", DevicesDetailsPage.getTypeIT().getText(),null);
        CommonSteps.jsonReader(tree, "systemCommands", DevicesDetailsPage.getSystemCommandsHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree_direct, "editDirectThing", DevicesDetailsPage.getUpdateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "deactivate", DevicesDetailsPage.getDeactivateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "reboot", DevicesDetailsPage.getRebootBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "firmwareUpdate", DevicesDetailsPage.getFirmwareUpdateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "remoteControl", DevicesDetailsPage.getRemoteControlBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "renewCertificate", DevicesDetailsPage.getRenewCertificatesBTNit().getText(),null);
        CommonSteps.jsonReader(tree_files, "uploadFile", DevicesDetailsPage.getUploadFileBTNit().getText(),null);
        CommonSteps.jsonReader(tree_files, "downloadFile", DevicesDetailsPage.getDownloadFileBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "showLogs", DevicesDetailsPage.getShowLogsBTNit().getText(),null);
        CommonSteps.jsonReader(tree_direct, "telemetryDirectThing", DevicesDetailsPage.getTelemetryBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "getHistoryLogs", DevicesDetailsPage.getGetHistoryLogsBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "enableCollectLogs", DevicesDetailsPage.getEnableCollectLogsBTNit().getText(),null);

    }

    @Then("I check that the Gateway details page is correctly translated")
    public void checkTranslationGatewayDetails() throws IOException {
//        //*Check options not traduced*//
        String [] tree  = new String[]{"controlRoom"};
        //String [] tree_direct  = new String[]{"controlRoom", "directThing"};
        //String [] tree_files  = new String[]{"controlRoom", "fileTransfers"};
        String textLogs = DevicesDetailsPage.getDeviceLastLogsText().getText();
        String textLogsCut = textLogs.substring(0, textLogs.indexOf(":")) + ":";
        //*Check options*//
        CommonSteps.jsonReader(null, "Back", DevicesDetailsPage.getBackBTN().getText(),null);
        CommonSteps.jsonReader(null, "lastCollectLogs", textLogsCut,null);
        CommonSteps.jsonReader(tree, "tooltipMaker", DevicesDetailsPage.getMakerIT().getText(),null);
        CommonSteps.jsonReader(tree, "serialNumber", DevicesDetailsPage.getSerialNumberIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipEnvPref", DevicesDetailsPage.getEnvironmentPrefixIT().getText(),null);
        //CommonSteps.jsonReader(tree, "tooltipGeoLocalization", DevicesDetailsPage.getGeolocalizationIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipType", DevicesDetailsPage.getTypeIT().getText(),null);
        CommonSteps.jsonReader(tree, "tooltipGtwType", DevicesDetailsPage.getTypeGatewayIT().getText(),null);
        CommonSteps.jsonReader(tree, "systemCommands", DevicesDetailsPage.getSystemCommandsHeaderIT().getText(),null);
        //CommonSteps.jsonReader(tree_direct, "editDirectThing", DevicesDetailsPage.getUpdateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "deactivate", DevicesDetailsPage.getDeactivateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "reboot", DevicesDetailsPage.getRebootBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "firmwareUpdate", DevicesDetailsPage.getFirmwareUpdateBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "remoteControl", DevicesDetailsPage.getRemoteControlBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "renewCertificate", DevicesDetailsPage.getRenewCertificatesBTNit().getText(),null);
        //CommonSteps.jsonReader(tree_files, "uploadFile", DevicesDetailsPage.getUploadFileBTNit().getText(),null);
        //CommonSteps.jsonReader(tree_files, "downloadFile", DevicesDetailsPage.getDownloadFileBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "showLogs", DevicesDetailsPage.getShowLogsBTNit().getText(),null);
        //CommonSteps.jsonReader(tree_direct, "telemetryDirectThing", DevicesDetailsPage.getTelemetryBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "getHistoryLogs", DevicesDetailsPage.getGetHistoryLogsBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "updateGateway", DevicesDetailsPage.getUpdateGatewayBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "greengrassDeploy", DevicesDetailsPage.getGreenGrassDeployBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "greengrassResetTitle", DevicesDetailsPage.getGreenGrassResetBTNit().getText(),null);
        CommonSteps.jsonReader(tree, "otaUpdateTitle", DevicesDetailsPage.getOtaUpdateBTNit().getText(),null);

    }

    @Then("I check that the refresh button works properly in the device details page")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        CommonSteps.waitProgressBar();
        PageElement pe = UtilFunctions.createNewPageElement("first row" , "//tbody/tr[1]");
        Assert.assertTrue(pe.isPresent(), "Unable to find any row in the table");

        List<WebElement> els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();

        if (els.size() == 0 ){
            Assert.fail("The Table do not present any row!");
        }

        for (WebElement we : els) {
            origin.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }
        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(10000);
        DeploymentHistoryDeviceDetailsPage.getRefreshButton().click();
        //Thread.sleep(10000);
        CommonSteps.waitProgressBar();
        Assert.assertTrue(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertNotEquals(webElement.getText(), "TEST", "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrieved after refresh are different from the expected");
    }

    public static String getRandomNumberForLatitudeOrLongitude() {

        Random random = new Random();
        int x = random.nextInt(900) + 100;

        return String.valueOf(x);
    }

    @Then("^I enter a random \"(.+)\" in (\\w+).(\\w+)$")
    public static void iEnterARandomInUpdateGatewayDeviceDetailsPageLatitudeInputField(String lonLatOption, String className, String fieldName) throws Exception {

        int d;
        int h;
        int m;
        String randomNumber = "";
        DateTime dt = new DateTime();

        switch (lonLatOption) {
            case "latitude":
                randomNumber = "43.".concat(getRandomNumberForLatitudeOrLongitude());
                break;
            case "longitude":
                randomNumber = "11." + getRandomNumberForLatitudeOrLongitude();
                d = dt.getDayOfMonth();
                h = dt.getHourOfDay();
                m = dt.getMinuteOfHour();
                day = String.valueOf(d);
                setDay(day);
                hour = String.valueOf(h);
                setHour(hour);
                minute = String.valueOf(m);
                setMinute(minute);

                System.out.println("Day: " + day + " at: " + hour + ":" + minute);
                break;
            default:
                System.out.println("Error: choice not valid!");
        }

        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.CONTROL+"a");
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.BACK_SPACE);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(randomNumber);
    }

    @Then("I check the row with succeeded status is present")
    public void iCheckTheRowWithSucceededStatusIsPresent() throws InterruptedException {

        PageElement p_element = UtilFunctions.createNewPageElement("first row", "//tbody/tr[1]/td");
        Assert.assertTrue(p_element.isPresent(), "Unable to find any row in the table");
        List<WebElement> els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        List<String> list = new ArrayList<>();
        boolean flag = false;
        int count = 0;

        if (els.size() == 0) {
            Assert.fail("The table do not present any row!");
        }

        for (WebElement we : els) {
            list.add(we.getText().toLowerCase());
        }

        String str = list.toString();

        while (!flag && count <= 30) {
            if (str.contains(getDay()) && str.contains(getHour()) && str.contains(getMinute()) && str.contains("succeeded")) {
                flag = true;
            }
            count++;
            TimeUnit.SECONDS.sleep(1);
        }
    }
    @Then("I check for at least one row into the table on ThingListPage")
    public static void checkTableRow(){
        List<WebElement> we = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(we== null || we.isEmpty()){
            Assert.fail("No row into the table");
        }
    }

    @Then("I check that all row contains the source searched previously on ThingListPage")
    public static void checkFilteredRows(){
        String locator = String.format(DevicesDetailsPage.rowFilteredBySource, getSourceToBeCheck());
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
    @Then("I type random source in Source SearchBox on ThingListPage")
    public static void typeRandomSourceIntheSourceSearchBox(){
        String source = DevicesDetailsPage.getRandomSource();
        setSourceToBeCheck(source);
        WebElement we = CommonPage.getDriver().findElement(DevicesDetailsPage.getSearchThingLabel().getBy());
        we.sendKeys(source);
    }

    private static String customCommunicationEnabled;

    public static String getCustomCommunicationEnabled() {
        return customCommunicationEnabled;
    }

    public static void setCustomCommunicationEnabled(String customCommunicationEnabled) {
        DevicesDetailsSteps.customCommunicationEnabled = customCommunicationEnabled;
    }

    @Then("I check if the Custom Communication is enabled or not")
    public static void setCustomCommunicationEnabled(){
        String status = DevicesDetailsPage.getCustomCommunicationInMoreInfo().getText();
        setCustomCommunicationEnabled(status);
    }

    @Then("I change the status of the Custom Communication")
    public static void typeStringIntoElement() throws Exception {
        PageElement elem = DevicesDetailsPage.getCustomCommunicationEnabledBox();
        String status = getCustomCommunicationEnabled();
        if (Objects.equals(status, "false")){
            CommonPage.getDriver().findElement(elem.getBy()).sendKeys("true");
            //setCustomCommunicationEnabledNew("true");
        } else {
            CommonPage.getDriver().findElement(elem.getBy()).sendKeys("false");
            //setCustomCommunicationEnabledNew("false");
        }

    }

    @Then("I check if the Custom Communication status is changed")
    public static void checkChangeCustomCommunicationEnabled(){
        String oldStatus = getCustomCommunicationEnabled();
        System.out.println(oldStatus);
        String status = DevicesDetailsPage.getCustomCommunicationInMoreInfo().getText();
        System.out.println(status);

        if (Objects.equals(oldStatus, "false")) {
            Assert.assertEquals(status, "true");
        } else {
            Assert.assertEquals(status, "false");
        }

    }

    private static String collectLogsStatus;

    public static String getCollectLogsStatus() {
        return collectLogsStatus;
    }

    public static void setCollectLogsStatus(String collectLogsStatus) {
        DevicesDetailsSteps.collectLogsStatus = collectLogsStatus;
    }

    @Then("I check if Collect Logs is Enabled or Disabled")
    public static void setCollectLogsStatus(){
        String status = DirectThingLogsPage.getCollectLogsStatus().getText();
        setCollectLogsStatus(status);
    }

    @Then("I check if Collect Logs status is changed")
    public static void checkLogsCahnged(){
        String oldStatus = getCollectLogsStatus();
        System.out.println(oldStatus);
        String status = DirectThingLogsPage.getCollectLogsStatus().getText();
        System.out.println(status);

        if (Objects.equals(oldStatus.trim(), "Enabled")) {
            Assert.assertEquals(status.trim(), "Disabled");
        } else {
            Assert.assertEquals(status.trim(), "Enabled");
        }

    }

    @Then("I check if Collect Logs status is Enabled")
    public static void checkLogsEnabled(){

        String status = DirectThingLogsPage.getCollectLogsStatus().getText();
        System.out.println(status);

        Assert.assertEquals(status.trim(), "Enabled");

    }

    @Then("I click on details icon of the device \"(.+)\"")
    public static void clickDetailsIconSpeficDevice(String device){
        DevicesPage.setIconDetailSpeficDeviceId(device);
        PageElement pe = UtilFunctions.createNewPageElement("first occurrance of the details icon of the specified device: "+device, DevicesPage.getIconDetailSpeficDeviceId());
        Assert.assertTrue(pe.isPresent(), "Unable to find the element: "+pe);
        Assert.assertTrue(pe.tryClick(), "Unable to click on element: "+pe);
    }

    @Then("If gateway {string} is not present I run register.sh")
    public static void iRegisterTestConcept1(String gateway) throws Exception {
        //You have to be in device list to use this method
        //You have to search the device with precise string in order to ha 0 rows
        String command = "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa "+gateway+" ./payload_gateway_greengrass.txt";
        boolean gatewayPresent = DevicesPage.getFirstRowDeviceDetailsIcon().isPresent();
        if (!gatewayPresent){
            CommonSteps.iLaunchCommandOnShell(command);
            CommonSteps.iWaitMinutesAfterScript(2);
            //You end up searching the device in the input box
            UISteps.fillInputBox(gateway,"DevicesPage","searchBox");
        }

    }

    @Then("If direct thing {string} is not present I run register_direct.sh")
    public static void iRegisterDirect(String gateway) throws Exception {
        //You have to be in device list to use this method
        //You have to search the device with precise string in order to ha 0 rows
        String command = "bash ./register_direct.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa "+gateway+" ./payload_direct_thing.txt";
        System.out.println(command);
        boolean gatewayPresent = DevicesPage.getFirstRowDeviceDetailsIcon().isPresent();
        if (!gatewayPresent){
            CommonSteps.iLaunchCommandOnShell(command);
            CommonSteps.iWaitMinutesAfterScript(2);
            //You end up searching the device in the input box
            UISteps.fillInputBox(gateway,"DevicesPage","searchBox");
        }

    }

    @Then("If thing {string} is not present I run register_thing.sh with gateway {string}")
    public static void iRegisterThing (String thing, String gateway) throws Exception {
        //You have to be in device list to use this method
        //You have to search the device with precise string in order to ha 0 rows
        String command = "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa " + gateway + " " + thing + " ./payload_register_thing.txt";
        boolean gatewayPresent = DevicesPage.getFirstRowDeviceDetailsIcon().isPresent();
        if (!gatewayPresent) {
            CommonSteps.iLaunchCommandOnShell(command);
            CommonSteps.iWaitMinutesAfterScript(2);
            //You end up searching the device in the input box
            UISteps.fillInputBox(gateway, "DevicesPage", "searchBox");
        }

    }

    @Then("^I delete the text and type \"(.+)\" into the element (\\w+).(\\w+)$")
    public static void typeStringIntoElement(String text, String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        assertTrue(elem.tryClick(true), "Unable to click on the element: " + fieldName);
        Thread.sleep(2000);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.CONTROL+"a");
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.BACK_SPACE);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(text);
    }

    @Then("I check the presence of details icon for the specific Devices \"(.+)\" and then I click it")
    public static void checkThePresenceAndThenClickIt(String device){
        CommonSteps.waitProgressBar();
        DevicesPage.setDeviceDetailIcon(device);
        PageElement pe = UtilFunctions.createNewPageElement("icon detail for device "+device, DevicesPage.getDeviceDetailIcon());
        Assert.assertTrue(pe.isPresent(), "unable to locate the icon button "+DevicesPage.getDeviceDetailIcon());
        Assert.assertTrue(pe.tryClick(), "Unable to click the icon button document");
    }

    @Then("^I hover over package name")
    public static void hoverBy() throws Exception {
        //PageElement elem = UtilFunctions.createNewPageElement("softwareln", "/html/body/dmc-root/ng-component/div/div/app-device-detail-wrapper/dmc-gateway-detail/mat-tab-group/div/mat-tab-body[1]/div/dmc-gateway-detail-general/div/div[1]/div[2]/div/div[2]/dmc-details-grid/div/div/dmc-details-grid-item[9]/div[2]/div/dmc-packages-list/div/div[1]/span");
        WebElement elem = CommonPage.getDriver().findElement(By.xpath("//a[@class='--more-packages ng-star-inserted']"));
        Actions action = new Actions(CommonPage.getDriver());
        action.moveToElement(elem).perform();
        Thread.sleep(2000);
    }

    @Then("I check information in Deployment History tab \"(.+)\" tooltip")
    public static void DHtooltip(String tooltipName){
        switch ( tooltipName ){
            case "Software Type":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Software Type')]");
                Assert.assertEquals(Title.getText(), "Software Type");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='ng-star-inserted']");
                Assert.assertEquals(txt.getText(), "Software category of the packages inside the Software Catalogue.");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Deploy Type":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Deploy Type')]");
                Assert.assertEquals(Title.getText(), "Deploy Type");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'Gateway Software')]");
                Assert.assertEquals(txt.getText(), "Gateway Software: (only for Gateway): when the gateway is updated using the command \"Firmware Update\"");
                PageElement txt1 = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'Greengrass Software')]");
                Assert.assertEquals(txt1.getText(), "Greengrass Software: (only for Gateway): when the gateway is updated using the command \"Greengrass Reset\"");
                PageElement txt2 = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'Greengrass Deployment')]");
                Assert.assertEquals(txt2.getText(), "Greengrass Deployment: (only for Gateway): when the gateway is updated using the command \"Greengrass Deploy\"");
                PageElement txt3 = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'Direct Thing Software')]");
                Assert.assertEquals(txt3.getText(), "Direct Thing Software: (only for Direct Thing): when the direct thing is updated using the command \"Firmware Update\"");
                PageElement txt4 = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'Gateway Thing Software')]");
                Assert.assertEquals(txt4.getText(), "Gateway Thing Software: (only for Gateway's Things): when a thing of a gateway is updated using the command \"Firmware update\"");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Start":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Start')]");
                Assert.assertEquals(Title.getText(), "Start");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='ng-star-inserted']");
                Assert.assertEquals(txt.getText(), "Date and time when the deployment has been launched.");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Duration":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Duration')]");
                Assert.assertEquals(Title.getText(), "Duration");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='ng-star-inserted']");
                Assert.assertEquals(txt.getText(), "The time interval between the begin and the end of the Deployment.");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Latest":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Latest')]");
                Assert.assertEquals(Title.getText(), "Latest");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='ng-star-inserted']");
                Assert.assertEquals(txt.getText(), "When flagged, define that is the last Deploy done on that device.");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Status":{
                PageElement icon = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='greengrass-circle']");
                PageElement icontxt = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Greengrass Software')]");
                Assert.assertTrue(icon.isPresent());
                Assert.assertEquals(icontxt.getText(), "Greengrass Software");
                PageElement icon1 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='greengrass']");
                PageElement icontxt1 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Greengrass Deployment')]");
                Assert.assertTrue(icon1.isPresent());
                Assert.assertEquals(icontxt1.getText(), "Greengrass Deployment");
                PageElement icon2 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='grid-3x3']");
                PageElement icontxt2 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Gateway Software')]");
                Assert.assertTrue(icon2.isPresent());
                Assert.assertEquals(icontxt2.getText(), "Gateway Software");
                PageElement icon3 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='grid-3x3']");
                PageElement icontxt3 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Direct Thing Software')]");
                Assert.assertTrue(icon3.isPresent());
                Assert.assertEquals(icontxt3.getText(), "Direct Thing Software");
                PageElement icon4 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='grid-3x3']");
                PageElement icontxt4 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Gateway Thing Software')]");
                Assert.assertTrue(icon4.isPresent());
                Assert.assertEquals(icontxt4.getText(), "Gateway Thing Software");
                PageElement icon5 = UtilFunctions.createNewPageElement("icon", "//i[@class='--circle --timeout']");
                PageElement icontxt5 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Timeout')]");
                Assert.assertTrue(icon5.isPresent());
                Assert.assertEquals(icontxt5.getText(), "Timeout");
                PageElement icon6 = UtilFunctions.createNewPageElement("icon", "//i[@class='--circle --complete']");
                PageElement icontxt6 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Completed')]");
                Assert.assertTrue(icon6.isPresent());
                Assert.assertEquals(icontxt6.getText(), "Completed");
                PageElement icon7 = UtilFunctions.createNewPageElement("icon", "//i[@class='--circle --pending']");
                PageElement icontxt7 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'In Progress')]");
                Assert.assertTrue(icon7.isPresent());
                Assert.assertEquals(icontxt7.getText(), "In Progress");
                PageElement icon8 = UtilFunctions.createNewPageElement("icon", "//i[@class='--circle --failed']");
                PageElement icontxt8 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Failed')]");
                Assert.assertTrue(icon8.isPresent());
                Assert.assertEquals(icontxt8.getText(), "Failed");
                PageElement icon9 = UtilFunctions.createNewPageElement("icon", "//i[@class='--circle --partial']");
                PageElement icontxt9 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Partial')]");
                Assert.assertTrue(icon9.isPresent());
                Assert.assertEquals(icontxt9.getText(), "Partial");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
        }

    }
}
