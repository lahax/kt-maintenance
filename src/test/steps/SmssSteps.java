package test.steps;

import Util.Mailinator;
import Util.SmssReceiver;
import Util.UtilFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.DeploymentHistoryDeviceDetailsPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SmssSteps {

    private static String telephoneNumber;

    public static String getTelephoneNumber() {
        return telephoneNumber;
    }

    public static void setTelephoneNumber(String telephoneNumber) {
        SmssSteps.telephoneNumber = telephoneNumber;
    }

    @Then("I save telephone number")
    public static void saveTelephoneNumber() throws Exception {
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()"); //Create new tab
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://receive-smss.com/");
        List<WebElement> numbersList = CommonPage.getDriver().findElements(SmssReceiver.getSpainNumberList().getBy());
        setTelephoneNumber(numbersList.get(0).getText());
        numbersList.get(0).click();

        //grabbo tutti tutti gli iframe e ottengo una lista
        //per ogni iframe switcho e cerco se all'interno c'è un elemento con id ='dismiss-button'
        //se presente allora resto su quel frame e clicco il button
        // dopodiché switcho di nuovo al frame padre Utilizzando:
        //CommonPage.getDriver().switchTo().parentFrame();
        List<WebElement> wes = CommonPage.getDriver().findElements(By.xpath("//iframe"));
        if (wes != null && !wes.isEmpty()) {
            for (int i = 0; i < wes.size(); i++) {
                CommonPage.getDriver().switchTo().frame(wes.get(i));
                Thread.sleep(2000);
                try {
                    WebElement dismissBTN = CommonPage.getDriver().findElement(By.xpath("//*[@id='dismiss-button']"));
                    Thread.sleep(2000);
                    if (dismissBTN.isDisplayed()) {
                        dismissBTN.click();
                    }
                } catch (Exception e) {
                    System.out.println("no frame element found!");
                }
                wes = CommonPage.getDriver().findElements(By.xpath("//iframe"));
            }
            CommonPage.getDriver().switchTo().parentFrame();
        }
        CommonPage.getDriver().switchTo().window(tabs.get(0)); //return to DMC
    }


    @And("^I type the telephone number saved into the element (\\w+).(\\w+)$")
    public void iTypeTheNumberIntoTheElement(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(getTelephoneNumber());

    }

    @Then("I check text {string} is in sms boxes body")
    public static void checkTheSMSBoxMessages(String messageToCheck) throws  IOException {
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)).navigate().refresh();

        if (SmssReceiver.getSenderSMSEnelE2E().isPresent(180)) {
            Assert.assertTrue(SmssReceiver.getSenderSMSEnelE2E().scrollTo(), "Unable to scroll to ENELE2E message");
            UtilFunctions.addScreenshot("check the last sms");
            Assert.assertTrue(SmssReceiver.getE2E_MonitoringInSMSBody().isPresent(20), "String E2E_Monitoring not present in the message");
            Assert.assertTrue(SmssReceiver.getTargetApmSMSBody().isPresent(20), "Target apm is not esol-ap29551-qa");
            Assert.assertTrue(SmssReceiver.getBodyMessage().getText().contains(messageToCheck), messageToCheck+ " notification is not present in the body");
        } else {
            Assert.fail("No sms received in 3 minutes");
        }
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen

    }
}
