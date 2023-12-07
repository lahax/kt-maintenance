package test.steps;

import Util.UtilFunctions;
import com.amazonaws.services.dynamodbv2.xspec.S;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.pages.CampaignManagementView;
import test.pages.DeviceAlarmsConfigurationPage;
import test.pages.DevicesDetailsPage;
import test.pages.SearchingFilterDeploymentHistoryDeviceDetailsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DeploymentHistoryDeviceDetailsSteps {

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        DeploymentHistoryDeviceDetailsSteps.rows = rows;
    }

    private static int rows = 0;


    @Then("^I check the presence of the label \"(.+)\" of \"(.+)\" section$")
    public static void getLabel(String labelToFind, String section) {
        String locator = String.format("("+SearchingFilterDeploymentHistoryDeviceDetailsPage.label+")[%s]", labelToFind, getIndex(section));
        PageElement pe = UtilFunctions.createNewPageElement("label " + labelToFind, locator);
        Assert.assertTrue(pe.scrollTo(), "Unable to find the label " + labelToFind);
        Assert.assertTrue(pe.isPresent(), "Unable to find the label " + labelToFind);
    }

    @Then("I check the presence of the dropdown \"(.+)\" of \"(.+)\" section")
    public static void getDropdown(String labelToFind, String section) {
        String locator = String.format("("+SearchingFilterDeploymentHistoryDeviceDetailsPage.dropdown+"/dmc-dummy-input/div[contains(., '%s')]/parent::dmc-dummy-input)[%s]",labelToFind, getIndex(section));
        PageElement pe = UtilFunctions.createNewPageElement("label " + labelToFind, locator);
        Assert.assertTrue(pe.scrollTo(), "Unable to find the label " + labelToFind);
        Assert.assertTrue(pe.isPresent(), "Unable to find the label " + labelToFind);
    }

    public static String getIndex(String section){
        String index = "";
        switch (section){
            case "package to install":
            case "generic":
                index = "1";
                break;
            case "current stack":
                index = "2";
                break;
            default:
                Assert.fail("No valid option");
        }
        return index;
    }

    @Then("I check the presence of package to install with the name \"(.+)\" and version \"(.+)\"")
    public static void checkPackageToInstall(String name, String version){
        String nameVersion = name + " v" + version;
        String locator = "(//div[@class = 'ng-star-inserted']//span[contains(., '" + nameVersion + "')])[1]";
        PageElement pe = UtilFunctions.createNewPageElement("app :"+name+" and version :"+version+" to install ", locator);
        Assert.assertTrue(pe.isPresent(), "unable to find app and version element");
    }

    @Then("I check that the refresh button works properly in Deployments History Details")
    public static void checkRefreshButtonWorkProperlyInDeplyments() throws InterruptedException {
        List<WebElement> els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();

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
        CommonSteps.waitProgressBar();
//      Assert.assertTrue(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrived after refresh are different from the expected");
    }

    @Then("I count all the entries")
    public static void countAllTheEntries(){
        CommonSteps.waitProgressBar();
        List<WebElement> we = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(we!=null && !we.isEmpty()){
            setRows(we.size());
        }
    }

    @Then("I check the filtered entries")
    public static void checkFilteredEntries() throws InterruptedException {
        CommonSteps.waitProgressBar();
        List<WebElement> entries = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if(getRows() > 0){
            Assert.assertTrue(entries.size() > 0, "Unable to retrieve entries");
        }else{
            Assert.assertEquals(0, entries.size(), "The entries retrieved are different from 0");
        }
    }

    @Then("I check for presence of all details fields")
    public static void checkFields(){
        String[] fields = {"Latest","Deploy Type","Software Type","Device ID","Duration","Environment Prefix"};
        for(String fd: fields){
            PageElement fld = UtilFunctions.createNewPageElement("","//div[@class='-info-item__label' and contains(.,'" + fd +"')]");
            String fdlc = fd.toUpperCase();
            Assert.assertEquals(fld.getText(), fdlc);
        }
    }

    @Then("I check information in Deployment Details tab \"(.+)\" tooltip")
    public static void DDtooltip(String tooltipname){
        switch (tooltipname){
            case "Custom Status":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Custom Status')]");
                Assert.assertEquals(Title.getText(), "Custom Status");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='ng-star-inserted']");
                Assert.assertEquals(txt.getText(), "This is a custom value provided by the user while editing the deployment history status");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Packages Installations Outcome":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Packages Installations Outcome')]");
                Assert.assertEquals(Title.getText(), "Packages Installations Outcome");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//p[@class='text-secondary']");
                Assert.assertEquals(txt.getText(), "This field value is provided by the device.");
                PageElement icon = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='check-circle-filled']");
                PageElement icontxt = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Completed')]");
                Assert.assertTrue(icon.isPresent());
                Assert.assertEquals(icontxt.getText(), "Completed");
                PageElement icon1 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='cross-circle-filled']");
                PageElement icontxt1 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Failed')]");
                Assert.assertTrue(icon1.isPresent());
                Assert.assertEquals(icontxt1.getText(), "Failed");
                PageElement icon2 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='clock-alert']");
                PageElement icontxt2 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'Timeout')]");
                Assert.assertTrue(icon2.isPresent());
                Assert.assertEquals(icontxt2.getText(), "Timeout");
                PageElement icon3 = UtilFunctions.createNewPageElement("icon", "//i[@dmcicon='clock']");
                PageElement icontxt3 = UtilFunctions.createNewPageElement("icon txt", "//li[contains(.,'In Progress')]");
                Assert.assertTrue(icon3.isPresent());
                Assert.assertEquals(icontxt3.getText(), "In Progress");
                PageElement txt1 = UtilFunctions.createNewPageElement("text on tooltip", "//li[@class='-outcome']");
                Assert.assertEquals(txt1.getText(), "N/A (Not applicable)");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
            case "Current Stack":{
                PageElement Title = UtilFunctions.createNewPageElement("Title of tooltip", "//H4[contains(.,'Current Stack')]");
                Assert.assertEquals(Title.getText(), "Current Stack");
                PageElement txt = UtilFunctions.createNewPageElement("text on tooltip", "//li[@class='text-secondary']");
                Assert.assertEquals(txt.getText(), "This field value is provided by the device.");
                PageElement txt1 = UtilFunctions.createNewPageElement("text on tooltip", "//li[contains(.,'current')]");
                Assert.assertEquals(txt1.getText(), "The current software stack that has been installed on the device after the execution of the upgrade command.");
                DevicesDetailsPage.getCloseTPbtt().click();
                break;
            }
        }
    }
    @Then("I check for info icon others than expected")
    public static void infoIconMore(){
        List<WebElement> ls = CommonPage.getDriver().findElements(By.xpath("//div[@class='-info-item__label d-flex align-items-center']"));
        for(WebElement li: ls){
            System.out.println(li.getText());
            if(!(li.getText().equals("PACKAGES INSTALLATIONS OUTCOME")||li.getText().equals("CURRENT STACK"))){
                Assert.assertEquals(li.getText(),"PACKAGES INSTALLATIONS OUTCOME or CURRENT STACK");
            }
        }
        List<WebElement> ls1 = CommonPage.getDriver().findElements(By.xpath("//div[@class='-info-item__label']"));
        for(WebElement li: ls1){
                String nm = li.getText().substring(0,3);
                nm = nm.substring(0, 1).toUpperCase() + nm.substring(1).toLowerCase();
                //System.out.println(nm);
                if(!(li.getText().equals("CUSTOM STATUS"))) {
                    boolean lp = CommonPage.getDriver().findElements(By.xpath("//div[@class='-info-item__label' and contains(.,'" + nm + "')]/i")).isEmpty();
                    if (!lp) {
                        System.out.println("Unexpected tooltip: " + li.getText());
                    }
                }
                else{
                    System.out.println(li.getText());
                }

        }
    }


}
