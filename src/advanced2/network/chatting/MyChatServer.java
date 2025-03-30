package advanced2.network.chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyChatServer {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            ArrayList<Session> sessions = new ArrayList<>();
            SessionManager sessionManager = new SessionManager(sessions);

            while (true) {
                Socket socket = serverSocket.accept();
                Session session = new Session(socket, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
