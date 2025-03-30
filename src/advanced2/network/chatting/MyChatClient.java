package advanced2.network.chatting;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyChatClient {

    public static final int PORT = 9999;

    public static void main(String[] args) throws InterruptedException {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("localhost", PORT), 10000);

            Thread readHandler = new Thread(new ReadHandler(socket), "readHandler");
            readHandler.start();
            Thread writeHandler = new Thread(new WriteHandler(socket), "writeHandler");
            writeHandler.start();
            writeHandler.join();
            readHandler.interrupt();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class ReadHandler implements Runnable {
        private final Socket socket;

        public ReadHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String input = "";
                while (!Thread.interrupted()) {
                    input = dis.readUTF();
                    System.out.println(input);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class WriteHandler implements Runnable {
        private final Socket socket;

        public WriteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                Scanner sc = new Scanner(System.in);
                String msg = "";
                while (!(msg = sc.nextLine()).equals("/exit")) {
                    dos.writeUTF(msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
