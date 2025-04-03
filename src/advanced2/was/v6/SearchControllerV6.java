package advanced2.was.v6;

import advanced2.was.httpserver.HttpRequest;
import advanced2.was.httpserver.HttpResponse;

import java.io.IOException;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getQueryParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
