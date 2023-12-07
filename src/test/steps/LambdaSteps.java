package test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.Util;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.LambdasPage;
import test.pages.StepFunctionPage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Util.UtilFunctions;

public class LambdaSteps {
    @And("I verify that the table contains these columns")
    public void iVerifyThatTheTableContainsTheseColumns(List elements) throws Exception {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(CommonPage.getDriver().findElements(LambdasPage.getTableHeaders().getBy()).get(i).getText(), elements.get(i), elements.get(i) + " not found.");
        }
    }

    /**
     * @param className
     * @param fieldName
     * @throws Exception
     */
    @Then("^I verify that Type column contains (\\w+).(\\w+) icon$")
    public void iVerifyThatColumnContainsWIcon(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        PageElement pagination = ReflectionUtils.getPageElementByString("LambdasPage","pagination");
        //while next page arrow is enabled
        do {
            //Check the column type for all rows
            List<WebElement> tableRows = CommonPage.getDriver().findElements(By.xpath("//table//tr[@class='ng-star-inserted']"));
            for (int i = 0; i < tableRows.size(); i++) {
                WebElement rowElement = CommonPage.getDriver().findElement(By.xpath("(//table//tr[@class='ng-star-inserted'])[" + (i +1) + "]//td" + elem.getCustomBy().getByString()));
                Assert.assertTrue(rowElement.isDisplayed(), fieldName + " not found");
            }
            if(LambdasPage.getNextPageEnabled().isVisible()){
                LambdasPage.getNextPageEnabled().click();
            }
        } while (LambdasPage.getNextPageEnabled().isVisible());
        pagination.scrollTo();
        UtilFunctions.addScreenshot("Bottom of table");
    }

    @And("that the table is not empty")
    public void thatTheTableIsNotEmpty() {
        List<WebElement> logRows = CommonPage.getDriver().findElements(By.cssSelector("mat-accordion mat-expansion-panel.ng-star-inserted"));
        Assert.assertTrue(logRows.size()>0, "Log is empty");
    }

    @And("I display {int} rows per page")
    public void iDisplayRowsPerPage(int arg0) {
        Assert.assertTrue(LambdasPage.getPagination().tryClick(), "Unable to click on pagination element");
        Assert.assertTrue(LambdasPage.getHundredRowsOption().tryClick(), "Unable to click on the rows option");
        Util.Wait(1000);
    }

    @Then("^(\\w+).(\\w+) should be displayed$")
    public void wWShouldBeW(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.isVisible(), elem.getDescription() + " is not displayed");
    }

    @And("I set filters")
    public void iSetFilters() throws InterruptedException {
        String commandType= CommonPage.getDriver().findElement(By.xpath("(//tr//td)[7]")).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDate date= LocalDate.parse(CommonPage.getDriver().findElement(By.xpath("(//tr//td)[8]")).getText(), formatter);
        String status=CommonPage.getDriver().findElement(By.xpath("(//tr//td)[9]")).getText();

        Assert.assertTrue(LambdasPage.getFiltersCommandExpandArrow().tryClick());
        CommonPage.getDriver().findElement(By.xpath("//div[@class='dmc-option-label' and contains(text(),'" + commandType + "')]")).click();
        CommonPage.getDriver().findElement(By.xpath("//div[@id='dmc-affix-safenet']")).click();
        UtilFunctions.addScreenshot("set command filter");

        Assert.assertTrue(LambdasPage.getFiltersStatusExpandArrow().tryClick());
        CommonPage.getDriver().findElement(By.xpath("//div[@class='dmc-option-label' and contains(text(),'" + status + "')]")).click();
        CommonPage.getDriver().findElement(By.xpath("//div[@id='dmc-affix-safenet']")).click();
        UtilFunctions.addScreenshot("set status filter");

        Assert.assertTrue(LambdasPage.getFiltersCreationDateExpandArrow().tryClick());
        String monthAndYearFrom=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[1]")).getText();
        if(!monthAndYearFrom.contains(String.valueOf(date.getYear()))){
            String year = monthAndYearFrom.split(" ")[1];

            while(year.compareTo(String.valueOf(date.getYear()))!=0){
                CommonPage.getDriver().findElement(By.xpath("(//i[@class='dmc-icon__chevron-left dmc-icon'])[1]")).click();
                Thread.sleep(1000);
                monthAndYearFrom=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[1]")).getText();
                year = monthAndYearFrom.split(" ")[1];
            }
            Thread.sleep(1000);
        }
        if(!monthAndYearFrom.contains(date.getMonth().name())){
            String month = monthAndYearFrom.split(" ")[0];

            while(month.compareTo(date.getMonth().name())!=0){
                CommonPage.getDriver().findElement(By.xpath("(//i[@class='dmc-icon__chevron-left dmc-icon'])[1]")).click();
                Thread.sleep(1000);
                monthAndYearFrom=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[1]")).getText();
                month = monthAndYearFrom.split(" ")[0];
            }
            Thread.sleep(1000);
        }
        CommonPage.getDriver().findElement(By.xpath("(//div[@class='-days'])[1]//div[contains(@class,'-day') and not(contains(@class,'--disabled')) and text()=' " +  date.getDayOfMonth() +" ']")).click();
        UtilFunctions.addScreenshot("set Date From");
        CommonPage.getDriver().findElement(By.xpath("//div[@class='-tab ng-star-inserted']")).click();
        Util.Wait(1000);
        String monthAndYearTo=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[2]")).getText();
        if(!monthAndYearTo.contains(String.valueOf(date.getYear()))){
            String year = monthAndYearTo.split(" ")[1];

            while(year.compareTo(String.valueOf(date.getYear()))!=0){
                CommonPage.getDriver().findElement(By.xpath("(//i[@class='dmc-icon__chevron-left dmc-icon'])[2]")).click();
                Thread.sleep(1000);
                monthAndYearTo=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[2]")).getText();
                year = monthAndYearFrom.split(" ")[1];
            }
            Thread.sleep(1000);
        }
        if(!monthAndYearTo.contains(date.getMonth().name())){
            String month = monthAndYearTo.split(" ")[0];

            while(month.compareTo(date.getMonth().name())!=0){
                CommonPage.getDriver().findElement(By.xpath("(//i[@class='dmc-icon__chevron-left dmc-icon'])[2]")).click();
                Thread.sleep(1000);
                monthAndYearTo=CommonPage.getDriver().findElement(By.xpath("(//div[@class='-current'])[2]")).getText();
                month = monthAndYearTo.split(" ")[0];
            }
            Thread.sleep(1000);
        }

        CommonPage.getDriver().findElement(By.xpath("(//div[@class='-days'])[2]//div[contains(@class,'-day') and not(contains(@class,'--disabled')) and text()=' " +  date.getDayOfMonth() +" ']")).click();
        UtilFunctions.addScreenshot("set Date To");
        CommonPage.getDriver().findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();

        Assert.assertTrue(LambdasPage.getConfirmButton().isPresent(), "Unable to locate the confirm Button in the Filter box");
        Assert.assertTrue(LambdasPage.getConfirmButton().tryClick(), "Unable to click the Confirm button in the filter box");

        CommonSteps.waitProgressBar();
        List<WebElement> tableRows = CommonPage.getDriver().findElements(StepFunctionPage.getTableRows().getBy());

        for(int i=1; i<=tableRows.size(); i++){
            String commandTypeData = CommonPage.getDriver().findElement(By.xpath("(//dmc-table//tbody//tr)["+ i+"]//td[7]")).getText();
            Assert.assertTrue(commandTypeData.equalsIgnoreCase(commandType));
            String creationDateData = CommonPage.getDriver().findElement(By.xpath("(//dmc-table//tbody//tr)[" + i +"]//td[8]")).getText().split(" ")[0];
            String dateString = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            Assert.assertTrue(creationDateData.equalsIgnoreCase(dateString));
            String statusData = CommonPage.getDriver().findElement(By.xpath("(//dmc-table//tbody//tr)[" + i +"]//td[9]")).getText();
            Assert.assertTrue(statusData.equalsIgnoreCase(status));
        }
    }

    @And("I should see filters reset")
    public void iShouldSeeFiltersReset() {
        Assert.assertTrue(CommonPage.getDriver().findElement(By.xpath("//dmc-form-field-label[contains(text(),'Command')]/following-sibling::*//div[@class='dmc-facade-label' and text()=' Select options... ']")).isDisplayed(), "Unable to find Command field cleared");
        Assert.assertTrue(CommonPage.getDriver().findElement(By.xpath("//dmc-form-field-label[contains(text(),'Status')]/following-sibling::*//div[@class='dmc-facade-label' and text()=' Select options... ']")).isDisplayed(), "Unable to find Status field cleared");
        Assert.assertTrue(CommonPage.getDriver().findElement(By.xpath("//dmc-form-field-label[contains(text(),'Creation date')]/following-sibling::*//div[@class='-input' and contains(text(),' Select datetimes... ')]")).isDisplayed(), "Unable to find Creation date field cleared");

    }

    @Then("I verify that each row contains details buttons and delete buttons")
    public void iVerifyThatEachRowContainsDeleteButtonAndInProgressButtonWhereItIsNecessary() {
            List<WebElement> tableRows = CommonPage.getDriver().findElements(StepFunctionPage.getTableRows().getBy());

            //Check the column action for all rows
            for (int i = 0; i < tableRows.size(); i++) {
                System.out.println("row: " + i);
                String deleteIcon = tableRows.get(i).findElement(By.xpath("(//td)[11]//i[@class='dmc-icon__trash dmc-icon']/ancestor::dmc-table-action")).getAttribute("class");
                Assert.assertTrue(tableRows.get(i).findElement(By.xpath("(//td)[11]//i[@class='dmc-icon__document dmc-icon']")).isEnabled(), "Details button is not clickable or visible");
                if(tableRows.get(i).findElement(By.xpath("(//td)[9]//span")).getText().contains("PROGRESS")){
                    Assert.assertFalse(deleteIcon.contains("--disabled"), "Delete button is not clickable");
                } else {
                    Assert.assertTrue(deleteIcon.contains("--disabled"), "Delete button is clickable");
                }
            }

    }

    @And("I verify the details displayed")
    public void iVerifyTheDetailsDisplayed() {
        List<WebElement> sectionKeys = CommonPage.getDriver().findElements(LambdasPage.getSectionSegmentKey().getBy());
        int sectionKeysSize = sectionKeys.size();
        List<WebElement> sectionValues = CommonPage.getDriver().findElements(LambdasPage.getSectionSegmentValue().getBy());
        int sectionValuesSize = sectionValues.size();
        Assert.assertEquals(sectionKeys.get(0).getText(), "status");
        Assert.assertNotNull(sectionValues.get(0).getText());
        Assert.assertEquals(sectionKeys.get(1).getText(), "timestamp_created");
        Assert.assertNotNull(sectionValues.get(1).getText());
        Assert.assertEquals(sectionKeys.get(2).getText(), "notification_type");
        Assert.assertNotNull(sectionValues.get(2).getText());
        Assert.assertEquals(sectionKeys.get(3).getText(), "project_id");
        Assert.assertNotNull(sectionValues.get(3).getText());
        Assert.assertEquals(sectionKeys.get(4).getText(), "device_id");
        Assert.assertNotNull(sectionValues.get(4).getText());
        Assert.assertEquals(sectionKeys.get(5).getText(), "command");
        Assert.assertNotNull(sectionValues.get(5).getText());
        Assert.assertEquals(sectionKeys.get(6).getText(), "status_details");
        /*Assert.assertEquals(sectionKeys.get(sectionKeysSize-3).getText(), "timestamp_completed");
        Assert.assertNotNull(sectionValues.get(sectionValuesSize-3).getText());
        Assert.assertEquals(sectionKeys.get(sectionKeysSize-2).getText(), "thing_arn");
        Assert.assertNotNull(sectionValues.get(sectionValuesSize-2).getText());
        Assert.assertEquals(sectionKeys.get(sectionKeysSize-1).getText(), "step_function_id");
        Assert.assertNotNull(sectionValues.get(sectionValuesSize-1).getText());*/
    }

    @Then("I check that the Lambda is correctly translated in italian")
    public static void checkTranslationLambdaPage() throws IOException {
        String [] tree = new String[]{"controlRoom"};
        String [] tree_lambdas = new String[]{"controlRoom","lambdas"};
        //checking tabs and logs landing page
        CommonSteps.jsonReader(tree_lambdas,"selectLambda", UtilFunctions.createNewPageElement("landing page select lambda", "//h2[contains(.,'Seleziona Lambda')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_lambdas,"selectLambda", UtilFunctions.createNewPageElement("text inside seacrh box", "//div[@class='-input' and text()=' Seleziona Lambda ']").getText().trim(), null );
        CommonSteps.jsonReader(tree,"execution", UtilFunctions.createNewPageElement("execution tab", "//div[@class='mat-tab-label-content' and contains (.,'Esecuzione')]").getText().trim(), null );
        //clicking on execution tab
        Assert.assertTrue(UtilFunctions.createNewPageElement("filter box", "//div[@class='mat-tab-label-content' and contains (.,'Esecuzione')]").tryClick(false, false), "Unable to click on execution tab ");
        CommonSteps.waitProgressBar();
        CommonSteps.jsonReader(tree_lambdas,"selectLambda", UtilFunctions.createNewPageElement("text inside seacrh box", "//div[@class='-input' and text()=' Seleziona Lambda ']").getText().trim(), null );
        CommonSteps.jsonReader(tree_lambdas,"selectLambda", UtilFunctions.createNewPageElement("landing page select lambda", "//h2[contains(.,'Seleziona Lambda')]").getText().trim(), null );
    }

}
