package com.company.sprint11;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws ColorException, TypeException {
//        try {
//            System.out.println("Делим число на ноль");
//            System.out.println(366/0);//в этой строчке кода будет выброшено исключение
//            Scanner scan = new Scanner(System.in);
//            int c = scan.nextInt();
//
//            int[] arr = new int[5];
//            System.out.println(arr[5]);
//
//            System.out.println("Этот");
//            System.out.println("код");
//            System.out.println("не");
//            System.out.println("будет");
//            System.out.println("выполнен!");
//
//        } catch (ArithmeticException e) {
//
//            System.out.println("Программа перепрыгнула в блок catch!");
//            System.out.println("Ошибка! Нельзя делить на ноль!");
//        }
//        catch (InputMismatchException e) {
//            System.out.println("Не правильно указано число! " + e.getMessage());
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Не правильно указан индекс!");
//        }
        System.out.println(Operation.trySquareRectangle(1,-2));
//        Plant plant = new Plant("rare", "Red", "Rose");
//        System.out.println(plant);

        System.out.println(tryCreatePlant("Rare", "Black", "Roza"));

        BankDemo test = new BankDemo();
        test.doOperations();
    }
    static Plant tryCreatePlant(String type,String color,String name) throws ColorException, TypeException {

        while (true){
            try {
                return new Plant(type, color, name);
            } catch (ColorException e) {
                color = Color.RED.toString();
            } catch (TypeException e) {
                name = Type.ORDINARY.toString();
            }
        }
    }
}
//import java.util.StringJoiner;
 class Plant{
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException{
        this.name = name;

        if (color.equalsIgnoreCase(String.valueOf(Color.BLUE)) || color.equalsIgnoreCase(String.valueOf(Color.WHITE)) || color.equalsIgnoreCase(String.valueOf(Color.RED))){
            this.color = Color.valueOf(color.toUpperCase());
        }else
            throw new ColorException("Invalid value " + color + " for field color");

        if (type.equalsIgnoreCase(String.valueOf(Type.ORDINARY)) || type.equalsIgnoreCase(String.valueOf(Type.RARE))){
            this.type = Type.valueOf(type.toUpperCase());
        }else
            throw new TypeException("Invalid type " + type + " for field type");
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ","{", "}")
                .add("type: " + type )
                .add("color: " + color)
                .add("name: " + name)
                .toString();
    }
}
enum Color{
    WHITE,RED,BLUE
}
enum Type{
    RARE ,ORDINARY
}

class ColorException extends Exception{
    public ColorException(String message) { super(message); }
}

class TypeException extends Exception{
    public TypeException(String message) { super(message); }
}

class Operation{
    public static int squareRectangle (int a, int b) throws IllegalArgumentException{
        if(a<0 || b<0) throw new IllegalArgumentException("Negative number");
        return a*b;
    }
    public static int trySquareRectangle(int a, int b) {
        try{
            return squareRectangle(a,b);
        }
        catch (IllegalArgumentException e){
            System.out.println("You entered negative number !");
        }
        return 0;
    }
}

class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
        if(amount <= balance) {
            balance -= amount;
        }else {
            double needs = amount - balance;
            throw new InsufficientAmountException(needs);
        }
    }
    // some other code
}
class InsufficientAmountException extends Exception{
    double amount;

    public InsufficientAmountException(double amount) {
        this.amount = amount;
    }
    public String getMessage() {
        return "Sorry, but you are short $" + amount;
    }

    public double getAmount() {
        return amount;
    }
}

class BankDemo {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}

