package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.ActivitiesPage;
import test.pages.DevicesPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static test.steps.CommonSteps.*;

public class ActivitiesSteps {
    @And("^I cancel the text from the text area (\\w+).(\\w+)$")
    public void iCanceltext( String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.CONTROL+"a");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.BACK_SPACE);
        System.out.println();

    }

    @And("^I input the payload into (\\w+).(\\w+)$")
    public void iInputPayload(String classname, String fieldname, String payload) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.CONTROL+"a");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.BACK_SPACE);
        // CommonPage.getDriver().findElement(By.xpath("//textarea")).clear();
        Thread.sleep(1000);
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(payload);
        System.out.println();
    }
    @And("^I compare the payload (\\w+).(\\w+)$")
    public void iChecktext(String classname, String fieldname, String payload) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        waitForElementLocatedByXpath("//textarea");
        String message = CommonPage.getDriver().findElement(By.xpath("//div[@class = 'ace_layer ace_text-layer']")).getText();
        Thread.sleep(1000);
        assertEquals(payload.trim(),message.trim(), "The payload of the activity is not saved after editing the payload");
        System.out.println();

    }
    @And("I check the icon in the last column of the activity list table")
    public void iCheckTheContentOfTargetNameColumn() {

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        PageElement pe = null;
        for (int i = 1; i <= rows.size(); i++) {
      /*      Assert.assertNotNull(CommonPage.getDriver().findElement(By.xpath("//tr[" +i+ "]//i[contains(@class, 'dmc-icon__play')]")));
            Assert.assertNotNull(CommonPage.getDriver().findElement(By.xpath("//tr[" +i+ "]//i[contains(@class, 'dmc-icon__copy')]")));
            Assert.assertNotNull(CommonPage.getDriver().findElement(By.xpath("//tr[" +i+ "]//i[contains(@class, 'dmc-icon__pencil')]")));
            Assert.assertNotNull(CommonPage.getDriver().findElement(By.xpath("//tr[" +i+ "]//i[contains(@class, 'dmc-icon__trash')]")));*/

            pe = UtilFunctions.createNewPageElement("row "+i +"into the table icon delete", "//tr[" +i+ "]//i[contains(@class, 'dmc-icon__trash')]");
            Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            pe = UtilFunctions.createNewPageElement("row "+i +"into the table icon play", "//tr[" +i+ "]//i[contains(@class, 'dmc-icon__play')]");
            Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            pe = UtilFunctions.createNewPageElement("row "+i +"into the table icon edit", "//tr[" +i+ "]//i[contains(@class, 'dmc-icon__pencil')]");
            Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
            pe = UtilFunctions.createNewPageElement("row "+i +"into the table icon copy", "//tr[" +i+ "]//i[contains(@class, 'dmc-icon__copy')]");
            Assert.assertTrue(pe.isPresent(), "The Element "+pe+" is not present");
        }
        }

    @Then("I check the number of rows present in the table")
    public void iCheckIfTheNumberOfRowsPresentInTheTable() throws Exception {

        /*int numberOfPagination = Integer.parseInt(DevicesPage.getPaginationTableButton().getText());
        String counterPagesTable = DevicesPage.getPagesCounter().getText();

        boolean flag = false;

        try {
            PageElement pe = UtilFunctions.createNewPageElement("All rows present in the table", "//i[@class='dmc-icon__document dmc-icon']");
            pe.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No rows showed in 20 sec");
        }*/

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//i[@class='dmc-icon__document dmc-icon']"));

//        Assert.assertEquals(numberOfPagination, rows.size(), "The rows present in the table do not correspond to the correct visualization");

        for (int i = rows.size(); i < 6; i++) {
            //Assert.fail("The rows present in the table do not correspond to the correct visualization");
            System.out.println("Records nella tabella= "+i);
            String activityId = "test2813_"+i;
            System.out.println(activityId);
            PageElement pe = UtilFunctions.createNewPageElement("New Activity Button", "//i[@class='dmc-icon__plus dmc-icon ng-star-inserted']");
            Assert.assertTrue(pe.tryClick(), "Cannot click new activity button");
            Thread.sleep(2000);
            PageElement elem = UtilFunctions.createNewPageElement("ActivityID add activity input label", "//input[@name = 'activityId']");
            CommonPage.getDriver().findElement(elem.getBy()).sendKeys(activityId);
            Thread.sleep(2000);

            iInputPayload("ActivitiesPage", "activityDescriptionInput","{\n" +
                    "    \"version\": \"1.0\",\n" +
                    "    \"gateway_id\": \"Test_Concept-01\",\n" +
                    "    \"command\": \"activate-thing\",\n" +
                    "    \"parameters\": {\n" +
                    "        \"device_type\": \"epiSensor\",\n" +
                    "        \"interaction_mode\": \"gateway\",\n" +
                    "        \"authentication_mode\": \"gateway\",\n" +
                    "        \"radio_type\": \"Eth\",\n" +
                    "        \"filter_tag\": [\n" +
                    "            {\n" +
                    "                \"tag\": \"Test\",\n" +
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
                    "}");
            Thread.sleep(2000);
            PageElement elem2 = UtilFunctions.createNewPageElement("Confirm add new activity button", "//button[text()=' Confirm ']");
            Assert.assertTrue(elem2.tryClick(), "Cannot click element confirm add new activity");
            Thread.sleep(2000);
            PageElement elem3 = UtilFunctions.createNewPageElement("Remove confirmation Delete button", "//button[@class='-dismiss']");
            Assert.assertTrue(elem3.tryClick(), "Cannot click toast message close");
        }
    }
}