package test.steps;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.ActivateThingPage;

import java.util.List;

public class ActivateThingsSteps {
    @And("^I validate error \"(.+)\" for (\\w+).(\\w+) with these characters$")
    public void iClickActivateThingDDMOptionThatContains(String error, String className, String fieldName, List characters) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        for (int i = 0; i < characters.size(); i++) {
            //if()
            Assert.assertTrue(elem.fillText(characters.get(i).toString()));
            By errorMessage = By.xpath(elem.getCustomBy().getByString() + "//parent::dmc-input-container/following-sibling::dmc-form-field-error//div[contains(.,'" + error + "')]");
            Assert.assertTrue(new PageElement("Error message for " + fieldName, errorMessage).isVisible());
            CommonPage.getDriver().findElement(elem.getBy()).clear();
        }
    }

    @And("I should see these options")
    public void iShouldSeeTheseOptions(List options) {
        for (int i = 0; i < options.size(); i++) {
            Assert.assertTrue(CommonPage.getDriver().findElements(ActivateThingPage.getInteractionModeOption().getBy()).get(i).getText().contains(options.get(i).toString()));
        }
    }

    @And("^I verify that \"(.+)\" for (\\w+).(\\w+) is set to \"(.+)\"")
    public void iVerifyThatForStringStringIsSetTo(String attribute, String className, String fieldName, String value) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertEquals(value, elem.getAttribute(attribute), "Attribute " + attribute + " for element " + fieldName + " is not set to " + value);
    }
}
