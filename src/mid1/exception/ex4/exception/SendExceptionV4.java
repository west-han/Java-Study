package mid1.exception.ex4.exception;

public class SendExceptionV4 extends NetworkClientExceptionV4 {
    private final String sendData;

    public SendExceptionV4(String address, String message) {
        super(message);
        this.sendData = message;
    }

    public String getSendData() {
        return sendData;
    }
}
