package advanced2.network.review.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static advanced2.network.review.util.MyLogger.log;

public class WriteHandler implements Runnable {
    private final Client client;
    private final DataOutputStream output;
    private static final String DELIMITER = "|";

    private boolean closed = false;

    public WriteHandler(Client client, DataOutputStream output) {
        this.client = client;
        this.output = output;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("사용자 이름 입력");
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    continue;
                }

                if (input.equals("/exit")) {
                    output.writeUTF(input);
                    break;
                }

                if (input.startsWith("/")) {
                    output.writeUTF(input);
                } else {
                    output.writeUTF("/message" + DELIMITER + input);
                }
            }

        } catch (IOException e) {
            log(e.getMessage());
        } finally {
            client.close();
        }

    }

    public synchronized void close() {

        if (closed) return;

        try {
            System.in.close();
        } catch (IOException e) {
            log(e);
        }

        log("writeHandler 종료");
        closed = true;
    }

    public String inputUsername(Scanner scanner) {
        String username = scanner.nextLine();
        while (username.isEmpty()) {
            username = scanner.nextLine();
        }

        return username;
    }
}
