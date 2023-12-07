package UtilShell;

public class CommandResult {

    private String output;
    private String errorOutput;
    private int code;

    public CommandResult(String output, String errorOutput, int code) {
        this.output = output;
        this.errorOutput = errorOutput;
        this.code = code;
    }

    public String getOutput() {
        return output;
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    public int getCode() {
        return code;
    }

    public void raiseForStats() {
        if (code != 0) {
            throw new RuntimeException("Command failed, code: " + code);
        }
    }
}
