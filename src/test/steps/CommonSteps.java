package test.steps;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.MailEntity;
import ta.entities.Util;
import ta.entities.elements.PageElement;
import ta.entities.elements.PageElementHelper;
import ta.formatters.ReportFormatter;
import ta.steps.MobileSteps;
import ta.utilities.Configuration;
import ta.utilities.EmailUtil;
import ta.utilities.ReflectionUtils;
import ta.utilities.StepUtils;
import test.pages.DeploymentsHistoryPage;
import test.pages.HomePage;
import test.pages.LogPage;
import Util.UtilFunctions;
import Util.Mailinator;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;
import static ta.utilities.StepUtils.callFunction;

public class CommonSteps {

    public static int minutes = 0;

    public static String getEmailRandom() {
        return emailRandom;
    }

    public static void setEmailRandom(String emailRandom) {
        CommonSteps.emailRandom = emailRandom;
    }

    private static String emailRandom;


    public static int getMinutes() {
        return minutes;
    }

    @Then("^I check the presence of (\\w+).(\\w+)$")
    public static void checkElement(String className, String fieldName) throws Exception {
        Thread.sleep(1500);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(elem.isPresent())
            elem.scrollTo();
        Assert.assertTrue(elem.isPresent(50), "The element " + fieldName + " is not present in the page " + className);
    }

    public static void jsonReader(String[] elements, String property, String textToCheck, List<WebElement> descriptions) throws FileNotFoundException, IOException {
        String fileName = "resources/it.json";
        Path path = Paths.get(fileName);
        String value = "";
        List<String> descriptionString = new ArrayList<>();
        if (descriptions != null && !descriptions.isEmpty()) {
            for (WebElement we : descriptions) {
                descriptionString.add(we.getText().toLowerCase().trim());
            }
        }

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);

            JsonObject a = tree.getAsJsonObject();
            if (elements != null) {
                String start = elements[0];
                JsonObject json = a.get(start).getAsJsonObject();
                for (int i = 1; i < elements.length; i++) {
                    json = json.get(elements[i]).getAsJsonObject();
                }
                value = json.get(property).getAsString().toLowerCase().trim();
            } else {
                value = a.get(property).getAsString().toLowerCase().trim();
            }

