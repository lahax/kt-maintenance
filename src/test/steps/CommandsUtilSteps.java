package test.steps;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.utilities.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class CommandsUtilSteps {

    private static HashMap<String, Process> gatewayProcessMap = new HashMap<>();
    private static HashMap<String, String> gatewayJobIDMap = new HashMap<>();

    private static BufferedReader notifyProcessReader;

    public static BufferedReader getNotifyProcessReader() {
        return notifyProcessReader;
    }

    public static void setNotifyProcessReader(BufferedReader notifyProcessReader) {}

    private static Process notifyProcess;

    public static Process getNotifyProcess() {
        return notifyProcess;
    }

    public static void setNotifyProcess(Process notifyProcess) {
        CommandsUtilSteps.notifyProcess = notifyProcess;
    }
private static Process notifyProcessMQTT;

    public static Process getNotifyProcessMQTT() {
        return notifyProcessMQTT;
    }

    public static void setNotifyProcessMQTT(Process notifyProcessMQTT) {
        CommandsUtilSteps.notifyProcessMQTT = notifyProcessMQTT;
    }

    public static String jobId;

    public static String getJobId() {
        return jobId;
    }

    public static void setJobId(String jobId) {
        CommandsUtilSteps.jobId = jobId;
    }

    public static long processId;

    public static long getProcessId() {
        return processId;
    }

    public static void setProcessId(long processId) {
        CommandsUtilSteps.processId = processId;
    }


    @Then("I save the job ID")
    public static void iSaveTheJobId() {

        try {
            Process process = getNotifyProcess();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line="";
            do{
                if(reader.ready()){
                    line = reader.readLine();
                }
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun Job Document ricevuto in 2 minuti: nessuna interazione rilevata con l'operazione su DMC.");
                }
                // TODO: Wait the *2 time and print a warning message if the job id comes in this range of time
            }while(!line.contains("jobId"));

            System.out.println(line);
            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);

            setJobId(jobID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I save the job ID from the job document received")
    public static void iGetTheJobId() {

        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line;
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun Job Document ricevuto in 2 minuti: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);

            setJobId(jobID);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Then("I save the job ID from the job document received and check the message: {string}")
    public static void iGetTheJobIdAndMessage(String message){

        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
            }
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            String jobMessage = job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("parameters").getAsJsonObject().get("thing_software").getAsJsonArray().get(0).getAsJsonObject().get("options").getAsString();
            System.out.println(jobMessage);
            Assert.assertEquals(message.trim(), jobMessage.trim());
            System.out.println(jobID);

            setJobId(jobID);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Then("I run the script {string}, with the job Id retrieved, on {string} in the project {string}")
    public static void iRunCloseJob(String script, String gateway, String project) {
        int count = 0;
        int exitCode = 0;
        boolean isRetry = true;
        String jobID = getJobId();
        ProcessBuilder processBuilder3 = new ProcessBuilder();
        String commandCloseJob = "bash ./" + script + ".sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + jobID;
        System.out.println(commandCloseJob);
        processBuilder3.command("powershell.exe", commandCloseJob);
        processBuilder3.directory(new File(Configuration.get("path.scripsBash")));

        while (isRetry) {
            try {

                Process processLast = processBuilder3.start();

                BufferedReader readerLast = new BufferedReader(new InputStreamReader(processLast.getInputStream()));

                String lineLast;

                while ((lineLast = readerLast.readLine()) != null) {
                    System.out.println(lineLast);
                }

                int exitCodeLast = processLast.waitFor();

                if (exitCodeLast == 0) {
                    System.out.println("The script has worked successfully");
                    isRetry = false;
                }

                if (count > 3) {
                    isRetry = false;
                }
                count++;

                System.out.println("\nClosing job Exited with error code: " + exitCodeLast);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("I kill the notify_job command still opened")
    public static void killNotifyJob() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");
    }

    @Then("I disconnect the last device connected")
    public static void killNotifyJobPID() throws IOException {
        long pid = getProcessId();
        String command = "taskkill /F /PID "+pid+" /T";
        System.out.println(command);
        Runtime.getRuntime().exec(command);
    }

    Thread th = null;
    public static String topicName = null;


    @And("^I start listen on topic (.+)$")
    public void startListenOnTopic(String topic) throws InterruptedException {
//        CommonPage.getDriver().quit();
        String endpoint = "ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com";
        String crt = "Test_Concept-02.crt";
        String pem = "Test_Concept-02.pem";
        String key = "Test_Concept-02.key";
        String identifier = "test_concept";
        String file = "payload_telemetry_test_concept_02.txt";
        boolean isFile = true;
        th = new MQTTUtilSteps(endpoint, topic, crt, pem, key, identifier, isFile, file, "");
       th.start();
    }


    @And("I interrupt the MQTT listener")
    public void interruptThread() throws InterruptedException {
        th.interrupt();
    }

    @And("^I read the topic (.+) file expecting \"(SOME|NONE)\" values$")
    public void iReadTheFile(String topic, String messageInside) throws InterruptedException, IOException {

        String core_test_provisioning_path = new File(Configuration.get("path.scripsBash")).getCanonicalPath();
        String separator = System.getProperty("os.name").toLowerCase().contains("win") ? "\\" : "/";
        String filePath = null;
        filePath = core_test_provisioning_path + separator + "results_listener" + separator + topic.replaceAll("[^a-zA-Z0-9]","")+".txt";

        String content = "";
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                content+= myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (messageInside.equalsIgnoreCase("SOME")) {
            Assert.assertTrue(content.length()>0,"No date received from MQTT connection");
        } else if (messageInside.equalsIgnoreCase("NONE")) {
            Assert.assertEquals(content.length(), 0, "Expected an empty file but founded some values. Contentet retrieved into file:\n"+content);
        } else {
            Assert.fail("Content not supported, only SOME or NONE. You provided: " + messageInside);
        }
    }


    @Then("I run the notify_job script on {string}, in the project {string}")
    public static void iDeactivateThing(String gateway, String project) throws IOException {

        String command1 = "bash ./notify_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway;
        System.out.println(command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);
            setNotifyProcess(process);
            setNotifyProcessReader(reader);
            long pid = process.pid();
            setProcessId(pid);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
    @Then("I run the notify_thing script on {string}, {string} in the project {string}")
    public static void iNotifyThing(String gateway,String thing, String project) throws IOException {

        String command1 = "bash ./notify_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + thing;
        System.out.println(command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);
            setNotifyProcess(process);
            setNotifyProcessReader(reader);
            long pid = process.pid();
            setProcessId(pid);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Then("I run the notify_job_script on {string}, in the project {string}")
    public static void iDeactivateThing2(String gateway, String project) throws IOException {
        String command1 = "bash ./notify_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway;
        System.out.println(command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            long timestart = System.currentTimeMillis();
            //System.out.println(timestart);
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun echo ricevuto in 2 minuti");
                }
            }
            System.out.println(line);
            gatewayProcessMap.put(gateway, process);
            System.out.println("MAP: \n"+gatewayProcessMap);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Then("I save the job ID from the job document received from the gateway \"(.+)\"")
    public static void iGetTheJobId2(String gateway){
        try {
            Process process = gatewayProcessMap.get(gateway);
            System.out.println("retrieved process: \n"+process);
            Thread.sleep(2500);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            long timestart = System.currentTimeMillis();
            System.out.println(timestart);
            do{
                if(reader.ready())
                    line = reader.readLine();
                if(System.currentTimeMillis() > timestart+120000)
                    Assert.fail("Nessun JobID ricevuto in 2 minuti");
            }while(!line.contains("jobId"));
            /*
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun JobID ricevuto in 2 minuti");
                }else {
                    System.out.println("Wait the jobID");
                }
            }

             */
            System.out.println(line);
            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
//            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println("#### JobID retrieved: "+jobID);
            gatewayJobIDMap.put(gateway, jobID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I run the script: {string}, with the job Id retrieved, on {string} in the project {string}")
    public static void iRunCloseJob2(String script, String gateway, String project){
        String jobID = gatewayJobIDMap.get(gateway);
        ProcessBuilder processBuilder3 = new ProcessBuilder();
        String commandCloseJob = "bash ./"+script+".sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + jobID;
        System.out.println(commandCloseJob);
        processBuilder3.command("powershell.exe", commandCloseJob);
        processBuilder3.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process processLast = processBuilder3.start();
            BufferedReader readerLast = new BufferedReader(new InputStreamReader(processLast.getInputStream()));
            String lineLast;
            long timestart = System.currentTimeMillis();
            System.out.println(timestart);
            while ((lineLast = readerLast.readLine()) != null) {
                System.out.println(lineLast);
                setMessageRetrivedFromCloseJob(lineLast);
                if(System.currentTimeMillis() > timestart+180000){
                    Assert.fail("Nessun messaggio ricevuto in 3 minuti");
                }
            }
            int exitCodeLast = processLast.waitFor();
            System.out.println("\nClosing job Exited with error code: " + exitCodeLast);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getMessageRetrivedFromCloseJob() {
        return messageRetrivedFromCloseJob;
    }

    public static void setMessageRetrivedFromCloseJob(String message) {
        CommandsUtilSteps.messageRetrivedFromCloseJob = message;
    }

    private static String messageRetrivedFromCloseJob = "";

    @Then("I check if message retrieved from close job script contains Status: \"(.+)\"")
    public static void checkCloseJobMessage(String message){
        System.out.println("#### message retrieved from close job: "+getMessageRetrivedFromCloseJob());
        Assert.assertTrue(getMessageRetrivedFromCloseJob().contains(message));
    }

    @Then("I save the job ID from the job document received and check the attribute force delete: {string}")
    public static void iGetTheJobIdAndMessageForceDelete(String message) {

        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";
            long timestart = System.currentTimeMillis();
            do{
                if(reader.ready()){
                    line = reader.readLine();
                    System.out.println(line);
                }
                if(System.currentTimeMillis() > timestart+180000) {
                    Assert.fail("Nessun jobId ricevuto in 3 minuti");
                }
            }while(!line.contains("jobId"));
            /*
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart+180000){
                    Assert.fail("Nessun jobId ricevuto in 3 minuti");
                }
            }

             */
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            JsonObject jobMessage = job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("parameters").getAsJsonObject();
            System.out.println(jobMessage.toString());
            //Check if delete_certificate is true, should always be true
            Assert.assertEquals("true", jobMessage.get("delete_certificate").getAsString());
            //Check if force-delete is true or false(input in method)
            Assert.assertEquals(message, jobMessage.get("force-delete").getAsString());
            System.out.println(jobID);

            setJobId(jobID);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("I listen to MQTT topic given for {string}, in the project {string}")
    public static void listenToTopic(String gateway, String project) throws IOException {

        String command1 = "bash ./listenToMqtt.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway;
        System.out.println("Listening to command1: "+ command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);
            setNotifyProcessMQTT(process);
            System.out.println("Notify Process MQTT settato:"+ getNotifyProcessMQTT());
            setNotifyProcessReader(reader);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Then("I listen to MQTT topic given for Cloud Component, in the project {string}")
    public static void listenToTopiccloud(String project) throws IOException {

        String command1 = "bash ./listenToMqttCloud.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project;
        System.out.println(command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);
            setNotifyProcessMQTT(process);
            setNotifyProcessReader(reader);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }


    @Then("I check that MQTT is receiving a notification message with fields: {string} and {string}")
    public static void checkMessageOnTopic(String field1, String field2){
        Boolean cloud =  Boolean.FALSE;
        if (field2.equals("cloud")){
            cloud =  Boolean.TRUE;
        }
        try {
            Process process = getNotifyProcessMQTT();
            System.out.println("process:"+ process);
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line = "";
            String lineField2 = null;
            boolean found = false;
            do{
                if(reader.ready()){
                    line = reader.readLine();
                    if(!line.contains(field1) && line.contains(field2)){
                        lineField2 = line;
                        System.out.println(lineField2);
                        found = true;
                    }
                }
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun Job Document ricevuto in 2 minuti: nessuna interazione rilevata con l'operazione su DMC.");
                }
                // TODO: Wait the *2 time and print a warning message if the job id comes in this range of time
            }while(!found);

            /*
            while (!(line = reader.readLine()).contains(field1)) {
                System.out.println(line);
                if((line = reader.readLine()).contains(field2)){
                    lineField2 = line;
                    System.out.println(lineField2);
                    break;
                }
                if(System.currentTimeMillis() > timestart+180000){
                    Assert.fail("Nessun messaggio ricevuto in 3 minuti");
                }
            }
             */
            System.out.println(line);
            if (!cloud){
                Assert.assertTrue(!(lineField2.equals(null)), "The message received does not contains the fields specified");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("I check that MQTT is not receiving a notification message with field {string} from device {string}")
    public static void checkMessageOnTopicNot(String field1, String device){

        try {
            Process process = getNotifyProcessMQTT();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line;
            while (!(line = reader.readLine()).contains(device)) {
                System.out.println(line);
                Assert.assertFalse(line.contains(field1));

            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("I listen to MQTT topic, in the project {string}")
    public static void listenToTopic(String project) throws IOException {

        String command1 = "bash ./listenToMqttCloud.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project;
        System.out.println(command1);
        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);
            setNotifyProcessMQTT(process);
            setNotifyProcessReader(reader);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Then("I save the job ID from the job document received and I verify that the inbound message have the specified format")
    public static void iGetTheJobIdAndMore() {
        System.out.println("Start waiting for job ID");
        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line="";
            long c = 1;
            /*
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart + c * 1000) {
                    System.out.println("Waiting for job ID: "+ c + "s");
                    c++;
                }
                if(System.currentTimeMillis() > timestart+15000){
                    Assert.fail("Nessun Job Document ricevuto in 10 secondi: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }

             */
            do{
                if(reader.ready()){
                    line = reader.readLine();
                    System.out.println(line);
                }

                if(System.currentTimeMillis() > timestart + c * 1000) {
                    System.out.println("Waiting for job ID: "+ c + "s");
                    c++;
                }
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun Job Document ricevuto in 120 secondi: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }while (!line.contains("jobId"));
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);

            setJobId(jobID);

            Assert.assertNotNull(job_notification.getAsJsonObject().get("timestamp"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobId"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("status"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("queuedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("lastUpdatedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("versionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("executionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("version"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("command"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("parameters"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("I save the job ID from the job document received and I verify that the inbound message is received in three minutes have the specified format")
    public static void iGetTheJobIdAndMoreInThreeMinutes() {

        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line;
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart+180000){
                    Assert.fail("Nessun Job Document ricevuto in 3 minuti: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);

            setJobId(jobID);

            Assert.assertNotNull(job_notification.getAsJsonObject().get("timestamp"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobId"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("status"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("queuedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("lastUpdatedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("versionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("executionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("version"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("command"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("parameters"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Then("I save the job ID from the job document and I verify the format for command: {string}")
    public static void iGetTheJobIdAndCheckCommand(String command) {

        try {
            Process process = getNotifyProcess();
            //BufferedReader reader = getNotifyProcessReader();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            long timestart = System.currentTimeMillis();
            String line = "";
            /*
            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
                if(System.currentTimeMillis() > timestart+15000){
                    Assert.fail("Nessun Job Document ricevuto in 10 seconds: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }

             */
            do{
                if(reader.ready()){
                    line = reader.readLine();
                    System.out.println(line);
                }
                if(System.currentTimeMillis() > timestart+120000){
                    Assert.fail("Nessun Job Document ricevuto in 120 seconds: nessuna interazione rilevata con l'operazione su DMC.");
                }
            }while(!line.contains("jobId"));
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println("jobID: " + jobID);

            setJobId(jobID);

            Assert.assertNotNull(job_notification.getAsJsonObject().get("timestamp"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobId"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("status"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("queuedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("lastUpdatedAt"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("versionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("executionNumber"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("version"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("command"));
            Assert.assertNotNull(job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("parameters"));

            //Check the command type//
            String commandType = job_notification.get("execution").getAsJsonObject().get("jobDocument").getAsJsonObject().get("command").getAsString();
            Assert.assertEquals(commandType, command);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
