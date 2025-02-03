package mid1.lang.string.test;

import java.util.StringJoiner;

public class TestString9 {
    public static void main(String[] args) {
        String fruits = "apple,banana,mango";
        String[] parts = fruits.split(",");
        for (String part : parts) {
            System.out.println(part);
        }
        String joinedString = String.join("->", parts);
        System.out.println("joinedString = " + joinedString);
    }
}