            if (textToCheck != null) {
                System.out.println(textToCheck.toLowerCase());
                Assert.assertEquals(textToCheck.toLowerCase().trim(), value, "Testo diverso/non presente. Expected: " + value + " but found: " + textToCheck.toLowerCase());
            } else if (!descriptionString.isEmpty()) {
                Assert.assertTrue(descriptionString.contains(value), "Testo diverso/non presente. Expected: " + value);
            } else {
                throw new Exception("text to check and descriptionString List are both null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I set chrome {string} mode")
    public static void changeResolution(String mode) {
        int width = 0;
        int height = 0;
        if (mode.equalsIgnoreCase("iPhone")) {
            width = 400;
            height = 800;
        } else if (mode.equalsIgnoreCase("iPad") || mode.equalsIgnoreCase("tablet")) {
            width = 768;
            height = 1024;
        } else if (mode.equalsIgnoreCase("iPad pro")) {
            width = 1024;
            height = 1366;
        } else if (mode.equalsIgnoreCase("desktop")) {
            width = 1080;
            height = 1920;
        }
        CommonPage.getDriver().manage().window().setSize(new Dimension(width, height));
    }


    @Then("^I check the presence of (\\w+).(\\w+) Element and then i click it$")
    public static void checkAndClickElementPresent(String className, String fieldName) throws Exception {
        Thread.sleep(1000);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(elem.isPresent())
            elem.scrollTo();
        Assert.assertTrue(elem.isPresent(20), "The element " + fieldName + " is not present in the page " + className);
        Assert.assertTrue(elem.tryClick(true, false), "The element " + fieldName + " is not clickable");
        Thread.sleep(500);
    }

    @Then("^I type \"(.+)\" into the element (\\w+).(\\w+)$")
    public static void typeStringIntoElement(String text, String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        // assertTrue(elem.tryClick(true), "Unable to click on the element: " + fieldName);
        Thread.sleep(2000);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(text);
    }

    @And("I type \"(.+)\" minutes into the element (\\w+).(\\w+)$")
    public void iTypeMinutesIntoTheElementDeviceAlarmsConfigurationPageTimeWindow(String text, String className, String fieldName) throws Exception {

        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(text);

        minutes = Integer.parseInt(text);
        minutes *= 60;
    }

    @Then("^I cancel text from the input box element (\\w+).(\\w+)$")
    public static void cancelStringFromElement(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        //Doppio click per selezionare il testo
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.CONTROL + "a");
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.BACK_SPACE);
    }

    @Then("^I cancel a letter from the input box element (\\w+).(\\w+)$")
    public static void cancelLetterFromElement(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        //Doppio click per selezionare il testo
        //CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.CONTROL + "a");
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(Keys.BACK_SPACE);
    }

    @Then("I set a Breakpoint")
    public static void breakpoint() {
        System.out.println("breakpoint");
    }

    @Then("^I check that the element (\\w+).(\\w+) is not active.$")
    public static void checkElementNotActive(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        // System.out.println(elem.getAttribute("class"));
        Assert.assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        elem.scrollTo();
        Assert.assertTrue(elem.getAttribute("class").contains("disabled"), "The element " + fieldName + " is not disabled");
        //Assert.assertFalse(elem.isClickable(), "The element " + fieldName + " is not disabled"); //Metodo alternatico, non sicuro
    }

    @Then("^I check that the element (\\w+).(\\w+) is active.$")
    public static void checkElementActive(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        // System.out.println(elem.getAttribute("class"));
        boolean isTrue = elem.isPresent(15);
        Assert.assertTrue(isTrue, "The element " + fieldName + " is not present in the page " + className);
        elem.scrollTo();
        Assert.assertFalse(elem.getAttribute("class").contains("disabled"), "The Element "+fieldName+" is disabled");
        Assert.assertTrue(elem.isClickable(), "The element " + fieldName + " is disabled");

    }


    @Then("I launch command {string} on shell")
    public static void iLaunchCommandOnShell(String command) throws IOException {
        int count = 0;
        int exitCode = 0;
        boolean isRetry = true;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));

        while (isRetry) {
            try {
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if (line.contains("sending DISCONNECT")) {
                        System.out.println("The script has worked successfully");
                        isRetry = false;
                    }
                }
                exitCode = process.waitFor();
                if (count > 3) {
                    isRetry = false;
                }
                count++;
                System.out.println("Script code return: " + exitCode);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertNotEquals(exitCode, 1, "FAILURE -> exit code: " + exitCode);
    }

    static String readFile(String path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    @Then("I activate the {string} on {string}, in the project {string}.")
    public static void iLaunch2CommandsOnShell(String thing, String gateway, String project) throws IOException {

        String command1 = "bash ./notify_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway;
        String command2 = "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + thing + " ./payload_register_thing.txt";

        System.out.println(command1);
        System.out.println(command2);

        ProcessBuilder processBuilder1 = new ProcessBuilder();

        processBuilder1.command("powershell.exe", command1);
        processBuilder1.directory(new File(Configuration.get("path.scripsBash")));

        ProcessBuilder processBuilder2 = new ProcessBuilder();

        processBuilder2.command("powershell.exe", command2);
        processBuilder2.directory(new File(Configuration.get("path.scripsBash")));

        try {

            Process process = processBuilder1.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while (!(line = reader.readLine()).contains("Listening to topic")) {
                System.out.println(line);
            }
            System.out.println(line);

            //Now fill the form in the dmc with the correct payload//

            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "selectTemplateOption");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "othersTemplateOption");
            CommonSteps.cancelStringFromElement("DevicesDetailsPage", "templateForm");
            String activateThingPayload = CommonSteps.readFile(".\\scripts\\core_test_provisioning\\Payload_ActivationThing.txt");
            String activateThingPayloadOnProj = activateThingPayload.replace("<environment_prefix>", project);
            CommonSteps.typeStringIntoElement(activateThingPayloadOnProj, "DevicesDetailsPage", "templateForm");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "confirmActivateThingBTN");
            //Wait the activation and check the job (Directly on the DMC)
            Util.Wait(5 * 1000);
            //Uncomment to check the step function status.
            //CommonSteps.checkAndClickElementPresent("HomePage", "hamburgerMenuIcon");
            //CommonSteps.checkAndClickElementPresent("SidebarPage", "diagnosticOption");
            //CommonSteps.checkAndClickElementPresent("SidebarPage", "stepFunctionSubOption");
            //CommonSteps.checkAndClickElementPresent("StepFunctionPage", "firstRowDeviceDetailsIcon");
            //String jobID = StepFunctionPage.getJobID().getText();
            //System.out.println(jobID);

            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
            }

            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);


            try {

                Process processNew = processBuilder2.start();

                BufferedReader readerNew = new BufferedReader(new InputStreamReader(processNew.getInputStream()));

                //while (!(line = reader.readLine()).contains("jobID")) {
                //  System.out.println(line);
                //}
                //System.out.println(line);

                String lineNew = "";

                while (!(lineNew = readerNew.readLine()).contains("End Registration")) {
                  System.out.println(lineNew);
                }
                System.out.println(lineNew);
                /*
                while ((lineNew = readerNew.readLine()) != null) {
                    System.out.println(lineNew);
                }
                 */

                int exitCodeFirst = processNew.waitFor();
                System.out.println("\nThing registration Exited with error code: " + exitCodeFirst);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //process.waitFor(timeConnect, TimeUnit.SECONDS);
            //process = Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");
            //process.destroy();

            ProcessBuilder processBuilder3 = new ProcessBuilder();
            String commandCloseJob = "bash ./close_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + thing + " " + jobID;
            System.out.println(commandCloseJob);
            processBuilder3.command("powershell.exe", commandCloseJob);
            processBuilder3.directory(new File(Configuration.get("path.scripsBash")));

            try {

                Process processLast = processBuilder3.start();

                BufferedReader readerLast = new BufferedReader(new InputStreamReader(processLast.getInputStream()));

                String lineLast;

                while ((lineLast = readerLast.readLine()) != null) {
                    System.out.println(lineLast);
                }

                int exitCodeLast = processLast.waitFor();
                System.out.println("\nClosing job Exited with error code: " + exitCodeLast);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I check the visibility of (\\w+).(\\w+)$")
    public static void checkVisibleElement(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        //Assert timeout NEEDED otherwise when it loads landing page of massive projects it throws error
        assertTrue(elem.isVisible(10), "The element " + fieldName + " is not present in the page " + className);


    }

    public static String randomString(int min, int max) {
        return RandomStringUtils.randomAlphanumeric(min, max);
    }

    public static String randomNumber(int min, int max) {
        return RandomStringUtils.randomNumeric(min, max);
    }
    public static String generateRandomMail() {
        String text = "testconcept";
        String email = text.concat(randomString(8, 10)).concat("test@mailinator.com");
        System.out.println("# generated email #\n" + email);
        return email;
    }


    public static String findFunctionAndReplace(String string) {
        String outputResult = string;
        while (true) {
            Pattern p = Pattern.compile("\\$(\\w+)::(\\w+)\\(([^\"]*)\\)");
            Matcher m = p.matcher(outputResult);
            if (m.find()) {
                String className = m.group(1);
                String functionName = m.group(2);
                String[] params = m.group(3).split(",");
                if (params[0].isEmpty() && (params.length <= 1)) {
                    params = null;
                }

                if (params != null) {
                    for (int i = 0; i < params.length; i++) {
                        params[i] = params[i].trim();
                    }
                }

                String foundFoo = m.group(0);
                String result = callFunction(className, functionName, params);
                outputResult = outputResult.replaceFirst(Pattern.quote(foundFoo), result);
            } else {
                break;
            }
        }

        return outputResult;
    }


    @And("^I type the random mail into the element (\\w+).(\\w+)$")
    public void iTypeTheRandomMailIntoTheElement(String className, String fieldName) throws Exception {
        String randomMail = generateRandomMail();
        setEmailRandom(randomMail);
        writeUtilFile(randomMail);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(findFunctionAndReplace(randomMail));
    }

    @Then("^I click Element (\\w+).(\\w+) using Javascript$")
    public static void clickElementWithJS(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15));
        elem.clickJS(true);
    }

    @Then("I check if the number of rows present in the table is in accordion with the pagination number")
    public static void checkNumberOfRowPagination() {
        CommonSteps.waitProgressBar();
        int numberOfPagination = Integer.parseInt(LogPage.getPaginationTableButton().getText());
        try {
            PageElement pe = UtilFunctions.createNewPageElement("All rows present in the table", "//tbody/tr");
            pe.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No rows showed in 20 sec");
        }
        CommonSteps.waitProgressBar();
        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        if (rows.size() != numberOfPagination) {
            Assert.fail("The row present in the table are different from the expected ones. Table: " + rows.size() + " Expected: " + numberOfPagination);
        }else{
            LogPage.getPaginationTableButton().scrollTo();
        }

    }

    @And("^I check that the (\\w+).(\\w+) element is disabled$")
    public void iCheckThatTheButtonIsDisabled(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.isPresent(), "The Element: " + elem + "is not present");
        try {
            Assert.assertNotNull(elem.getAttribute("disabled"));
            ;
        } catch (Exception e) {
            Assert.fail("The Element is not disabled");
        }
    }

    @Then("I enter on {string} project")
    public static void enterOnProjectChoiced(String project) {
        if (HomePage.getClearBTN().isPresent()) {
            UtilFunctions.addScreenshot("Click on Clear button in order to deselect the projects selected");
            HomePage.getClearBTN().click();
        }
        String locator = String.format(HomePage.getProjectEsolChoiced().getBy().toString().replace("By.xpath: ", " ").trim(), project.toLowerCase());
        PageElement pe = UtilFunctions.createNewPageElement("Element " + locator, locator);
        if (pe.isPresent(20)) {
            pe.click();
            if (HomePage.getEnterBTN().isPresent()) {
                UtilFunctions.addScreenshot("Select the Project: " + project + " and then click on Enter");
                HomePage.getEnterBTN().click();
                //Assert.assertTrue(ProjectPage.getLabelDevices().isPresent(40), "Label Devices not found");
                //Smartphone landing page alarm section is not present so I check the only element present in all device mode
                //Assert.assertTrue(ProjectPage.getLabelAlarms().isPresent(), "Label Alarms not found");
                //Assert.assertTrue(ProjectPage.getLabelDeviceAndActivation().scrollTo(), "Unable to scroll to Label Devices & Activation not found");
                //Assert.assertTrue(ProjectPage.getLabelDeviceAndActivation().isPresent(), "Label Devices & Activation not found");
            } else {
                Assert.fail("Button Enter not present!");
            }
        } else {
            Assert.fail("No project found!");
        }
    }

    @Then("I check the presence of the project {string} and then i click it")
    public static void checkAndClickProject(String project) throws Exception {
        String locator = String.format(HomePage.getProjectEsolChoiced().getBy().toString().replace("By.xpath: ", " ").trim(), project.toLowerCase());
        PageElement pe = UtilFunctions.createNewPageElement("Element " + locator, locator);
        if (pe.isPresent(20)) {
            pe.scrollTo();
            Assert.assertTrue(pe.tryClick(false, false), "The Project: " + project + " is not clickable");
        } else {
            Assert.fail("No project found!");
        }
    }

    @Then("^I check the absence of (\\w+).(\\w+)$")
    public static void checkElementAbsent(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        //Assert timeout NEEDED otherwise when it loads landing page of massive projects it throws error
        Assert.assertFalse(elem.isPresent(50), "The element " + fieldName + " is present in the page " + className);
    }

    @Then("If present, I deactivate the {string} on {string}, in the project {string}")
    public static void iDeactivateThingIfPresent(String thing, String gateway, String project) throws Exception {
        String className = "";
        String fieldName = "";

        //em[@class='ng-star-inserted' and text()='Test_Concept-01_thing1']
        if(thing.equals("thing2") && gateway.equals("Test_Concept-02")){
            className = "DevicesPage";
            fieldName = "testConcept02Thing2Details";
        }
        if(thing.equals("thing1") && gateway.equals("Test_Concept-01")){
            className = "DevicesPage";
            fieldName = "testConcept01Thing1Row";
        }
        if(thing.equals("thing2") && gateway.equals("Test_Concept-01")){
            className = "DevicesPage";
            fieldName = "testConcept01Thing2Row";
        }
        if(thing.equals("thing3") && gateway.equals("Test_Concept-01")){
            className = "DevicesPage";
            fieldName = "testConcept01Thing3Row";
        }
        if(thing.equals("thing3") && gateway.equals("Test_Concept-02")){
            className = "DevicesPage";
            fieldName = "testConcept02Thing3Row";
        }
        Thread.sleep(1000);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        if(elem.isPresent()) {
            elem.scrollTo();
            Assert.assertTrue(elem.isPresent(20), "The element " + fieldName + " is not present in the page " + className);
            Assert.assertTrue(elem.tryClick(true, false), "The element " + fieldName + " is not clickable");
            Thread.sleep(500);
            CommandsUtilSteps.killNotifyJob();
            iDeactivateThing(thing, gateway, project);
            System.out.println("Wait 3 minutes to remove thing");
            Thread.sleep(180000);
            checkElementAbsent(className, fieldName);
        }
        else{
            System.out.println("Thing is not present");
        }
    }

    @Then("I deactivate the {string} on {string}, in the project {string}.")
    public static void iDeactivateThing(String thing, String gateway, String project) throws IOException {

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

            //Delete thing from the DMC//

            //CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "selectorThingBTN");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "selectedThingMoreInfo");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deactivateSelectedThing");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deleteCertificate");
            //force delete is not necessary since I am running notify_job
            //CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "forceDelete");
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deleteConfirm");


            while (!(line = reader.readLine()).contains("jobId")) {
                System.out.println(line);
            }
            System.out.println(line);

            JsonObject job_notification = new JsonParser().parse(line).getAsJsonObject();
            Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
            System.out.println(job_notification);
            String jobID = "";
            jobID = job_notification.get("execution").getAsJsonObject().get("jobId").getAsString();
            System.out.println(jobID);

            //process.waitFor(timeConnect, TimeUnit.SECONDS);

            ProcessBuilder processBuilder3 = new ProcessBuilder();
            String commandCloseJob = "bash ./close_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + gateway + " " + thing + " " + jobID;
            System.out.println(commandCloseJob);
            processBuilder3.command("powershell.exe", commandCloseJob);
            processBuilder3.directory(new File(Configuration.get("path.scripsBash")));

            try {

                Process processLast = processBuilder3.start();

                BufferedReader readerLast = new BufferedReader(new InputStreamReader(processLast.getInputStream()));

                String lineLast;

                while ((lineLast = readerLast.readLine()) != null) {
                    System.out.println(lineLast);
                }

                int exitCodeLast = processLast.waitFor();
                System.out.println("\nClosing job Exited with error code: " + exitCodeLast);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("I connect the device {string}, in the project {string}, for {int} seconds, then disconnect it.")
    public static void iConnectAndDisconnect(String device, String project, int timeConnect) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        String command = "bash ./notify_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com " + project + " " + device;

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

//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }

            //Util.Wait(1000*timeConnect);

            iWaitSecondsAfterScript(timeConnect);
            //process.waitFor(timeConnect, TimeUnit.SECONDS);
            process = Runtime.getRuntime().exec("taskkill /F /IM bash.exe /T");

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code: " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//
//
//    public static void main(String[] args) throws IOException {
//        iConnectAndDisconnect("Test_Concept-02","esol_ap29551_qa",60);
//    }
//
////    public static void main(String[] args) throws IOException {
////        iLaunch2CommandsOnShell("thing3", "Test_Concept-01", "esol_ap29551_qa");
////    }
//


    @Then("I check the mail boxes")
    public static void checkTheMailBox() throws InterruptedException {
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://www.mailinator.com/");

        Mailinator.getInputInbox().fillText(getEmailRandom(), true);
        if (Mailinator.getNewEmailReceived().isPresent(180)) {
            UtilFunctions.addScreenshot("check the email box");
            Assert.assertTrue(Mailinator.getNewEmailReceived().tryClick(), "Unable to click on email");
            UtilFunctions.addScreenshot("email received");
            CommonPage.getDriver().switchTo().frame("html_msg_body");
            Assert.assertTrue(Mailinator.getLinkConfirmSubscription().tryClick(), "Unable to click on link present in the email in order to confirm the subscription");
            tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
            CommonPage.getDriver().switchTo().window(tabs.get(2));
            Assert.assertTrue(Mailinator.getSubscriptionConfirmedTitle().isPresent(25), "Unable to check Label for subscription confirmed");
            UtilFunctions.addScreenshot("Subscription confirmed!");
//            Assert.assertTrue(Mailinator.getUnsubcribeLink().tryClick(), "Unable to click on link present Message pop up in order to unsubscribe ");
//            Assert.assertTrue(Mailinator.getSubscriptionRemovedTitle().isPresent(25), "Unable to check Label for removed subscription");
//            UtilFunctions.addScreenshot("Subscription removed!");
//            CommonPage.getDriver().switchTo().window(tabs.get(1));
//            PageElement pe = UtilFunctions.createNewPageElement("delete button mailinator", "//div/a[contains(text(),'Back to Inbox')]");
//            Assert.assertTrue(pe.tryClick(true), "Unable to click on backbutton in order to return to the inbox email");
//
//            Thread.sleep(5000);
//            List<WebElement> emailPresent  = CommonPage.getDriver().findElements(By.xpath("//table[contains(@class, 'table-striped')]/tbody/tr/td[1]"));
//            for(WebElement we : emailPresent){
//                we.click();
//            }
//            pe = UtilFunctions.createNewPageElement("delete button mailinator", "//button[@aria-label='Delete Button']");
//            Assert.assertTrue(pe.tryClick(true), "Unable to click on delete button in order to remove all email present in the inbox");
//            UtilFunctions.addScreenshot("All emails was successfully removed!");

        } else {
            Assert.fail("No email received in 3 minute");
        }
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen
    }


    @Then("I check the gmail inbox")
    public static void checkGmail() {
        EmailUtil mailutil = new EmailUtil("testconceptreplyenelx@gmail.com", "conceptreply");
        mailutil.loadDefaultConfig();
        mailutil.getMailsCount();
        MailEntity email = mailutil.findMailWithSubjectContains("AWS Notification - Subscription Confirmation", 3);
        System.out.println(email.getContent().toLowerCase().trim());
    }

    @Then("I check message of {string} notification in mail object, from device {string} in the project {string}")
    public static void checkTheMailObjectMessages(String typeAlarm, String device, String project) throws InterruptedException, IOException {
//        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://www.mailinator.com/");
        Mailinator.getInputInbox().fillText(CommonSteps.readUtilFile(), true);
        CommonPage.getDriver().switchTo().frame("texthtml_msg_body");
        Mailinator.setDeviceAndProjectInEmail(device, project);
        PageElement deviceAndProjectElement = UtilFunctions.createNewPageElement("Project and device in email", Mailinator.getDeviceAndProjectInEmail());
        boolean isTelemetryAll = false;
        int n = 1;
        int iterations = 20;
        PageElement mailToClick;
        Thread.sleep(3000);
        CommonPage.getDriver().navigate().refresh();
        switch (typeAlarm) {
            case "lower":
                if (Mailinator.getLowerThresholdReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getLowerThresholdReceived().isPresent(20), "The element " + Mailinator.getLowerThresholdReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getLowerThresholdReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No LOWER_THRESHOLD email received in 3 minutes");
                }
                break;
            case "telemetry":
                if (Mailinator.getTelemetryReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getTelemetryReceived().isPresent(20), "The element " + Mailinator.getTelemetryReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getTelemetryReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No TELEMETRY email received in 3 minutes");
                }
                break;
            case "alarm-cleared":
                if (Mailinator.getAlarmClearedReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getAlarmClearedReceived().isPresent(20), "The element " + Mailinator.getAlarmClearedReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getAlarmClearedReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No alarm cleared email received in 3 minutes");
                }
                break;
            case "higher":
                if (Mailinator.getHigherThresholdReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getHigherThresholdReceived().isPresent(20), "The element " + Mailinator.getHigherThresholdReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getHigherThresholdReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No HIGHER_THRESHOLD email received in 3 minutes");
                }
                break;
            case "higher all":
                Thread.sleep(3000);
                CommonPage.getDriver().navigate().refresh();
                for (int i = 0; i < iterations; i++) {
                    mailToClick = UtilFunctions.createNewPageElement("Project and device in email", "(//tbody/tr//td[contains(.,'HIGHER_THRESHOLD')])[" + n + "]");
                    if(mailToClick.isPresent(180))
                        Assert.assertTrue(mailToClick.tryClick(), "Unable to click on " + n + " email");
                    else
                        Assert.assertTrue(mailToClick.isPresent(), "Email has not been received");
                    if (!deviceAndProjectElement.isPresent()) {
                        iterations++;
                    } else if (Mailinator.getHigherTelemetryNotificationInEmail().isPresent(20) && deviceAndProjectElement.isPresent()) {
                        isTelemetryAll = true;
                        UtilFunctions.addScreenshot("Email received");
                        break;
                    }
                    System.out.println("Email received N " + n);
                    UtilFunctions.addScreenshot("Email received N " + n);
                    n++;
                    CommonPage.pressBack();
                }
                Assert.assertTrue(isTelemetryAll, "message of telemetry notification not present");
                break;
            case "lower all":
                Thread.sleep(3000);
                CommonPage.getDriver().navigate().refresh();
                for (int i = 0; i < iterations; i++) {
                    mailToClick = UtilFunctions.createNewPageElement("Project and device in email", "(//tbody/tr//td[contains(.,'LOWER_THRESHOLD')])[" + n + "]");
                    if(mailToClick.isPresent(180))
                        Assert.assertTrue(mailToClick.tryClick(), "Unable to click on " + n + " email");
                    else
                        Assert.assertTrue(mailToClick.isPresent(), "Email has not been received");
                    if (!deviceAndProjectElement.isPresent()) {
                        iterations++;
                    } else if (Mailinator.getLowerThresholdReceived().isPresent(20) && deviceAndProjectElement.isPresent()) {
                        isTelemetryAll = true;
                        UtilFunctions.addScreenshot("Email received");
                        break;
                    }
                    System.out.println("Email received N " + n);
                    UtilFunctions.addScreenshot("Email received N " + n);
                    n++;
                    CommonPage.pressBack();
                }
                Assert.assertTrue(isTelemetryAll, "message of telemetry notification not present");
                break;
            case "telemetry all":
                Thread.sleep(3000);
                CommonPage.getDriver().navigate().refresh();
                for (int i = 0; i < iterations; i++) {
                    mailToClick = UtilFunctions.createNewPageElement("Project and device in email", "(//tbody/tr//td[contains(.,'TELEMETRY')])[" + n + "]");
                    if(mailToClick.isPresent(180))
                        Assert.assertTrue(mailToClick.tryClick(), "Unable to click on " + n + " email");
                    if (!deviceAndProjectElement.isPresent()) {
                        iterations++;
                    } else if (Mailinator.getTelemetryReceived().isPresent(20) && deviceAndProjectElement.isPresent()) {
                        isTelemetryAll = true;
                        UtilFunctions.addScreenshot("Email received");
                        break;
                    }
                    System.out.println("Email received N " + n);
                    UtilFunctions.addScreenshot("Email received N " + n);
                    n++;
                    CommonPage.pressBack();
                }
                Assert.assertTrue(isTelemetryAll, "message of telemetry notification not present");
                break;
            case "higher_aggregated":
                if (Mailinator.getAggregatedNotificationReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getAggregatedNotificationReceived().isPresent(20), "The element " + Mailinator.getAggregatedNotificationReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getAggregatedNotificationReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No AGGREGATED_NOTIFICATION email received in 3 minutes");
                }
                break;
            case "business":
                if (Mailinator.getBusinessAlarmReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getBusinessAlarmReceived().isPresent(20), "The element " + Mailinator.getBusinessAlarmReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getBusinessAlarmReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No BUSINESS_ALARM email received in 3 minutes");
                }
                break;
            case "lifecycle":
                if (Mailinator.getlifecycleNotificationReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getlifecycleNotificationReceived().isPresent(20), "The element " + Mailinator.getBusinessAlarmReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getlifecycleNotificationReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No LIFECYCLE email received in 3 minutes");
                }
                break;
            case "widspread disservice":
                if (Mailinator.getWidspreadDisserviceReceived().isPresent(180)){
                    UtilFunctions.addScreenshot("check the email box");
                    Assert.assertTrue(Mailinator.getWidspreadDisserviceReceived().isPresent(20), "The element " + Mailinator.getWidspreadDisserviceReceived() + " is not present in the page ");
                    Assert.assertTrue(Mailinator.getWidspreadDisserviceReceived().tryClick(), "Unable to click on email");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
                    //Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
                }
                else{
                    Assert.fail("No DISSERVICE email received in 3 minutes");
                }
        }
        //I check device name and apm only if the configuration is not of type all, otherwise i could find any other device sending messages
        if (!typeAlarm.contains("all")) {
            Assert.assertTrue(deviceAndProjectElement.isPresent(20), "device and project specified not present in email");
        }
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen
    }
    @Then("I check message of {string} notification in mail boxes, from device {string} in the project {string}")
    public static void checkTheMailBoxMessages(String typeAlarm, String device, String project) throws InterruptedException, IOException {
//        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://www.mailinator.com/");

        Mailinator.getInputInbox().fillText(CommonSteps.readUtilFile(), true);
        if (Mailinator.getNewEmailErrorReceived().isPresent(180)) {
            UtilFunctions.addScreenshot("check the email box");
            Assert.assertTrue(Mailinator.getNewEmailErrorReceived().isPresent(20), "The element " + Mailinator.getNewEmailErrorReceived() + " is not present in the page ");
            Assert.assertTrue(Mailinator.getNewEmailErrorReceived().tryClick(), "Unable to click on email");
            CommonPage.getDriver().switchTo().frame("texthtml_msg_body");
            Mailinator.setDeviceAndProjectInEmail(device, project);
            //I check device name and apm only if the configuration is not of type all, otherwise i could find any other device sending messages
            if (!typeAlarm.contains("all")) {
                PageElement deviceAndProjectElement = UtilFunctions.createNewPageElement("Project and device in email", Mailinator.getDeviceAndProjectInEmail());
                Assert.assertTrue(deviceAndProjectElement.isPresent(20), "device and project specified not present in email");
            }
            switch (typeAlarm) {
                //for telemetry Higher or lower I check last 2 emails received because they send both in alarm and alarm-cleared notification
                //with the exact same timestamp
                case "lower":
                    boolean isLower = false;
                    if (Mailinator.getLowerTelemetryNotificationInEmail().isPresent(20)){
                        isLower=true;
                    }else {
                        CommonPage.pressBack();
                        //I check the second email received
                        Assert.assertTrue(Mailinator.getSecondEmailErrorReceived().tryClick(), "Unable to click on email");
                        if (Mailinator.getLowerTelemetryNotificationInEmail().isPresent(20)){
                            isLower=true;}
                    }
                    Assert.assertTrue(isLower, "message of lower telemetry notification not present");
                    break;
                case "higher":
                    boolean isHigher = false;
                    if (Mailinator.getHigherTelemetryNotificationInEmail().isPresent(20)){
                        isHigher=true;
                    }else {
                        CommonPage.pressBack();
                        //I check the second email received
                        Assert.assertTrue(Mailinator.getSecondEmailErrorReceived().tryClick(), "Unable to click on email");
                        if (Mailinator.getHigherTelemetryNotificationInEmail().isPresent(20)){
                            isHigher=true;}
                    }
                    Assert.assertTrue(isHigher, "message of higher telemetry notification not present");
                    break;
                    case "telemetry all":
                        PageElement deviceAndProjectElement = UtilFunctions.createNewPageElement("Project and device in email", Mailinator.getDeviceAndProjectInEmail());
                        boolean isTelemetryAll = false;
                        int n = 1;
                        int iterations = 5;
                        PageElement mailToClick = UtilFunctions.createNewPageElement("Project and device in email", "(//tbody/tr["+n+"]//td[contains(.,'ERROR notification')])");
                    if (Mailinator.getLowerTelemetryNotificationInEmail().isPresent(20) && deviceAndProjectElement.isPresent()){
                        UtilFunctions.addScreenshot("Email received");
                        isTelemetryAll=true;
                    }else {
                        for (int i = 0; i < iterations; i++){
                        CommonPage.pressBack();
                        //I check other email received until fifth
                        Assert.assertTrue(mailToClick.tryClick(), "Unable to click on "+n+" email");
                            if (!deviceAndProjectElement.isPresent()){
                                iterations++;
                            }else if (Mailinator.getLowerTelemetryNotificationInEmail().isPresent(20) && deviceAndProjectElement.isPresent()){
                                isTelemetryAll=true;
                                UtilFunctions.addScreenshot("Email received");
                                break;
                            }
                        System.out.println("Email received N "+n);
                        UtilFunctions.addScreenshot("Email received N "+n);
                        n++;

                    }}
                    Assert.assertTrue(isTelemetryAll, "message of telemetry notification not present");
                    break;
                    case "higher_aggregated":
                    boolean isHigherAggregated = false;
                    if (Mailinator.getHigherAggregatedTelemetryNotificationInEmail().isPresent(20)){
                        isHigherAggregated=true;
                    }else {
                        CommonPage.pressBack();
                        //I check the second email received
                        Assert.assertTrue(Mailinator.getSecondEmailErrorReceived().tryClick(), "Unable to click on email");
                        if (Mailinator.getHigherAggregatedTelemetryNotificationInEmail().isPresent(20)){
                            isHigherAggregated=true;}
                    }
                    Assert.assertTrue(isHigherAggregated, "message of higher telemetry notification not present");
                    break;

                case "alarm-cleared":
                    boolean isCleared = false;
                    if (Mailinator.getAlarmClearedTelemetryNotificationInEmail().isPresent(20)){
                        isCleared=true;
                    }else {
                        CommonPage.pressBack();
                        //I check the second email received
                        Assert.assertTrue(Mailinator.getSecondEmailErrorReceived().tryClick(), "Unable to click on email");
                        if (Mailinator.getAlarmClearedTelemetryNotificationInEmail().isPresent(20)){
                            isCleared=true;}
                    }
                    Assert.assertTrue(isCleared, "message of cleared telemetry notification not present");
                    break;
                case "short time disservice":
                    Assert.assertTrue(Mailinator.getTextOfDisserviceNotificationInEmail().isPresent(20), "message of disservice notification not present");
                    Assert.assertTrue(Mailinator.getShortTimeDisserviceNotificationInEmail().isPresent(20), "message of short time disservice notification not present");
                    break;
                case "long time disservice":
                    Assert.assertTrue(Mailinator.getTextOfDisserviceNotificationInEmail().isPresent(20), "message of disservice notification not present");
                    Assert.assertTrue(Mailinator.getLongTimeDisserviceNotificationInEmail().isPresent(20), "message of long time disservice notification not present");
                    break;
                case "business":
                    Assert.assertTrue(Mailinator.getTextOfBusinessNotificationInEmail().isPresent(20), "message of business notification not present");
                    break;
                case "cloud component":
                    Assert.assertTrue(Mailinator.getTextOfCloudComponentInEmail().isPresent(20), "message of cloud component notification not present");
                case "telemetry":
                    Assert.assertTrue(Mailinator.getTextOfLowTelemetryNotificationInEmail().isPresent(20), "message of telemetry notification not present");
                    break;
                default: Assert.fail("The method needs an alarm type specification valid.");
            }
            UtilFunctions.addScreenshot("email received");
        } else {
            Assert.fail("No email received in 3 minutes");
        }
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen
    }

    @Then("I wait the progress bar")
    public static void waitProgressBar() {
        PageElement progressBar = UtilFunctions.createNewPageElement("progress bar", "//mat-spinner[@role='progressbar']");
        if (progressBar.isPresent()) {
            Assert.assertTrue(progressBar.isInvisible(120), "progress bar present after 120 sec");
        }
    }

    @Then("I wait the ticket progress bar")
    public static void waitTicketProgressBar() {
        PageElement progressBar = UtilFunctions.createNewPageElement("progress bar", "//h1[@class='d-flex align-items-center justify-content-center loader-spin ng-star-inserted']");
        if (progressBar.isPresent()) {
            Assert.assertTrue(progressBar.isInvisible(120), "progress bar present after 120 sec");
        }
    }

    @And("^I check that the (\\w+).(\\w+) element is not disabled$")
    public void iCheckThatTheButtonIsNotDisabled(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.isPresent(), "The Element: " + elem + "is not present");
        Assert.assertNull(elem.getAttribute("disabled"), "The Element is disabled");
    }

    @Then("^I enter a query \"(.+)\" with parameter \"(.+)\" changed with value \"(.+)\" in (\\w+).(\\w+)$")
    public void iEnterAQueryInAElement(String queryFile, String parameterQuery, String valueParameterQuery, String className, String fieldName) throws Exception {

        String pathQuery = "";
        String newQuery = "";
        String queryStr = "";

        pathQuery = Configuration.get("path.scriptQuery") + queryFile;
        queryStr = CommonSteps.readFile(pathQuery);
        newQuery = queryStr.replace(parameterQuery, valueParameterQuery);

        System.out.println(newQuery);
        CommonSteps.typeStringIntoElement(newQuery, className, fieldName);
        System.out.println(newQuery);
    }

    @And("Info {string}")
    public void info(String msg) {
        System.out.println(msg);
    }

    public void writeUtilFile(String msg) {
        String path = ".\\resources\\utils.txt";
        try {
            File file = new File(path);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    Assert.fail("unable to create util file");
                }
            }
            System.out.println("file present");
            BufferedWriter bw = new BufferedWriter(new FileWriter(".\\resources\\utils.txt"));
            bw.write(msg);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readUtilFile() throws IOException {
        // incapsula in BufferedReader un file aperto in lettura
        String msg = "";
        BufferedReader filebuf = new BufferedReader(new FileReader(".\\resources\\utils.txt"));
        String nextStr = filebuf.readLine();     // legge una riga del file
        if (nextStr != null) {
            msg = nextStr;
            filebuf.close();  // chiude il file
        }
        return msg;

    }

    @Then("I wait {int} minutes after script")
    public static void iWaitMinutesAfterScript(int num) throws InterruptedException {
        int sec = 60 * num;
        for (int i = 1; i <= sec; i++) {
            if (i % 10 == 0) {
                Thread.sleep(10000);
                CommonPage.getDriver().navigate().refresh();
                System.out.println(i);
            }
        }
    }
    @Then("I wait {int} seconds after script")
    public static void iWaitSecondsAfterScript(int sec) throws InterruptedException {
        for (int i = 1; i <= sec; i++) {
            if (i % 10 == 0) {
                Thread.sleep(10000);
                System.out.println(i);
            }
        }
    }

    @Then("^I check that (\\w+).(\\w+) contains (\\w+)$")
    public void iCheckThatWWContains(String className, String fieldName, String text) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.getText().equalsIgnoreCase(text), "Text is not as expected");
    }

    @Then("^I click on the first option from (\\w+).(\\w+)$")
    public void iClickOnTheFirstOption(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);

        Select ddmLambdasLogs = new Select(CommonPage.getDriver().findElement(elem.getBy()));
        ddmLambdasLogs.selectByIndex(1);
    }


    @Then("I wait {int} minutes to be outside the notification window")
    public static void iWaitMinutesToBeOutsideTheNotificationWindow(int num) throws InterruptedException {
        iWaitMinutesAfterScript(num);
    }


    @Then("I check the number of emails received and expect {int} notification")
    public static void iCheckTheNumberOfEmailsReceivedAndExpect(int emailExpected) throws IOException, InterruptedException {
//        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)).navigate().back();
        CommonPage.getDriver().switchTo().window(tabs.get(1)).navigate().refresh();
        Thread.sleep(2000);
        int emailPresent = CommonPage.getDriver().findElements(Mailinator.getAllEmailReceived().getBy()).size();
        UtilFunctions.addScreenshot("Controllo mail presenti");
        Assert.assertEquals(emailPresent, emailExpected, "Email received number not as expected");
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen
    }

    @Then("^I clear (\\w+).(\\w+)$")
    public void iClearMqttClientPageInputField(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        CommonPage.getDriver().findElement(elem.getBy()).clear();
    }

    @Then("^I verify that (\\w+).(\\w+) contains (\\w+)$")
    public void iVerifyThatWWContains(String className, String fieldName, String text) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.getText().toLowerCase().contains(text.toLowerCase()), "Text expected: " + text + ", actual: " + elem.getText());
    }


    @Then("^If Element (\\w+).(\\w+) is present I click it$")
    public void ifElementPresentIClickIt(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Thread.sleep(2000);
        if (elem.isPresent(30)) {
            Assert.assertTrue(elem.tryClick(), "Cannot click element " + fieldName + " in page " + className);
        }
    }

    private static int numberOfEmails;

    public static int getNumberOfMails() {
        return numberOfEmails;
    }

    public static void setNumberOfMails(int numberOfEmails) {
        CommonSteps.numberOfEmails = numberOfEmails;
    }

    @Then("I save current number of emails")
    public static void iSaveNofEmails() throws IOException, InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://www.mailinator.com/");
        Mailinator.getInputInbox().fillText(CommonSteps.readUtilFile(), true);
        Thread.sleep(5000);
        int emailPresent = CommonPage.getDriver().findElements(Mailinator.getAllEmailReceived().getBy()).size();
        setNumberOfMails(emailPresent);
        System.out.println("Current n. of emails  " + emailPresent);
        CommonPage.getDriver().switchTo().window(tabs.get(0)); // switch back to main screen

    }

    @Then("I check there are no more mail notifications")
    public static void iCheckNoMoreEmails() throws IOException, InterruptedException {
        Thread.sleep(5000);
        int emailExpected = CommonSteps.getNumberOfMails();

        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);
        int emailPresent = CommonPage.getDriver().findElements(Mailinator.getAllEmailReceived().getBy()).size();
        Assert.assertEquals(emailPresent, emailExpected, "Email received number not as expected");
        CommonPage.getDriver().switchTo().window(tabs.get(0));
    }

    @Then("I check there is a new mail notification")
    public static void iCheckOneMoreEmail() throws IOException {
        int emailPresent = CommonPage.getDriver().findElements(Mailinator.getAllEmailReceived().getBy()).size();
        int emailExpected = CommonSteps.getNumberOfMails() + 1;
        ((JavascriptExecutor) CommonPage.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(1)); //switches to new tab
        CommonPage.getDriver().get("https://www.mailinator.com/");

        Mailinator.getInputInbox().fillText(CommonSteps.readUtilFile(), true);
        Assert.assertEquals(emailPresent, emailExpected, "Email received number not as expected");

    }

    @And("I check if the filter works for {string} and {string}")
    public void iCheckIfTheFilterWorksForSwGatewayAndRegressionEig(String first, String second) {
        new WebDriverWait(CommonPage.getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//td[4][contains(.,'%s')]", first))));
        ArrayList<WebElement> listSecondColumn = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath(String.format("//td[4][contains(.,'%s')]", first)));
        ArrayList<WebElement> listThirdColumn = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath(String.format("//td[5][contains(.,'%s')]", second)));
        assertEquals(listThirdColumn.size(), listSecondColumn.size(), String.format("Filter based on %s and %s doesn't properly work", first, second));
    }

    @And("I check if filtered only {string} for {string}")
    public void iCheckIfAreFilteredOnlyCompleted(String text, String field) throws InterruptedException {
        int time = 10;
        switch (field) {
            case "status": {
                String xpath = String.format("//i[contains(@class,'%s') or contains(@class,'%s')]", text.toLowerCase(), text.toLowerCase().substring(0, text.length() - 2));
                waitForElementLocatedByXpath(xpath, time);
                waitForElementLocatedBy(DeploymentsHistoryPage.rowsDisplayed.getBy(), time);
                String righeMostrate = CommonPage.getDriver().findElement(DeploymentsHistoryPage.rowsDisplayed.getBy()).getText();
                int size = !righeMostrate.toLowerCase().contains("no rows") ? Integer.parseInt(righeMostrate.substring(0, righeMostrate.indexOf("of")).split(" ")[2]) : 0;
                ArrayList<WebElement> list = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath(xpath));
                assertEquals(list.size(), size, String.format("Filter not properly works for status %s", text));
                break;
            }
            case "latest": {
                waitForElementLocatedBy(DeploymentsHistoryPage.rowsDisplayed.getBy(), time);
                String righeMostrate = CommonPage.getDriver().findElement(DeploymentsHistoryPage.rowsDisplayed.getBy()).getText();
                int size = !righeMostrate.toLowerCase().contains("no rows") ? Integer.parseInt(righeMostrate.substring(0, righeMostrate.indexOf("of")).split(" ")[2]) : 0;
                waitForElementLocatedBy(DeploymentsHistoryPage.YesIcon.getBy(), time);
                ArrayList<WebElement> list = (ArrayList<WebElement>) CommonPage.getDriver().findElements(DeploymentsHistoryPage.YesIcon.getBy());
                if (text.equalsIgnoreCase("yes")) {
                    assertEquals(list.size(), size, String.format("Filter not properly works for status %s", text));
                } else {
                    assertEquals(list.size(), 0, String.format("Filter not properly works for status %s", text));
                }
                break;
            }
            case "deploy": {
                waitForElementLocatedBy(DeploymentsHistoryPage.rowsDisplayed.getBy(), time);
                String righeMostrate = CommonPage.getDriver().findElement(DeploymentsHistoryPage.rowsDisplayed.getBy()).getText();
                int size = !righeMostrate.toLowerCase().contains("no rows") ? Integer.parseInt(righeMostrate.substring(0, righeMostrate.indexOf("of")).split(" ")[2]) : 0;
                if (size > 0) {
                    String xpathIconaTipoDeploy = "//td/i[contains(@aria-describedby,'cdk-describedby-message')]";
                    waitForElementLocatedByXpath(xpathIconaTipoDeploy, time);
                    ArrayList<WebElement> list = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath(xpathIconaTipoDeploy));
                    String number = "0";
                    number = list.get(0).getAttribute("aria-describedby");
                    String xpathDivLegend = String.format("//div[@id='%s']", number);
                    ((JavascriptExecutor) CommonPage.getDriver()).executeScript("document.getElementById('cdk-describedby-message-container').setAttribute('style', '')");
                    String message = CommonPage.getDriver().findElement(By.xpath(xpathDivLegend)).getText();
                    assertEquals(text.toLowerCase().trim(), message.toLowerCase().trim(), "Filter doesn't work for " + field);
                }
                break;
            }
            default:
                break;
        }

    }

    public static void waitForElementLocatedByXpath(String xpath, int time) throws InterruptedException {
        boolean showed = false;
        int counter = 0;
        while (!showed && counter < time) {
            try {
                showed = CommonPage.getDriver().findElement(By.xpath(xpath)).isDisplayed();
                counter++;
            } catch (Exception e) {
                Thread.sleep(1000);
                counter++;
            }
        }
    }

    public static void waitForElementLocatedByXpath(String xpath) throws InterruptedException {
        int time = 60;
        boolean showed = false;
        int counter = 0;
        while (!showed && counter < time) {
            try {
                showed = CommonPage.getDriver().findElement(By.xpath(xpath)).isDisplayed();
                counter++;
            } catch (Exception e) {
                Thread.sleep(1000);
                counter++;
            }
        }
    }

    public static void waitForElementLocatedBy(By by, int time) throws InterruptedException {
        boolean showed = false;
        int counter = 0;
        while (!showed && counter < time) {
            try {
                showed = CommonPage.getDriver().findElement(by).isDisplayed();
                counter++;
            } catch (Exception e) {
                Thread.sleep(1000);
                counter++;
            }
        }
    }

    @Then("I wait up to {int} minutes after reboot")
    public void iWaitUpToMinutesAfterReboot(int minutes) throws InterruptedException {
        iWaitMinutesAfterScript(minutes);
    }

    // These strings were used in the old way to retrieve tokens
    //private static String adminToken = "return localStorage[\"{\\\"authority\\\":\\\"https://login.microsoftonline.com/d539d4bf-5610-471a-afc2-1c76685cfefa/\\\",\\\"clientId\\\":\\\"9ae3f295-5c09-49d0-adbb-3cddceb6dbfa\\\",\\\"scopes\\\":\\\"Group.Read.All User.Read profile openid email\\\",\\\"homeAccountIdentifier\\\":\\\"ZmMyMTE2ZTItZjYwNi00YTcyLWEzMWQtMTVhOTZkZjA3NzI4.ZDUzOWQ0YmYtNTYxMC00NzFhLWFmYzItMWM3NjY4NWNmZWZh\\\"}\"]";
    //private static String basicToken = "return localStorage[\"{\\\"authority\\\":\\\"https://login.microsoftonline.com/d539d4bf-5610-471a-afc2-1c76685cfefa/\\\",\\\"clientId\\\":\\\"9ae3f295-5c09-49d0-adbb-3cddceb6dbfa\\\",\\\"scopes\\\":\\\"Group.Read.All User.Read profile openid email\\\",\\\"homeAccountIdentifier\\\":\\\"ZjA5ZTgzYTEtMTE1OC00ZWNkLTk3MmUtNGM4NGVmNjIzMWI2.ZDUzOWQ0YmYtNTYxMC00NzFhLWFmYzItMWM3NjY4NWNmZWZh\\\"}\"]";
    //private static String basic_CompacF_false = "return localStorage[\"{\\\"authority\\\":\\\"https://login.microsoftonline.com/d539d4bf-5610-471a-afc2-1c76685cfefa/\\\",\\\"clientId\\\":\\\"9ae3f295-5c09-49d0-adbb-3cddceb6dbfa\\\",\\\"scopes\\\":\\\"Group.Read.All User.Read profile openid email\\\",\\\"homeAccountIdentifier\\\":\\\"M2Q4YjQ2ZTQtZTlmZi00OTZjLTllZWQtYjU1ZDQ5YTk1YjMx.ZDUzOWQ0YmYtNTYxMC00NzFhLWFmYzItMWM3NjY4NWNmZWZh\\\"}\"]";

    private static String retrievedToken;

    public static String getRetrievedToken() {
        return retrievedToken;
    }

    public void setRetrievedToken(String retrievedToken) {
        this.retrievedToken = retrievedToken;
    }

    @And("I retrieve token from dmc")
    public void retrieveToken(){
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) CommonPage.getDriver();
            setRetrievedToken(jsExecutor.executeScript("return JSON.parse(localStorage[Object.keys(localStorage).find(key => key.includes(\"login.windows.net-accesstoken\"))]).secret").toString());
        } catch (Exception e) {
            Assert.fail("Failed to retrieve token from dmc cache - " + e);
        }
    }

    /*
    @And("I retrieve token from dmc with {string} user")
    public void retrieveToken(String user) {
        String itemFromStorage = null;
        switch (user) {
            case "admin":
                itemFromStorage = adminToken;
                break;
            case "basic":
                itemFromStorage = basicToken;
                break;
            case "basic_CompacF_false":
                itemFromStorage = basic_CompacF_false;
                break;
            default:
                Assert.fail("No valid option. User are: basic, basic_CompacF_false, admin");
        }
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) CommonPage.getDriver();
            // retrieve the item value
            String scriptToken = jsExecutor.executeScript(itemFromStorage).toString();
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(scriptToken);

            JsonObject a = tree.getAsJsonObject();
            a.get("accessToken");
            setRetrievedToken(a.get("accessToken").getAsString());
        } catch (Exception e) {
            Assert.fail("Failed to retrieve token from dmc cache - " + e);
        }
    }

     */



    public static void waitForElementLocatedBy(By by) throws InterruptedException {
        int time = 60;
        boolean showed = false;
        int counter = 0;
        while (!showed && counter < time) {
            try {
                showed = CommonPage.getDriver().findElement(by).isDisplayed();
                counter++;
            } catch (Exception e) {
                Thread.sleep(1000);
                counter++;
            }
        }
    }

    @And("I select {int} element of list identified by DeploymentsHistoryPage.checkableRow")
    public void iSelectElementOfListIdentifiedByXpath(int arg0) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString("DeploymentsHistoryPage", "checkableRow");
        new WebDriverWait(CommonPage.getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(elem.getBy()));
        ArrayList<WebElement> listElement = (ArrayList<WebElement>) CommonPage.getDriver().findElements(elem.getBy());
        for (int i = 0; i < arg0; i++) {
            Thread.sleep(500);
            elem.scrollTo();
            Thread.sleep(500);
            listElement.get(i).click();
        }
    }

    static String nameToFilter = "";
    static public String nameOption = "";

    @And("I save the name of the first record")
    public void iSaveTheNameOfTheFirstRecord() throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString("CampaignManagementView", "firstRowName");
        waitForElementLocatedBy(elem.getBy(), 60);
        nameToFilter = elem.getText().trim();
    }

    @And("I save the name of the first type record")
    public void iSaveTheNameOfTheFirstTypeRecord() throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString("CampaignManagementView", "firstRowType");
        waitForElementLocatedBy(elem.getBy(), 60);
        nameOption = elem.getText().trim();
    }

    @And("^I input the name previously saved into (\\w+).(\\w+)$")
    public void iInputTheNamePreviouslySavedInto(String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        elem.fillText(nameToFilter);
    }

    @Then("I check if the results has only the name previously saved")
    public void iCheckIfTheResultsHasOnlyTheNamePreviouslySaved() throws InterruptedException {
        waitForElementLocatedByXpath("//tr/td[2]");
        ArrayList<WebElement> listElement = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath("//tr/td[2]"));

        for (WebElement e : listElement) {
            assertEquals(e.getText().trim(), nameToFilter.trim(), "Filter on Gateway ID doesn't work properly: keyword -> " + nameToFilter.trim() + " but founded also -> " + e.getText().trim());
        }

    }

    //static String nameOption = "";

    @And("^I save the text of the first option of the list (\\w+).(\\w+)$")
    public void iSaveTheTextOfTheFirstOptionOfTheList(String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        nameOption = elem.getText().trim();
    }

    @And("I check if filter for {string}")
    public void iCheckIfFilterFor(String arg0) throws InterruptedException {

        switch (arg0) {
            case "Gateway Software Type":
            case "Thing Software Type":{
                waitForElementLocatedByXpath("//tr/td[3]");
                ArrayList<WebElement> listElement = (ArrayList<WebElement>) CommonPage.getDriver().findElements(By.xpath("//tr/td[3]"));

                for (WebElement e : listElement) {
                    assertEquals(e.getText().trim(), nameOption.trim(), "Filter on Gateway ID doesn't work properly: keyword -> " + nameOption.trim() + " but founded also -> " + e.getText().trim());
                }
                break;
            }
            case "Custom Query": {
                String xpath2 = "//*[contains(text(),\"" + nameToFilter + "\")]";
                waitForElementLocatedByXpath(xpath2);
                PageElement el = UtilFunctions.createNewPageElement("First Record Name", xpath2);
                assertTrue(el.isPresent(), "Record with name " + nameToFilter + " not found");
            }
            default:
                break;
        }
    }


    @And("^I input the custom query into (\\w+).(\\w+)$")
    public void iInputCustomQuery(String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);

        String query = String.format("[\n" +
                " {\n" +
                "  \"query\": {\n" +
                "   \"bool\": {\n" +
                "    \"must\": [\n" +
                "     {\n" +
                "      \"match\": {\n" +
                "        \"latest\": true\n" +
                "      }\n" +
                "     } \n" +
                "    ],\n" +
                "    \"filter\": {\n" +
                "     \"terms\": {\n" +
                "      \"gateway_id.keyword\": [\n" +
                "        \"%s\"\n" +
                "      ]\n" +
                "     }\n" +
                "    }\n" +
                "   }\n" +
                "  }\n" +
                " },\n" +
                " {\n" +
                "  \"devices_types\": \"not_supported\"\n" +
                " }\n" +
                "]", nameToFilter);
        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(query);
        System.out.println();

    }

    @And("^I check if the elements are disabled except for firmwareUpdateButton$")
    public void iCheckIfTheAttributeOfTheElementIs() throws Exception {

        waitForElementLocatedBy(DeploymentsHistoryPage.greengrassDeployButton.getBy());

        String greengrassDeployButton = CommonPage.getDriver().findElement(DeploymentsHistoryPage.greengrassDeployButton.getBy()).getAttribute("class");
        String greengrassResetButton = CommonPage.getDriver().findElement(DeploymentsHistoryPage.greengrassResetButton.getBy()).getAttribute("class");
        String otaUpdateButton = CommonPage.getDriver().findElement(DeploymentsHistoryPage.otaUpdateButton.getBy()).getAttribute("class");
        String firmwareUpdateButton = CommonPage.getDriver().findElement(DeploymentsHistoryPage.firmwareUpdateButton.getBy()).getAttribute("class");


        assertTrue(greengrassDeployButton.contains("disabled"), "Element " + DeploymentsHistoryPage.greengrassDeployButton.getDescription() + " doesn't contains '" + "disabled" + "' in the attribute " + "class");
        assertTrue(greengrassResetButton.contains("disabled"), "Element " + DeploymentsHistoryPage.greengrassResetButton.getDescription() + " doesn't contains '" + "disabled" + "' in the attribute " + "class");
        assertTrue(otaUpdateButton.contains("disabled"), "Element " + DeploymentsHistoryPage.otaUpdateButton.getDescription() + " doesn't contains '" + "disabled" + "' in the attribute " + "class");
        assertFalse(firmwareUpdateButton.contains("disabled"), "Element " + DeploymentsHistoryPage.firmwareUpdateButton.getDescription() + " contains '" + "disabled" + "' in the attribute " + "class");


    }

    @And("I reload the page")
    public void iReloadThePage() {
        CommonPage.getDriver().navigate().refresh();
    }

    @Then("^I verify that (\\w+).(\\w+) contains \"(.+)\"$")
    public void iVerifyThatWWContainsString(String className, String fieldName, String text) throws Exception {
        Thread.sleep(2000);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.getText().toLowerCase().contains(text.toLowerCase()), "Text expected: " + text + ", actual: " + elem.getText());
    }


    public static String getStringRandom() {
        return stringRandom;
    }

    public static void setStringRandom(String stringRandom) {
        CommonSteps.stringRandom = stringRandom;
    }

    private static String stringRandom;
    public static HashMap<String, String> randomMap = new HashMap<>();

    public static String generateRandomString() {
        String text = randomString(1, 10);
        System.out.println("# generated string #\n" + text);
        return text;
    }

    public static String generateRandomNumber() {
        String number = randomNumber(1, 10);
        System.out.println("# generated number #\n" + number);
        return number;
    }
    @And("^I type the random string into the element (\\w+).(\\w+) - field \"(.+)\"$")
    public void iTypeTheRandomStringIntoTheElement(String className, String fieldName, String box) throws Exception {
        String randomString = generateRandomString();
        randomMap.put(box, randomString);
        setStringRandom(randomString);
        writeUtilFile(randomString);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(findFunctionAndReplace(randomString));
    }

    @And("^I type the random number into the element (\\w+).(\\w+) - field \"(.+)\"$")
    public void iTypeTheRandomNumberIntoTheElement(String className, String fieldName, String box) throws Exception {
        //String randomString = generateRandomString();
        String randomNumber = generateRandomNumber();
        randomMap.put(box, randomNumber);
        setStringRandom(randomNumber);
        writeUtilFile(randomNumber);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertTrue(elem.isPresent(15), "The element " + fieldName + " is not present in the page " + className);
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(findFunctionAndReplace(randomNumber));
    }
    @And("^I verify the update into the element (\\w+).(\\w+) - field \"(.+)\"$")
    public void iVerifyUpdateIntoTheElement(String className, String fieldName, String box) throws Exception {
        String boxValue = randomMap.get(box);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);

        Assert.assertEquals(elem.getText(), boxValue, "Update in the field was not saved");
    }

    @And("^I input the firmware update query into (\\w+).(\\w+) for gateway \"(.+)\"$")
    public void iInputFirmWareUpdateQuery(String classname, String fieldname, String gatewayId, String request) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);

        /*String query = String.format("[\n" +
                        " {\n" +
                        "  \"gateway_id\":"+ gatewayId +",\n" +
                        "   \"command\":\"firmware-update-gateway\",\n" +
                        "    \"parameters\": {\n" +
                        "     \"snapKey\":  \"test\",\n" +

                        "     \"snapName\":  \"eig-agent\",\n" +
                        "     \"snapVersion\": \"1.0\" ,\n" +
                        "     \"installFlags\":  \"Y\",\n" +
                        "     \"reboot\":  \"false\", \n" +
                        " }\n" +
                        " }\n"
                , nameToFilter);*/
        String query = String.format(request, gatewayId);

        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(query);
        System.out.println();

    }

    @And("^I input \"(.+)\" into the text area (\\w+).(\\w+)$")
    public void iInputCustomQuery(String value, String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);
        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(value);
        System.out.println();
    }

    public static void waitProgressBar(int sec) {
        PageElement progressBar = UtilFunctions.createNewPageElement("progress bar", "//mat-spinner[@role='progressbar']");
        if (progressBar.isPresent(sec)) {
            Assert.assertTrue(progressBar.isInvisible(120), "progress bar present after 120 sec");
        }
    }
    private String checkIfAddZero(String text){
       if(text.length() == 1)
           text = "0" + text;
       return text;
    }

    private String fixDateString (String dateString){
        String[] datePartial = dateString.split("-");
        datePartial[1] = checkIfAddZero(datePartial[1]);
        datePartial[2] = checkIfAddZero(datePartial[2]);
        String[] hourPartial = datePartial[3].split("_");
        hourPartial[0] = checkIfAddZero(hourPartial[0]);
        hourPartial[1] = checkIfAddZero(hourPartial[1]);
        hourPartial[2] = checkIfAddZero(hourPartial[2]);

        String fixed = datePartial[0] + "-" + datePartial[1] + "-" + datePartial[2] + " " + hourPartial[0] + ":" + hourPartial[1] + ":" + hourPartial[2];
        return fixed;
    }

    @And("I read the filtered downloaded file and i delete it")
    public void iReadTheDownloadedFile() throws IOException, InterruptedException, ParseException {
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        System.out.println(pathUserHome);
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("Logs") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        System.out.println(listaFileLog);

        int lastDate = 0;
        String dateString = listaFileLog.get(0).substring(5, listaFileLog.get(0).indexOf(".xlsx"));
        Date actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixDateString(dateString));
        for(int i = 1; i < listaFileLog.size(); i++){
            String dateStr = listaFileLog.get(i).substring(5, listaFileLog.get(0).indexOf(".xlsx"));
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixDateString(dateStr));
            if(date.after(actualDate)){
                actualDate = date;
                lastDate = i;
            }

        }
        System.out.println(actualDate + " " + lastDate);
        String pathFileDaAprire = pathUserHome+listaFileLog.get(lastDate);
        File fileExcelScaricato = new File(pathFileDaAprire);
        FileInputStream file = new FileInputStream(fileExcelScaricato);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int type = 1;
        int creationDate = 2;
        int status = 7;
        String dateRilevate = CommonPage.getDriver().findElement(By.xpath("//*[contains(text(),'Date Range')]/following-sibling::*//*[@class='-input']")).getText();
        assertEquals(Integer.parseInt(LogSteps.numeroRighe)+1, sheet.getPhysicalNumberOfRows(), "Less record exported into .xlsx file");

        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
            Assert.assertTrue(sheet.getRow(i).getCell(type).getStringCellValue().contains("platform_log"));
            Assert.assertTrue(sheet.getRow(i).getCell(status).getStringCellValue().contains("error"));
            String primaData = dateRilevate.trim().substring(0,16);
            String secondaData = dateRilevate.trim().substring(primaData.length()+2,dateRilevate.trim().length());
            Date dataInizioThingFiltro = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(primaData);
            Date dataFineThingFiltro = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(secondaData);
            String dataExcel = sheet.getRow(i).getCell(creationDate).getStringCellValue();
            Date dataCreazioneThingExcel = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataExcel);
            Assert.assertTrue(dataInizioThingFiltro.compareTo(dataCreazioneThingExcel)<=0,"Filter didn't work on date field. Filter on Date FROM setted on "+dataInizioThingFiltro.toString()+" but retrieved "+dataCreazioneThingExcel.toString());
            Assert.assertTrue(dataFineThingFiltro.compareTo(dataCreazioneThingExcel)>=0,"Filter didn't work on date field. Filter on Date TO setted on "+dataFineThingFiltro.toString()+" but retrieved "+dataCreazioneThingExcel.toString());
        }
        fileExcelScaricato.delete();

    }

    @And("I read the filtered downloaded csv file and i delete it")
    public void iReadTheDownloadedCsvFile() throws IOException, InterruptedException, ParseException {
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        System.out.println(pathUserHome);
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("Logs") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        System.out.println(listaFileLog);

        int lastDate = 0;
        String dateString = listaFileLog.get(0).substring(5, listaFileLog.get(0).indexOf(".csv"));
        Date actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixDateString(dateString));
        for(int i = 1; i < listaFileLog.size(); i++){
            String dateStr = listaFileLog.get(i).substring(5, listaFileLog.get(0).indexOf(".csv"));
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixDateString(dateStr));
            if(date.after(actualDate)){
                actualDate = date;
                lastDate = i;
            }

        }
        System.out.println(actualDate + " " + lastDate);
        String pathFileDaAprire = pathUserHome+listaFileLog.get(lastDate);
        File fileCsvScaricato = new File(pathFileDaAprire);
        //FileInputStream file = new FileInputStream(fileCsvScaricato);
        //Workbook workbook = new XSSFWorkbook(file);
        //Sheet sheet = workbook.getSheetAt(0);

        //Reading file
        BufferedReader br = null;
        String line;
        String delimiterRow = ";";
        String delimiterCol = ",";
        List<List<String>> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileCsvScaricato));
            while((line=br.readLine()) !=null){
                String[] valuesRow = line.split(delimiterRow);
                data.add(Arrays.asList(valuesRow));
            }
        } catch (IOException e){
            System.out.println(e);
        }
        br.close();

        int lenghtData = data.toArray().length;
        System.out.println("lenghtData: "+lenghtData);
        int type = 1;
        int creationDate = 2;
        int status = 7;
        String dateRilevate = CommonPage.getDriver().findElement(By.xpath("//*[contains(text(),'Date Range')]/following-sibling::*//*[@class='-input']")).getText();
        assertEquals(Integer.parseInt(LogSteps.numeroRighe)+1, lenghtData, "Less record exported into .csv file");

        for(int i=1;i<lenghtData;i++){
            System.out.println("Row n: "+i);
            String devicesTableRow = String.valueOf(data.get(i));
            System.out.println("devicesTableRow: "+devicesTableRow);
            String[]valueRow=devicesTableRow.split(delimiterCol);
            Assert.assertTrue(valueRow[1].contains("platform_log"));
            //Assert.assertTrue(valueRow[7].contains("error"));
            //String primaData = dateRilevate.trim().substring(0,16);
            //String secondaData = dateRilevate.trim().substring(primaData.length()+2,dateRilevate.trim().length());
            //Date dataInizioThingFiltro = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(primaData);
            //Date dataFineThingFiltro = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(secondaData);
            //String dataExcel = valueRow[2];
            //((Date dataCreazioneThingExcel = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataExcel);
            //Assert.assertTrue(dataInizioThingFiltro.compareTo(dataCreazioneThingExcel)<=0,"Filter didn't work on date field. Filter on Date FROM setted on "+dataInizioThingFiltro.toString()+" but retrieved "+dataCreazioneThingExcel.toString());
            //Assert.assertTrue(dataFineThingFiltro.compareTo(dataCreazioneThingExcel)>=0,"Filter didn't work on date field. Filter on Date TO setted on "+dataFineThingFiltro.toString()+" but retrieved "+dataCreazioneThingExcel.toString());
        }
        fileCsvScaricato.delete();

    }


    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }

    @And("^I input (\\w+).(\\w+) file into (\\w+).(\\w+)$")
    public void iInputFileInto(String filename, String extension, String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        String pathScritp = new File(".").getCanonicalPath()+"\\scripts\\"+filename+"."+extension;
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(pathScritp);
        Thread.sleep(1000);
        SoftwareCatalogueSteps.setFileUploaded(filename+"."+extension);
    }

    public static String timestamped = null;

    @And("^I input timestamp after the word (\\w+) into (\\w+).(\\w+)$")
    public void iInputTimestampedTestInto(String text, String classname, String fieldname) throws Exception {
        String timestamp = String.valueOf(new Date().getTime());
        if(timestamped == null){
            timestamped = timestamp;
        }
        String testo = text+ timestamped;
        if(!fieldname.equals("architectureInput") && !fieldname.equals("descriptionInput")) {
            SoftwareCatalogueSteps.setPathS3(testo + "/");
        }
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        Assert.assertTrue(elem.fillText(testo, true, 1000), "Cannot input text (with enter) into " + fieldname + " in page " + classname);
    }


    @And("^I click (\\w+).(\\w+) that contains \"(.+)\"$")
    public void iClickActivateThingDDMOptionThatContains(String className, String fieldName, String text) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        List<WebElement> options = CommonPage.getDriver().findElements(elem.getBy());
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().contains(text)) {
                options.get(i).click();
            }
        }
    }

    @Then("I check and click the last icon document of the entry named \"(.+)\"")
    public static void checkTheEntryWithSpecificString(String device) throws InterruptedException {
        CommonSteps.waitProgressBar();
        String locator = "(//td[contains(., '%s')]//following-sibling::td//*[@icon='document'])[1]";
        PageElement elem = UtilFunctions.createNewPageElement("icon document of the last entry: "+device, String.format(locator, device));
        Assert.assertTrue(elem.isPresent(20), "The icon element of the device: "+device+" is not present");
        elem.scrollTo();
        Assert.assertTrue(elem.tryClick(true, false), "The icon element of the device" + device + " is not clickable");
    }

    public static void moveToElementToCoordinate(WebElement webelement, int x, int y) {

        Actions action = new Actions(CommonPage.getDriver());
        action.clickAndHold(webelement).moveByOffset(x, y).release().perform();
    }

    @And("I scroll to coordinate")
    public void iScrollToCoordinateXY(String coordinatex, String coordinatey) {

        int x = Integer.parseInt(coordinatex);
        int y = Integer.parseInt(coordinatey);

        JavascriptExecutor js = (JavascriptExecutor) CommonPage.getDriver();

        js.executeScript("window.scrollBy(0, 200)");
    }
    @Then("^I check the presence of the toast message (\\w+).(\\w+)$")
    public static void checkToastMessage(String className, String fieldName) throws Exception {
        waitProgressBar(2);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.isPresent(50), "The element " + fieldName + " is not present in the page " + className);
        Assert.assertTrue(elem.scrollTo(), "Unable to scroll to element in order to shown");
    }

    @And("^I input the payload into (\\w+).(\\w+) for apm \"(.+)\"$")
    public void iInputPayload(String classname, String fieldname, String apm, String payload) throws Exception {
        //You can use this method to input a payload into an already filled text area
        //You have to specify %s for apm
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);

        String query = String.format(payload, apm);

        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.CONTROL+"a");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(Keys.BACK_SPACE);
        // CommonPage.getDriver().findElement(By.xpath("//textarea")).clear();
        Thread.sleep(1000);
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(query);
        System.out.println();

    }

    @And("^I input (\\w+) tar gz file into (\\w+).(\\w+)$")
    public void iInputFileInto2(String filename, String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        String timestamp = String.valueOf(new Date().getTime());
        if(timestamped == null){
            timestamped = timestamp;
        }
        findFileAndRenameIt(filename, new File(Configuration.get("path.scriptFolder")), filename+timestamp+".tar.gz");
        String pathScript = findFile(filename, new File(Configuration.get("path.scriptFolder")));
        File file = new File(pathScript);
        System.out.println(file.getName());
        CommonPage.getDriver().findElement(elem.getBy()).sendKeys(pathScript);
        Thread.sleep(1000);
        SoftwareCatalogueSteps.setFileUploaded(new File(pathScript).getName());
    }

    public void findFileAndRenameIt(String name,File file, String newName)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File fil : list){
                if (fil.isDirectory()){
                    findFileAndRenameIt(name,fil, newName);
                }
                else if (fil.getName().contains(name)){
                    if(fil.renameTo(new File(Configuration.get("path.scriptFolder")+"\\"+newName))){
                        System.out.println("renamed ");
                        break;
                    }else{
                        Assert.fail("Error during the refactoring of the name");
                    }
                    System.out.println(fil.getParentFile());
                }
            }
    }

    public String findFile(String name, File file) throws IOException {
        File[] list = file.listFiles();
        String path = "";
        if(list!=null)
            for (File fil : list){
                if (fil.isDirectory()){
                    findFile(name,fil);
                }
                else if (fil.getName().contains(name)){
                    path = fil.getCanonicalPath();
                }
            }
        return path;
    }

    @Then("I reset the input box \"(.+)\".\"(.+)\"")
    public static void resetInputBox(String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        WebElement we = CommonPage.getDriver().findElement(elem.getBy());
        we.sendKeys(Keys.CONTROL+"a");
        we.sendKeys(Keys.BACK_SPACE);

    }

    @And("I check if export file with csv format is downloaded successfully and I delete it")
    public void iCheckTheDownloadedFileCSV() throws IOException, InterruptedException, ParseException {
        boolean isDownloadedNew = false;
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        listFiles.removeIf(s -> !s.contains(".csv"));
        Set<String> listFilesBefore = getListFiles();
        String nameFile="";
        listFiles.removeAll(listFilesBefore);
        for(String s : listFiles){
            if (s != null && s.contains(".csv")) {
                isDownloadedNew = true;
                nameFile = s;
                break;
            }
        }
       if(isDownloadedNew) {
           String pathFileDaAprire = pathUserHome + nameFile;
           File fileExcelScaricato = new File(pathFileDaAprire);

           fileExcelScaricato.delete();
       }
       Assert.assertTrue(isDownloadedNew, "No new file csv found in the download user directory");
    }

    @And("I check if export file with {string} format is downloaded successfully and I delete it")
    public void iCheckTheDownloadedFileAndDelete(String fileType) throws IOException, InterruptedException, ParseException {
        boolean isDownloadedNew = false;
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        listFiles.removeIf(s -> !s.contains("."+fileType));
        Set<String> listFilesBefore = getListFiles();
        String nameFile="";
        listFiles.removeAll(listFilesBefore);
        for(String s : listFiles){
            if (s != null && s.contains("."+fileType)) {
                isDownloadedNew = true;
                nameFile = s;
                break;
            }
        }
        if(isDownloadedNew) {
            String pathFileDaAprire = pathUserHome + nameFile;
            File fileExcelScaricato = new File(pathFileDaAprire);

            fileExcelScaricato.delete();
        }
        Assert.assertTrue(isDownloadedNew, "No new file " + fileType+ " found in the download user directory");
    }

    private static Set<String> listFiles = null;

    public static Set<String> getListFiles() {
        return listFiles;
    }

    public static void setListFiles(Set<String> listFiles) {
        CommonSteps.listFiles = listFiles;
    }

    @And("I save number of csv file in directory")
    public void iCheckTheDownloadedFile() throws IOException, InterruptedException, ParseException {
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        //Iterate all files in Download directory
        listFiles.removeIf(s -> !s.contains(".csv"));
        setListFiles(listFiles);

    }
    @And("I save number of {string} files in directory")
    public void iCheckTheDownloadedFiles(String fileType) throws IOException, InterruptedException, ParseException {
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        //Iterate all files in Download directory
        listFiles.removeIf(s -> !s.contains("."+fileType));
        setListFiles(listFiles);

    }

    @Then("I set the browser")
    public static void setBrowser(){
        PageElement.getPageElementHelper().enableHighlight(false);
    }

    @And("^I input the custom query into (\\w+).(\\w+) for direct things$")
    public void iInputCustomQueryForDirectThing(String classname, String fieldname) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(classname, fieldname);
        waitForElementLocatedBy(elem.getBy(), 60);

        String query = String.format("[\n" +
                " {\n" +
                "  \"query\": {\n" +
                "   \"bool\": {\n" +
                "    \"must\": [\n" +
                "     {\n" +
                "      \"match\": {\n" +
                "        \"latest\": true\n" +
                "      }\n" +
                "     } \n" +
                "    ],\n" +
                "    \"filter\": {\n" +
                "     \"terms\": {\n" +
                "      \"thing_id.keyword\": [\n" +
                "        \"%s\"\n" +
                "      ]\n" +
                "     }\n" +
                "    }\n" +
                "   }\n" +
                "  }\n" +
                " },\n" +
                " {\n" +
                "  \"devices_types\": \"not_supported\"\n" +
                " }\n" +
                "]", nameToFilter);
        waitForElementLocatedByXpath("//textarea");
        CommonPage.getDriver().findElement(By.xpath("//textarea")).sendKeys(query);
        System.out.println();
    }

    @Then("I wait the progress bar for a maximum of \"(.+)\" seconds")
    public static void waitProgressBar(String seconds) {
        PageElement progressBar = UtilFunctions.createNewPageElement("progress bar", "//mat-spinner[@role='progressbar']");
        if (progressBar.isPresent()) {
            Assert.assertTrue(progressBar.isInvisible(Integer.parseInt(seconds)), "progress bar present after 120 sec");
        }
    }
    @When("^I input with enter \"(.+)\" in (\\w+).(\\w+)$")
    public static void fillInputBox(String value, String className, String fieldName) throws Exception {
        String finalValue = StepUtils.findFunctionAndReplace(value);
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        Assert.assertTrue(elem.fillText(finalValue, true), "Cannot input text into " + fieldName + " in page " + className);
    }
    @Then("I print {string} used in script")
    public static void iPrint(String filePath) throws IOException {

        StringBuilder output = null;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\scripts\\core_test_provisioning\\"+filePath+".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while((line = in.readLine()) != null)
        {

            output = new StringBuilder(output + line);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String outputString= output.toString().replaceAll("null"," ");
        JSONObject obj = new JSONObject(outputString);
        ReportFormatter.addMarkup(MarkupHelper.createCodeBlock(String.valueOf(obj), CodeLanguage.JSON));
    }

    @And("^I check that (\\w+).(\\w+) element is not clickable$")
    public static void iCheckThatTheWWElementNotClickable(String className, String fieldName) throws Exception {
        PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
        assertFalse(elem.tryClick(), elem.getDescription() + "is clickable");

    }
}