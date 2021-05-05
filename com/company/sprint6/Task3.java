package com.company.sprint6;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Task3 {
    public static void main(String[] args) {
        Figurable figure = new Square(4);
        Figurable figure1 = new Square(5);
        Figurable figure2 = new Rectang (2,3);

        List<Figurable> figures = new ArrayList<>();

        figures.add(figure);
        figures.add(figure1);
        figures.add(figure2);

        System.out.println(MyUtils3.sumPerimeter(figures));
    }

}

@FunctionalInterface
interface Figurable {
    double getPerimeter();
}

class Rectang implements Figurable{

    private double width;
    private double height;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        if (width>0 && height>0){
            return width*2 + height*2;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rectang.class.getSimpleName() + "[", "]")
                .add("width=" + width)
                .add("height=" + height)
                .toString();
    }
}
class Square implements Figurable {
    private double width;

    public Square(double width) {
        this.width = width;
    }
    @Override
    public double getPerimeter() {
        if (width>0){
            return width*4;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Square.class.getSimpleName() + "[", "]")
                .add("width=" + width)
                .toString();
    }
}

class MyUtils3 {
    public static double sumPerimeter(List<?> figures) {
        if (figures == null) {
            return 0;
        }

        double res = 0;
        for (Object figure : figures) {
            if (figure==null){
                return 0;
            }
            res += ((Figurable) figure).getPerimeter();
        }

        return res;
    }
}

