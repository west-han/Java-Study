package advanced2.network.chat.server.command;

import advanced2.network.chat.server.Session;
import advanced2.network.chat.server.SessionManager;

public class ChangeCommand implements Command {
    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String username = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + username + "로 이름을 변경했습니다.");
        session.setUsername(username);
    }
}
