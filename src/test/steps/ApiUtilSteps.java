package test.steps;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ta.common.CommonEndpoint;
import ta.entities.ResponseEntity;
import ta.utilities.StepUtils;

import java.util.HashMap;
import java.util.Map;

public class ApiUtilSteps {

    private static Map<String, String> headers = new HashMap();
    private static ResponseEntity response;
    private static Object responseObject;

    public static String getResponseMessage() {
        return responseMessage;
    }

    public static void setResponseMessage(String responseMessage) {
        ApiUtilSteps.responseMessage = responseMessage;
    }

    private static String responseMessage;
    public static ResponseEntity getResponse() {
        return response;
    }

    public static void setResponse(ResponseEntity response) {
        ApiUtilSteps.response = response;
    }

    @Given("Header \"(.+)\"")
    public static void addHeader(String name) {
        String finalHeader = CommonSteps.getRetrievedToken();
        headers.put(name, "Bearer "+finalHeader);
    }

    @When("^I make a custom \"(GET|DELETE)\" request to (.+)")
    public static void call(String method, String url) throws Exception {
        String finalUrl = StepUtils.findFunctionAndReplace(url);
        response = CommonEndpoint.request(method, finalUrl, (Object)null, headers, true);
    }

    @When("^I make a custom \"(POST|PUT|PATCH)\" request to (.+) using")
    public static void callWithBody(String method, String url, String body) throws Exception {
        String finalUrl = StepUtils.findFunctionAndReplace(url);
        String finalBody = StepUtils.findFunctionAndReplace(body);
        response = CommonEndpoint.request(method, finalUrl, finalBody, headers, true);
    }

    @Then("^Status custom code should be (\\d+)$")
    public static void checkStatus(int requestedStatus) {
        Assert.assertEquals(response.getStatusCode(), requestedStatus, "Bad status code");
    }


    @Then("I check that the status {string} of device is align")
    public void iCheckThatTheStatusOfDevicesAreAlign(String status) {
        //Need api request before
        String response = ApiUtilSteps.getResponse().asString();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(response);

        JsonObject a = tree.getAsJsonObject();
        JsonArray b =  a.get("list_items").getAsJsonArray();
        JsonObject c =  b.get(0).getAsJsonObject();
        JsonObject d= (JsonObject) c.get("device_state");
        String state = d.get("state").getAsString();
        Assert.assertEquals(status, state, "the status of devices is not align on IoT platform");


    }
}
