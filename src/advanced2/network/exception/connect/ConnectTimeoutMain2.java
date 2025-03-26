package advanced2.network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectTimeoutMain2 {

    // Windows: 약 2초
    // Linux: 약 75초에서 180초 사이, mac test 75초
    // java.net.ConnectException: Operation timed out
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000);
        } catch (ConnectException e) {
            // ConnectException: Operation timed out
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
