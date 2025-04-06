package advanced2.was.v8;

import advanced2.was.httpserver.HttpServer;
import advanced2.was.httpserver.HttpServlet;
import advanced2.was.httpserver.ServletManager;
import advanced2.was.httpserver.servlet.DiscardServlet;
import advanced2.was.httpserver.servlet.annotation.AnnotationServletV2;
import advanced2.was.httpserver.servlet.annotation.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class ServerMainV8 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV8(), new SearchControllerV8());
//        HttpServlet annotationServlet = new AnnotationServletV2(controllers);
        HttpServlet annotationServlet = new AnnotationServletV3(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
