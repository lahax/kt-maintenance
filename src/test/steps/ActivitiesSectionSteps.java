package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.ActivitiesPage;
import test.pages.RDEPage;

import java.io.IOException;

import static test.steps.CommonSteps.waitForElementLocatedBy;
import static test.steps.CommonSteps.waitForElementLocatedByXpath;

public class ActivitiesSectionSteps {

    @Then("I check that the Activities page is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage() throws IOException {
        String [] tree = new String[]{"controlRoom"};
        String [] tree_reset = new String[]{"components", "table"};

        //Check table
        CommonSteps.jsonReader(tree, "Activities", ActivitiesPage.getActivitiesLandingPageTitleIT().getText(),null);
        CommonSteps.jsonReader(tree, "creationDate", ActivitiesPage.getCreationDateColumnIT().getText().replaceAll("[\\-\\+\\.\\^:,]",""),null);
        CommonSteps.jsonReader(tree, "activityId", ActivitiesPage.getActivityIdColumnIT().getText(),null);

        //Open the column actions
        ActivitiesPage.getSelectColumnsIcon().click();
        CommonSteps.jsonReader(tree, "creationDate", ActivitiesPage.getSelectCreationDateIT().getText().replaceAll("[\\-\\+\\.\\^:,]",""),null);
        CommonSteps.jsonReader(tree, "activityId", ActivitiesPage.getSelectActivityIdIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", ActivitiesPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", ActivitiesPage.getCloseColumnsBTN().getText(),null);
        //Close the column actions
        ActivitiesPage.getCloseColumnsBTN().click();

    }

