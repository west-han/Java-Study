package advanced2.network.chat.server.command;

import advanced2.network.chat.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
