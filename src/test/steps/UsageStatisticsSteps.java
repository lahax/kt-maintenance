package test.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import test.pages.ActivitiesPage;
import test.pages.UsageStatisticsPage;

import java.io.IOException;
import java.util.List;

public class UsageStatisticsSteps {

    @Then("I check that the Usage Statistics page is correctly translated in italian")
    public static void checkTranslationUsageStatisticsPage() throws IOException {
        String [] tree_landing = new String[]{"controlRoom", "landingPage"};
        String[] tree_select = new String[]{"components", "multiSelect"};

        CommonSteps.jsonReader(null, "tap a column", UsageStatisticsPage.getGraphDescriptionTextIT().getText(), null);
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths6", UsageStatisticsPage.getUsageStatisticsSixMonthsOptionsIT().getText(), null);
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths3", UsageStatisticsPage.getUsageStatisticsThreeMonthsOptionsIT().getText(), null);
        CommonSteps.jsonReader(tree_select, "defaultLabel", UsageStatisticsPage.getUsageStatisticsSelectOptionsIT().getText(), null);
    }

    @Then("I check if the graph show \"(.+)\" month as expected")
    public static void checkNumberOfMonthShowed(String num) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> months = CommonPage.getDriver().findElements(UsageStatisticsPage.getNumberOfabscissa().getBy());
        if(months!= null && !months.isEmpty()){
            Assert.assertEquals(months.size(), Integer.parseInt(num), "The number of the month showed are different.");
        }else{
            Assert.fail("unable to retrieve the absissa elements");
        }
    }
}
