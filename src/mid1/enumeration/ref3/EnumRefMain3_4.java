package mid1.enumeration.ref3;

import static mid1.enumeration.ref3.Grade.*;

public class EnumRefMain3_4 {
    public static void main(String[] args) {
        int price = 10000;

        for (Grade value : values()) {
            printDiscount(value, price);
        }

    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " 등급의 할인 금액: " + grade.getDiscountPrice(price));
    }
}
