package test.steps;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import cucumber.api.java.en.Then;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AWSUtilFunctionsSteps {

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

    private DynamoDB createObjectDynamoDB() {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        return new DynamoDB(client);
    }

    private Table setTableDynamoDB(String tableName) {

        DynamoDB db = createObjectDynamoDB();
        return db.getTable(tableName);
    }


    @Then("I check the absence of rule {string} in {string} DynamoDD table for the {string} apm")
    public void iCheckTheAbsenceOfRuleInDynamoDDTableForTheApm(String rule, String tableDynamo, String apmProject) {

        Table table = setTableDynamoDB(tableDynamo);

        ScanSpec scanSpec = new ScanSpec();
        Item item = null;
        boolean absenceFlag = false;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext() && !absenceFlag) {
                Item item2 = iter.next();
                if (item2.toString().contains(rule) && item2.toString().contains(apmProject)) {
                    absenceFlag = true;
                }

            }
        } catch (Exception e) {
            Assert.fail("### ERROR ###\n\t" + e);
        }

        Assert.assertTrue(absenceFlag, "The rule on DynamoDB is present");
    }

}
