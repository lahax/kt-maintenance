package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.pages.CustomGroupsPage;
import test.pages.TicketsManagementPage;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TicketsManagementSteps {

    @Then("I check that the page Tickets Management is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage() throws IOException {
//        System.out.println(TicketsManagementPage.getSelectDateTimeInFilters());
        String [] tree  = new String[]{"controlRoom"};
        String [] tree_incidents = new String[]{"controlRoom", "incidents"};
//        String [] tree_selectDate = new String[]{"components", "select", "date-range-picker"};
        String [] tree_reset = new String[]{"components", "table"};

        CommonSteps.jsonReader(tree, "filters", TicketsManagementPage.getFilterBox().getText(),null);
        //Open filters box
        TicketsManagementPage.getFilterBox().click();
        CommonSteps.jsonReader(tree_incidents, "tsCreated", TicketsManagementPage.getTimeStampCreatedInFilters().getText(),null);
//        CommonSteps.jsonReader(tree, "tree_selectDate", TicketsManagementPage.getSelectDateTimeInFilters().getText().replaceAll("[\\-\\+\\.\\^:,]",""),null);
        CommonSteps.jsonReader(tree, "confirm", TicketsManagementPage.getConfirmInFilters().getText(),null);
        CommonSteps.jsonReader(tree, "reset", TicketsManagementPage.getClearInFilters().getText(),null);
        //Close filter box
        TicketsManagementPage.getFilterBox().click();
        //Check table
        CommonSteps.jsonReader(tree_incidents, "ticketsManagement", TicketsManagementPage.getticketsManagementLandingPageTitleIT().getText(),null);
        CommonSteps.jsonReader(tree_incidents, "number", TicketsManagementPage.getTicketsManagementIncidentNumberColumnIT().getText().replaceAll("[\\-\\+\\.\\^:,]",""),null);
        CommonSteps.jsonReader(tree_incidents, "tsCreated", TicketsManagementPage.getTicketsManagementTimestampCreatedColumnIT().getText(),null);
        CommonSteps.jsonReader(tree_incidents, "userId", TicketsManagementPage.getTicketsManagementUserIdColumnIT().getText(),null);
        CommonSteps.jsonReader(tree_incidents, "targetName", TicketsManagementPage.getTicketsManagementTargetNameColumnIT().getText(),null);
        //Open the column actions
        TicketsManagementPage.getSelectColumnsIcon().click();
        CommonSteps.jsonReader(tree_incidents, "number", TicketsManagementPage.getSelectIncidentNumberIT().getText().replaceAll("[\\-\\+\\.\\^:,]",""),null);
        CommonSteps.jsonReader(tree_incidents, "tsCreated", TicketsManagementPage.getSelectTimestampCreatedIT().getText(),null);
        CommonSteps.jsonReader(tree_incidents, "userId", TicketsManagementPage.getSelectUserIdIT().getText(),null);
        CommonSteps.jsonReader(tree_incidents, "targetName", TicketsManagementPage.getSelectTargetNameIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", TicketsManagementPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", TicketsManagementPage.getCloseColumnsBTN().getText(),null);
        //Close the column actions
        TicketsManagementPage.getCloseColumnsBTN().click();


    }

    @Then("I check there is at least one detail info for the selected ticket")
    public static void checkTableRow(){
        List<WebElement> detailTitles = CommonPage.getDriver().findElements(By.xpath("//label[contains(@class, 'subtext')]"));
        if(detailTitles== null || detailTitles.isEmpty()){
            Assert.fail("No detail tiles info for the ticket");
        }
    }

    public boolean checkIfDateBetweenTodayAndOneMonth(@NotNull String event_check)  throws Exception{
        LocalDateTime currentDate = LocalDateTime.now();
//        System.out.println(currentDate); // 2021-09-01T10:08:55.568
        LocalDateTime previousDay = currentDate.minusMonths(2).withDayOfMonth(1);
//        System.out.println(previousDay);  //2021-08-31T10:08:55.568
        String newsrt = event_check.replace("/", "-").replace(" ", "T");
        LocalDateTime event = LocalDateTime.parse(newsrt);
//        System.out.println(event);
        if (!event.isBefore(previousDay) && !event.isAfter(currentDate)) {
            return true;
        }
        else return false;
    }

    @And("I check if the DateTime filter works properly")
    public void iCheckIfTheFilterWorksForCalendar() throws Exception {
        new WebDriverWait(CommonPage.getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]")));
        ArrayList<WebElement> listSecondColumn = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath("//td[2]"));
        for (WebElement webElement : listSecondColumn) {
            String dateString = webElement.getText();
            Assert.assertTrue(checkIfDateBetweenTodayAndOneMonth(dateString), "Date found not valid:" + dateString);
        }
    }


}
