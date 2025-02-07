package basic.staticex;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("K3");
        Car car1 = new Car("G80");
        Car car2 = new Car("Model Y");

        Car.showTotalCars();
    }
}
