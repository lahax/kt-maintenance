package test.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.formatters.ReportFormatter;
import test.pages.SoftwareCataloguePage;

import java.util.List;

public class SoftwareManagerSteps {

    private static final Logger LOG = LoggerFactory.getLogger(ReportFormatter.class);

    @Then("I check if searchbar work with the word {string}")
    public static void checkSearchBarWork(String wordSearch) {

        List<WebElement> listSoftwareCard = CommonPage.getDriver().findElements(By.xpath("//div[contains(text(),'" + wordSearch + "')]"));
        Assert.assertTrue(listSoftwareCard.size() > 0, "Text not found: Searchbar not working!");
    }

    @Then("I check the {string} input box are only read mode")
    public void iCheckTheInputBoxAreOnlyReadMode(String numberOfInputBox) {

        int numberOfInputFields = Integer.parseInt(numberOfInputBox);

        List<WebElement> inputBoxDisabled = CommonPage.getDriver().findElements(By.xpath("//input[@readonly=\"\"]"));

        int s = inputBoxDisabled.size();

        Assert.assertEquals(numberOfInputFields, inputBoxDisabled.size(), "Error: The number of input fields that are in only read mode not match");
    }

    @Then("I check the input box are on edit mode")
    public void iCheckTheInputBoxAreOnEditMode() {

        List<WebElement> inputBoxDisabled = CommonPage.getDriver().findElements(By.xpath("//input[@readonly=\"\"]"));

        Assert.assertEquals(inputBoxDisabled.size(), 6, "Error: The number of input fields that are in edit mode not match");
    }

    @Then("I count all the software presents")
    public void iCountAllTheSoftwarePresentsAndCheckThereAreInThePage() {
        int softwareCounted = CommonPage.getDriver().findElements(SoftwareCataloguePage.getSoftwareNumber().getBy()).size();

        Assert.assertTrue(softwareCounted > 0, "");
        LOG.info("There are " + softwareCounted + " software card");
    }



}
