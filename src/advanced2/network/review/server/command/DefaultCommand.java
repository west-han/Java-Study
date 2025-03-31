package advanced2.network.review.server.command;

import advanced2.network.review.server.Session;
import advanced2.network.review.server.SessionManager;

import java.io.IOException;
import java.util.Arrays;

public class DefaultCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        session.send("처리할 수 없는 명령어 입니다." + Arrays.toString(args));
    }
}
