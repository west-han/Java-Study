package advanced2.network.chat.client;

import java.io.IOException;

public class ClientMain {

    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", PORT);
        client.start();
    }
}
