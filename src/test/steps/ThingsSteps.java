package test.steps;

import Util.UtilFunctions;
import com.google.gson.JsonSyntaxException;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.entities.elements.PageElement;
import ta.utilities.Configuration;
import test.pages.ThingsPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThingsSteps {

    @Then("I click on more info icon of the row with DeviceID \"(.+)\"")
    public static void clickOnMoreInfo(String device){
        String locator = String.format(ThingsPage.allthingPresent+"/td[contains(.,'%s')]//following-sibling::td/div[contains(@class, '-actions')]//dmc-table-action[contains(@icon, 'more')]", device);
        PageElement pe = UtilFunctions.createNewPageElement("more info of the device id "+device, locator);
        Assert.assertTrue(pe.isPresent(), "Unable to find the element "+pe);
        Assert.assertTrue(pe.tryClick(true), "unable to click the element "+pe);
    }

    @Then("I connect the {string} of device {string}, in the project {string}, for {int} seconds, then disconnect it.")
    public static void iConnectAndDisconnect(String thing, String device, String project, int timeConnect) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        String command = "bash ./notify_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + device + " " + thing;

        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));

        try {

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);


            iWaitSecondsAfterScript(timeConnect);
            //process.waitFor(timeConnect, TimeUnit.SECONDS);
            process = Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void iWaitSecondsAfterScript(int sec) throws InterruptedException {
        for (int i = 1; i <= sec; i++) {
            if (i % 10 == 0) {
                Thread.sleep(10000);
                System.out.println(i);
            }
        }
    }
    public static long processId1;
    public static long processId2;
    public static long processId3;
    public static long processId4;
    public static long processId5;

    public static long getProcessId1() {
        return processId1;
    }

    public static void setProcessId1(long processId1) {
        ThingsSteps.processId1 = processId1;
    }

    public static long getProcessId2() {
        return processId2;
    }

    public static void setProcessId2(long processId2) {
        ThingsSteps.processId2 = processId2;
    }

    public static long getProcessId3() {
        return processId3;
    }

    public static void setProcessId3(long processId3) {
        ThingsSteps.processId3 = processId3;
    }

    public static long getProcessId4() {
        return processId4;
    }

    public static void setProcessId4(long processId4) {
        ThingsSteps.processId4 = processId4;
    }

    public static long getProcessId5() {
        return processId5;
    }

    public static void setProcessId5(long processId5) {
        ThingsSteps.processId5 = processId5;
    }

    @Then("I connect the {string} of {string}, in the project {string}")
    public static void iActivateThing(String thing, String gateway, String project) throws IOException {

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
            long pid = process.pid();
            System.out.println(pid);

            switch (thing) {
                case "thing1":
                    setProcessId1(pid);
                    break;
                case "thing2":
                    setProcessId2(pid);
                    break;
                case "thing3":
                    setProcessId3(pid);
                    break;
                case "thing4":
                    setProcessId4(pid);
                    break;
                case "thing5":
                    setProcessId5(pid);
                    break;
            }

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Then("I disconnect {string}")
    public void killNotifyThing(String thing) throws IOException {
        long pid;
        switch (thing) {
            case "thing1":
                pid =getProcessId1();
                break;
            case "thing2":
                pid =getProcessId2();
                break;
            case "thing3":
                pid = getProcessId3();
                break;
            case "thing4":
                pid = getProcessId4();
                break;
            case "thing5":
                pid = getProcessId5();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + thing);
        }

        String command = "taskkill /F /PID "+pid+" /T";
        System.out.println(command);
        Runtime.getRuntime().exec(command);
    }
}
