package advanced2.network.review.client;

import advanced2.network.review.util.MyLogger;

import java.io.DataInputStream;
import java.io.IOException;

import static advanced2.network.review.util.MyLogger.*;

public class ReadHandler implements Runnable {
    private final Client client;
    private final DataInputStream input;

    private boolean closed = false;

    public ReadHandler(Client client, DataInputStream input) {
        this.client = client;
        this.input = input;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) return;

        log("readHandler 종료");
        closed = true;
    }
}
