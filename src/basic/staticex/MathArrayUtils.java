package basic.staticex;

import java.util.Arrays;

public class MathArrayUtils {
    private MathArrayUtils(){}

    public static int sum(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static double average(int[] array) {
        return Arrays.stream(array).average().orElse(0.0);
    }

    public static int min(int[] array) {
        return Arrays.stream(array).min().orElseThrow();
    }

    public static int max(int[] array) {
        return Arrays.stream(array).max().orElseThrow();
    }
}
