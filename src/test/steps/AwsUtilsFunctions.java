package test.steps;

import Util.UtilFunctions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.macie2.model.S3Bucket;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import cucumber.api.java.en.Then;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
import ta.common.CommonPage;
import ta.formatters.ReportFormatter;
import ta.utilities.Configuration;
import test.pages.SoftwareCataloguePage;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

class MyWorker extends Thread {

    @Override
    public void run() {

        String command = "./aws_adfs_mfa_enel_x86-64-final.exe login --profile=concept-reply";

        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scriptAws")));

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 1) {
                Assert.fail("Error: exit code 1!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        while (!AwsUtilsFunctions.flag_kill_thread) {

            int temp = 1000 * 60 * 58;

            for (int i = 0; i < temp; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + " --- " + this.getState());
            }
        }
        this.interrupt();
    }

}

public class AwsUtilsFunctions {

    static ArrayList<Map<String, String>> padreFiglioTemplate = new ArrayList<Map<String, String>>();
    static ArrayList<Map<String, String>> padreFiglioDaConfrontare = new ArrayList<Map<String, String>>();

    public static boolean flag_kill_thread = false;

    public static void getStructureOfFather(JSONObject oggetto,  String padre, boolean template) {
        Iterator<String> keys = oggetto.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (oggetto.get(key) instanceof JSONObject) {
                getStructureOfFather((JSONObject) oggetto.get(key), key,template);
            }
            if (oggetto.get(key) instanceof String || oggetto.get(key) instanceof Integer) {

                if (template) {
                    padreFiglioTemplate.add(
                            new HashMap<String, String>() {{
                                put(padre, key);
                            }}
                    );
                }
                else {
                    padreFiglioDaConfrontare.add(
                            new HashMap<String, String>() {{
                                put(padre, key);
                            }}
                    );
                }
            }

        }
    }

    public static boolean areThemEquals(ArrayList<Map<String, String>> a, ArrayList<Map<String, String>>b){
        boolean res = true;
        for(int i=0;i<a.size();i++){
            if (!b.contains(a.get(i))){
                return false;
            }
        }
        return res;
    }

    public boolean getFlagkillThread() {
        return flag_kill_thread;
    }

    @Then("I check the loop script")
    public void iCheckTheLoopScript() throws InterruptedException {

        WebDriver driver = CommonPage.getDriver();

        for (int i = 0; i < 1000 * 60 * 62; i++) {

            driver.navigate().refresh();
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @Then("Close AWS credential script")
    public void closeAWSCredentialFlag() {

        flag_kill_thread = true;
    }

    @Then("I check for updating credentials")
    public void iCheckForUpdatingCredentials() throws IOException, InterruptedException {

        boolean killThread = false;

        Thread thread = new MyWorker();
        thread.start();

    }

    private DynamoDB createObjectDynamoDB() {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        return dynamoDB;
    }

    private Table setTableDynamoDB(String tableName) {

        DynamoDB db = createObjectDynamoDB();
        return db.getTable(tableName);
    }

//    @Then("I check the absence of rule {string} in {string} DynamoDD table for the {string} apm")
//    public void iCheckTheAbsenceOfRuleInDynamoDDTableForTheApm(String rule, String tableDynamo, String apmProject) {
//
//        Table table = setTableDynamoDB(tableDynamo);
//
//        ScanSpec scanSpec = new ScanSpec();
//        Item item = null;
//        boolean absenceFlag = false;
//
//        try {
//            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
//            Iterator<Item> iter = items.iterator();
//            while (iter.hasNext() && !absenceFlag) {
//                Item item2 = iter.next();
//                if (item2.toString().contains(rule) && item2.toString().contains(apmProject)) {
//                    absenceFlag = true;
//                }
//
//            }
//        } catch (Exception e) {
//            Assert.fail("### ERROR ###\n\t" + e);
//        }
//
//        Assert.assertTrue(absenceFlag, "The rule on DynamoDB is present");
//    }

    @Then("I check the rule {string} in {string} DynamoDD table for the {string} apm")
    public void iCheckTheRuleInDynamoDDTableForTheApm(String rule, String tableDynamo, String apmProject) {

        Table table = setTableDynamoDB(tableDynamo);

        ScanSpec scanSpec = new ScanSpec();

        Item item = null;

        List<String> values = RDESteps.getAllDetailsOfRule();
        String ris = "";
        int flag = 0;

        for (String value : values) {
            ris += value;
        }

        System.out.println(ris);

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item2 = iter.next();
                if (item2.toString().contains(rule) && item2.toString().contains(apmProject)) {
                    item = item2;
                }

            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        if (item == null) {
            Assert.fail("\"### ERROR ###");
        }

        for (String value : values) {
            if (item.toString().contains(value)) {
                flag++;
            }
        }

        Assert.assertEquals(flag, values.size());
    }

    @Then("I check the general information like projectid {string} scope target {string} and scope type {string} on {string} DynamoDb table for project {string} apm")
    public void iCheckTheGeneralInformationLikeProjectidScopeTargetAndScopeTypeOnDynamoDbTableForProjectApm(String projectId, String scopeTarget, String scopeType, String tableDynamo, String apmProject) {

        Table table = setTableDynamoDB(tableDynamo);
        ScanSpec scanSpec = new ScanSpec();
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item2 = iter.next();
                if (item2.toString().contains(scopeTarget) && item2.toString().contains(apmProject)) {
                    item = item2;
                }

            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        if (item == null) {
            Assert.fail("\"### ERROR ###");
        }

        Assert.assertTrue(item.toString().contains(projectId), "The \"" + projectId + "\" correct is not present");
        Assert.assertTrue(item.toString().contains(scopeTarget), "The scope target = \"" + scopeTarget + "\" is not present");
        Assert.assertTrue(item.toString().contains(scopeType), "The scope type \"" + scopeType + "\" is not present");
    }

    @Then("I check the {string} notification data for device {string} on {string} DynamoDb table for project {string} apm")
    public void iCheckTheTypeNotificationDataOnDynamoDbTableForProjectApm(String type, String device, String tableDynamo, String apmProject) {

        String endpoint = "";
        String subscriptionArn = "";

        switch (type) {
            case "email":
                endpoint = CommonSteps.getEmailRandom();
                subscriptionArn = "subscription_arn=arn:aws:sns:eu-central-1:039931352532:esol_ap27611_test_sns_e2e_monitoring_notification";
                break;
            case "telephone":
                endpoint = SmssSteps.getTelephoneNumber();
                subscriptionArn = "subscription_arn=arn:aws:sns:eu-west-1:039931352532:esol_ap27611_test_sns_e2e_monitoring";
                break;
            default:
                Assert.fail("Type of notifications is not correct");
        }

        int check_flag = 0;

        Table table = setTableDynamoDB(tableDynamo);
        ScanSpec scanSpec = new ScanSpec();
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item2 = iter.next();
                if (item2.toString().contains(device) && item2.toString().contains(apmProject)) {
                    item = item2;
                }

            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        if (item == null) {
            Assert.fail("\"### ERROR ###");
        }

        Assert.assertTrue(item.toString().contains(endpoint), "The \"" + type + "\" used for this notification is not present");
        Assert.assertTrue(item.toString().contains("channel_type=" + type ), "The channel type = \"" + type + "\" is not present");
        Assert.assertTrue(item.toString().contains(subscriptionArn), "The subscription \"" + subscriptionArn + "\" is not present");

    }


    @Then("I check the information of json notification result for {string} in the table {string} of DynamoDB for {string} apm")
    public void iCheckTheInformationOfJsonNotificationResultForTest_ConceptInTheTableOfDynamoDBForApm(String deviceAlarm, String tableDynamo, String apmProject) {

        List<String> listItems = new ArrayList<>();
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(apmProject);

        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, notification_id").withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", apmProject));
        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                listItems.add(item.toString());
                System.out.println(listItems);
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }
    }

    @Then("I compare the structure of json disservice alarm for {string} device in the table {string} of DynamoDB for {string} apm")
    public void iTakeTheJsonOfInTheTableOfDynamoDBForApm(String deviceAlarm, String tableDynamo, String apmProject) {

        String attributeToCheck = "group_id";

        String template = "{\n" +
                "  \"short_window_conf\": {\n" +
                "   \"disconnection_window_threshold\": 120,\n" +
                "   \"rde_rule_id\": \"<id>\",\n" +
                "   \"device_nr_threshold\": 3\n" +
                "  },\n" +
                "  \"long_window_conf\": {\n" +
                "   \"disconnection_window_threshold\": 240,\n" +
                "   \"rde_rule_id\": \"<id>\",\n" +
                "   \"device_nr_threshold\": 3\n" +
                "  }}";

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(tableDynamo);

        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, " + attributeToCheck  + ", alarm_category, business_alarm, disservice_alarm, group_class, message_rates, rde_filter_id, rde_rule_id, telemetry_rules").withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", apmProject));

        int cont = 0;
        boolean flag = false;
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext() && !flag) {
                Item item2 = iter.next();
                if (item2.get(attributeToCheck).toString().equalsIgnoreCase(deviceAlarm)) {
                    item = item2;
                    flag = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        Assert.assertNotNull(item, "No item found in DynamoDB");

        String disservice = item.getJSON("disservice_alarm");
        System.out.println(disservice);

        JSONObject b = new JSONObject(disservice);
        getStructureOfFather(b, "", false);

        JSONObject j = new JSONObject(template);
        getStructureOfFather(j, "", true);

        boolean equals = areThemEquals(padreFiglioTemplate, padreFiglioDaConfrontare);
        Assert.assertTrue(equals, "JSON Not Equals");

        System.out.println();
    }

    @Then("I check the table {string} in order to verify the number of {string} present into the project {string}")
    public static void checkAlarmsIntoTable(String nameTable, String type, String nameProject) {
        int dmcNum = 0;
        int dynamoNum = 0;
        String attributeToCheck = null;
        switch (type) {
            case "alarms":
                dmcNum = DeviceAlarmsConfigurationSteps.getNumOfAlarms();
                attributeToCheck = "group_id";
                break;
            case "notifications":
                dmcNum = NotificationsConfigurationsSteps.getNumOfNotification();
                attributeToCheck = "notification_id";
                break;
            default:
                Assert.fail("option is not valid!");
        }

        List<String> listItems = new ArrayList<>();
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(nameTable);
        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, " + attributeToCheck).withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", nameProject));
        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                listItems.add(item.get(attributeToCheck).toString());
                System.out.println(item.get(attributeToCheck).toString());
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        dynamoNum = listItems.size();
        Assert.assertEquals(dynamoNum, dmcNum, "The entries present into the DynamoDb is different. DynamoDB: " + dynamoNum + " Portal: " + dmcNum);
        ReportFormatter.logInfo("Entries into the DMC: " + dmcNum + "Entries into the DynamoDB: " + dynamoNum);
    }

    @Then("I check the scope of alarm of DynamoDB {string} in the project {string}")
    public void iCheckTheScopeOfAlarmInDynamoDB(String nameTable, String nameProject) {

        List<JSONObject> listItems = new ArrayList<>();
        String list = "";
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(nameTable);
        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, alarm_category, business_alarm, message_rates").withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", nameProject));
        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                String t = item.toString().replaceAll("=", ":");
                JSONObject tmp = new JSONObject(t);
                listItems.add(tmp);
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        System.out.println(listItems);
        JSONObject item = listItems.get(0).getJSONObject("Item");
        System.out.println("Item 466:" + item);
        JSONObject business = item.getJSONObject("business_alarm");
        String rde_rule_id = business.getString("rde_rule_id");

        Assert.assertTrue(rde_rule_id != null);
    }

    @Then("I check the disconnection window threshold in DynamoDB {string} in the project {string}")
    public void iCheckTheDisconnectionWindowThresholdInDynamoDBTableInTheProject(String nameTable, String nameProject) {
        int index = 0;
        List<JSONObject> listItems = new ArrayList<>();
        DynamoDB dn_db = createObjectDynamoDB();
        Table table = dn_db.getTable(nameTable);

        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, alarm_type, business_alarm, message_rates,group_id").withFilterExpression("#pr_ID = :project_id")
               .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", nameProject));


        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                String t = item.toString().replaceAll("=", ":");
                JSONObject tmp = new JSONObject(t);
                listItems.add(tmp);
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }


        for (int i = 0; i < listItems.size(); i++){
            JSONObject item = listItems.get(i).getJSONObject("Item");
            String groupId = item.get("group_id").toString();
            if(groupId.equals("all")){
                index = i;
            }

        }


        JSONObject item = listItems.get(index).getJSONObject("Item");
        JSONObject buisiness = item.getJSONObject("business_alarm");

        int disconnection_window_threshold = buisiness.getInt("disconnection_window_threshold");

        Assert.assertTrue(disconnection_window_threshold == 300,"disconnection_window_threshold from AWS is " + disconnection_window_threshold +" instead of 300s" );
    }

    @Then("I check the trigger data and the trigger type configuration in DynamoDB {string} in the project {string}")
    public void iCheckTheTriggerDataAndTheTriggerTypeConfigurationInDynamoDBTableInTheProject(String nameTable, String nameProject) {

        List<JSONObject> listItems = new ArrayList<>();
        DynamoDB dn_db = createObjectDynamoDB();
        Table table = dn_db.getTable(nameTable);
        ScanSpec scanSpec = new ScanSpec();
        String finale = "";

        String first_filter = "";
        String weekDayIsolato = "";
        String timeIsolato = "";

        int indexEmailPoint = 0;
        int posizione_weekday = 0;
        int posizione_time = 0;
        int posizione_notificationID = 0;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();

            JSONObject tmp = null;
            while (iter.hasNext()) {
                finale += iter.next().toString().replaceAll("=", ":");
            }
            System.out.println(finale);
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        indexEmailPoint = finale.indexOf(CommonSteps.getEmailRandom());
        first_filter = finale.substring(indexEmailPoint, finale.length() - 1);
        posizione_weekday =  first_filter.indexOf("weekday");
        posizione_time =  first_filter.indexOf("time");
        posizione_notificationID =  first_filter.indexOf("notification_id");
        weekDayIsolato = first_filter.substring(posizione_weekday,posizione_time);
        timeIsolato = first_filter.substring(posizione_time,posizione_notificationID);

        String[] content1 = weekDayIsolato.substring(weekDayIsolato.indexOf("{") + 1, weekDayIsolato.indexOf("}")).split(",");
        String day_from = content1[0].substring(content1[0].indexOf(":") + 1, content1[0].length());
        String day_to = content1[1].substring(content1[0].indexOf(":"), content1[0].length() - 1);
        String[] content = timeIsolato.substring(timeIsolato.indexOf("{") + 1, timeIsolato.indexOf("}")).split(",");
        String hour_from = content[0].substring(content[0].indexOf(":") + 1, content[0].length());
        String hour_to = content[1].substring(content[1].indexOf(":") + 1, content[0].length() - 1);

        String day_from_dmc = DeviceAlarmsConfigurationSteps.getDayFrom();
        String day_to_dmc = DeviceAlarmsConfigurationSteps.getDayTo();
        String hour_from_dmc = DeviceAlarmsConfigurationSteps.getFrom_Hour();
        String hour_to_dmc = DeviceAlarmsConfigurationSteps.getTo_Hour();

        Assert.assertTrue(day_from.toLowerCase().contains(day_from_dmc.toLowerCase()));
        Assert.assertTrue(day_to.toLowerCase().contains(day_to_dmc.toLowerCase()));
        Assert.assertTrue(hour_from_dmc.toLowerCase().contains(hour_from.toLowerCase()));
        Assert.assertTrue(hour_to_dmc.toLowerCase().contains(hour_to.toLowerCase()));
    }

    /*@Then("I check the notes of activity {string} in DynamoDB table {string} in the project {string}")
    public void iCheckActivityinDynamoDB(String activity, String tableDynamo, String apmProject) {

        String attributeToCheck = "op_id";
        String attributeToCheck2 = "notes";

        String valueAttributeToCheck =apmProject+"_"+activity;
        System.out.println(valueAttributeToCheck);

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(tableDynamo);

        System.out.println("table"+tableDynamo);

        ScanSpec scanSpec = new ScanSpec();

        int cont = 0;
        boolean flag = false;
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext() && !flag) {
                Item item2 = iter.next();
                System.out.println(item2);
                if (item2.get(attributeToCheck).toString().equalsIgnoreCase(valueAttributeToCheck) && item2.get(attributeToCheck2).toString().equalsIgnoreCase("provaL")) {
                    item = item2;
                    flag = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        Assert.assertNotNull(item, "No item found in DynamoDB");

        //String disservice = item.getJSON("disservice_alarm");
        //System.out.println(disservice);

        //JSONObject b = new JSONObject(disservice);
        //getStructureOfFather(b, "", false);

        //JSONObject j = new JSONObject(template);
        //getStructureOfFather(j, "", true);

        //boolean equals = areThemEquals(padreFiglioTemplate, padreFiglioDaConfrontare);
        //Assert.assertTrue(equals, "JSON Not Equals");

        System.out.println("item cercato: "+item);
    }
*/

    @Then("I check the notes of activity {string} in DynamoDB table {string} in the project {string}")
    public void iCheckActivityinDynamoDB(String activity, String tableDynamo, String apmProject) {

        String attributeToCheck = "op_id";
        String attributeToCheck2 = "notes";

        String valueAttributeToCheck =apmProject+"_"+activity;
        System.out.println(valueAttributeToCheck);

        List<String> listItems = new ArrayList<>();
        List<JSONObject> li = new ArrayList<>();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(tableDynamo);

        System.out.println("table: "+table);

        //funziona piu o meno:
        /*ScanSpec scanSpec = new ScanSpec().withProjectionExpression(
                "#pr_ID, " + attributeToCheck).withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", apmProject));*/

        //funziona piu o meno:
        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("#pr_ID, " + attributeToCheck + ", "+attributeToCheck2).withFilterExpression("#pr_ID = :project_id")
                .withNameMap(new NameMap().with("#pr_ID", "project_id")).withValueMap(new ValueMap().withString(":project_id", apmProject));

        System.out.println("scan spec: "+scanSpec);
        /*try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                System.out.println(item);
                listItems.add(item.get(attributeToCheck).toString());
            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }*/

        int cont = 0;
        boolean flag = false;
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()&& !flag) {
                Item item2 = iter.next();
                System.out.println("item dentro try: "+item2);
                //String t = item.toString().replaceAll("=", ":");
                //System.out.println(t);
                //JSONObject tmp = new JSONObject(item);
                //li.add(tmp);
                if(item2.get(attributeToCheck).toString().equalsIgnoreCase(valueAttributeToCheck) && item2.get(attributeToCheck2).toString().equalsIgnoreCase("NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjj")){
                    item = item2;
                    flag = true;
                }
            }
            System.out.println("lista json:"+li);
            System.out.println("item:"+item);
            System.out.println("item:"+flag);
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

       // JSONObject tmp = li.get(0).getJSONObject("Item");
       // JSONObject opId = tmp.getJSONObject("op_id");
        //JSONObject notes = tmp.getJSONObject("notes");

       // System.out.println("opId"+opId+"note"+notes);
    }

    @Then("I check if dynamoDB Software catalogue contains {string} same as DMC FE")
    public static void softwareDynamoDB( String type ){
        switch( type) {
            case "thing":
                int ln = 1;
                /*
                //FE check
                List<String> swCat = new Vector<>();
                while (UtilFunctions.createNewPageElement("", "//dmc-software-card[@style='z-index: " + ln + ";']").isPresent()) {
                    CommonPage.getDriver().findElement(By.xpath("//dmc-software-card[@style='z-index: " + ln + ";']//div[@class='-handle']")).click();
                    SoftwareCataloguePage.getDetailFunctionOnSoftwareCard().tryClick();
                    if (SoftwareCataloguePage.getSoftwareCatalogueAppName().isPresent())
                        swCat.add(SoftwareCataloguePage.getSoftwareCatalogueAppName().getText());
                    ln++;
                    SoftwareCataloguePage.getBackBtn().tryClick();
                }

                //for (String p : swCat)
                //    System.out.println(p);

                //DDB check
                String nameTable = "esol_ap2955103_qa_ddb_sw_catalogue";
                AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
                DynamoDB dynamoDB = new DynamoDB(client);
                Table table = dynamoDB.getTable(nameTable);
                List<String> listItems = new Vector<>();
                //ScanSpec scanSpec = new ScanSpec().withFilterExpression()  .withValueMap(new ValueMap().withString("device_type", type));
                ScanSpec scanSpec = new ScanSpec()
                .withProjectionExpression("appname, device_type");
                //.withFilterExpression("device_type");
                try {
                    ItemCollection<ScanOutcome> items = table.scan(scanSpec);
                    for (Item item : items) {
                        String t = item.toString().replaceAll("=", ":");
                        if(t.contains("device_type:thing")){

                            String tt = t.substring(17,t.indexOf(","));
                            listItems.add(tt);
                        }

                    }
                } catch (Exception e) {
                    Assert.fail("### ERROR ###\n\t" + e);
                }

                //for(String ls: listItems){
                //    System.out.println(ls);
                //}

                Collections.reverse(listItems);
                //FE vs DDB check
                Assert.assertEquals(swCat, listItems);
                */

                //S3 bucket check
                String AWS_BUCKET = "enel-noprod-esol-ap2955103-qa-sm-artifacts";
                //Region AWS_REGION = Region.EU_CENTRAL_1;
                //S3Client s3Client = S3Client.builder()
                //        .region(AWS_REGION)
                //        .build();
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
                ListObjectsV2Request swList = ListObjectsV2Request.builder().bucket(AWS_BUCKET).prefix("packages_things").build();

                ListObjectsV2Result listObjectsV2Iterable = s3Client.listObjectsV2(String.valueOf(swList));
                long totalObjects = 0;


                System.out.println(listObjectsV2Iterable);


        }
    }
    @Then("I check if {string} is present in Software table in DynamoDB")
    public static void softwareDDBPresent( String name ){
        String nameTable = "esol_ap2955103_qa_ddb_sw_catalogue";
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(nameTable);
        List<String> listItems = new Vector<>();

        ScanSpec scanSpec = new ScanSpec()
                .withProjectionExpression("appname, device_type");
        //.withFilterExpression("device_type");
        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            for (Item item : items) {
                String t = item.toString().replaceAll("=", ":");
                if(t.contains("device_type:thing")){

                    String tt = t.substring(17,t.indexOf(","));
                    listItems.add(tt);
                }

            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }
        boolean present = false;
        for(String ls: listItems){
            if (ls.equals(name)) {
                present = true;
                break;
            }
        }
        Assert.assertTrue(present);
    }
}