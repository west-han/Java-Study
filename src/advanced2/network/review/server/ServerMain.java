package advanced2.network.review.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManager(sessionManager);
        Server server = new Server(PORT, sessionManager, commandManager);
        server.start();
    }
}
