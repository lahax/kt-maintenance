package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.HomePage;
import test.pages.SidebarPage;

import java.io.IOException;

public class SidebarSteps {

    @Then("I check that the Sidebar is correctly translated")
    public void checkTranslationSidebar() throws IOException {
//        //*Check options not traduced*//
        SidebarPage.getHomeOption().isPresent();

        String [] tree  = new String[]{"controlRoom"};
        //*Check options*//
        CommonSteps.jsonReader(tree, "devices", SidebarPage.getDevicesOptionIT().getText(),null);
        CommonSteps.jsonReader(tree, "Activities", SidebarPage.getActivitiesOptionIT().getText(),null);
        CommonSteps.jsonReader(tree, "diagnostic", SidebarPage.getDiagnosticOptionIT().getText(),null);

        //*Check sub-options*//
        SidebarPage.getDiagnosticOptionIT().click();
        CommonSteps.jsonReader(tree, "Lambdas", SidebarPage.getLambdasSubOptionIT().getText(),null);
        SidebarPage.getMqttSubOption().isPresent();
        SidebarPage.getStepFunctionSubOption().isPresent();
        CommonSteps.jsonReader(tree, "amsTool", SidebarPage.getLoadCertificateSubOptionIT().getText(),null);
        SidebarPage.getApiInvocationSubOption().isPresent();
        UtilFunctions.addScreenshot("Dignostic section");
        SidebarPage.getDiagnosticDropDownOption().click();

        SidebarPage.getLogOption().isPresent();

        CommonSteps.jsonReader(tree, "Alarms", SidebarPage.getAlarmsOptionIT().getText(),null);

        CommonSteps.jsonReader(tree, "softwareManager", SidebarPage.getSoftwareManagerOptionIT().getText(),null);

        SidebarPage.getSoftwareManagerOptionIT().click();
        CommonSteps.jsonReader(tree, "softwareCatalogue", SidebarPage.getSoftwareCatalogueOptionIT().getText(),null);
        CommonSteps.jsonReader(tree, "deploymentsHistory", SidebarPage.getDeploymentsHistoryOptionIT().getText(),null);
        CommonSteps.jsonReader(tree, "campaignManagement", SidebarPage.getCampaignManagementOptionIT().getText(),null);
        UtilFunctions.addScreenshot("Software Manager section");
        SidebarPage.getSoftwareManagerDropDownOption().click();

        SidebarPage.getRdeOption().isPresent();
        CommonSteps.jsonReader(tree, "e2eMonitoring", SidebarPage.getE2eMonitoringOptionIT().getText(),null);
        String [] tree_e2e  = new String[]{"controlRoom", "e2em"};

        SidebarPage.getE2eMonitoringOptionIT().click();
        SidebarPage.getDeviceAlarmsConfigurationSubOptionIT().isPresent();
        CommonSteps.jsonReader(tree_e2e, "devicesConfigurations", SidebarPage.getDeviceAlarmsConfigurationSubOptionIT().getText(),null);
        CommonSteps.jsonReader(tree_e2e, "notificationsConfigurations", SidebarPage.getNotificationsConfigurationSubOptionIT().getText(),null);
        CommonSteps.jsonReader(tree, "customGroups", SidebarPage.getCustomGroupsSubOptionIT().getText(),null);
        UtilFunctions.addScreenshot("E2E Monitoring section");
        SidebarPage.getE2eMonitoringDropDownOption().click();

//        CommonSteps.jsonReader(tree, "usageStatistics", SidebarPage.getUsageStatisticOptionIT().getText(),null);

        String [] tree_tickets  = new String[]{"controlRoom", "incidents"};
        CommonSteps.jsonReader(tree_tickets, "ticketsManagement", SidebarPage.getTicketsManagementOptionIT().getText(),null);

        CommonSteps.jsonReader(tree, "trendIdRegistry", SidebarPage.getTrendIdRegistryOptionIT().getText(),null);


    }

    @Then("^If (\\w+).(\\w+) Element is not visible I click on E2E Monitoring option$")
    public void openE2Eif(String className, String fieldName) throws Exception {
        Thread.sleep(1000);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(elem.isClickable()){
            elem.scrollTo();
            Assert.assertTrue(elem.isPresent(20), "The element " + fieldName + " is not present in the page " + className);
            Assert.assertTrue(elem.tryClick(true, false), "The element " + fieldName + " is not clickable");
            Thread.sleep(500);
        }
        else{
            PageElement e2eOption = ReflectionUtils.getPageElementByString("SidebarPage", "e2eMonitoringOption");
            if(e2eOption.isPresent()){
                e2eOption.scrollTo();
                Assert.assertTrue(e2eOption.isPresent(20), "The element " + "e2eMonitoringOption" + " is not present in the page " + "SidebarPage");
                Assert.assertTrue(e2eOption.tryClick(true, false), "The element " + "e2eMonitoringOption" + " is not clickable");
                Thread.sleep(500);
            }
            if(elem.isClickable()){
                elem.scrollTo();
                Assert.assertTrue(elem.isPresent(20), "The element " + fieldName + " is not present in the page " + className);
                Assert.assertTrue(elem.tryClick(true, false), "The element " + fieldName + " is not clickable");
                Thread.sleep(500);
            }
        }
    }


}
