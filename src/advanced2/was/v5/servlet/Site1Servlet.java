package advanced2.was.v5.servlet;

import advanced2.was.httpserver.HttpRequest;
import advanced2.was.httpserver.HttpResponse;
import advanced2.was.httpserver.HttpServlet;

import java.io.IOException;

public class Site1Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site1</h1>");
    }
}
