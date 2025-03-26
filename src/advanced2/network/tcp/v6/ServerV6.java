package advanced2.network.tcp.v6;

import advanced2.network.tcp.v5.SessionV5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static advanced2.util.MyLogger.log;

public class ServerV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        SessionManagerV6 sessionManager = new SessionManagerV6();
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // ShutdownHook 등록
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "Shutdown"));

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);

                SessionV5 session = new SessionV5(socket);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소캣 종료: " + e);
        }
    }

    private static class ShutdownHook implements Runnable {

        private ServerSocket serverSocket;
        private SessionManagerV6 sessionManager;

        public ShutdownHook(ServerSocket socket, SessionManagerV6 sessionManager) {
            this.serverSocket = socket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdownHook 실행");
            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000); // 자원 정리 대기
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}