    @Then("If the activity \"(.+)\" is present I delete it")
    public static void deleteActivities(String device) throws Exception {
        String locator = "(//td[contains(., '%s')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']";
        String iconToClick = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("icon delete activity device"+device, iconToClick);
        boolean present = pe.isPresent();
        if (present) {
            Assert.assertTrue(pe.tryClick(), "Unable to click the element");
            CommonSteps.checkAndClickElementPresent("ActivitiesPage", "confirmDeleteButton");
        }
    }
    @Then("If the activity \"(.+)\" for device \"(.+)\" is not present I create it with note \"(.+)\"")
    //And If the activity "test2806A" for device "Test_Concept-01" is not present I create it
    public void createActivityWithNote(String activity, String device, String note) throws Exception {
        String payload= "{\n" +
                "    \"version\": \"1.0\",\n" +
                "    \"gateway_id\": \""+device+"\",\n" +
                "    \"command\": \"activate-thing\",\n" +
                "    \"parameters\": {\n" +
                "        \"device_type\": \"epiSensor\",\n" +
                "        \"interaction_mode\": \"gateway\",\n" +
                "        \"authentication_mode\": \"gateway\",\n" +
                "        \"radio_type\": \"Eth\",\n" +
                "        \"filter_tag\": [\n" +
                "            {\n" +
                "                \"tag\": \""+device+"\",\n" +
                "                \"id\": 2000,\n" +
                "                \"period\": 60\n" +
                "            },\n" +
                "            {\n" +
                "                \"tag\": \"CommunicationCode\",\n" +
                "                \"trendType\": \"CommCodeValue\",\n" +
                "                \"id\": 2001,\n" +
                "                \"period\": 60\n" +
                "            }\n" +
                "        ],\n" +
                "        \"inbound_communication_modes\": [\n" +
                "            \"shadow\",\n" +
                "            \"topic\"\n" +
                "        ],\n" +
                "        \"outbound_communication_modes\": \"shadow\",\n" +
                "        \"serial_number\": \"000D6F000D7EF1F8\",\n" +
                "        \"model\": \"ZDR\",\n" +
                "        \"maker\": \"EPISENSOR\"\n" +
                "    }\n" +
                "}";
        String locator = "(//td[contains(., '%s')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']";
        String iconToClick = String.format(locator, activity);
        PageElement pe = UtilFunctions.createNewPageElement("icon delete activity device"+activity, iconToClick);
        boolean present = pe.isPresent();
        if (!present) {
            //Assert.assertTrue(pe.tryClick(), "Unable to click the element");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "newActivityButton");
            //CommonSteps.cancelStringFromElement("ActivitiesPage", "activityDescriptionInput");
            CommonSteps.fillInputBox(activity , "ActivitiesPage", "activityIdInputLabel");
            PageElement elem = ReflectionUtils.getPageElementByString("ActivitiesPage", "activityDescriptionInput");
            waitForElementLocatedBy(elem.getBy(), 60);
            waitForElementLocatedByXpath("//textarea");
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.CONTROL+"a");
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.BACK_SPACE);
            // CommonPage.getDriver().findElement(By.xpath("//textarea")).clear();
            Thread.sleep(1000);
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(payload);
            System.out.println();
            CommonSteps.fillInputBox(note , "ActivitiesPage", "notesInputLabel");
            Thread.sleep(1000);
            CommonSteps.checkAndClickElementPresent("ActivitiesPage", "confirmNewActivityButton");
            CommonSteps.checkAndClickElementPresent("ActivitiesPage", "toastMessageClose");
        }
    }
    @Then("If the activity \"(.+)\" for device \"(.+)\" is not present I create it")
    //And If the activity "test2806A" for device "Test_Concept-01" is not present I create it
    public void createActivities(String activity, String device) throws Exception {
        String payload= "{\n" +
                "    \"version\": \"1.0\",\n" +
                "    \"gateway_id\": \""+device+"\",\n" +
                "    \"command\": \"activate-thing\",\n" +
                "    \"parameters\": {\n" +
                "        \"device_type\": \"epiSensor\",\n" +
                "        \"interaction_mode\": \"gateway\",\n" +
                "        \"authentication_mode\": \"gateway\",\n" +
                "        \"radio_type\": \"Eth\",\n" +
                "        \"filter_tag\": [\n" +
                "            {\n" +
                "                \"tag\": \""+device+"\",\n" +
                "                \"id\": 2000,\n" +
                "                \"period\": 60\n" +
                "            },\n" +
                "            {\n" +
                "                \"tag\": \"CommunicationCode\",\n" +
                "                \"trendType\": \"CommCodeValue\",\n" +
                "                \"id\": 2001,\n" +
                "                \"period\": 60\n" +
                "            }\n" +
                "        ],\n" +
                "        \"inbound_communication_modes\": [\n" +
                "            \"shadow\",\n" +
                "            \"topic\"\n" +
                "        ],\n" +
                "        \"outbound_communication_modes\": \"shadow\",\n" +
                "        \"serial_number\": \"000D6F000D7EF1F8\",\n" +
                "        \"model\": \"ZDR\",\n" +
                "        \"maker\": \"EPISENSOR\"\n" +
                "    }\n" +
                "}";
        String locator = "(//td[contains(., '%s')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']";
        String iconToClick = String.format(locator, activity);
        PageElement pe = UtilFunctions.createNewPageElement("icon delete activity device"+activity, iconToClick);
        boolean present = pe.isPresent();
        if (!present) {
            //Assert.assertTrue(pe.tryClick(), "Unable to click the element");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "newActivityButton");
            //CommonSteps.cancelStringFromElement("ActivitiesPage", "activityDescriptionInput");
            CommonSteps.fillInputBox(activity , "ActivitiesPage", "activityIdInputLabel");
            PageElement elem = ReflectionUtils.getPageElementByString("ActivitiesPage", "activityDescriptionInput");
            waitForElementLocatedBy(elem.getBy(), 60);
            waitForElementLocatedByXpath("//textarea");
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.CONTROL+"a");
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.BACK_SPACE);
            // CommonPage.getDriver().findElement(By.xpath("//textarea")).clear();
            Thread.sleep(1000);
            CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(payload);
            System.out.println();
            CommonSteps.checkAndClickElementPresent("ActivitiesPage", "confirmNewActivityButton");

            CommonSteps.checkAndClickElementPresent("ActivitiesPage", "toastMessageClose");
        }
    }
}
