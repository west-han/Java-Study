package bibleofjava.syntax;

import java.util.Scanner;

class Shape {
    private final int size;

    public Shape(int size) {
        this.size = size;
    }

    public void render() {
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

class Triangle extends Shape {
    public Triangle(int size) {
        super(size);
    }

    @Override
    public void render() {
        for (int i = 0; i < super.getSize(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}

class Rectangle extends Shape {
    public Rectangle(int size) {
        super(size);
    }

    @Override
    public void render() {
        for (int i = 0; i < super.getSize(); i++) {
            for (int j = 0; j < super.getSize(); j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Shape s = null;

        if (input == 0) {
            s = new Triangle(5);
        } else {
            s = new Rectangle(5);
        }

        s.render();
        System.out.println(s instanceof Triangle);
    }
}
