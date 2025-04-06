package advanced2.was.v8;

import advanced2.was.httpserver.HttpRequest;
import advanced2.was.httpserver.HttpResponse;
import advanced2.was.httpserver.servlet.annotation.Mapping;

public class SearchControllerV8 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getQueryParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
