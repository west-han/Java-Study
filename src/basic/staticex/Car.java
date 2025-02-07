package basic.staticex;

public class Car {
    private static int count = 0;
    private String name;

    public Car(String name) {
        this.name = name;
        count++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수: " + count);
    }
}
