package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.entities.elements.PageElement;
import test.pages.OtaUpdatePage;

public class OtaUpdateSteps {
    @Then("I set the \"(.+)\" option from \"(.+)\" dropdown menu")
    public static void setChoiceFromDropdownmenu(String choice, String dropdown) throws InterruptedException {
        Thread.sleep(1000);
        OtaUpdatePage.setOptionFromDropdown(choice, dropdown);
        PageElement pe = UtilFunctions.createNewPageElement("option: "+choice+" from dropdown: "+dropdown, OtaUpdatePage.getOptionFromDropdown());
        Assert.assertTrue(pe.tryClick(), "Unable to click on choice: "+choice);
    }
}
