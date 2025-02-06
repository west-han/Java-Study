package mid1.enumeration.test.http;

import java.util.Arrays;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus findByCode(int code) {
        return Arrays.stream(values())
                .filter(e -> e.getCode() == code)
                .findFirst().orElse(null);
    }

    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }
}
