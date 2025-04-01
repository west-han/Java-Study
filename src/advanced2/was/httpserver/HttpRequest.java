package advanced2.was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.net.URLDecoder.decode;
import static java.nio.charset.StandardCharsets.UTF_8;

/*
 * METHOD PATH HTTP_VERSION
 * KEY: VALUE
 * KEY: VALUE
 * ...
 * CRLF
 * Body
 * ...
 */

public class HttpRequest {
    private String method;
    private String path;
    private Map<String, String> queryParameteres = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseHeader(reader);
    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if (requestLine == null) {
            throw new IOException("EOF: No request line received");
        }

        String[] parts = requestLine.split(" ");
        if (parts.length != 3) {
            throw new IOException("Invalid request line: " + requestLine);
        }

        method = parts[0];
        String[] pathParts = parts[1].split("\\?");
        path = pathParts[0];

        if (pathParts.length > 1) {
            parseQueryParameters(pathParts[1]);
        }

    }

    private void parseQueryParameters(String queryParameters) {
        for (String param : queryParameters.split("&")) {
            String[] keyValue = param.split("=");
            String key = decode(keyValue[0], UTF_8);
            String value = keyValue.length > 1 ? decode(keyValue[1], UTF_8) : "";
            queryParameteres.put(key, value);
        }
    }

    private void parseHeader(BufferedReader reader) throws IOException {
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(":");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public String getQueryParameter(String name) {
        return queryParameteres.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParameteres=" + queryParameteres +
                ", headers=" + headers +
                '}';
    }
}
