package test.steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class ResponseSteps {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private String deviceId;
    public ResponseSteps(String status, String message, String deviceId) {
        this.status = status;
        this.message = message;
        this.deviceId = deviceId;
    }
    public static ResponseSteps fromJson(String json, String device) {
        JSONObject jsonObject = new JSONObject(json);
        String status = jsonObject.getString("status");
        String message = jsonObject.getString("message");
        String deviceId = jsonObject.getString("device_id");
        deviceId = String.format(device, device);
        return new ResponseSteps(status, message, deviceId);
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Criar um objeto JSON com os campos necessários
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}"; // Em caso de erro, retornar um JSON vazio ou tratar adequadamente
        }
    }

}
