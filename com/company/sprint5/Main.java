package com.company.sprint5;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee semp = new SalariedEmployee("1","12345");
        System.out.println(semp.getFullInfo());

        Student vlad = new Student(2018,"Vlad", "Pasemko");

        System.out.println(vlad.getCourseNumber());

    }
}
class Person{
    int age;
    String healthInfo;
    String name;
    String getHealthStatus(){ return name +" " + healthInfo; }

    public Person(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }
}

class Child extends Person{
    String childIDNumber;

    public Child(int age, String healthInfo, String name, String childIDNumber) {
        super(age, healthInfo, name);
        this.childIDNumber = childIDNumber;
    }
}

class Adult extends Person{
    String passportNumber;

    public Adult(int age, String healthInfo, String name, String passportNumber) {
        super(age, healthInfo, name);
        this.passportNumber = passportNumber;
    }
}

abstract class Animal{
    int age;
    double weight;

    public Animal(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }
    public abstract String move();
}
class Mammal extends Animal{

    public Mammal(int age, double weight) {
        super(age, weight);
    }

    @Override
    public String move() {
        return "run";
    }
}
final class Fish extends Animal{

    public Fish (int age, double weight) {
        super(age, weight);
    }

    @Override
    public final String move() {
        return "swim";
    }
}

final class Bird extends Animal{

    public Bird (int age, double weight) {
        super(age, weight);
    }

    @Override
    public final String move() {
        return "fly";
    }
}

class User{
    protected String name;
    protected String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    String getFullName(){
        return name + " " + surname;
    }
}
class Student extends User{
    protected int year;

    public Student(int year, String name, String surname) {
        super(name, surname);
        this.year = year;
    }

    int getCourseNumber(){
        Calendar calendar = Calendar.getInstance();
        int res = (calendar.get(Calendar.YEAR)) - this.year;
        return (res > 0 && res<6) ? res : -1 ;
    }


}
abstract class Employee {
    protected String employeeID;
    public abstract String getFullInfo();

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }
}

class SalariedEmployee extends Employee{
    protected String socialSecurityNumber;

    public SalariedEmployee(String employeeID, String socialSecurityNumber) {
        super(employeeID);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String getFullInfo() {
        return employeeID + " " + socialSecurityNumber;
    }
}

class ContractEmployee extends Employee {
    protected String federalTaxIDMember;

    public ContractEmployee(String employeeID, String federalTaxIDMember) {
        super(employeeID);
        this.federalTaxIDMember = federalTaxIDMember;
    }


    @Override
    public String getFullInfo() {
        return employeeID + " " + federalTaxIDMember;
    }
}
