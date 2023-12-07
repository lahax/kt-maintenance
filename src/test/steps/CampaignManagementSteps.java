package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CampaignManagementSteps {

    @Then("I check that the Campaign Management Page is correctly translated in italiano")
    public static void checkTranslationCampaignManagementPage() throws IOException, InterruptedException {

        String tree[] = new String[]{"controlRoom", "swManager"};
        PageElement pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div[@class='mat-tab-label-content' and contains(., 'Campagne Gateway')]");
        CommonSteps.jsonReader(tree,"gatewaysCampaign", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div[@class='mat-tab-label-content' and contains(., 'Campagne Direct Things')]");
        CommonSteps.jsonReader(tree,"directThingsCampaign", pe.getText(), null);

        tree= new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]");
        CommonSteps.jsonReader(tree,"searchFilters", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]");
        CommonSteps.jsonReader(tree,"customQuery", pe.getText(), null);

        pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div/i[contains(@class, 'dmc-icon__chevron-down')]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on cevron icon in order to open the filter box");

        pe = UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]");
        CommonSteps.jsonReader(tree, "filters", pe.getText().trim(), null);

        tree = new String[]{"components", "select"};
        pe = UtilFunctions.createNewPageElement("dropdown Software gateway","//*[@class='-input' and contains(.,'Seleziona opzione')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);

        String locator = String.format("//form//button[contains(text(), '%s')]", "Pulisci");
        pe = UtilFunctions.createNewPageElement("Button Pulisci", locator);
        CommonSteps.jsonReader(null, "Reset", pe.getText().trim(),null);
        locator = String.format("//form//button[contains(text(), '%s')]", "Conferma ");
        pe = UtilFunctions.createNewPageElement("Button Conferma", locator);
        CommonSteps.jsonReader(null, "Confirm", pe.getText().trim(),null);

        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]");
        CommonSteps.jsonReader(tree,"customQuery", pe.getText(), null);

        Assert.assertTrue(pe.tryClick(), "Unable to click on Tab Query Manuale");

        pe = UtilFunctions.createNewPageElement("title Query Manuale", "//h2[contains(.,'Query manuale')]");
        CommonSteps.jsonReader(tree, "customQuery", pe.getText().trim(), null);

        pe = UtilFunctions.createNewPageElement("Tab Campagne Direct Things","//div[@class='mat-tab-label-content' and contains(., 'Campagne Direct Things')]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on the Tab Campagne Direct Things");
        tree = new String[]{"controlRoom", "swManager"};
        Thread.sleep(1000);
        pe = UtilFunctions.createNewPageElement("Title Campagne Direct Things","//h2[contains(., 'Campagne Direct Things')]");
        CommonSteps.jsonReader(tree,"directThingsCampaign", pe.getText(), null);

        tree= new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]");
        CommonSteps.jsonReader(tree,"searchFilters", pe.getText(), null);
        pe = UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]");
        CommonSteps.jsonReader(tree,"customQuery", pe.getText(), null);

        pe = UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div/i[contains(@class, 'dmc-icon__chevron-down')]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on cevron icon in order to open the filter box");

        pe = UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]");
        CommonSteps.jsonReader(tree, "filters", pe.getText().trim(), null);

        tree = new String[]{"components", "select"};
        pe = UtilFunctions.createNewPageElement("dropdown Software gateway","//*[@class='-input' and contains(.,'Seleziona opzione')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);

        locator = String.format("//form//button[contains(text(), '%s')]", "Pulisci");
        pe = UtilFunctions.createNewPageElement("Button Pulisci", locator);
        CommonSteps.jsonReader(null, "Reset", pe.getText().trim(),null);
        locator = String.format("//form//button[contains(text(), '%s')]", "Conferma ");
        pe = UtilFunctions.createNewPageElement("Button Conferma", locator);
        CommonSteps.jsonReader(null, "Confirm", pe.getText().trim(),null);

        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]");
        CommonSteps.jsonReader(tree,"customQuery", pe.getText(), null);

        Assert.assertTrue(pe.tryClick(), "Unable to click on Tab Query manuale");
        pe = UtilFunctions.createNewPageElement("title Query Manuale", "//h2[contains(.,'Query manuale')]");
        CommonSteps.jsonReader(tree, "customQuery", pe.getText().trim(), null);
    }

    @Then("I set the \"(.+)\" as Gateway Software Type")
    public static void setGatewaySoftwareType(String choice) throws InterruptedException {
        CampaignManagementPage.setOptionGatewaySoftwareType(choice);
        PageElement pe = UtilFunctions.createNewPageElement("gateway software type choiced", CampaignManagementPage.getOptionGatewaySoftwareType());
        Thread.sleep(2000);
        Assert.assertTrue(pe.tryClick(), "Unable to click on the choice: "+choice);
    }

    @Then("I choice two device ID: \"(.+)\" and \"(.+)\"")
    public static void IchoiceTwoDeviceId(String choice1, String choice2){

        PageElement pe = UtilFunctions.createNewPageElement("Device ID "+choice1, "//td[contains(.,'"+choice1+"')]//preceding-sibling::td");
        Assert.assertTrue(pe.isPresent(), "Unable to retrieve the element: "+choice1);
        pe.scrollTo();
        Assert.assertTrue(pe.tryClick(), "Unable to select The Device ID: "+choice1);
        UtilFunctions.addScreenshot("choice 1 selected");
        pe = UtilFunctions.createNewPageElement("Device ID "+choice2, "//td[contains(.,'"+choice2.trim()+"')]//preceding-sibling::td");

        Assert.assertTrue(pe.isPresent(), "Unable to retrieve the element: "+choice2);
        pe.scrollTo();
        Assert.assertTrue(pe.tryClick(), "Unable to select The Device ID: "+choice2);
        UtilFunctions.addScreenshot("choice 2 selected");
    }

    @Then("I set two package to install. App name: \"(.+)\" with version \"(.+)\" and App name: \"(.+)\" with version \"(.+)\"")
    public static void setTwoPackageToInstall(String app1, String version1, String app2, String version2){

        Assert.assertTrue(CampaignManagementView.getAppNameDropdown().tryClick(), "Unable to click on app dropdown menu");
        CampaignManagementView.setAppOptionDropdown(app1);
        PageElement pe = UtilFunctions.createNewPageElement("App name element", CampaignManagementView.getAppOptionDropdown());
        Assert.assertTrue(pe.tryClick(), "Unable to click on element: "+app1);

        Assert.assertTrue(CampaignManagementView.getVersionDropdown().tryClick(), "Unable to click on version dropdown menu");
        CampaignManagementView.setAppVersionDropdown(version1);
        pe = UtilFunctions.createNewPageElement("App name element", CampaignManagementView.getAppVersionDropdown());
        Assert.assertTrue(pe.tryClick(), "Unable to click on element: "+version1);

        Assert.assertTrue(CampaignManagementView.getButtonAddNewPackage().tryClick(), "unable to click on button ADD NEW PACKAGE. ");

        Assert.assertTrue(CampaignManagementView.getAppNameDropdown().tryClick(), "Unable to click on app dropdown menu");
        CampaignManagementView.setAppOptionDropdown(app2);
        pe = UtilFunctions.createNewPageElement("App name element", "("+CampaignManagementView.getAppOptionDropdown()+")[2]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on element: "+app2);

        Assert.assertTrue(CampaignManagementView.getVersionDropdown().tryClick(), "Unable to click on version dropdown menu");
        CampaignManagementView.setAppVersionDropdown(version2);
        pe = UtilFunctions.createNewPageElement("App name element", "("+CampaignManagementView.getAppVersionDropdown()+")[2]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on element: "+version2);
    }

    @Then("I check that the refresh button works properly in the Campaign Management page")
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
        Assert.assertTrue(CampaignManagementPage.getRefreshBtn().tryClick());
        CommonSteps.waitProgressBar();
        Assert.assertTrue(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrieved after refresh are different from the expected");
    }

    @Then("I click the option saved previously")
    public static void clickTheOptionSavedPreviously(){
        String option = CommonSteps.nameOption;
        CampaignManagementView.setOptionDropdownMenu(option);
        WebElement we = CommonPage.getDriver().findElement(By.xpath(CampaignManagementView.optionDropdownMenu));
        we.click();
    }

    @Then("I verify the presence of the option \"(.+)\"")
    public static void verifyPresenceOfTheOption(String option){
        CampaignManagementPage.setOptionDeploySoftwarePopUp(option);
        PageElement pe = UtilFunctions.createNewPageElement("option "+option, CampaignManagementPage.getOptionDeploySoftwarePopUp());
        Assert.assertTrue(pe.isPresent(), "Unable to locate the option "+option);
    }

    @Then("I check that the Campaign Management Page is correctly translated in italian")
    public static void checkTranslationCampaignManagementPage21() throws IOException, InterruptedException {

        String tree_swManager[] = new String[]{"controlRoom", "swManager"};
        String tree[]= new String[]{"controlRoom"};
        String tree_select[] = new String[]{"components", "select"};
        String [] tree_reset = new String[]{"components", "table"};

        // checking campagne gateways and campagne direct things tabs
        CommonSteps.jsonReader(tree_swManager,"gatewaysCampaign", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div[@class='mat-tab-label-content' and contains(., 'Campagne Gateway')]").getText(), null);
        CommonSteps.jsonReader(tree_swManager,"directThingsCampaign", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div[@class='mat-tab-label-content' and contains(., 'Campagne Direct Things')]").getText(), null);
        //clicking on campagne gateways tab and checking its title
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Campagne Gateways","//div[(text()= 'Campagne Gateways')]").tryClick(), "Unable to click on campagne gateways tab");
        CommonSteps.jsonReader(tree_swManager,"gatewaysCampaign", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//h2[text()='Campagne Gateways ']").getText(), null);

        //checking search filters and custom querty tabs
        CommonSteps.jsonReader(tree,"searchFilters", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]").getText(), null);
        CommonSteps.jsonReader(tree,"customQuery", UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").getText(), null);
        //clicking on search filters tab
        Assert.assertTrue(UtilFunctions.createNewPageElement("search filters","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]").tryClick(), "Unable to click on search filters tab");
        // opening the filter box and checking its components
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on cevron icon in order to open the filter box");
        UtilFunctions.addScreenshot("filter box");
        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_select, "defaultLabel", UtilFunctions.createNewPageElement("dropdown Software gateway","//*[@class='-input' and contains(.,'Seleziona opzione')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//form//button[contains(text(), 'Pulisci')]").getText().trim(),null);
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("Button Conferma", "//form//button[contains(text(), 'Conferma')]").getText().trim(),null);
        //clicking on custom query tab
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").tryClick(), "Unable to click on Tab Query Manuale");
        CommonSteps.jsonReader(tree, "customQuery", UtilFunctions.createNewPageElement("title Query Manuale", "//h2[contains(.,'Query manuale')]").getText().trim(), null);
        Thread.sleep(1000);
        UtilFunctions.addScreenshot("custom query tab");
        Assert.assertTrue(UtilFunctions.createNewPageElement("open Tab Query manuale","//div/div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on Tab Query Manuale open");
        UtilFunctions.addScreenshot("custom query expanded");
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("title Query Manuale", "//div[@class='-card-footer']//button[text()=' Conferma ']").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//div[@class='-card-footer']//button[text()=' Pulisci ']").getText().trim(),null);
        //clicking on campagne direct thing tab and cheking its title
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Campagne Direct Things","//div[@class='mat-tab-label-content' and contains(., 'Campagne Direct Things')]").tryClick(), "Unable to click on the Tab Campagne Direct Things");
        Thread.sleep(1000);
        UtilFunctions.addScreenshot("direct things campagne");
        CommonSteps.jsonReader(tree_swManager,"directThingsCampaign", UtilFunctions.createNewPageElement("Title Campagne Direct Things","//h2[text()='Campagne Direct Things ']").getText(), null);
        //checking search filters and custom querty tabs
        CommonSteps.jsonReader(tree,"searchFilters", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]").getText(), null);
        CommonSteps.jsonReader(tree,"customQuery", UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").getText(), null);
        //clicking on search filters tab
        Assert.assertTrue(UtilFunctions.createNewPageElement("search filters","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]").tryClick(), "Unable to click on search filters tab");
        UtilFunctions.addScreenshot("filter tab");
        // opening the filter box and checking its components
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on cevron icon in order to open the filter box");
        UtilFunctions.addScreenshot("filter box");
        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_select, "defaultLabel", UtilFunctions.createNewPageElement("dropdown Software gateway","//*[@class='-input' and contains(.,'Seleziona opzione')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//form//button[contains(text(), 'Pulisci')]").getText().trim(),null);
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("Button Conferma", "//form//button[contains(text(), 'Conferma')]").getText().trim(),null);
        CommonSteps.jsonReader(tree,"customQuery", UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").getText(), null);
        //clicking on custom query tab
        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").tryClick(), "Unable to click on Tab Query Manuale");
        UtilFunctions.addScreenshot("custom query tab");
        CommonSteps.jsonReader(tree, "customQuery", UtilFunctions.createNewPageElement("title Query Manuale", "//h2[contains(.,'Query manuale')]").getText().trim(), null);
        Thread.sleep(1000);
        Assert.assertTrue(UtilFunctions.createNewPageElement("open Tab Query manuale","//div/div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on Tab Query Manuale open");
        UtilFunctions.addScreenshot("expanded custom query");
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("title Query Manuale", "//div[@class='-card-footer']//button[text()=' Conferma ']").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//div[@class='-card-footer']//button[text()=' Pulisci ']").getText().trim(),null);


        //check the pagination
        CommonSteps.jsonReader(tree_reset, "rowsPerPage", CampaignManagementPage.getRowsPerPageIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "pageCounters", CampaignManagementPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+CampaignManagementPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);
        CampaignManagementPage.getPageCountersIT().scrollTo();

        /*CommonSteps.jsonReader(tree,"searchFilters", UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//*[@class='mat-tab-label-content' and contains(., 'Filtri di Ricerca')]").getText(), null);
        CommonSteps.jsonReader(tree,"customQuery", UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").getText(), null);

        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Filtri di ricerca","//div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on cevron icon in order to open the filter box");

        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]").getText().trim(), null);

        CommonSteps.jsonReader(tree_select, "defaultLabel", UtilFunctions.createNewPageElement("dropdown Software gateway","//*[@class='-input' and contains(.,'Seleziona opzione')]").getText().trim(), null);

        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//form//button[contains(text(), 'Pulisci')]").getText().trim(),null);

        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("Button Conferma", "//form//button[contains(text(), 'Conferma')]").getText().trim(),null);

        CommonSteps.jsonReader(tree,"customQuery", UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").getText(), null);

        Assert.assertTrue(UtilFunctions.createNewPageElement("Tab Query manuale","//*[@class='mat-tab-label-content' and contains(., 'Query manuale')]").tryClick(), "Unable to click on Tab Query manuale");
        CommonSteps.jsonReader(tree, "customQuery", UtilFunctions.createNewPageElement("title Query Manuale", "//h2[contains(.,'Query manuale')]").getText().trim(), null);*/

    }

}
