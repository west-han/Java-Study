package advanced2.was.v7;

import advanced2.was.httpserver.HttpServer;
import advanced2.was.httpserver.ServletManager;
import advanced2.was.httpserver.servlet.annotation.AnnotationServlet;

import java.io.IOException;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(new AnnotationServlet());
        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
