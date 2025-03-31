package advanced2.network.review.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object object) {
        LocalDateTime now = LocalDateTime.now();
        System.out.printf("%s [%10s] %s\n", now.format(formatter), Thread.currentThread().getName(), object);
    }
}
