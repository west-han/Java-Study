package advanced2.network.chatting;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Session implements Runnable {
    private final Socket socket;
    private String nickname;
    private final SessionManager sessionManager;
    private DataInputStream input;
    private DataOutputStream output;

    public Session(Socket socket, SessionManager sessionManager) {
        this.socket = socket;
        this.sessionManager = sessionManager;
        sessionManager.addSession(this);
    }

    @Override
    public void run() {
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            String received = "";
            String toSend = "";

            while (!join(input.readUTF())) {
                output.writeUTF("[서버] 채팅창에 입장하시려면 /join|닉네임 명령어를 입력하십시오.");
            }

            while (true) {
                received = input.readUTF();
                if (received == null) {
                    toSend = "[서버] 메시지를 입력하세요.";
                }

                if (received.charAt(0) == '/') {
                    String[] split = received.split("\\|");
                    String command = split[0];
                    String content = split[1];

                    if (received.equals("/exit")) {
                        break;
                    }

                    switch (command) {
                        case "/join":
                            toSend = "[서버] 이미 채팅창에 입장하셨습니다. 닉네임을 변경하려면 /change|닉네임 명령을 입력하십시오.";
                            break;
                        case "/message":
                            toSend = "[" + nickname + "] " + content;
                            break;
                        case "/change":
                            this.nickname = content;
                            toSend = "";
                            break;
                        case "/users":
                            List<String> nicknames = sessionManager.getNicknames();
                            content = String.valueOf(nicknames);
                            break;
                        default:
                            toSend = "잘못된 명령어입니다.";
                            break;
                    }
                }

                sendMessage(toSend);
            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            close();
        }
    }

    public boolean join(String nickname) {
        if (!nickname.startsWith("/join|")) {
            return false;
        }

        nickname = nickname.substring("/join|".length());
        this.nickname = nickname;
        return true;
    }

    public void close() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        System.out.println(this + " 자원 정리 완료");
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Session{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

    public void sendMessage(String message) throws IOException {
        output.writeUTF(message);
    }
}
