package basic.oopex;

class Rectangle {
    int width = 0;
    int height = 0;
    boolean isSquare = true;

    int calculateArea() {
        return width * height;
    }

    int calculatePerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }
}

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        int area = rectangle.calculateArea();
        System.out.println("넓이: " + area);
        int perimeter = rectangle.calculatePerimeter();
        System.out.println("둘레: " + perimeter);
        boolean square = rectangle.isSquare();
        System.out.println("정사각형 여부: " + square);
    }
}
