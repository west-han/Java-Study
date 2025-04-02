package advanced2.was.v6;

import advanced2.was.httpserver.HttpRequest;
import advanced2.was.httpserver.HttpResponse;

import java.io.IOException;

public class SiteControllerV6 {
    public void site1(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site1</h1>");
    }

    public void site2(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site2</h1>");
    }
}
