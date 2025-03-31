package advanced2.network.review.server.command;

import advanced2.network.review.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
