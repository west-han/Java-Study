package advanced2.was.httpserver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface HttpServlet {
    void service(HttpRequest request, HttpResponse response) throws IOException, InvocationTargetException, IllegalAccessException;
}
