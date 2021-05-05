package com.company.sprint7;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Task5 {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1,"Vladik");
//        map.put(6,"dik");
//        map.put(3,"Vlad");
//
//        System.out.println(map.toString());
        AddressBook book = new AddressBook(3);

        book.create("Vlad", "Pasemko", "Lviv 17");
        book.create("Vla", "Pasemk", "Lvi 17");

//        System.out.println(book.create("Vlad", "Pasmko", "Lviv 17"));
//        System.out.println(book.create("Vlad", "Pasemko", "Lviv 17"));


    }
}

class AddressBook{
    private int capacity;
    private NameAddressPair[] addressBook = new NameAddressPair[capacity];
    private int counter = 0;

    public AddressBook(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }




    public boolean create(String firstName, String lastName, String address){
        if (counter < capacity ){
            System.out.println(counter);
//            System.out.println(counter);
//            System.out.println(addressBook.length);
//            addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
//            System.out.println(Arrays.toString(this.addressBook));
            counter++;
//            System.out.println(addressBook[counter]);
            return true;
        }
        else{
            return false;
        }
    }

    private static class NameAddressPair{
        private Person person;
        private String address;

        public NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", NameAddressPair.class.getSimpleName() + "[", "]")
                    .add("person=" + person)
                    .add("address='" + address + "'")
                    .toString();
        }

        private static class Person{
            private String firstName;
            private String lastName;

            public Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                        .add("firstName='" + firstName + "'")
                        .add("lastName='" + lastName + "'")
                        .toString();
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Person person = (Person) o;

                if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
                return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
            }

            @Override
            public int hashCode() {
                int result = firstName != null ? firstName.hashCode() : 0;
                result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
                return result;
            }
        }
    }
}
