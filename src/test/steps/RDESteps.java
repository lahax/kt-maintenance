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
import ta.utilities.Configuration;
import test.pages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RDESteps {

    public static List<String> getAllDetailsOfRule() {

        List<String> ris = new ArrayList<>();
        List<WebElement> els = CommonPage.getDriver().findElements(By.xpath("//span[@class='segment-value ng-star-inserted']"));

        for (WebElement webElement : els) {
            ris.add(webElement.getText().replace("\"", ""));
        }

        return ris;
    }

    @Then("I check that the refresh button works properly on RDE page")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        List<WebElement> els = CommonPage.getDriver().findElements(RDEPage.getAllCellOfFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();
        for (WebElement we : els) {
            origin.add(we.getText().toLowerCase());
        }
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }
        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(10000);
        RDEPage.getRefreshBTN().click();
        Assert.assertTrue(RDEPage.getAllCellOfFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
//        els = CommonPage.getDriver().findElements(RDEPage.getAllCellOfFirstRow().getBy());
//        for (WebElement we : els) {
//            updated.add(we.getText().toLowerCase());
//        }
//        for (WebElement webElement : els) {
//            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
//        }
//        Assert.assertTrue(origin.containsAll(updated), "The values retrived after refresh are different from the expected");
        els = CommonPage.getDriver().findElements(By.xpath("//tbody/tr/td[1]"));
        for (WebElement we : els) {
              updated.add(we.getText().toLowerCase().trim());
        }

        Assert.assertTrue(updated.contains(origin.get(0).trim()), "The table doesn't contains the same RDE rule after the updating");
    }

    @Then("I check that the RDE page is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage() throws IOException {
        String[] tree_rde = new String[]{"controlRoom", "rde"};
        String[] tree_reset = new String[]{"components", "table"};

        //Check table
        CommonSteps.jsonReader(tree_rde, "ruleAndDispatchEngine", RDEPage.getRdeLandingPageTitleIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "filterId", RDEPage.getFilterIdColumnIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "ruleId", RDEPage.getRuleIdColumnIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "actionsDetail", RDEPage.getActionsDetailsColumnIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "andConditions", RDEPage.getConditionsColumnIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "occurrences", RDEPage.getOccurrenceColumnIT().getText(), null);

        //Open the column actions
        RDEPage.getSelectColumnsIcon().click();
        CommonSteps.jsonReader(tree_rde, "filterId", RDEPage.getSelectFilterIdIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "ruleId", RDEPage.getSelectRuleIdIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "actionsDetail", RDEPage.getSelectActionsDetailIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "andConditions", RDEPage.getSelectConditionsIT().getText(), null);
        CommonSteps.jsonReader(tree_rde, "occurrences", RDEPage.getSelectOccurrenceIT().getText(), null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", RDEPage.getResizeColumnsIT().getText(), null);
        CommonSteps.jsonReader(null, "Close", RDEPage.getCloseColumnsBTN().getText(), null);
        //Close the column actions
        RDEPage.getCloseColumnsBTN().click();

    }

    @Then("I check the presence of {string} {string} {string} buttons on the last column")
    public void iCheckThePresenceOfButtonsOnTheLastColumn(String arg1, String arg2, String arg3) throws InterruptedException {

        ArrayList<String> buttonsIcon = new ArrayList<>();
        buttonsIcon.add("document");
        buttonsIcon.add("pencil");
        buttonsIcon.add("trash");
        int indexList = 0;
        int flag = 0;

        String classIcon = "";

        Thread.sleep(5000);
        List<WebElement> iconsDMCPresent = CommonPage.getDriver().findElements(By.xpath("(//tr/td[6])[1]/div/div/descendant::i"));

        try {
            Assert.assertEquals(iconsDMCPresent.size(), buttonsIcon.size(), "The icon present in DMC are different");
        } catch (Exception e) {

            if (iconsDMCPresent.size() < buttonsIcon.size()) {
                Assert.fail("There are more icons on the DMC");
            }

            Assert.fail("The are less icons on the DMC");
        }

        for (WebElement element : iconsDMCPresent) {
            classIcon = element.getAttribute("class");
            if (classIcon.contains(buttonsIcon.get(indexList))) {
                flag++;
            }
            indexList++;
        }

        Assert.assertEquals(flag, iconsDMCPresent.size());

    }

    @Then("If the rule for \"(.+)\" is present I delete it")
    public static void deleteRuleForDevice(String device) throws Exception {
        String locator = "//td[contains(., '%s')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]";
        String iconToClick = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("icon delete rule device"+device, iconToClick);
        List<WebElement> peArray = CommonPage.getDriver().findElements(pe.getBy());

            for(int i = 0; i < peArray.size(); i++) {
                if (pe.isPresent()) {
                    CommonSteps.waitProgressBar();
                    pe.tryClick();
                    RDEPage.getDeleteConfirmBtn().tryClick();
                    RDEPage.getToastMessageClose().tryClick();
                    RDEPage.getRefreshBTN().tryClick();

                }
            }
        }
}
