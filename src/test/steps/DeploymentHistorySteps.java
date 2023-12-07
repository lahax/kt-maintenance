package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.pages.CampaignManagementPage;
import test.pages.DeploymentHistoryDeviceDetailsPage;
import test.pages.DeploymentsHistoryPage;
import test.pages.DevicesPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeploymentHistorySteps {

    @Then("I check that the Deployment History Page is correctly translated in italiano")
    public static void checkDEploymentHistoryPageTranslation() throws IOException {
        String tree[] = new String[]{"controlRoom"};
        PageElement pe = UtilFunctions.createNewPageElement("tab Filtri", "//*[@role='tab']/*[contains(.,'Filtri')]");

        CommonSteps.jsonReader(tree, "filters", pe.getText().trim(), null);

        pe = UtilFunctions.createNewPageElement("landing page title", "//h2[contains(.,' Cronologia Distribuzioni ')]");
        CommonSteps.jsonReader(tree, "deploymentsHistory", pe.getText().trim(), null);

        pe = UtilFunctions.createNewPageElement("tab Query manuale", "//*[@role='tab']/*[contains(.,'Query manuale')]");
        CommonSteps.jsonReader(tree, "customQuery", pe.getText().trim(), null);



        pe = UtilFunctions.createNewPageElement("tab Filtri", "//div[@class='-card-title']/following-sibling::i[contains(@class, 'dmc-icon__chevron-down')]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on: "+pe.getText());
        pe = UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]");
        CommonSteps.jsonReader(tree, "filters", pe.getText().trim(), null);

        pe = UtilFunctions.createNewPageElement("label tipo dispositivo", "//*[contains(text(), 'Tipo dispositivo')]");
        CommonSteps.jsonReader(tree, "deviceType", pe.getText().trim(), null);
        tree = new String[]{"controlRoom", "swManager", "filters"};
        pe = UtilFunctions.createNewPageElement("label tipo software gateway", "//dmc-form-field-label[contains(.,'Tipo software gateway')]");
        CommonSteps.jsonReader(tree, "gatewaySoftwareType", pe.getText().trim(), null);
        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("label Modalità di distribuzione", "//dmc-form-field-label[contains(.,'distribuzione')]");
        CommonSteps.jsonReader(tree, "deployType", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("label Data Inizio Deploy", "//dmc-form-field-label[contains(.,'Intervallo data inizio distribuzione ')]");
        //CommonSteps.jsonReader(tree, "startDate", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("label Data Fine Deploy", "//dmc-form-field-label[contains(.,'Intervallo data fine distribuzione')]");
        //CommonSteps.jsonReader(tree, "endDate", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("label tipo software gateway", "//dmc-form-field-label[contains(.,'Stato')]");
        CommonSteps.jsonReader(tree, "status", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("label Ultima Versione", "//dmc-form-field-label[contains(.,'Ultima versione')]");
        CommonSteps.jsonReader(tree, "latest", pe.getText().trim(), null);

        tree = new String[]{"components", "select"};
        pe = UtilFunctions.createNewPageElement("dropdown tipo software gateway", "//*[contains(., 'Tipo software gateway')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("dropdown modalita di distribuzione", "//*[contains(., 'distribuzione')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]");
        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);
        //pe = UtilFunctions.createNewPageElement("dropdown Data Inizio Deploy", "//*[contains(., 'Data Inizio Deploy')]/following-sibling::dmc-datetime-range-picker//div[@class='-input' and contains(., 'Seleziona date')]");
        //Assert.assertTrue(pe.isPresent(), "Unable to retrieve element "+pe);
        //pe = UtilFunctions.createNewPageElement("dropdown Data Fine Deploy", "//*[contains(., 'Data Fine Deploy')]/following-sibling::dmc-datetime-range-picker//div[@class='-input' and contains(., 'Seleziona date')]");
        //Assert.assertTrue(pe.isPresent(), "Unable to retrieve element "+pe);
        //pe = UtilFunctions.createNewPageElement("dropdown Ultima Versione", "//*[contains(., 'Ultima versione')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]");
        //CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);
       // pe = UtilFunctions.createNewPageElement("dropdown Stato", "//*[contains(., 'Stato')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]");
        //CommonSteps.jsonReader(tree, "defaultLabel", pe.getText().trim(), null);

        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("tab Query manuale", "//*[@role='tab']/*[contains(.,'Query manuale')]");
        CommonSteps.jsonReader(tree, "customQuery", pe.getText().trim(), null);
        Assert.assertTrue(pe.tryClick(), "Unable to click on: "+pe.getText());
        pe = UtilFunctions.createNewPageElement("title Query manuale", "//h2[contains(.,'Query manuale')]");
        CommonSteps.jsonReader(tree, "customQuery", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("box query manuale", "//div[@class='-card-title']/following-sibling::i[contains(@class, 'dmc-icon__chevron-down')]");
        Assert.assertTrue(pe.tryClick(), "Unable to click on: "+pe.getText());
        String locator = String.format("//button[contains(text(), '%s')]", "Pulisci");
        pe = UtilFunctions.createNewPageElement("Placeholder Estensione", locator);
        CommonSteps.jsonReader(null, "Reset", pe.getText().trim(),null);
        locator = String.format("//button[contains(text(), '%s')]", "Conferma");
        pe = UtilFunctions.createNewPageElement("Placeholder Estensione", locator);
        CommonSteps.jsonReader(null, "Confirm", pe.getText().trim(),null);

        tree = new String[]{"controlRoom", "swManager"};
        pe = UtilFunctions.createNewPageElement("table caption", "//p[@class='-table-hint' and contains(., 'Selezionando/deselezionando una riga della tabella, tutte le righe con stesso ID del dispositivo verranno selezionate')]");
        Assert.assertTrue(pe.isPresent(), "Unable to retrieve the element");

        pe = UtilFunctions.createNewPageElement("header id dispositivo", "//div[@class='-header']/div[contains(.,'ID Dispositivo')]");
        CommonSteps.jsonReader(tree, "deviceId", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("header tipologia dispositivo", "//div[@class='-header']/div[contains(.,'Tipologia Dispositivo')]");
        CommonSteps.jsonReader(tree, "deviceType", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("header tipologia dispositivo", "//div[@class='-header']/div[contains(.,'Tipo di Software')]");
        CommonSteps.jsonReader(tree, "softwareType", pe.getText().trim(), null);

        pe = UtilFunctions.createNewPageElement("header Inizio", "//div[@class='-header']/div[contains(.,'Inizio')]");
        CommonSteps.jsonReader(null, "Start Time", pe.getText().trim(), null);
        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("header durata", "//div[@class='-header']/div[contains(.,'Durata')]");
        CommonSteps.jsonReader(tree, "duration", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("header Utlima Versione", "//div[@class='-header']/div[contains(.,'Ultima versione')]");
        CommonSteps.jsonReader(tree, "latest", pe.getText().trim(), null);
        pe = UtilFunctions.createNewPageElement("header Stato", "//div[@class='-header']/div[contains(.,'Stato')]");
        CommonSteps.jsonReader(tree, "status", pe.getText().trim(), null);

        //check the pagination
        String [] tree_reset = new String[]{"components", "table"};
        CommonSteps.jsonReader(tree_reset, "rowsPerPage", DevicesPage.getRowsPerPageIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "pageCounters", DevicesPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+DevicesPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);

    }

    @Then("I select the checkbox of the entry \"(.+)\"")
    public static void selectCheckBoxSpecificEntry(String device){
        DeploymentsHistoryPage.setFirstCheckboxSpecifEntryInTheTable(device);
        PageElement pe = UtilFunctions.createNewPageElement("checkbox of entry "+device, DeploymentsHistoryPage.getFirstCheckboxSpecifEntryInTheTable());
        Assert.assertTrue(pe.tryClick(), "Unable to click the checkbox of the device "+device);
    }

    @Then("I select the details icon of the entry \"(.+)\"")
    public static void selectDetailIconSpecificEntry(String device){
        DeploymentsHistoryPage.setFirstDetailIconSpecifEntryInTheTable(device);
        PageElement pe = UtilFunctions.createNewPageElement("checkbox of entry "+device, DeploymentsHistoryPage.getFirstDetailIconSpecifEntryInTheTable());
        Assert.assertTrue(pe.tryClick(), "Unable to click the details icon of the device "+device);
    }

    @Then("I check that the refresh button works properly in the deployment hystory page")
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
        Assert.assertTrue(DeploymentHistoryDeviceDetailsPage.getRefreshButton().tryClick());
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

    @Then("I close the deployment popup")
    public static void closeDeploymentPopUp() throws InterruptedException {
        Thread.sleep(2000);
        WebElement we = CommonPage.getDriver().findElement(By.xpath("//div[@class='panel-body']"));
        we.sendKeys(Keys.ESCAPE);
    }

    @Then("I check that the Deployment History Page is correctly translated in italian")
    public static void checkDEploymentHistoryPageTranslation21() throws IOException, InterruptedException {
        String[] tree = new String[]{"controlRoom"};
        String[] tree_swManager_filters = new String[]{"controlRoom", "swManager", "filters"};
        String[] tree_select = new String[]{"components", "select"};
        String[] tree_swManager = new String[]{"controlRoom", "swManager"};
        String[] tree_reset = new String[]{"components", "table"};
        //checking page title and filters and custom query tabs
        CommonSteps.jsonReader(tree, "deploymentsHistory", UtilFunctions.createNewPageElement("landing page title", "//h2[contains(.,'Cronologia Distribuzioni')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("tab Filtri", "//*[@role='tab']/*[contains(.,'Filtri')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "customQuery", UtilFunctions.createNewPageElement("tab Query manuale", "//*[@role='tab']/*[contains(.,'Query manuale')]").getText().trim(), null);
        //clicking on filters tab and opening it
        Assert.assertTrue(UtilFunctions.createNewPageElement("search filters","//div[@class='mat-tab-label-content' and contains(., 'Filtri')]").tryClick(), "Unable to click on search filters tab");
        Assert.assertTrue(UtilFunctions.createNewPageElement("tab Filtri", "//div[@class='-card-title']/following-sibling::i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on: "+(UtilFunctions.createNewPageElement("tab Filtri", "//div[@class='-card-title']/following-sibling::i[contains(@class, 'dmc-icon__chevron-down')]").getText()));
        UtilFunctions.addScreenshot("filter box");
        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("title Filtri", "//h2[contains(.,'Filtri')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "deviceType", UtilFunctions.createNewPageElement("label tipo dispositivo", "//*[contains(text(), 'Tipo dispositivo')]").getText().trim(), null);
//        CommonSteps.jsonReader(tree_swManager_filters, "gatewaySoftwareType", UtilFunctions.createNewPageElement("label tipo software gateway", "//dmc-form-field-label[contains(.,'Tipo software gateway')]").getText().trim(), null);
//        CommonSteps.jsonReader(tree, "deployType", UtilFunctions.createNewPageElement("label Modalità di distribuzione", "//dmc-form-field-label[contains(.,'distribuzione')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "startDateRange", UtilFunctions.createNewPageElement("label Data Inizio Deploy", "//dmc-form-field-label[contains(.,'Intervallo data inizio distribuzione ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "endDateRange", UtilFunctions.createNewPageElement("label Data Fine Deploy", "//dmc-form-field-label[contains(.,'Intervallo data fine distribuzione')]").getText().trim(), null);
//        CommonSteps.jsonReader(tree, "status", UtilFunctions.createNewPageElement("label tipo software gateway", "//dmc-form-field-label[contains(.,'Stato')]").getText().trim(), null);
//        CommonSteps.jsonReader(tree, "latest", UtilFunctions.createNewPageElement("label Ultima Versione", "//dmc-form-field-label[contains(.,'Ultima versione')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Placeholder Estensione", "//div[@class='-card-footer']//button[(text()= ' Pulisci ')]").getText().trim(),null);
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("Placeholder Estensione", "//div[@class='-card-footer']//button[(text()= ' Conferma ')]").getText().trim(),null);
//        CommonSteps.jsonReader(tree_select, "defaultLabel", UtilFunctions.createNewPageElement("dropdown tipo software gateway", "//*[contains(., 'Tipo software gateway')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]").getText().trim(), null);
//        CommonSteps.jsonReader(tree_select, "defaultLabel", UtilFunctions.createNewPageElement("dropdown modalita di distribuzione", "//*[contains(., 'distribuzione')]/following-sibling::dmc-select//div[contains(@class, '-input' ) and contains(., 'Seleziona opzione')]").getText().trim(), null);
        //clicking on custom query tab and expanding it
        Assert.assertTrue(UtilFunctions.createNewPageElement("tab Query manuale", "//*[@role='tab']/*[contains(.,'Query manuale')]").tryClick(), "Unable to click on: "+UtilFunctions.createNewPageElement("tab Query manuale", "//*[@role='tab']/*[contains(.,'Query manuale')]").getText());
        CommonSteps.jsonReader(tree, "customQuery", UtilFunctions.createNewPageElement("title Query manuale", "//h2[contains(.,'Query manuale')]").getText().trim(), null);
        Thread.sleep(1000);
        Assert.assertTrue(UtilFunctions.createNewPageElement("open Tab Query manuale","//div/div/i[contains(@class, 'dmc-icon__chevron-down')]").tryClick(), "Unable to click on Tab Query Manuale open");
        UtilFunctions.addScreenshot("manual query");
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("title Query Manuale", "//div[@class='-card-footer']//button[text()=' Conferma ']").getText().trim(), null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Button Pulisci", "//div[@class='-card-footer']//button[text()=' Pulisci ']").getText().trim(),null);
        Assert.assertTrue(UtilFunctions.createNewPageElement("table caption", "//p[@class='-table-hint' and contains(., 'Selezionando/deselezionando una riga della tabella, tutte le righe con stesso ID del dispositivo verranno selezionate')]").isPresent(), "Unable to retrieve the element");
        CommonSteps.jsonReader(tree_swManager, "deviceId", UtilFunctions.createNewPageElement("header id dispositivo", "//div[@class='-header']/div[contains(.,'ID Dispositivo')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_swManager, "deviceType", UtilFunctions.createNewPageElement("header tipologia dispositivo", "//div[@class='-header']/div[contains(.,'Tipologia Dispositivo')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_swManager, "softwareType", UtilFunctions.createNewPageElement("header tipologia dispositivo", "//div[@class='-header']/div[contains(.,'Tipo di Software')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Start Time", UtilFunctions.createNewPageElement("header Inizio", "//div[@class='-header']/div[contains(.,'Inizio')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "duration", UtilFunctions.createNewPageElement("header durata", "//div[@class='-header']/div[contains(.,'Durata')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "latest", UtilFunctions.createNewPageElement("header Utlima Versione", "//div[@class='-header']/div[contains(.,'Ultima versione')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "status", UtilFunctions.createNewPageElement("header Stato", "//div[@class='-header']/div[contains(.,'Stato')]").getText().trim(), null);
        // click on action columns
        Assert.assertTrue(UtilFunctions.createNewPageElement("column actions", "//i[@dmcicon='table-columns']").tryClick(), "Unable to click on: "+UtilFunctions.createNewPageElement(null, "//i[@dmcicon='table-columns']").getText());
        UtilFunctions.addScreenshot("column actions");
        CommonSteps.jsonReader(tree_swManager, "deviceId", UtilFunctions.createNewPageElement("header id dispositivo", "//li/div[contains(.,' ID DISPOSITIVO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_swManager, "deviceType", UtilFunctions.createNewPageElement("header tipologia dispositivo", "//li/div[contains(.,' TIPOLOGIA DISPOSITIVO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_swManager, "softwareType", UtilFunctions.createNewPageElement("header tipologia dispositivo", "//li/div[contains(.,' TIPO DI SOFTWARE ')]").getText().trim(), null);
        CommonSteps.jsonReader(null, "Start Time", UtilFunctions.createNewPageElement("header Inizio", "//li/div[contains(.,' INIZIO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "duration", UtilFunctions.createNewPageElement("header durata", "//li/div[contains(.,' DURATA ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "latest", UtilFunctions.createNewPageElement("header Utlima Versione", "//li/div[contains(.,' ULTIMA VERSIONE ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree, "status", UtilFunctions.createNewPageElement("header Stato", "//li/div[contains(.,' STATO ')]").getText().trim(), null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", DeploymentsHistoryPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", DeploymentsHistoryPage.getCloseColumnsBTN().getText(),null);
        Assert.assertTrue(UtilFunctions.createNewPageElement("closing the column actions", "//span[contains(.,' Chiudi ')]").tryClick(), "Unable to retrieve the element");


        //check the pagination
        CommonSteps.jsonReader(tree_reset, "rowsPerPage", DeploymentsHistoryPage.getRowsPerPageIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "pageCounters", DeploymentsHistoryPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+DeploymentsHistoryPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);
        DeploymentsHistoryPage.getPageCountersIT().scrollTo();

    }
}
