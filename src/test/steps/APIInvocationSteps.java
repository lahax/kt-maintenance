package test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import ta.utilities.StepUtils;
import test.pages.APIInvocationPage;
import ta.entities.Util;
import Util.UtilFunctions;
import test.pages.DeploymentsHistoryPage;
import test.pages.LambdasPage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class APIInvocationSteps {

    @Then("select base, method {string} and fill URL with {string}")
    public void selectBaseMethodAndFillURLWith(String method, String url) {
        Assert.assertTrue(APIInvocationPage.getBaseInput().tryClick());
        Assert.assertTrue(APIInvocationPage.getBaseOption().tryClick());
        Assert.assertTrue(APIInvocationPage.getMethodInput().tryClick());
        List<WebElement> methodOptions = CommonPage.getDriver().findElements(APIInvocationPage.getMethodOption().getBy());
        boolean elementFound = false;
        for (int i = 0; i < methodOptions.size(); i++) {
            if (methodOptions.get(i).getText().contains(method)) {
                methodOptions.get(i).click();
                elementFound = true;
            }
        }
        if (!elementFound) {
            Assert.fail(method + " not displayed.");
        }

        Assert.assertTrue(APIInvocationPage.getURLInput().fillText(url));
        //Assert.assertTrue(APIInvocationPage.getInvokeButtonEnabled().tryClick());
    }

    @And("I check the network tab for {string}")
    public void iCheckTheNetworkTabFor(String param) {
        String scriptToExecute =
                "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        String netData = ((JavascriptExecutor) CommonPage.getDriver()).executeScript(scriptToExecute).toString();
        System.out.println(netData);
        Util.Wait(1000);
        Assert.assertTrue(netData.toLowerCase().contains(param.toLowerCase()));
    }

    @And("base options DDM should contains these elements")
    public void baseOptionsDDMShouldContainsTheseElements(List elements) throws Exception {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(CommonPage.getDriver().findElements(APIInvocationPage.getBaseOptions().getBy()).get(i).getText(), elements.get(i), elements.get(i) + " not found.");
        }
    }

    @And("I insert \"(.+)\" in (\\w+).(\\w+)$")
    public static void fillInputBox(String value, String className, String fieldName) throws Exception {
        String finalValue = StepUtils.findFunctionAndReplace(value);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Point location = CommonPage.getDriver().findElement(elem.getCustomBy().getBy()).getLocation();
        StringSelection stringSelection = new StringSelection(finalValue);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.mouseMove(location.getX(), location.getY());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

//        while (!elem.getText().equals(finalValue)) {
//            try {
//                js.executeScript("document.evaluate(\"" + elem.getCustomBy().getByString() +"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerHTML = \""+ finalValue+ "\"");
//                CommonPage.getDriver().findElement(By.xpath("//ace-editor//div[@class='ace_content']")).click();
//                CommonPage.getDriver().findElement(By.xpath("//ace-editor//div[@class='ace_line']")).click();
//            } catch (Exception e) {
//                System.out.println("va avanti");
//            }
//        }
        //js.executeScript("arguments[0].innerHTML=\""+ finalValue+ "\"", CommonPage.getDriver().findElement(elem.getCustomBy().getBy()));
    }

    @And("I verify the response displayed")
    public void iVerifyTheResponseDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> sectionKeys = CommonPage.getDriver().findElements(LambdasPage.getSectionSegmentKey().getBy());
        List<WebElement> sectionValues = CommonPage.getDriver().findElements(LambdasPage.getSectionSegmentValue().getBy());
        Assert.assertEquals(sectionKeys.get(0).getText(), "gateways");
        Assert.assertEquals(sectionKeys.get(1).getText(), "0");
        Assert.assertEquals(sectionKeys.get(2).getText(), "gateway_id");
        Assert.assertNotNull(sectionValues.get(2).getText());
        Assert.assertEquals(sectionKeys.get(3).getText(), "gateway_attributes");
        Assert.assertEquals(sectionKeys.get(4).getText(), "device_id");
        Assert.assertNotNull(sectionValues.get(4).getText());
        Assert.assertEquals(sectionKeys.get(5).getText(), "device_type");
        Assert.assertNotNull(sectionValues.get(5).getText());
        Assert.assertEquals(sectionKeys.get(6).getText(), "environment_prefix");
        Assert.assertNotNull(sectionValues.get(6).getText());
        Assert.assertEquals(sectionKeys.get(7).getText(), "gateway_type");
        Assert.assertNotNull(sectionValues.get(7).getText());
        Assert.assertEquals(sectionKeys.get(8).getText(), "geolocalization");
        Assert.assertNotNull(sectionValues.get(8).getText());
    }

    @Then("I wait that the progress bar into the button invoke disappear")
    public static void disappearProgressBar(){
        PageElement pe = UtilFunctions.createNewPageElement("progress bar into the button invoke", "//i[contains(@class, 'fa-circle-o-notch')]");
        Assert.assertTrue(pe.isInvisible(60), "The progress bar into the button is still present after 60 sec");
    }
    @Then("I check that the API Invocation page is correctly translated in italian")
    public static void checkTranslationStepFunctionPage() throws IOException {
        String [] tree = new String[]{"controlRoom"};
        String [] tree_multiSelect = new String[]{"components", "multiSelect"};
        String [] tree_select = new String[]{"components", "select"};
        String [] tree_postman = new String[]{"postman"};

        CommonSteps.jsonReader(tree,"diagnostic", UtilFunctions.createNewPageElement("landing page title", "//h6[contains(.,'Diagnostica')]").getText().trim().replace("/",""), null );
        CommonSteps.jsonReader(tree,"apiInvocation", UtilFunctions.createNewPageElement("landing page title", "//h2[contains(.,'Invocazione API')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_select,"defaultLabel", UtilFunctions.createNewPageElement("select options", "//dmc-form-field-label[contains(.,'BASE')]/following-sibling::dmc-select/div//div[@class='-input' and contains(.,'Seleziona opzione...')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_select,"defaultLabel", UtilFunctions.createNewPageElement("select options", "//dmc-form-field-label[contains(.,'METODO')]/following-sibling::dmc-select/div//div[@class='-input' and contains(.,'Seleziona opzione...')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_postman,"invoke", UtilFunctions.createNewPageElement("invoke btn", "//div/button[contains (.,' Invoca ')]").getText().trim(), null );
        APIInvocationPage.getInvocaBTNitaliano().scrollTo();
    }

}
