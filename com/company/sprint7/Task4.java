package com.company.sprint7;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(drawLine(LineType.DASHED));
    }
    public static String drawLine(LineType lineType) {
        return "The line is " + lineType.toString().toLowerCase() + " type";
    }
}

enum LineType {SOLID, DOTTED, DASHED, DOUBLE}


