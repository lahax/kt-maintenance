package test.steps;

import org.testng.Assert;
import ta.utilities.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MQTTUtilSteps extends Thread {

    static String endpoint = null;
    static String topic = null;
    static String crt = null;
    static String pem = null;
    static String key = null;
    static String identifier = null;
    static String file = null;
    static boolean isFile = false;
    static String message = null;
    static String category = null;

    public MQTTUtilSteps(String endpoint, String topic, String crt, String pem, String key, String identifier,
                         boolean isFile, String file, String message) {
        this.endpoint = endpoint;
        this.topic = topic;
        this.crt = crt;
        this.pem = pem;
        this.key = key;
        this.identifier = identifier + "_" + new Date().getTime();
        this.isFile = isFile;
        if (isFile) {
            this.file = file;
        } else {
            this.message = "\"" + message + "\"";
        }
    }

    @Override
    public void run() {
        String base = "./listen_on_topic_original.sh";
        String separator = System.getProperty("os.name").toLowerCase().contains("win") ? "/" : "\\";
        String path = ".\\certs" + separator;
        String percorsoLinux = path.replaceAll("\\\\","/");
        String pattern = "dd_MM_yyyy_HH_mm_ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String nameResult = "";
        String top2 = topic;
        CommandsUtilSteps.topicName = top2.replaceAll("[^a-zA-Z0-9]","")+".txt";
        String risultato = "results_listener" + separator+top2.replaceAll("[^a-zA-Z0-9]","")+".txt";
        String command = null;
        if (isFile) {
            command = String.format("bash %s %s %s %s %s %s -i %s %s", base, endpoint, topic, percorsoLinux + crt, percorsoLinux + pem, percorsoLinux + key, identifier, risultato);
        } else {
            command = String.format("bash %s %s %s %s %s %s -i %s %s", base, endpoint, topic, percorsoLinux +crt, percorsoLinux +pem, percorsoLinux +key, identifier,risultato);
        }

        System.out.println(command);
        assert command != null;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));
        try {
            Process process = processBuilder.start();
        }catch (Exception e){
            System.out.println(e);
        }
}}
