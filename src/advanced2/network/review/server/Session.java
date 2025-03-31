package advanced2.network.review.server;

import advanced2.network.review.util.MyLogger;
import advanced2.network.review.util.ResourceCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network.review.util.MyLogger.*;
import static advanced2.network.review.util.ResourceCloseUtil.*;

public class Session implements Runnable {

    private final Socket socket;
    private final SessionManager sessionManager;
    private final CommandManager commandManager;

    private DataInputStream input;
    private DataOutputStream output;
    private String username;
    private boolean closed = false;

    public Session(Socket socket, SessionManager sessionManager, CommandManager commandManager) throws IOException {
        this.socket = socket;
        this.sessionManager = sessionManager;
        this.commandManager = commandManager;

        sessionManager.addSession(this);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                log("client -> server: " + received);
                commandManager.execute(received, this);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.removeSession(this);
            sessionManager.sendAll(username + "님이 퇴장했습니다.");
            close();
        }
    }

    public void send(String message) throws IOException {
        log("server -> client: " + message);
        output.writeUTF(message);
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
