package advanced2.network.review.server.command;

import advanced2.network.review.server.Session;
import advanced2.network.review.server.SessionManager;

import java.io.IOException;

public class ChangeCommand implements Command {

    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String username = args[1];
        sessionManager.sendAll(session.getUsername() + " 님의 이름이 " + username + "로 변경되었습니다.");
        session.setUsername(username);
    }
}
