package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.formatters.ReportFormatter;
import ta.utilities.ReflectionUtils;
import test.pages.DeviceAlarmsConfigurationPage;
import test.pages.NotificationsConfigurationsPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class NotificationsConfigurationsSteps {

    private static boolean createdNotification = false;

    public static boolean isCreatedNotification() {
        return createdNotification;
    }
    public static void setCreatedNotification(boolean createdNotification) {
        NotificationsConfigurationsSteps.createdNotification = createdNotification;
    }

    private static int numOfNotification;
    public static int getNumOfNotification(){
        return numOfNotification;
    }

    public static void setNumOfNotification(int totalNumberOfAlarmsPresent){
        numOfNotification = totalNumberOfAlarmsPresent;
    }

    @Then("I check that user land on  Notifications Configurations page")
    public static void checkLandInPage(){
        Assert.assertTrue(NotificationsConfigurationsPage.getNotificationsConfigurationsPageTitleENG().isVisible(), "Notifications Configurations page not found!");
    }

    @Then("^I click on (\\w+).(\\w+) action icon and check the landing page or pop up - Notification Page$")
    public static void clickOnActionIconInTheTableAndCheckTheLandingPage(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(), "The element " + fieldName + " is not present in the page " + className);
        switch (fieldName){
            case "iconDocumentFirstRow":
                NotificationsConfigurationsPage.getIconDocumentFirstRow().click();
                Assert.assertTrue(NotificationsConfigurationsPage.getTitleNotificationsConfigurationDetailPage().isPresent(10), "Device configuration Detail page not present");
                NotificationsConfigurationsPage.getBackBTN().click();
                break;
            case "iconPencilFirstRow":
                NotificationsConfigurationsPage.getIconPencilFirstRow().click();
                Assert.assertTrue(NotificationsConfigurationsPage.getTitleNotificationsConfigurationEditPage().isPresent(), "Device configuration Edit page not present");
                NotificationsConfigurationsPage.getBackBTN().click();
                break;
            case "iconBellFirstRow":
                NotificationsConfigurationsPage.getIconBellFirstRow().click();
                Assert.assertTrue(NotificationsConfigurationsPage.getTitleNotificationsConfigurationSubscriptionsPage().isPresent(), "Subscribe pop up not present");
                NotificationsConfigurationsPage.getBackBTN().click();
                break;
            case "iconTrashFirstRow":
                NotificationsConfigurationsPage.getIconTrashFirstRow().click();
                Assert.assertTrue(NotificationsConfigurationsPage.getTitlePopUpRemoveItem().isPresent(), "Delete pop up not present");
                NotificationsConfigurationsPage.getCancelButton().click();
                break;
            default:
        }

    }

    @Then("I check that the Notification page is translated in ITALIANO")
    public static void checkTranslation() throws IOException {
        String [] tree  = new String[]{"controlRoom", "e2em"};
        CommonSteps.jsonReader(tree, "notificationsConfigurations",NotificationsConfigurationsPage.getNotificationsConfigurationsPageTitle().getText(),null);
        CommonSteps.jsonReader(tree, "alarmTarget", CommonPage.getDriver().findElement(By.xpath("//th[1]")).getText(),null);
        CommonSteps.jsonReader(tree, "scopeTarget", CommonPage.getDriver().findElement(By.xpath("//th[2]")).getText(),null);
        CommonSteps.jsonReader(tree, "scopeType", CommonPage.getDriver().findElement(By.xpath("//th[3]")).getText(),null);
        CommonSteps.jsonReader(tree, "notificationsSchedule", CommonPage.getDriver().findElement(By.xpath("//th[4]")).getText(),null);
        CommonSteps.jsonReader(tree, "notificationsSubscriptions", CommonPage.getDriver().findElement(By.xpath("//th[5]")).getText(),null);
    }

    @Then("I count all the Notifications are present into the page")
    public static void retrieveAllAlarmsçPresent(){
        CommonSteps.waitProgressBar();
        setNumOfNotification(CommonPage.getDriver().findElements(NotificationsConfigurationsPage.getAllNotifications().getBy()).size());
        System.out.println(getNumOfNotification());
    }

    public static void createExempleNotificationRow() {
        CommonSteps.waitProgressBar();
        //I create the basic notification----> cloud component
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardBTN().tryClick(), "Unable to click on WizardBTN ");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getMonitorCloudComponentRadioBTN().tryClick(), "Unable to click on MonitorCloudComponentRadioBTN ");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardNextBTN().tryClick(), "Unable to click on WizardNextBTN after Monitor component");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getMicroserviceDropDownBTN().tryClick(), "Unable to click on MicroserviceDropDownBTN");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getCommandtoOption().tryClick(), "Unable to click on CommandtoOption ");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab" );
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getDropDownArrowTAB().tryClick(), "Unable to click on DropDownArrowTAB");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getContinuousOption().tryClick(), "Unable to click on ContinuousOption");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab()");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getButtonNextStepsTab().tryClick(), "Unable to click on ButtonNextStepsTab()");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getWizardSaveBTN().tryClick(), "Unable to click on  WizardSaveBTN ");
        Assert.assertTrue(DeviceAlarmsConfigurationPage.getExitBTN().tryClick(), "Unable to click on ExitBTN ");

    }

    @Then("I check that the refresh button works properly in Notifications Configurations")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        boolean createdNotification = false;
        CommonSteps.waitProgressBar();
        List<WebElement> els = CommonPage.getDriver().findElements(NotificationsConfigurationsPage.getAllCellOfFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();

        if (els.size() == 0 ){
            createdNotification= true;
            createExempleNotificationRow();
            CommonSteps.waitProgressBar();
            els = CommonPage.getDriver().findElements(NotificationsConfigurationsPage.getAllCellOfFirstRow().getBy());

        }

        for (WebElement we : els) {
            origin.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
            Thread.sleep(500);
        }
        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(5000);
        DeviceAlarmsConfigurationPage.getRefreeshBTN().click();
        CommonSteps.waitProgressBar(5);
        Assert.assertTrue(NotificationsConfigurationsPage.getAllCellOfFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        Thread.sleep(5000);
        els = CommonPage.getDriver().findElements(NotificationsConfigurationsPage.getAllCellOfFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin.size(), updated.size(), "The values retrieved after refresh are different from the expected");

        if(createdNotification){
            CommonSteps.waitProgressBar();
            Assert.assertTrue(NotificationsConfigurationsPage.getDeleteCommandtoNotification().tryClick(), "Error while deleting alarm");
            Assert.assertTrue(NotificationsConfigurationsPage.getConfirmDeleteButton().tryClick(), "Error while deleting alarm");

        }

    }

    @Then("If there is not at least one notification I create one")
    public void ifThereIsNotAtLeastOneNotificationICreateOne() {
        List<WebElement> els = CommonPage.getDriver().findElements(NotificationsConfigurationsPage.getAllCellOfFirstRow().getBy());
        if (els.size() == 0 ){
            setCreatedNotification(true);
            createExempleNotificationRow();
        }

    }

    @Then("If I created a notification I delete it")
    public void ifICreatedAnAlarmIDeleteIt() {
        if (isCreatedNotification()) {
            NotificationsConfigurationsPage.getIconTrashFirstRow().click();
            NotificationsConfigurationsPage.getConfirmDeleteButton().click();
        }
    }
}


