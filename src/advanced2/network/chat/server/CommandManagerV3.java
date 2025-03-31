package advanced2.network.chat.server;

import advanced2.network.chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {

    private final SessionManager sessionManager;
    private final String DELIMITER = "\\|";
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandManagerV3(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        commandMap.put("/join", new JoinCommand(sessionManager));
        commandMap.put("/message", new MessageCommand(sessionManager));
        commandMap.put("/change", new ChangeCommand(sessionManager));
        commandMap.put("/users", new UsersCommand(sessionManager));
        commandMap.put("/exit", new ExitCommand(sessionManager));
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

        Command command = commandMap.get(key);
        if (command == null) {
            session.send("처리할 수 없는 명령어 입니다." + totalMessage);
            return;
        }

        command.execute(args, session);
    }
}
