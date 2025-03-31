package advanced2.network.review.client;

import java.io.IOException;

public class ClientMain {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", PORT);
        client.start();
    }
}
