package com.company.sprint8;
import java.util.function.Consumer;

import java.util.Arrays;
import java.util.function.Predicate;

public class Test1 {
    public static void main(String[] args) {
        Predicate<Integer> positive = x-> x > 0;
        Predicate<String> containA = x-> x.contains("a") || x.contains("A");

        int a = -5;
        System.out.println(positive.test(a));
        System.out.println(containA.test("Hella"));

        Predicate<String> containsA = t -> t.contains("A");
        Predicate<String> containsB = t -> t.contains("B");
        System.out.println(containsA.and(containsB).test("ABCD"));

        int[] Arr = {1, 2, 3, -1, -5, 0};
        System.out.println(MyUtils.getCount(Arr, x-> x > 2));

        System.out.println(Arrays.toString(App0.getChanged(new double[] {1,10}, App0.cons)));
    }
}

class MyUtils {
    public static int getCount(int[] arr, Predicate<Integer> condition) {
        int sum = 0;
        for (int a: arr) {
            if(condition.test(a)){
                sum+=1;
            }
        }
        return sum;
    };
}

class App0 {
    public static Consumer<double[]> cons = arr-> {
        for (int i = 0; i<arr.length; i++)
            arr[i] *= (arr[i]>2 ? 0.8 : 0.9);
    };

        public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
            double [] newArr = Arrays.copyOf(initialArray, initialArray.length);
            consumer.accept(newArr);
            return newArr;
    }
}


