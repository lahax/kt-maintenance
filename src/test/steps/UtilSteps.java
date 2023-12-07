package test.steps;

import Util.UtilFunctions;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.certificatemanager.model.InvalidArnException;
import com.amazonaws.services.certificatemanager.model.ResourceNotFoundException;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClient;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.sample.sampleUtil.SampleUtil;
import com.amazonaws.services.iot.model.*;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import main.java.MyTopic;
import org.testng.Assert;
import ta.entities.Util;
import ta.formatters.ReportFormatter;
import ta.utilities.Configuration;
import test.pages.APIInvocationPage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UtilSteps {

    private static AWSIotMqttClient client_sub;
    private static List<MyTopic> topics = new ArrayList<>();
    private static MyTopic topic1;

    private static MyTopic topic2;

    public static String getFingerprint() {
        return fingerprint;
    }

    public static void setFingerprint(String fingerprint) {
        UtilSteps.fingerprint = fingerprint;
    }

    private static String fingerprint;

    public static String getCertificateArn() {
        return certificateArn;
    }

    public static void setCertificateArn(String certificateArn) {
        UtilSteps.certificateArn = certificateArn;
    }

    private static String certificateArn;

    public static DescribeCertificateResult getResult() {
        return result;
    }

    public static void setResult(DescribeCertificateResult result) {
        UtilSteps.result = result;
    }

    private static DescribeCertificateResult result = null;

    public static DescribeThingResult getThingResult() {
        return resultThing;
    }

    public static void setThingResult(DescribeThingResult resultThing) {
        UtilSteps.resultThing = resultThing;
    }

    private static DescribeThingResult resultThing = null;

    public static AWSIot getClient() {
        return client;
    }

    public static void setClient(AWSIot client) {
        UtilSteps.client = client;
    }

    private static AWSIot client = null;

    @Then("I launch command {string} on shell.")
    public static void iLaunchCommandOnShell(String command) throws IOException {
        int count = 0;
        boolean isRetry = true;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));

        while (isRetry) {
            try {
                Process process = processBuilder.start();
                isRetry = readBuffer(process, "sending DISCONNECT");
                if (count > 2) {
                    isRetry = false;
                }
                count++;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Then("I Set the subscription on the topics below using the certificate \"(.+)\"")
    public static void subscription(String certificateID, List<String> topic) throws AWSIotException, InterruptedException {
        String clientEndpoint = "ax3v62h9b8tp2-ats.iot.eu-central-1.amazonaws.com";   // use value returned by describe-endpoint --endpoint-type "iot:Data-ATS"

        setCurrentCertificateID(certificateID);
        setCurrentTopics(topic);

        System.out.println("List of the topic to subscribe");
        for (String t : topic) {
            System.out.println(t);
        }
        // SampleUtil.java and its dependency PrivateKeyReader.java can be copied from the sample source code.
        // Alternatively, you could load key store directly from a file - see the example included in this README.
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair("./scripts/core_test_provisioning/certs/"+certificateID+".crt", "./scripts/core_test_provisioning/certs/"+certificateID+".key");
        Thread.sleep(3000);
        client_sub = new AWSIotMqttClient(clientEndpoint, certificateID, pair.keyStore, pair.keyPassword);

        Thread.sleep(5000);
        client_sub.connect();
        if(!topic.isEmpty()){
            for (String s : topic) {
                topics.add(new MyTopic(s, AWSIotQos.QOS0));
            }
        }

        for (MyTopic t : topics) {
            System.out.println(t);
        }

        Util.Wait(3000);
        for(MyTopic t: topics){
            client_sub.subscribe(t);
        }
        Util.Wait(3000);

        ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(topic.toString()));
    }

    @Then("I check the response is equal to the expected. Gateway \"(.+)\"")
    public static void response(String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        int elapsingTime = 60_000;
        for(MyTopic t: topics){
            Thread.sleep(5000);
            message = t.waitForMessageOnTopic(msg -> true, elapsingTime);
            if(message!=null) {
                System.out.println("!");
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));
            }
            else {
                Assert.fail("### --- Response is expected in " + elapsingTime/1000 + " seconds . No response received in " + elapsingTime*2/1000 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }

        String respToCompare = String.format(resp, device);
        assert message != null;
        Assert.assertEquals(message.getStringPayload().trim(), respToCompare.trim());
    }

    @Then("I check the response contains expected values and is received in (.+) seconds. Gateway \"(.+)\"")
    public static void responseInTimeParam(long maxTime, String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        for(MyTopic t: topics){
            message = t.waitForMessageOnTopic(msg -> true, maxTime * 1000L);
            if(message!=null) {
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));

                ResponseSteps expectedResponse = ResponseSteps.fromJson(resp, device);
                ResponseSteps actualResponse = ResponseSteps.fromJson(message.getStringPayload(), device);

                Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
                Assert.assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
                Assert.assertEquals(expectedResponse.getDeviceId(), actualResponse.getDeviceId());
            }else{
                Assert.fail("### --- Response is expected in " + maxTime + " seconds . No response received in " + maxTime*2 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }
    }

    @Then("I check the IoT Core response contains expected values and is received in (.+) seconds. Gateway \"(.+)\"")
    public static void responseIoTCore(long maxTime, String device, String resp) throws InterruptedException, JsonProcessingException {
        AWSIotMessage message = null;
        ObjectMapper mapper = new ObjectMapper();
        for(MyTopic t: topics){
            message = t.waitForMessageOnTopic(msg -> true, maxTime * 1000L);
            if(message!=null) {
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));

                ResponseSteps expectedResponse = ResponseSteps.fromJson(resp, device);
                ResponseSteps actualResponse = ResponseSteps.fromJson(message.getStringPayload(), device);

                JsonNode expectedJson = mapper.readTree(expectedResponse.toJson());
                JsonNode actualJson = mapper.readTree(actualResponse.toJson());

                JsonNode expectedStatusDetails = expectedJson.get("statusDetails");
                JsonNode actualStatusDetails = actualJson.get("statusDetails");

                Assert.assertEquals(expectedStatusDetails.get("environment_prefix").asText(),
                        actualStatusDetails.get("environment_prefix").asText());
                Assert.assertEquals(expectedStatusDetails.get("thing_id").asText(),
                        actualStatusDetails.get("thing_id").asText());
                Assert.assertEquals(expectedStatusDetails.get("thing_sw").asText(),
                        actualStatusDetails.get("thing_sw").asText());
            }else{
                Assert.fail("### --- Response is expected in " + maxTime + " seconds . No response received in " + maxTime*2 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }
    }

    @Then("I check the response")
    public static void howIsResponse() throws InterruptedException {
        AWSIotMessage message = null;
        int elapsingTime = 60_000;
        for(MyTopic t: topics){
            Thread.sleep(5000);
            message = t.waitForMessageOnTopic(msg -> true, elapsingTime);
            if(message!=null) {
                System.out.println("!");
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));
            }
            else {
                Assert.fail("### --- Response is expected in " + elapsingTime/1000 + " seconds . No response received in " + elapsingTime*2/1000 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }
    }

    @Then("I retrieve the fingerprint of the certificate from the retrieved API response")
    public static void apiResponse(){
        String resp = ApiUtilSteps.getResponseMessage();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(resp);
        JsonObject a = tree.getAsJsonObject();
        System.out.println(a);
        JsonArray b =  a.get("list_items").getAsJsonArray();
        JsonObject c =  b.get(0).getAsJsonObject();
        String fingerprint = c.get("certificate").getAsJsonObject().get("fingerprint").getAsString();
        setFingerprint(fingerprint);
    }

     @Then("I check the expiration date from AWS Iot Core")
    public static void checkExprationDateFromAws() throws ParseException {
         if(client == null){
             createClient();
         }
         makeDescribeCertificateResult(getClient());
         String expirationData = retrieveExpirationDate();

         SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
         Date d = sdf.parse(expirationData);
         sdf.applyPattern("dd/MM/yyyy");
         String newDateString = sdf.format(d);
         System.out.println(newDateString);
         Assert.assertEquals(newDateString, DevicesDetailsSteps.getExpirationDateRetrieved(), "The two date are different");
    }

    @Then("I check the expiration date of thing from AWS Iot Core")
    public static void checkExprationDateFromAwsThing() throws ParseException {
        if(client == null){
            createClient();
        }
        makeDescribeCertificateResult(getClient());
        String expirationData = retrieveExpirationDate();

        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date d = sdf.parse(expirationData);
        sdf.applyPattern("MM/dd/yyyy");
        String newDateString = sdf.format(d);
        System.out.println(newDateString);
        Assert.assertEquals(newDateString, DevicesDetailsSteps.getExpirationDateRetrieved(), "The two date are different");
    }

    @Then("I check the response is not received. Device \"(.+)\"")
    public static void responseNotReceived(String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        for(MyTopic t: topics){
           message = t.waitForNoMessageOnTopic(msg -> true, 30_000);
        }

        String respToCompare = String.format(resp, device);

        if(message != null){
            Assert.assertNotEquals(message.getStringPayload().trim(), respToCompare.trim(), "Message retrieved and equal.");
        }
    }

    @Then("I verify that the policies attached to the certificate are the same as the expected ones")
    public static void getPolicy(List<String> policies){
        if(client == null){
            createClient();
        }
        makeDescribeCertificateResult(getClient());
        retrieveCertificateArn();
        GetEffectivePoliciesRequest gepr = new GetEffectivePoliciesRequest().withPrincipal(getCertificateArn());
        GetEffectivePoliciesResult geprRes = getClient().getEffectivePolicies(gepr);
        System.out.println(geprRes);
        UtilFunctions.addScreenshot("Expected policies - "+policies.toString());
        UtilFunctions.addScreenshot("Retrieved AWS policies - "+ geprRes.getEffectivePolicies());
        String response = geprRes.getEffectivePolicies().toString();
        for (String policy : policies){
            if(!response.contains(policy)){
                Assert.fail(policy + " not found!");
            }
        }
    }

    public static AWSCredentials retrieveCredentials(){
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        }
        catch (Exception ex) {
            throw new AmazonClientException("Cannot load the credentials from file.", ex);
        }
        return credentials;
    }

    public static String retrieveExpirationDate(){
        String [] description = getResult().toString().split("NotAfter:");
        description = description[1].split("},");
        String expirationData = description[0].trim();
        return expirationData;
    }

    public static String retrieveCertificateArn(){
        String [] description = getResult().toString().split("CertificateArn:");
        description = description[1].split(",CertificateId");
        String certificateArn = description[0].trim();
        System.out.println(certificateArn);
        setCertificateArn(certificateArn);
        return certificateArn;
    }

    public static DescribeCertificateResult makeDescribeCertificateResult(AWSIot client){
        DescribeCertificateRequest req1 = new DescribeCertificateRequest();
        DescribeCertificateResult result = null;
        req1.setCertificateId(getFingerprint());
        try {
            result = client.describeCertificate(req1);
            setResult(result);
        } catch (InvalidArnException | ResourceNotFoundException ex) {
            throw ex;
        }
        return result;
    }

    public static DescribeCertificateResult makeDescribeCertificateResult(AWSIot client, String certificateID){
        DescribeCertificateRequest req1 = new DescribeCertificateRequest();
        DescribeCertificateResult result = null;
        req1.setCertificateId(certificateID);
        try {
            result = client.describeCertificate(req1);
            setResult(result);
        } catch (InvalidArnException | ResourceNotFoundException ex) {
            throw ex;
        }
        return result;
    }

    @And("I check {string} attributes from AWSIot")
    public void iCheckAttributesFromAWSIot(String thingName) {
        AWSIotClient client= (AWSIotClient) AWSIotClientBuilder.standard().build();
        DescribeThingRequest describeThingRequest = new DescribeThingRequest();
        describeThingRequest.setThingName(thingName);
        //System.out.println("Print 1: "+client.describeThing(describeThingRequest));
        //System.out.println("Print 2 :"+client.describeThing(describeThingRequest).getAttributes().get("authentication_mode"));
        Assert.assertEquals(client.describeThing(describeThingRequest).getAttributes().get("authentication_mode"), "gateway", "The checked field has incorrect value");
    }

    @Then("I create an AWSIot Client")
    public static void createClient(){
        setClient(AWSIotClient.builder().withRegion(Regions.EU_CENTRAL_1).withCredentials(new AWSStaticCredentialsProvider(retrieveCredentials())).build());
    }

    @Then("I retrieve the {string} and check that is equal to {string}")
    public static void apiResponseCheckField(String field, String expected_value) {
        String resp = ApiUtilSteps.getResponseMessage();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(resp);
        JsonObject a = tree.getAsJsonObject();
        System.out.println(a);
        JsonArray b = a.get("list_items").getAsJsonArray();
        JsonObject c = b.get(0).getAsJsonObject();
        String field_value = c.get(field).getAsString().toLowerCase();
        System.out.println(field_value);
        Assert.assertEquals(expected_value.toLowerCase(), field_value, "The checked field has incorrect value");
    }

    @Then("I retrieve the {string} and check that is equal to element {string}")
    public static void apiResponseCheckFieldElement(String field, String expected_value) {
        String resp = ApiUtilSteps.getResponseMessage();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(resp);
        JsonObject a = tree.getAsJsonObject();
        System.out.println(a);
        JsonArray b = a.get("list_items").getAsJsonArray();
        JsonObject c = b.get(0).getAsJsonObject();
        String field_value = c.get(field).getAsJsonArray().get(0).getAsString().toLowerCase();
        Assert.assertEquals(expected_value.toLowerCase(), field_value, "The checked field has incorrect value");
    }

    @Then("I verify that the status of the certificateID is \"(.+)\"")
    public static void checkTheStatusOfCertificateID(String status){
        createClient();
        String result =  makeDescribeCertificateResult(getClient(), getFingerprint()).toString();
        System.out.println(result);
        String [] resp = result.split("Status: ");
        resp = resp[1].split(",CertificatePem:");

        String retrievedStatus = resp[0].toLowerCase().trim();
        Assert.assertEquals(retrievedStatus, status.toLowerCase().trim(), "The retrieved status is different from the expected.");

    }
    public static DescribeThingResult makeDescribeThingResult(AWSIot client, String thing) {
        DescribeThingRequest req1 = new DescribeThingRequest();
        DescribeThingResult result = null;
        req1.setThingName("esol_ap29551_qa_" + thing);
        try {
            result = client.describeThing(req1);
            setThingResult(result);
        } catch (InvalidArnException | ResourceNotFoundException ex) {
            throw ex;
        }
        return result;
    }
    @Then("I check aws attributes for thing {string}")
    public static void checkAttributesForThing(String thing) throws ParseException {
        String value = null;
        String expectedLineParsed = null;
        if (client == null) {
            createClient();
        }
        makeDescribeThingResult(getClient(), thing);
        Map<String, String> map = getThingResult().getAttributes();
        String elem = APIInvocationPage.getJSONResult().getText();
        for (String key : map.keySet()) {

            value = map.get(key);
            expectedLineParsed = key + ": \"" + value + "\"";
            System.out.println(expectedLineParsed);
            Assert.assertTrue(elem.contains(expectedLineParsed), "The dmc element doesnt contain value: " + value);
            }
        ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(map.toString()));

    }
    @Then("I launch command {string} on shell. And Check that the registration fail")
    public static void iLaunchCommandOnShellAndCheckThatTheRegistrationFail(String command) throws IOException {
        int count = 0;
        boolean isRetry = true;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));

        while (isRetry) {
            try {
                String textToRetrieve = "sending PUBLISH (d0, q1, r0, m1, 'devices/registration', ... (335 bytes))\n" +
                        "Register device..";
                Process process = processBuilder.start();
                isRetry = readBuffer(process, textToRetrieve);
                if (count > 3) {
                    Assert.fail("Error. The device could have been successfully registered.");
                }
                count++;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean readBuffer(Process process, String textToRetrieve) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        long mill = System.currentTimeMillis();
        while (((line = reader.readLine()) != null) || (System.currentTimeMillis() > mill+60000)) {
            System.out.println(line);
            assert line != null;
            if (line.contains(textToRetrieve)) {
                return false;
            }
        }
        return true;
    }

    @Then("I check the response contains the expected. Gateway \"(.+)\"")
    public static void responseContained(String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        long elapsingTime = 1800_000;
        for(MyTopic t: topics){
            message = t.waitForMessageOnTopic(msg -> msg.getStringPayload().contains(resp), elapsingTime);
            if(message!=null) {
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));
            }
            else {
                Assert.fail("### --- Response is expected in " + elapsingTime/1000 + " seconds . No response received in " + elapsingTime*2/1000 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
            //System.out.println("#### --- \n" + message.getStringPayload());
        }

        String respToCompare = String.format(resp, device);
        assert message != null;
        Assert.assertTrue(message.getStringPayload().trim().contains(respToCompare.trim()));
    }

    @Then("I launch command {string} on shell for device {string} adding the following symbols to payload {string} and I check that the response {string} is not received:")
    public static void iRegisterWithMultipleCustomizedPayloadsAndCheckMissingResponses(String command, String device, String payload_file, String resp, List<String> symbols) throws IOException, InterruptedException, AWSIotException {

        String temp_payload = "temp_" + payload_file;
        String original_payload_path = Configuration.get("path.scripsBash") + "\\" + payload_file + ".txt";
        String temp_payload_path = Configuration.get("path.scripsBash") + "\\" + temp_payload + ".txt";
        File original_payload = null;
        File temp_payload_file = null;
        FileWriter temp_writer = null;
        Scanner original_reader = null;
        boolean response_is_not_received = false;

        List<String> topics_list = getCurrentTopics();

        for(String sym: symbols) {
            try {
                original_payload = new File(original_payload_path);
                if(!original_payload.exists())
                {
                    Assert.fail("Invalid payload file path: " + original_payload_path);
                }

                temp_payload_file = new File(temp_payload_path);
                if(temp_payload_file.exists()) {
                    temp_payload_file.delete();
                }

                temp_writer = new FileWriter(temp_payload_path, true);
                original_reader = new Scanner(original_payload);
                while (original_reader.hasNextLine()) {
                    String data = original_reader.nextLine();
                    if(data.contains("\"maker\"")) {
                        char[] chars = data.toCharArray();
                        chars[chars.length-3] = sym.charAt(0);
                        data = new String(chars);
                    }
                    temp_writer.write(data+"\n");
                    System.out.println(data);
                }

                temp_writer.close();
                original_reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            iLaunchCommandOnShell(command + " " + device + " ./" + temp_payload + ".txt");
            CommonSteps.iPrint(temp_payload);
            Thread.sleep(10000);
            response_is_not_received = responseNotReceivedForSymbol(device, resp);
            System.out.println("IS NOT RECEIVED: " + response_is_not_received);
            Thread.sleep(30000);
            System.out.println("IS NOT RECEIVED: " + response_is_not_received);
            Assert.assertTrue(response_is_not_received, "Message retrieved and equal, the char " + sym + " has been accepted.");

            Util.Wait(3000);
            for(MyTopic t: topics){
                client_sub.unsubscribe(t);
            }
            Util.Wait(3000);


            subscriptionReiteration();

            if(temp_payload_file.exists()) {
                temp_payload_file.delete();
            }
        }

    }

    public static boolean responseNotReceivedForSymbol(String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        for(MyTopic t: topics){
            message = t.waitForNoMessageOnTopic(msg -> true, 30_000);
        }

        String respToCompare = String.format(resp, device);
        System.out.println("RECEIVED RESPONSE: " + message.getStringPayload().trim());
        System.out.println("RESPONSE TO AVOID: " + respToCompare.trim());

        if(message != null){
            System.out.println("CONDITION TO AVOID: " + (message.getStringPayload().trim()).equals(respToCompare.trim()));

            return (!(message.getStringPayload().trim()).equals(respToCompare.trim()));
        }

        return true;
    }

    public static String current_certificate_ID;

    public static String getCurrentCertificateID(){ return current_certificate_ID;}

    public static void setCurrentCertificateID(String certificate_ID) {UtilSteps.current_certificate_ID = certificate_ID;}

    public static List<String> current_topics;

    public static List<String> getCurrentTopics(){ return current_topics;}

    public static void setCurrentTopics(List<String> topics) {UtilSteps.current_topics = topics;}

    public static void subscriptionReiteration() throws AWSIotException, InterruptedException {

        List<String> topics_list = getCurrentTopics();
        for (MyTopic t : topics) {
            System.out.println(t);
        }

        Util.Wait(3000);
        for(MyTopic t: topics){
            client_sub.subscribe(t);
        }
        Util.Wait(3000);

        ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(topics_list.toString()));
    }


    @Then("I check the response is equal to the expected and is received in (.+) seconds. Gateway \"(.+)\"")
    public static void responseInTime(long maxTime, String device, String resp) throws InterruptedException {
        AWSIotMessage message = null;
        for(MyTopic t: topics){
            message = t.waitForMessageOnTopic(msg -> true, maxTime * 1000L);
            if(message!=null) {
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));
            }
            else{
                Assert.fail("### --- Response is expected in " + maxTime + " seconds . No response received in " + maxTime*2 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }

        String respToCompare = String.format(resp, device);
        assert message != null;
        Assert.assertEquals(message.getStringPayload().trim(), respToCompare.trim());
    }

    @Then("I check the response is {string}, equal to the expected and is received. Project {string}, Device {string}, InstallStatus {string}, Software {string}, CustomStatus {string}")
    public static void responseDeviceUpdateInTime(String result,  String project, String device, String installStatus, String software, String customStatus) throws InterruptedException {
        AWSIotMessage message = null;
        String jobID = CommandsUtilSteps.getJobId();
        for(MyTopic t: topics){
            System.out.println("t: "+ t);
            message = t.waitForMessageOnTopic(msg -> true, 120 * 1000L);
            if(message!=null) {
                System.out.println("#### --- \n" + message.getStringPayload());
                ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(message.getStringPayload(), CodeLanguage.JSON));
            }
            else{
                Assert.fail("### --- Response is expected in " + 120 + " seconds . No response received in " + 120*2 + " seconds --- ###");
                System.out.println("### --- No message is received in response --- ###");
            }
        }
        String respToCompare = "{ \"status\":"+result+"," +
                " \"commandId\":"+jobID+"," +
                "\"statusDetails\":{" +
                " \"environment_prefix\":"+project+","+
                "\"thing_id\":"+device+","+
                "\"install_status\":"+installStatus+","+
                "\"thing_sw\":"+software+","+
                "\"custom_status\":"+customStatus+"}}";

        //String respToCompare = String.format(resp, device);
        assert message != null;
        System.out.println("message.getStringPayload().trim()" + message.getStringPayload().replaceAll(" ", "") +"EEEE + respToCompare.trim()"+ respToCompare.trim());
        Assert.assertTrue(message.getStringPayload().trim().contains(result));
        Assert.assertTrue(message.getStringPayload().trim().contains(installStatus));
        Assert.assertTrue(message.getStringPayload().trim().contains(software));
        Assert.assertTrue(message.getStringPayload().trim().contains(customStatus));
    }
    @Then("I check that the fingerprint is deleted from AWS Iot Core")
    public static void checkFingerprintDeletedAwsThing() throws ParseException {
        try {
            if(client == null){
                System.out.println("Client è null");
                createClient();
                System.out.println("Client:"+ getClient());
            }
            makeDescribeCertificateResult(getClient());
            String description = getResult().toString();
            System.out.println("Description: " +description);
        } catch (com.amazonaws.services.iot.model.ResourceNotFoundException exception) {
            System.out.println("AWS Exeption: Certificate ID not found, as expected");
            return;
        }
        Assert.fail("There are still some certificate attached to the fingerprint");
    }

    @Then("I retrieve the expiration date of the certificate from the retrieved API response")
    public static void apiResponseExpiration(){
        String resp = ApiUtilSteps.getResponseMessage();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(resp);
        JsonObject a = tree.getAsJsonObject();
        System.out.println(a);
        JsonArray b =  a.get("list_items").getAsJsonArray();
        JsonObject c =  b.get(0).getAsJsonObject();
        String exp_date = c.get("certificate").getAsJsonObject().get("not_after").getAsString();
        setExpirationDateRetrieved(exp_date);
    }

    public static String getExpirationDateRetrieved() {
        return expirationDateRetrieved;
    }

    public static void setExpirationDateRetrieved(String expirationDateRetrieved) {
        UtilSteps.expirationDateRetrieved = expirationDateRetrieved;
    }

    private static String expirationDateRetrieved;

    @Then("I check that the expiration date is updated")
    public static void apiResponseExpirationUpdate(){
        String old_exp_date = getExpirationDateRetrieved();
        String resp = ApiUtilSteps.getResponseMessage();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(resp);
        JsonObject a = tree.getAsJsonObject();
        System.out.println(a);
        JsonArray b =  a.get("list_items").getAsJsonArray();
        JsonObject c =  b.get(0).getAsJsonObject();
        String exp_date = c.get("certificate").getAsJsonObject().get("not_after").getAsString();
        Assert.assertFalse(exp_date.equals(old_exp_date), "The Expiration date is not update");
    }

}