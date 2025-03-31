package advanced2.network.review.server;

import advanced2.network.review.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commandMap = new HashMap<>();
    private final Command defaultCommand;

    public CommandManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        commandMap.put("/join", new JoinCommand(sessionManager));
        commandMap.put("/change", new ChangeCommand(sessionManager));
        commandMap.put("/exit", new ExitCommand(sessionManager));
        commandMap.put("/message", new MessageCommand(sessionManager));
        commandMap.put("/users", new UsersCommand(sessionManager));
        defaultCommand = new DefaultCommand();
    }

    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

        Command command = commandMap.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
