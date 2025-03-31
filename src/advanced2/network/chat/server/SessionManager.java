package advanced2.network.chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static advanced2.util.MyLogger.log;

public class SessionManager {
    private final List<Session> sessions = new ArrayList<>();

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public void sendAll(String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public List<String> getAllUsername() {
        return sessions.stream()
                .map(Session::getUsername)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
