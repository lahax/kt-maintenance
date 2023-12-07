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
import ta.utilities.ReflectionUtils;
import test.pages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static test.steps.CommonSteps.jsonReader;

public class CustomGroupsSteps {

    private static boolean createdCustom = false;

    public static boolean isCreatedCustom() {
        return createdCustom;
    }

    public static void setCreatedCustom(boolean createdCustom) {
        CustomGroupsSteps.createdCustom = createdCustom;
    }

    @Then("I check that user land on Custom Groups Page")
    public static void checkLandInPageCustomerGroup() {
        Assert.assertTrue(CustomGroupsPage.getCustomGroupsPageTitle().isVisible(), "Custom Groups page not found!");
    }

    @Then("^I click (\\w+).(\\w+) action icon and check the landing page or pop up$")
    public static void clickOnActionIconInTheTableAndCheckTheLandingPageCustomerGroup(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(), "The element " + fieldName + " is not present in the page " + className);
        switch (fieldName) {
            case "iconDocumentFirstRow":
                CustomGroupsPage.getIconDocumentFirstRow().click();
                Assert.assertTrue(CustomGroupsPage.getCustomGroupDetailPage().isVisible(), "Custom Groups Detail page not present");
                CustomGroupsPage.getBackBTN().click();
                break;
            case "iconPencilFirstRow":
                CustomGroupsPage.getIconPencilFirstRow().click();
                Assert.assertTrue(CustomGroupsPage.getTitleCustomGroupEditPage().isVisible(), "Custom Groups Edit page not present");
                CustomGroupsPage.getBackBTN().click();
                break;
            case "iconCopyFirstRow":
                CustomGroupsPage.getIconCopyFirstRow().click();
                Assert.assertTrue(CustomGroupsPage.getCustomGroupDetailPage().isVisible() &&
                        CustomGroupsPage.getDuplicateModeWarningCustomGroupPage().isVisible(), "Custom Groups Copy page not present");
                CustomGroupsPage.getBackBTN().click();
                break;
            case "iconTrashFirstRow":
                CustomGroupsPage.getIconTrashFirstRow().click();
                Assert.assertTrue(CustomGroupsPage.getTitlePopUpdeleteItem().isVisible(), "Delete pop up not present");
                CustomGroupsPage.getCancelButton().click();
                break;
            default:
        }
    }

    @Then("I check in Custom Group that the refresh button works properly")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        Assert.assertTrue(CustomGroupsPage.getAllCellOfFirstRow().isPresent(30), "No data present into the list in 30 sec");
        List<WebElement> els = CommonPage.getDriver().findElements(CustomGroupsPage.getAllCellOfFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();
        for(WebElement we : els){
            origin.add(we.getText().toLowerCase());
        }
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els){
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }

        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(10000);
        CustomGroupsPage.getRefreeshBTN().click();
        Assert.assertTrue(CustomGroupsPage.getAllCellOfFirstRow().isPresent(30), "La lista non compare in 30 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(CustomGroupsPage.getAllCellOfFirstRow().getBy());
        for(WebElement we : els){
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els){
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrived after refresh are different from the expected");
    }

    @Then("I check that the Custom Group page is correctly translated")
    public void checkTranslationSidebar() throws IOException {

        String [] tree  = new String[]{"controlRoom"};
        String [] tree_bis = new String[]{"components", "table"};
        //*Check options*//
        //Assert.assertTrue(CustomGroupsPage.getCustomGroupsPageTitleIT().isPresent(), "title not present");
        //Assert.assertTrue(CustomGroupsPage.getGroupsNameColumnTitle().isPresent(), "groups columns not present");
        //Assert.assertTrue(CustomGroupsPage.getProjectsNameColumnTitle().isPresent(), "project column not present");
        CommonSteps.jsonReader(tree, "customGroups", CustomGroupsPage.getCustomGroupsPageTitleIT().getText(),null);
        CommonSteps.jsonReader(tree, "groupName", CustomGroupsPage.getGroupsNameColumnTitle().getText(),null);
        CommonSteps.jsonReader(tree, "projectName", CustomGroupsPage.getProjectsNameColumnTitle().getText(),null);

        //*Open the column actions*//
        CustomGroupsPage.getSelectColumnsIcon().click();
        CommonSteps.jsonReader(tree, "groupName", CustomGroupsPage.getGroupNameIT().getText(),null);
        CommonSteps.jsonReader(tree, "projectName", CustomGroupsPage.getProjectsNameIT().getText(),null);
        CommonSteps.jsonReader(tree_bis, "resetColumnsSize", CustomGroupsPage.getResizeColumns().getText(),null);
        CommonSteps.jsonReader(null, "Close", CustomGroupsPage.getCloseColumnsBTN().getText(),null);
        CustomGroupsPage.getCloseColumnsBTN().click();


    }

    @Then("If no custom group is present I create one")
    public void ifNoCustomGroupIsPresentICreateOne() throws Exception {
            List<WebElement> els = CommonPage.getDriver().findElements(DeviceAlarmsConfigurationPage.getAllCellOfFirstRow().getBy());
            if (els.size() == 0 ){
                setCreatedCustom(true);
                createExampleCustom();
            }
    }

    public static void createExampleCustom()throws Exception {
        //Create basic custom
        System.out.println("I Create a custom group");
        CommonSteps.checkAndClickElementPresent("CustomGroupsPage","addGroupBTN");
        CommonSteps.typeStringIntoElement("ConceptCustomTest","CustomGroupsPage","addGroupName");
        CommonSteps.checkAndClickElementPresent("CustomGroupsPage","addDirectThingBox");
        CommonSteps.typeStringIntoElement("DirectThing_Test15_26","CustomGroupsPage","addDirectThingBox");
        CommonSteps.checkAndClickElementPresent("CustomGroupsPage","addDirectThingBTN");
        CommonSteps.checkAndClickElementPresent("CustomGroupsPage","saveAddingGroupBTN");
        CommonSteps.waitProgressBar();
        CommonSteps.checkAndClickElementPresent("CustomGroupsPage","refreeshBTN");
    }
    @Then("If I created a custom group I delete it")
    public void ifICreatedAnAlarmIDeleteIt() {

        if (isCreatedCustom()) {

            Assert.assertTrue(CustomGroupsPage.getIconTrashFirstRow().tryClick());
            Assert.assertTrue(CustomGroupsPage.getConfirmDelete().tryClick());

        }
    }

    @Then("If {string} is present I delete it")
    public void ifIsPresentIDeleteIt(String customGroup) {
        PageElement pe = UtilFunctions.createNewPageElement("Custom group", "//td[contains(., '"+customGroup+ "')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]");

        if (pe.isPresent()) {
            Assert.assertTrue(pe.tryClick());
            Assert.assertTrue(CustomGroupsPage.getConfirmDelete().tryClick());
            CustomGroupsPage.getToastMessageClose().tryClick();

        }
    }
}

