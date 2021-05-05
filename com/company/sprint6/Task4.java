package com.company.sprint6;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {

    }
}



abstract class Shape  implements Comparable<Shape>  {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getAria();
}
class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getAria() {
        return Math.PI*Math.pow(radius,2);
    }


    @Override
    public int compareTo(Shape o) {
        return (int) (getAria()-o.getAria());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    @Override
    public double getAria() {
        return height*width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public int compareTo(Shape o) {
        return (int) (getAria()-o.getAria());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
class MyUtils4 {
    public List<Shape> maxAreas(List<Shape> shapes) {
        Set<Shape> shapeSet = new HashSet<>(shapes);

        List<Shape> shapeList = new ArrayList<>(shapeSet);

        List<Circle> circleList = new ArrayList<>();

        List<Rectangle> rectangles = new ArrayList<>();

        for (Shape shape : shapeList) {
            if (shape instanceof Circle) {
                circleList.add((Circle) shape);
            } else if (shape instanceof Rectangle) {
                rectangles.add((Rectangle) shape);
            }
        }
        List<Shape> result = new ArrayList<>();

        for (Circle std : circleList)
            if (std.getAria() == Collections.max(circleList).getAria())
                result.add(std);

        for (Rectangle wrk : rectangles)
            if (wrk.getAria() == Collections.max(rectangles).getAria())
                result.add(wrk);

        Collections.sort(result);
        return result;
    }
}