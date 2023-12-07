package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.entities.elements.PageElement;
import test.pages.ConnectivityHistoryPage;

import java.util.List;

public class ConnectivityHistorySteps {
    @Then("I check all the label into the info section of Connectivity History page")
    public static void checkLabelInfo(List<String> label){
        if(label.isEmpty())
            Assert.fail("The list is empty");
        String locator = "";
        PageElement pe = null;
        for(String l: label){
            locator = String.format(ConnectivityHistoryPage.labelInfo, l);
            pe = UtilFunctions.createNewPageElement("label "+l, locator);
            pe.scrollTo();
            Assert.assertTrue(pe.isPresent(), "Unable to find the element: "+pe);
        }

    }
}
