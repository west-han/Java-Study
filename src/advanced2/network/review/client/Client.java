package advanced2.network.review.client;

import advanced2.network.review.util.ResourceCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static advanced2.network.review.util.MyLogger.*;
import static advanced2.network.review.util.ResourceCloseUtil.closeAll;

public class Client {

    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private WriteHandler writeHandler;
    private ReadHandler readHandler;

    private boolean closed = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        writeHandler = new WriteHandler(this, output);
        readHandler = new ReadHandler(this, input);

        Thread writeThread = new Thread(writeHandler, "writeHandler");
        Thread readThread = new Thread(readHandler, "readHandler");

        writeThread.start();
        readThread.start();

        log("클라이언트 종료");
    }

    public void close() {

        if (closed) return;

        writeHandler.close();
        readHandler.close();
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);
    }
}
