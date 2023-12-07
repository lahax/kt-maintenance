package test.steps;

import Util.Mailinator;
import Util.UtilFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;

import ta.utilities.Configuration;
import ta.utilities.ReflectionUtils;
import test.pages.DeviceAlarmsConfigurationPage;
import test.pages.HomePage;
import test.pages.ProjectPage;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.testng.Assert.assertTrue;
import static test.steps.CommonSteps.jsonReader;

public class DeviceAlarmsConfigurationSteps {

    private static boolean createdAlarm = false;

    public static boolean isCreatedAlarm() {
        return createdAlarm;
    }
    public static void setCreatedAlarm(boolean createdAlarm) {
        DeviceAlarmsConfigurationSteps.createdAlarm = createdAlarm;
    }

    private static String numberPhone;

    public static String getNumberPhone() {
        return numberPhone;
    }

    public static void setNumberPhone(String numberPhone) {
        DeviceAlarmsConfigurationSteps.numberPhone = numberPhone;
    }

    private static int numOfAlarms;
    public static int getNumOfAlarms(){
        return numOfAlarms;
    }

    public static void setNumOfAlarms(int totalNumberOfAlarmsPresent){
        numOfAlarms = totalNumberOfAlarmsPresent;
    }

    @Then("I check that user land on Device Alarm Configuration Page")
    public static void checkLandInPage() {
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getDeviceAlarmsConfigurationPageTitle().isVisible(), "Device Alarm page not found!");
    }

    @Then("I check that all columns are present")
    public static void checkColumnsName(List<String> columns) {
        List<String> col = new ArrayList<String>();
        for (String s : columns) {
            col.add(s.toLowerCase());
        }
        List<WebElement> els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getColumnsName().getBy());
        if (els.size() == col.size()) {
            PageElement pe = null;
            for (int i = 1; i <= els.size(); i++) {
                pe = new PageElement("colonna " + i, By.xpath("//th[contains(text(), '')][" + i + "]"));
                System.out.println("Found column " + i + ": " + "\"" + pe.getText() + "\"");
                Assert.assertTrue(col.contains(pe.getText().toLowerCase()), "Column: " + columns.get(i - 1) + " not present");
            }
        } else {
            Assert.fail("The retrieved columns are " + els.size() + " but should be " + col.size());
        }

    }

    @Then("I check that the refresh button works properly")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        boolean createdAlarm = false;

        List<WebElement> els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();

        if (els.size() == 0 ){
            createdAlarm= true;
            createExampleAlarm();
            els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());

        }
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        for (WebElement we : els) {
            origin.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }
        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(10000);
        DeviceAlarmsConfigurationPage.getRefreeshBTN().click();
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrived after refresh are different from the expected");

        if(createdAlarm){
            Assert.assertTrue(DeviceAlarmsConfigurationPage.getIconTrashFirstRow().tryClick(), "Error while deleting alarm");
            Assert.assertTrue(DeviceAlarmsConfigurationPage.getDeleteButton().tryClick(), "Error while deleting alarm");

        }

    }

    @Then("I check that there is the info icon close to each column name")
    public static void checkInfoIconCloseToEachNameColumn() {
        List<WebElement> infoIcons = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getInfoIcons().getBy());
        List<WebElement> columnsName = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getColumnsName().getBy());
        PageElement pe;
        int count = 0;
        for (WebElement we : columnsName) {
            if (!we.getText().isEmpty()) {
                count++;
            }
        }
        if (infoIcons.size() == count) {
            for (int i = 1; i <= infoIcons.size(); i++) {
                pe = new PageElement("info icon " + i, By.xpath("(//i[@dmcicon='info'])[" + i + "]"));
                Assert.assertTrue(pe.isPresent(), "The info icon " + i + " not present");
            }
        } else {
            Assert.fail("The number of info icons should be equal to " + count + "since there are " + count + "columns with a name ");
        }
    }

    @Then("I check each pop up after click on info icon")
    public static void checkAllPopUp() {
        List<WebElement> infoIcons = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getInfoIcons().getBy());
        PageElement pe;
        for (int i = 1; i <= infoIcons.size(); i++) {
            pe = new PageElement("info icon " + i, By.xpath("(//i[@dmcicon='info'])[" + i + "]"));
            pe.click();
            switch (i) {
                case 1:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpAlarmTarget().isVisible(), "Alarm pop up not present");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                case 2:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpBusinessAlarmConfiguration().isVisible(), "pop up Business Alarm Configuration not visible");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                case 3:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpWidespreadDisserviceAlarmConfiguration().isVisible(), "pop up Widespread Disservice Alarm Configuration not visible");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                case 4:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpLowMsgRatesTHLD().isVisible(), "Lower Message Rate Threshold Alarm Configuration not visible");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                case 5:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpHighMsgRatesTHLD().isVisible(), "pop up Higher Message Rate Threshold Alarm Configuration not visible");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                case 6:
                    Assert.assertTrue(DeviceAlarmsConfigurationPage.getPopUpTelemetryAlarmConfiguration().isVisible(), "pop up Telemetry Alarm Configuration not visible");
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUp().click();
                    break;
                default:

            }
        }
    }

    @Then("^I click on (\\w+).(\\w+) action icon and check the landing page or pop up$")
    public static void clickOnActionIconInTheTableAndCheckTheLandingPage(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(), "The element " + fieldName + " is not present in the page " + className);
        switch (fieldName) {
            case "iconDocumentFirstRow":
                DeviceAlarmsConfigurationPage.getIconDocumentFirstRow().click();
                Assert.assertTrue(DeviceAlarmsConfigurationPage.getTitleDeviceConfigurationDetailPage().isVisible(), "Device configuration Detail page not present");
                DeviceAlarmsConfigurationPage.getBackBTN().click();
                break;
            case "iconPencilFirstRow":
                DeviceAlarmsConfigurationPage.getIconPencilFirstRow().click();
                Assert.assertTrue(DeviceAlarmsConfigurationPage.getTitleDeviceConfigurationEditPage().isVisible(), "Device configuration Edit page not present");
                //DeviceAlarmsConfigurationPage.getTitleDeviceConfigurationEditPage().click();
                //DeviceAlarmsConfigurationPage.getBackBTN().click();
                break;
            case "iconTrashFirstRow":
                DeviceAlarmsConfigurationPage.getIconTrashFirstRow().click();
                Assert.assertTrue(DeviceAlarmsConfigurationPage.getTitlePopUpdeleteItem().isVisible(), "Delete pop up not present");
                ProjectPage.getLogoEnel().isVisible();
                DeviceAlarmsConfigurationPage.getBackBTN().isVisible();
                DeviceAlarmsConfigurationPage.getCancelButton().click();
                break;
            default:
        }
    }

    @Then("I check that the Device Configuration Alarm Page is correctly translated")
    public static void checkTranslationDeviceConfAlarmPage() throws IOException {
        /*check elements in page - Title and columns */
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getDeviceAlarmsConfigurationPageTitleIT().isPresent(), "Title page not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getOrigineAllarmeCol().isPresent(), "origine allarme column not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getBusinessCol().isPresent(), "business column not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getDisservizioDiffusoCol().isPresent(), "disservizio diffuso column not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getSogliaminimaCol().isPresent(), "soglia minima column not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getSogliaMassimaCol().isPresent(), "soglia massima column not found");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getRegoleTelemetricheCol().isPresent(), "regole telemetriche column not found");

        /*check all pop up*/
        List<WebElement> wels = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getInfoIcons().getBy());
        PageElement pe;
        WebElement el = null;
        List<WebElement> elements = null;

        for (int i = 1; i <= wels.size(); i++) {
            pe = new PageElement("info icon " + i, By.xpath("(//i[@dmcicon='info'])[" + i + "]"));
            pe.click();
            elements = CommonPage.getDriver().findElements(By.xpath("//dmc-column-descriptor/p"));
            String[] tree = new String[]{"controlRoom", "e2em", "infoDialog"};
            switch (i) {
                case 1:
                    jsonReader(tree, "groupIdTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "groupIdDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;
                case 2:
                    jsonReader(tree, "businessConfigTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "businessConfigDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;

                case 3:
                    jsonReader(tree, "disserviceConfigTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "disserviceConfigDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;
                case 4:
                    jsonReader(tree, "lowerMessageRateConfigTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "lowerMessageRateConfigDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;
                case 5:
                    jsonReader(tree, "higherMessageRateConfigTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "higherMessageRateConfigDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;
                case 6:
                    jsonReader(tree, "telemetryRulesConfigTitle", DeviceAlarmsConfigurationPage.getPopUpTitleInfoDialog().getText().toLowerCase(), null);
                    for (int j = 0; j < elements.size(); j++) {
                        jsonReader(tree, "telemetryRulesConfigDescription" + (j + 1), null, elements);
                    }
                    DeviceAlarmsConfigurationPage.getCloseBtnPopUpIT().click();
                    break;
                default:
            }
        }
    }


    @Then("check if AddThreshold Button is not present and then i click on Reset option button")
    public static void checkAddThresholdNotPresentAndClickReset() {
        if (!DeviceAlarmsConfigurationPage.getAddThresholdBTN().isPresent()) {
            Assert.assertTrue(DeviceAlarmsConfigurationPage.getVisibleResetOptionsBTN().isPresent(), "Add threshold BTN and trash not found");
            DeviceAlarmsConfigurationPage.getVisibleResetOptionsBTN().click();
        }
    }

    public static String day_from = "";
    public static String day_to = "";

    public static String getDayTo() {
        return day_to;
    }

    public static String getDayFrom() {
        return day_from;
    }

    @Then("I click on the current day")
    public void iClickOnTheCurrentDay() {
        //Metodo per prendere la data attuale e cliccare sulla dropdown corrispondente sia per FROM che per TO
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        PageElement elem1 = null;
        PageElement elem2 = null;
        switch (day) {
            case Calendar.MONDAY:
                elem1= DeviceAlarmsConfigurationPage.getMondayFromNotificationWindow();
                day_from = "MON";
                elem2= DeviceAlarmsConfigurationPage.getMondayToNotificationWindow();
                day_to = "MON";
                break;
            case Calendar.TUESDAY:
                elem1= DeviceAlarmsConfigurationPage.getTuesdayFromNotificationWindow();
                day_from = "TUE";
                elem2= DeviceAlarmsConfigurationPage.getTuesdayToNotificationWindow();
                day_to = "TUE";
                break;
            case Calendar.WEDNESDAY:
                elem1= DeviceAlarmsConfigurationPage.getWednesdayFromNotificationWindow();
                day_from = "WED";
                elem2= DeviceAlarmsConfigurationPage.getWednesdayToNotificationWindow();
                day_to = "WED";
                break;
            case Calendar.THURSDAY:
                elem1= DeviceAlarmsConfigurationPage.getThursdayFromNotificationWindow();
                day_from = "THU";
                elem2= DeviceAlarmsConfigurationPage.getThursdayToNotificationWindow();
                day_to = "THU";
                break;
            case Calendar.FRIDAY:
                elem1= DeviceAlarmsConfigurationPage.getFridayFromNotificationWindow();
                day_from = "FRI";
                elem2= DeviceAlarmsConfigurationPage.getFridayToNotificationWindow();
                day_to = "FRI";
                break;
            case Calendar.SATURDAY:
                elem1= DeviceAlarmsConfigurationPage.getSaturdayFromNotificationWindow();
                day_from = "SAT";
                elem2= DeviceAlarmsConfigurationPage.getSaturdayToNotificationWindow();
                day_to = "SAT";
                break;
            case Calendar.SUNDAY:
                elem1= DeviceAlarmsConfigurationPage.getSundayFromNotificationWindow();
                day_from = "SUN";
                elem2= DeviceAlarmsConfigurationPage.getSundayToNotificationWindow();
                day_to = "SUN";
                break;
        }

       DeviceAlarmsConfigurationPage.getDropDownFromDays().click();
       Assert.assertTrue(elem1.isPresent(), "DropDown option FROM ----- Day of the week not found");
       elem1.click();
       DeviceAlarmsConfigurationPage.getDropDownToDays().click();
        Assert.assertTrue(elem2.isPresent(), "TO Day of the week option not found");
       elem2.click();

    }

    public static String to_Hour = "";
    public static String from_Hour = "";

    public static String getTo_Hour() {
        return to_Hour;
    }

    public static String getFrom_Hour() {
        return from_Hour;
    }

    @Then("^I select the current hour window plus \"(.+)\" minutes")
    public void iSelectTheCurrentHourWindowPlusMinutes(int minutesToAdd) throws Exception {
        //When I perform a test the input entry mode is HH:MM PM/AM
        //if I type example: 14:40PM the last part doesnt work so I split the string input in HH:MM
        //and another send key for AM/PM
        Date today = getCurrentUtcTime();
        Date todayPlus = getCurrentUtcTime();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        System.out.println("Current Time: " + sdf.format(today));
        todayPlus = DateUtils.addMinutes(todayPlus, minutesToAdd);
        today = DateUtils.addMinutes(today, -5);
        System.out.println("Time after window minutes: " + sdf.format(todayPlus));
        String fromHour = sdf.format(today);
        from_Hour = fromHour;
        String toHour = sdf.format(todayPlus);
        to_Hour = toHour;
        String locator = DeviceAlarmsConfigurationPage.getFromHourNotificationWindow().getBy().toString().replace("By.xpath: ", " ").trim();
        System.out.println(locator.concat(" "+fromHour));
        PageElement fromHourNotification = UtilFunctions.createNewPageElement("from hour input box", locator);
        Assert.assertTrue(fromHourNotification.fillText(fromHour, true, 1000));
        String  locator1 = DeviceAlarmsConfigurationPage.getToHourNotificationWindow().getBy().toString().replace("By.xpath: ", " ").trim();
        System.out.println(locator1.concat(" "+toHour));
        PageElement toHourNotification = UtilFunctions.createNewPageElement("to hour input box", locator1);
        Assert.assertTrue(toHourNotification.fillText(toHour, true, 1000, true));
    }

    @Then("I count all the alarms present into the page")
    public static void retrieveAllAlarmsçPresent(){
        CommonSteps.waitProgressBar();
        setNumOfAlarms(CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllAlarms().getBy()).size());
        System.out.println(getNumOfAlarms());
    }

   public static void createExampleAlarm() {
        //Create basic allarm - with first device group
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardBTN().tryClick(), "Unable to click on WizardBTN");
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getMonitorDevicesRadioBTN().tryClick(), "Unable to click on MonitorDevicesRadioBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardNextBTN().tryClick(), "Unable to click on WizardNextBTN after MonitorDevicesRadioBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getConfigureNewAlarmRadioBTN().tryClick(), "Unable to click on ConfigureNewAlarmRadioBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardNextBTN().tryClick(), "Unable to click on WizardNextBTN after ConfigureNewAlarmRadioBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getTelemetryOfThresholdAlarmRadioBTN().tryClick(), "Unable to click on TelemetryOfThresholdAlarmRadioBTN");
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardNextBTN().tryClick(), "Unable to click on WizardNextBTN after TelemetryOfThresholdAlarmRadioBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getDropDownArrowTAB().tryClick(), "Unable to click on DropDownArrowTAB for GroupDeviceOptionToSelect" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getGroupDeviceOptionToSelect().tryClick(), "Unable to click on GroupDeviceOptionToSelect " );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getSelectionBoxDevicesGroup().tryClick(), "Unable to click on SelectionBoxDevicesGroup" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getFirstDeviceGroupOption().tryClick(), "Unable to click on FirstDeviceGroupOption" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getAddThresholdBTN().tryClick(), "Unable to click on AddThresholdBTN" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getNumberOfMessagesToWrite().fillText("3"), "Unable to click on NumberOfMessagesToWrite" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getDropDownArrowTAB().tryClick(), "Unable to click on DropDownArrowTAB" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getThreeHundredsecondsTimeSelectionLowThreshold().tryClick(), "Unable to click on ThreeHundredsecondsTimeSelectionLowThreshold" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab after LowThreshold" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getAddThresholdBTN().tryClick(), "Unable to click on AddThresholdBTN after LowThreshold" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getVisibleNumberOfMessage().fillText("5"), "Unable to click on VisibleNumberOfMessage" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getDropDownArrowTAB().tryClick(), "Unable to click on DropDownArrowTAB" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getThreeHundredsecondsTimeSelectionHighThreshold().tryClick(), "Unable to click on ThreeHundredsecondsTimeSelectionHighThreshold " );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab" );
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab");
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab");
       Assert.assertTrue(DeviceAlarmsConfigurationPage.getExitBTN().tryClick(), "Unable to click on ExitBTN");

   }

    @Then("If there is not at least one alarm I create one")
    public void ifThereIsNotAtLeastOneAlarmIconsICreateOne() {
        List<WebElement> els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
        if (els.size() == 0 ){
            setCreatedAlarm(true);
            createExampleAlarm();
        }
    }

    @Then("If I created an Alarm I delete it")
    public void ifICreatedAnAlarmIDeleteIt() {
        if (isCreatedAlarm()) {
            DeviceAlarmsConfigurationPage.getIconTrashFirstRow().click();
            DeviceAlarmsConfigurationPage.getDeleteButton().click();
        }
    }

    @And("^I type the number \"(.+)\" into the element (\\w+).(\\w+)$")
    public void iTypeTheNumberIntoTheElementDeviceAlarmsConfigurationPagePhoneNumberToInsertBox(String number, String className, String fieldName) throws Exception {

        setNumberPhone(number);
        CommonSteps.typeStringIntoElement(number, className, fieldName);
    }

    public static void main(String[] args) throws Exception {
        int minutesToAdd=10;
        Date today = getCurrentUtcTime();
        Date todayPlus = getCurrentUtcTime();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        System.out.println("Current Time: " + sdf.format(today));
        todayPlus = DateUtils.addMinutes(todayPlus, minutesToAdd);
        System.out.println("Time after window minutes: " + sdf.format(todayPlus));
        String fromHour = sdf.format(today);
        from_Hour = fromHour;
        String toHour = sdf.format(todayPlus);
        to_Hour = toHour;
    }

    public static Date getCurrentUtcTime() throws Exception {  // handling ParseException
        // create an instance of the SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        // set UTC time zone by using SimpleDateFormat class
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //create another instance of the SimpleDateFormat class for local date format
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        // declare and initialize a date variable which we return to the main method
        Date d1 = null;
        // use try catch block to parse date in UTC time zone
        try {
            // parsing date using SimpleDateFormat class
            d1 = ldf.parse( sdf.format(new Date()) );
        }
        // catch block for handling ParseException
        catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        // pass UTC date to main method.
        return d1;
    }
}

