package advanced2.network.review.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static advanced2.network.review.util.MyLogger.log;

public class SessionManager {
    List<Session> sessions = new ArrayList<Session>();

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
    }

    public List<String> getAllUsername() {
        return sessions.stream()
                .filter(Objects::nonNull)
                .map(Session::getUsername)
                .collect(Collectors.toList());
    }
}
