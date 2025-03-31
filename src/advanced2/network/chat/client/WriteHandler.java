package advanced2.network.chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static advanced2.util.MyLogger.log;

public class WriteHandler implements Runnable {
    private final Client client;
    private final DataOutputStream output;
    private boolean isClosed = false;
    private static final String DELIMITER = "|";

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty()) {
                    continue;
                }

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private String inputUsername(Scanner scanner) {
        System.out.println("이름을 입력하세요.");
        String username;

        do {
            username = scanner.nextLine();
        } while (username.isEmpty());

        return username;
    }

    public synchronized void close() {
        if (isClosed) {
            return;
        }

        try {
            System.in.close();
        } catch (IOException e) {
            log(e);
        }

        isClosed = true;
        log("writeHandler 종료");
    }
}
