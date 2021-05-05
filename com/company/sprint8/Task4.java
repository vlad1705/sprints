package com.company.sprint8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task4 {
    public static void main(String[] args) {

        DecisionMethod person = new Person("Vlad").goShopping;
        DecisionMethod person2 = new Person("Vladik").goShopping;

        Shop.clients.add(person);
        Shop.clients.add(person2);

        System.out.println(Shop.sale("product1", 11));


    }
}


class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = (name, discount) -> (name.equals("product1") && (discount>10))? true : false;
}

// Create DecisionMethod interface here
@FunctionalInterface
interface DecisionMethod{
    boolean deсide(String obj1, int obj2);
}

class Shop {
    public static List<DecisionMethod> clients = new ArrayList<>();

    public static int sale(String product, int percent) {
        int res = 0;
        for (DecisionMethod c: clients)
            res += c.deсide(product, percent) ? 1 : 0 ;
        return res;
    }
}
