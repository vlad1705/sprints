//package com.company.sprint8;
//import java.util.Collections;
//import java.util.StringJoiner;
//import java.util.function.BinaryOperator;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Task3 {
//    public static void main(String[] args) {
//        List<Person> peoples = new ArrayList<>();
//        Collections.addAll(peoples, new Person("Vlad", "Pasemko"),new Person("Oleg", "Matskula"));
//        System.out.println(peoples);
//        System.out.println(App.createGreetings(peoples,App.greetingOperator));
//
//
//    }
//}
//
//class App {
//    public static BinaryOperator<String> greetingOperator = (x,y) -> "Hello " + x + " " + y + "!!!";
//
//    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {
//        List<String> res = new ArrayList<>();
//        for (Person person: people) {
//            res.add(greetingOperator.apply(person.name, person.surname));
//        }
//        return res;
//    }
//
//}
//
//class Person {
//    String name ;
//    String surname;
//
//    public Person(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    @Override
//    public String toString() {
//        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
//                .add("name='" + name + "'")
//                .add("surname='" + surname + "'")
//                .toString();
//    }
//}
