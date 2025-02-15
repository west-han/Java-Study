package mid1.exception.ex3.exception;

public class SendExceptionV3 extends NetworkClientExceptionV3 {
    private final String sendData;

    public SendExceptionV3(String address, String message) {
        super(message);
        this.sendData = message;
    }

    public String getSendData() {
        return sendData;
    }
}
