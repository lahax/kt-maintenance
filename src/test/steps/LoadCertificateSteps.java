package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.pages.LoadCertificatePage;

import java.util.List;

public class LoadCertificateSteps {

    @Then("I verify that following elements are displayed")
    public void iVerifyThatFollowingElementsAreDisplayed(List elements) {
        for(int i =0; i<elements.size();i++)
            Assert.assertNotNull(CommonPage.getDriver().findElement(By.xpath("//label[text()='" + elements.get(i).toString() + "']/../following-sibling::div/label")));
    }

    @Then("I check that the box of File to be uploaded is correctly showed")
    public static void checkPresenceOfTheBoxOfFileToBeUploaded(){
        LoadCertificatePage.setBoxFileToBeUploaded(SoftwareCatalogueSteps.getFileUploaded());
        PageElement pe = UtilFunctions.createNewPageElement("Box file to be uploaded", LoadCertificatePage.getBoxFileToBeUploaded());
        Assert.assertTrue(pe.isPresent(), "Unable to locate the element: "+pe.getBy());
    }
}
