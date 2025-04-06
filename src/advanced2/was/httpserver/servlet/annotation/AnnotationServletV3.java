package advanced2.was.httpserver.servlet.annotation;

import advanced2.was.httpserver.HttpRequest;
import advanced2.was.httpserver.HttpResponse;
import advanced2.was.httpserver.HttpServlet;
import advanced2.was.httpserver.PageNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationServletV3 implements HttpServlet {

    private final List<Object> controllers;
    private final Map<String, ControllerMethod> pathMap;

    public AnnotationServletV3(List<Object> controllers) {
        this.pathMap = new HashMap<>();
        this.controllers = controllers;

        initializePathMap(controllers);
    }

    private void initializePathMap(List<Object> controllers) {
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getAnnotation(Mapping.class) != null) {
                    String path = method.getAnnotation(Mapping.class).value();
                    // 중복 경로 체크
                    if (pathMap.containsKey(path)) {
                        ControllerMethod controllerMethod = pathMap.get(path);
                        throw new IllegalArgumentException("경로 중복 등록, path=" + path +
                                ", method=" + method + ", 이미 등록된 메서드=" + controllerMethod.method);
                    }
                    pathMap.put(path, new ControllerMethod(controller, method));
                }
            }
        }
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        String requestPath = request.getPath();

        ControllerMethod controllerMethod = pathMap.get(requestPath);
        if (controllerMethod == null) {
            throw new PageNotFoundException("request=" + requestPath);
        }
        controllerMethod.invoke(request, response);
    }

    private static class ControllerMethod {
        private final Object controller;
        private final Method method;

        public ControllerMethod(Object controller, Method method) {
            this.controller = controller;
            this.method = method;
        }

        public void invoke(HttpRequest request, HttpResponse response) {

            Class<?>[] parameterTypes = method.getParameterTypes();
            // request, response
            Object[] args = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] == HttpRequest.class) {
                    args[i] = request;
                } else if (parameterTypes[i] == HttpResponse.class) {
                    args[i] = response;
                } else {
                    throw new IllegalArgumentException("Unsupported parameter type: " + parameterTypes[i]);
                }
            }

            try {
                method.invoke(controller, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
