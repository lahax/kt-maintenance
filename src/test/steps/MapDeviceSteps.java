package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.Configuration;
import test.pages.DevicesMapPage;

import java.io.IOException;

public class MapDeviceSteps {

    @Then("^I check that the Zoom \"(In|Out)\" button works correctly$")
    public static void checkZoomInButtonWorks(String type) throws InterruptedException {
        Thread.sleep(1000);
        String zoomString = DevicesMapPage.getZoomLabelMap().getText();
        String[] zoomLevel = zoomString.split(" ");
        int originalZoom = Integer.parseInt(zoomLevel[1]);
        if(type.equalsIgnoreCase("in")){
            DevicesMapPage.getZoomInButton().scrollTo();
            Assert.assertTrue(DevicesMapPage.getZoomInButton().tryClick(), "Unable to click on Zoom In button");
            Thread.sleep(1000);
            Assert.assertTrue(DevicesMapPage.getZoomInButton().tryClick(), "Unable to click on Zoom In button");
        }else if(type.equalsIgnoreCase("out")) {
            DevicesMapPage.getZoomOutButton().scrollTo();
            Assert.assertTrue(DevicesMapPage.getZoomOutButton().tryClick(), "Unable to click on Zoom out button");
            Thread.sleep(1000);
            Assert.assertTrue(DevicesMapPage.getZoomOutButton().tryClick(), "Unable to click on Zoom out button");
        } else{
            Assert.fail("option not valid. Only In or Out Options are valid");
        }

        zoomString = DevicesMapPage.getZoomLabelMap().getText();
        zoomLevel = zoomString.split(" ");
        int newZoom = Integer.parseInt(zoomLevel[1]);

        if(type.equalsIgnoreCase("in")){
            Assert.assertTrue(newZoom > originalZoom, "The zoom in button do not work");
        }else{
            Assert.assertTrue(originalZoom > newZoom, "The zoom out button do not work");
        }

    }

    @Then("I check that the button fullScreen work properly")
    public static void checkTheFullScreenButton() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(DevicesMapPage.getMapSizeDiv().isPresent(), "Unable to find the div container of the map");
        WebElement divMap = CommonPage.getDriver().findElement(DevicesMapPage.getMapSizeDiv().getBy());
        int originalWidth = divMap.getRect().width;
        int originalHeight = divMap.getRect().height;

        Assert.assertTrue(DevicesMapPage.getFullscreenButton().tryClick(), "Unable to click on FullScreen button");
        Thread.sleep(1000);
        UtilFunctions.addScreenshot("full screen");
        divMap = CommonPage.getDriver().findElement(DevicesMapPage.getMapSizeDiv().getBy());
        int newWidth = divMap.getRect().width;
        int newHeight = divMap.getRect().height;
        Assert.assertTrue((newHeight > originalHeight)&&(newWidth > originalWidth ), "The fullscreen button do not work properly");
        Thread.sleep(1000);
        Assert.assertTrue(DevicesMapPage.getFullscreenButton().tryClick(), "Unable to click on FullScreen button");
        divMap = CommonPage.getDriver().findElement(DevicesMapPage.getMapSizeDiv().getBy());

        Assert.assertTrue((divMap.getRect().width < newWidth) && (divMap.getRect().height < newHeight), "The Fullscreen button reverse do not work properly") ;
    }

    @Then("I check that the refresh button into the map page works properly")
    public static void checkRefreshButtonWorks() throws InterruptedException {
        PageElement pe = UtilFunctions.createNewPageElement("Device into the map", "(//div[@role='button' and @aria-label]/img)[1]");
        Assert.assertTrue(pe.isPresent(), "Unable to grab the element into the map");

        WebElement we = CommonPage.getDriver().findElement(pe.getBy());
        String script = "arguments[0].src='https://d11wkw82a69pyn.cloudfront.net/siteassets/images/logos/companies/reply-corporate-logo.png'";
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, we);
        script = "arguments[0].style='width: 550px; height: 140px; user-select: none; border: 0px; padding: 0px; margin: 0px; max-width: none;'";
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, we);
        Thread.sleep(1000);
        UtilFunctions.addScreenshot("set a Reply Logo");
        Assert.assertTrue(DevicesMapPage.getRefreshButton().tryClick(), "Unable to click on refresh button");
        CommonSteps.waitProgressBar(5);
        we = CommonPage.getDriver().findElement(pe.getBy());
        String src = we.getAttribute("src");
        Assert.assertFalse(src.contains("reply-corporate-logo.png"), "The refresh button do not work properly");
    }

    @Then("I check that the fit bounds button works correctly")
    public static void checkFitBoundsButtonWork() throws InterruptedException {
        Thread.sleep(1000);
        PageElement pe = UtilFunctions.createNewPageElement("Device into the map", "(//div[@role='button' and @aria-label]/img)[1]");

        WebElement we = CommonPage.getDriver().findElement(pe.getBy());
        String oldStyle = we.getAttribute("style");

        Assert.assertTrue(DevicesMapPage.getFitBoundsButton().tryClick(), "Unable to click on fit bounds button");
        CommonSteps.waitProgressBar(5);
        we = CommonPage.getDriver().findElement(pe.getBy());
        String newStyle = we.getAttribute("style");

        Assert.assertNotSame(newStyle, oldStyle, "The fit Bounds button do not works properly");
    }

    @Then("I check that the Map page is correctly translated in italiano")
    public static void checkTranslationfTheMapPage() throws IOException, InterruptedException {
        Thread.sleep(1000);
        String [] tree = {"controlRoom"};
        PageElement pe = UtilFunctions.createNewPageElement("Tab Nazione", "(//div[@role='tab' and @aria-selected='true'])[2]");
        CommonSteps.jsonReader(tree,"map", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Tab Lista", "//div[@role='tab' and @aria-selected='false']");
        CommonSteps.jsonReader(tree,"list", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Label Visualizza", "//h4[contains(@class, 'info-panel-subtitle')]");
        CommonSteps.jsonReader(tree,"view", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Label Dispositivi", "//div[@class='info-panel-title']/strong");
        String text = "";
        if(pe.getText().contains(":")){
            text = pe.getText().replace(":", "");
        }
        CommonSteps.jsonReader(null,"Devices", text, null);

    }
}
