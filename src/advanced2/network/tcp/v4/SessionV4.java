package advanced2.network.tcp.v4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network.tcp.SocketCloseUtil.closeAll;
import static advanced2.util.MyLogger.log;

public class SessionV4 implements Runnable {

    private Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // 클라이언트로부터 문자 받기
                String received = input.readUTF();
                log("client -> server: " + received);

                if (received.equals("exit")) {
                    break;
                }

                // 클라이언트에게 문자 보내기
                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client <- server: " + toSend);
            }

            // 자원 정리
            log("연결 종료: " + socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }
    }
}
