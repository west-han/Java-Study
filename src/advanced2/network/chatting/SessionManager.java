package advanced2.network.chatting;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SessionManager {
    private final List<Session> sessions;

    public SessionManager(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        session.close();
        sessions.remove(session);
    }

    public void closeSessions() {
        for (Session session : sessions) {
            session.close();
        }
    }

    public List<String> getNicknames() {
        return sessions.stream()
                .map(Session::getNickname)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void sendMessage(String message) throws IOException {
        for (Session session : sessions) {
            session.sendMessage(message);
        }
    }
}
