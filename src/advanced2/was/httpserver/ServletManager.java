package advanced2.was.httpserver;

import advanced2.was.httpserver.servlet.InternalErrorServlet;
import advanced2.was.httpserver.servlet.NotFoundServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {
    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet notFoundErrorServlet = new NotFoundServlet();
    private HttpServlet internalErrorServlet = new InternalErrorServlet();

    public ServletManager() {
    }

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void setDefaultServlet(HttpServlet servlet) {
        defaultServlet = servlet;
    }

    public void setNotFoundErrorServlet(HttpServlet servlet) {
        notFoundErrorServlet = servlet;
    }

    public void setInternalErrorServlet(HttpServlet servlet) {
        internalErrorServlet = servlet;
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            if (servlet == null) {
                throw new PageNotFoundException("request url = " + request.getPath());
            }
            servlet.service(request, response);
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            notFoundErrorServlet.service(request, response);
        } catch (IOException e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
