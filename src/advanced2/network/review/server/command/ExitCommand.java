package advanced2.network.review.server.command;

import advanced2.network.review.server.Session;
import advanced2.network.review.server.SessionManager;

import java.io.IOException;

public class ExitCommand implements Command {

    private final SessionManager sessionManager;

    public ExitCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
