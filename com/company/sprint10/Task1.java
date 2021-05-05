package com.company.sprint10;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class Task1 {
    public static void main(String[] args) {
//        Integer[] intarr = {1,2,3,4,5,6,7,8,9};
//        String[] stringarr = {"Vlad", "Vika", "Nazar", "Khrystia"};
//        Double[] doublearr = {1.2,2.4,3.5,4.6,5.65,656.65,7.65,8.65,9.65};
//
//        printel(intarr);
//        printel(stringarr);
//        printel(doublearr)  ;
//
//        Integer[] nums = new Integer[3];
//        int numsfrom1pos = ArrayUtil.setAndReturn(nums, 52, 1);
//        System.out.println(numsfrom1pos);
        Array<Integer> ar = new Array<>(new Integer[]{1,2,3,4,5});
        double res = ArrayUtil.averageValue(ar);
        System.out.println(res);
        Integer a = 4;

    }
    public static <T> void printel(T[] arr){
        for (T elem: arr) System.out.println(elem);
    }

}

class Wrapper<T extends Shape>{
    private T value;

    public Wrapper(T name) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class ArrayUtil<T> {
    public static <T> T setAndReturn(T[] arr, T elem, int pos) {
        arr[pos] = elem;
        return arr[pos];
    }

    public static double averageValue(Array<? extends Number> array) {
        double sum = 0.;
        for (int i = 0; i < array.length(); i++)
            sum += array.get(i).doubleValue();
        return sum/array.length();
    }
}

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}


