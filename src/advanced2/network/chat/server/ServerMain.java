package advanced2.network.chat.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();

        CommandManager commandManager =
//                new CommandManagerV1(sessionManager);
//                new CommandManagerV2(sessionManager);
                new CommandManagerV3(sessionManager);

        Server server = new Server(PORT, commandManager, sessionManager);
        server.start();
    }

}
