package com.company.sprint6;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan", 10, new BigDecimal(3000.00));
        Manager employee2 = new Manager("Petro", 9, new BigDecimal(3000.00),1.5);
        Employee employee3 = new Employee("Stepan", 8, new BigDecimal(4000.00));
        Employee employee4 = new Employee("Andriy", 7, new BigDecimal(3500.00));
        Employee employee5 = new Employee("Ihor", 5, new BigDecimal(3500.00));
        Manager employee6 = new Manager("Vasyl", 8, new BigDecimal(2000.00),2.0);


        ArrayList<Employee> some = new ArrayList<>();
        some.add(employee1);
        some.add(employee2);
        some.add(employee3);
        some.add(employee4);
        some.add(employee5);
        some.add(employee6);

        System.out.println(MyUtils2.largestEmployees(some));
//        [Employee[name='Ivan', experience=10, basePayment=3000],
//        Manager[name='Petro', experience=9, basePayment=3000, coefficient=1.5],
//        Employee[name='Stepan', experience=8, basePayment=4000],
//        Employee[name='Andriy', experience=7, basePayment=3500],
//        Employee[name='Ihor', experience=5, basePayment=3500],
//        Manager[name='Vasyl', experience=8, basePayment=2000, coefficient=2.0]]
    }
}

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (experience != employee.experience) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return basePayment != null ? basePayment.equals(employee.basePayment) : employee.basePayment == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + experience;
        result = 31 * result + (basePayment != null ? basePayment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("experience=" + experience)
                .add("basePayment=" + basePayment)
                .toString();
    }

    public int compareToByExperience(Employee o) {
        return experience - o.experience;
    }
    public int compareToByPayment(Employee o) {
        return getPayment().compareTo(o.getPayment());
    }



}

class Manager extends Employee{
    private double coefficient;

    public Manager(String name, int experience,BigDecimal basePayment, double coefficient ) {
        super(name, experience,basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public BigDecimal getPayment() {
        return super.getPayment().multiply(new BigDecimal(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getExperience() != employee.getExperience()) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        return getPayment() != null ? getPayment().equals(employee.getPayment()) : employee.getPayment() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName() .hashCode() : 0;
        result = 31 * result + getExperience();
        result = 31 * result + (getPayment() != null ? getPayment().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Manager.class.getSimpleName() + "[", "]")
                .add("name='" + getName() + "'")
                .add("experience=" + getExperience())
                .add("basePayment=" + super.getPayment())
                .add("coefficient=" + coefficient)
                .toString();
    }
}

class MyUtils2 {
    public static List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> res = new ArrayList<>();

        for(Employee worker : workers){
            if (worker.getExperience() == Collections.max(workers, Employee::compareToByExperience).getExperience())
                res.add(worker);
            if(worker.getPayment().compareTo(Collections.max(workers, Employee::compareToByPayment).getPayment()) == 0){
                res.add(worker);
            }
        }


        return res.stream().distinct().collect(Collectors.toList());
    }
}



