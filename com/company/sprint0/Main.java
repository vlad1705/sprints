package com.company.sprint0;

public class Main {

    public static void main(String[] args) {
        float b = 6;
        System.out.println(b);

        System.out.println(century(300));
        System.out.println(sumOfDigits(999));
        System.out.println(isLeapYear(2000));
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && !((year%100 == 0) && !(year%400 == 0))) ? true : false;
    }

    public static int century(int year) {
        return (year%100 != 0) ? year/100 + 1 : year/100;
    }
    public static int sumOfDigits(int number) {
        return (number / 100) + (number % 100 / 10) + (number % 100 % 10) ;
    }

}
