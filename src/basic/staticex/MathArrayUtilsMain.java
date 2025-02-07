package basic.staticex;

public class MathArrayUtilsMain {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        System.out.println("MathArrayUtils.sum(values) = " + MathArrayUtils.sum(values));
        System.out.println("MathArrayUtils.average(values) = " + MathArrayUtils.average(values));
        System.out.println("MathArrayUtils.max(values) = " + MathArrayUtils.max(values));
        System.out.println("MathArrayUtils.min(values) = " + MathArrayUtils.min(values));
    }
}
