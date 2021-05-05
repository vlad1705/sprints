package com.company.sprint7;

public class Task3 {
    public static void main(String[] args) {
        String c = "fjvnk";
        System.out.println(c.getClass().getSimpleName());
    }

    public static void execute(int a, int b, Strategy strategy){
        double result = strategy.doOperation(a,b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a , int b) {
                return a + b;
            }
        };
        double result = strategy.doOperation(a,b);
    };
}

interface Strategy{
    double doOperation(int a, int b);
};

