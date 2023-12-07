package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import test.pages.MqttClientPage;

import java.io.IOException;
import java.util.List;

public class MqttClientSteps {

    String topic;

    @And("I verify the DDM contains these elements")
    public void iVerifyThatTheTableContainsTheseColumns(List elements) throws Exception {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertTrue(CommonPage.getDriver().findElements(MqttClientPage.getDDMOptions().getBy()).get(i).getText().equalsIgnoreCase(elements.get(i).toString()), elements.get(i) + " not found.");
        }
    }

    @Then("I verify that DDM contains only one option {string}")
    public void iVerifyThatDDMContainsOnlyOneOption(String option) throws Exception {
        Thread.sleep(2000);
        int size = 0;
        List<WebElement> we = CommonPage.getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
        if(we!= null && !we.isEmpty()){
            size = we.size();
            Assert.assertEquals(we.size(), 1, "The size of the elements retrieved is greater than one");
            Assert.assertTrue(we.get(0).getText().equalsIgnoreCase(option), "The option retrieved is not the expected. ");
        }
    }

    @Then("I verify that DDM contains these options")
    public void iVerifyThatDDMContainsTheseOptions(List elements) throws Exception {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertTrue(CommonPage.getDriver().findElements(MqttClientPage.getDDMOptions().getBy()).get(i).getText().contains(elements.get(i).toString()), elements.get(i) + " not found.");
        }

    }

    @Then("I enter the topic in the input field")
    public void iEnterTheTopicInTheInputField() {
        String[]  topicString = CommonPage.getDriver().findElement(MqttClientPage.getTopic().getBy()).getText().split(" ");
        int size = topicString.length;
        topic= topicString[size-1];
        CommonPage.getDriver().findElement(MqttClientPage.getInputField().getBy()).clear();
        CommonPage.getDriver().findElement(MqttClientPage.getInputField().getBy()).sendKeys(topic);
    }

    @And("I should see only the provided topic")
    public void iShouldSeeOnlyTheProvidedTopic() {
        Assert.assertEquals(CommonPage.getDriver().findElements(MqttClientPage.getTopic().getBy()).size(), 1);
        String[] parseDmcTopic = CommonPage.getDriver().findElement(MqttClientPage.getTopic().getBy()).getText().split("> ");
        Assert.assertEquals(parseDmcTopic[1], topic);
    }
    @And("I verify that each topic contains at least one occurence of the keyword \"(.+)\"")
    public void iVerifyThatEachTopicContainsAtLeastOneOccurenceOfTheKeyword(String keyword) throws InterruptedException {
        List<WebElement> accordeonsList = CommonPage.getDriver().findElements(MqttClientPage.getTopicAccordeon().getBy());
        PageElement pe = null;
        for(int i = 0; i<accordeonsList.size(); i++){
            accordeonsList.get(i).click();
            String locator = String.format("(//strong[contains(., '%s') and @class='dmc-foundText'])[%s]", keyword, i+1);
            Thread.sleep(1000);
            pe = UtilFunctions.createNewPageElement("text to retrieve", locator);
            Assert.assertTrue(pe.isPresent(), "Unable to locate the Element: "+pe.getBy());
//            Assert.assertTrue(accordeonsList.get(i).findElement(By.xpath("//*[contains(text(), '" + keyword + "')]")).isDisplayed(), "keyword not found");
        }
    }
    @And("I verify that each occurrence contains the provided topic")
    public void iVerifyThatEachOccurenceContainsTheProvidedTopic() throws InterruptedException {
        String[] parseDmcTopic = CommonPage.getDriver().findElement(MqttClientPage.getTopic().getBy()).getText().split("> ");
        System.out.println("parseDmcTopic: "+ parseDmcTopic);
        for(int i = 0; i<=parseDmcTopic.length; i++){
            Assert.assertEquals(parseDmcTopic[1], topic);
        }
    }

    @Then("I enter the telemetry topic in the input field")
    public void iEnterThetelemtryTopicInTheInputField() {
        //String[]  topicString = CommonPage.getDriver().findElement(MqttClientPage.getTelemetryTopicVeigHA().getBy()).getText().split(" ");
        String[]  topicString = CommonPage.getDriver().findElement(MqttClientPage.getTelemetryTopic().getBy()).getText().split(" ");
        int size = topicString.length;
        topic= topicString[size-1];
        CommonPage.getDriver().findElement(MqttClientPage.getInputField().getBy()).clear();
        CommonPage.getDriver().findElement(MqttClientPage.getInputField().getBy()).sendKeys(topic);
    }

    @Then("I check that the string \"(.+)\" is correctly showed as hint")
    public static void checkTheHint(String text) throws InterruptedException {
        Thread.sleep(2000);
        String locator = String.format("//span[@class='mat-option-text']/div[contains(.,'%s')]", text);
        PageElement pe = UtilFunctions.createNewPageElement("hint dropdownmenu", locator);
        Assert.assertTrue(pe.isPresent(), "unable to find the suggestion with text: "+text);
    }
    @Then("I check that the MqttClient Page is correctly translated in italian")
    public static void checkDEploymentHistoryPageTranslation21() throws IOException, InterruptedException {
        String tree[] = new String[]{"controlRoom"};
        String[] tree_mqtt = new String[]{"controlRoom", "mqtt"};

        //CommonSteps.jsonReader(null, "Back", UtilFunctions.createNewPageElement("back btn", "//button[contains(.,'Indietro')]").getText().trim(), null);
        CommonSteps.jsonReader(tree,"diagnostic", UtilFunctions.createNewPageElement("landing page title", "//span[contains(.,'Diagnostica')]").getText().trim().replace("/",""), null );
        CommonSteps.jsonReader(tree,"mqttClient", UtilFunctions.createNewPageElement("landing page title", "//h2[contains(.,' Interfaccia Mqtt')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_mqtt,"searchPlaceholder", UtilFunctions.createNewPageElement("Search box at the top right", "//input[@type='search' and @placeholder='Trova nel payload']").getAttribute("placeholder").trim(), null );
        CommonSteps.jsonReader(tree,"typeTopic", UtilFunctions.createNewPageElement("text written in the page", "//label[contains(.,'INSERISCI UN TOPIC (UNO TRA DEVICES/REGISTRATION, DEVICES/MONITORING, <ENV_PREFIX>/...)')]").getText().trim(), null );
        CommonSteps.jsonReader(tree_mqtt,"clickPlay", UtilFunctions.createNewPageElement("landing page title", "//p[contains(.,' Premi il tasto PLAY per connetterti')]").getText().trim(), null );

  }
}
