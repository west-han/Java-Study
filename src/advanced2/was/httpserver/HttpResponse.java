package advanced2.was.httpserver;

import java.io.PrintWriter;

import static java.nio.charset.StandardCharsets.*;

public class HttpResponse {
    private final PrintWriter writer;
    private int statusCode = 200;
    private final StringBuilder bodyBuilder = new StringBuilder();
    private String contentType = "text/html; charset=utf-8";

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    public void setStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void writeBody(String body) {
        bodyBuilder.append(body);
    }

    public void flush() { // 응답 메시지 생성 후 전송
        int contentLength = bodyBuilder.toString().getBytes(UTF_8).length;
        writer.println("HTTP/1.1 " + statusCode + " " + getReasonPhase(statusCode));
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length: " + contentLength);
        writer.println();
        writer.println(bodyBuilder);
        writer.flush();
    }

    private String getReasonPhase(int statusCode) {
        return switch (statusCode) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "Unknown Status";
        };
    }
}
