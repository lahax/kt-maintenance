package main.java;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyTopic extends AWSIotTopic {
    public MyTopic(String topic, AWSIotQos qos) {
        super(topic, qos);
    }

    private List<AWSIotMessage> messages = new ArrayList<>();

    @Override
    public void onMessage(AWSIotMessage message) {
        // called when a message is received
        System.out.println(message.getStringPayload());
        System.out.println(message.getTopic());

        messages.add(message);
    }

    public AWSIotMessage waitForMessageOnTopic(Function<AWSIotMessage, Boolean> filter, long elapsingTime) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while (elapsingTime > System.currentTimeMillis() - startTime) {
            Thread.sleep(5000);
            for (AWSIotMessage message : messages) {
                System.out.println(message);
                if (filter.apply(message)) {
                    System.out.println("Response received in: "+(System.currentTimeMillis() - startTime)/1000 +" seconds");
                    return message;
                }
            }
        }
        long newStartTime = System.currentTimeMillis();
        while(elapsingTime > System.currentTimeMillis() - newStartTime){
            Thread.sleep(500);
            for (AWSIotMessage message : messages) {
                if (filter.apply(message)) {
                    Assert.fail("No response received in "+ elapsingTime/1000 +" seconds. Response Received in:  "+(System.currentTimeMillis() - startTime)/1000 +" seconds");
                }
            }
        }
        return null;
    }

    public AWSIotMessage waitForNoMessageOnTopic(Function<AWSIotMessage, Boolean> filter, long elapsingTime) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while (elapsingTime > System.currentTimeMillis() - startTime) {
            Thread.sleep(500);
            for (AWSIotMessage message : messages) {
                if (filter.apply(message)) {
                    return message;
                }
            }
        }
        return null;
    }

}
