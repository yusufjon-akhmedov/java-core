package oop.polymorphism.project;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shape> shapes = List.of(
                new Circle(5),
                new Rectangle(4, 6)
        );

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
