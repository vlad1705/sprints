package com.company.sprint8;

import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1,2,3,-1);
        System.out.println(MyUtils1.findMaxByCondition(numbers, x->x>0));

    }
}


class MyUtils1 {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        List<Integer> res_numbers = new ArrayList<>();
        for (Integer i: numbers) {
            if(pr.test(i)) res_numbers.add(i);
            else continue;
        }
        return Collections.max(res_numbers);
    }
}

class User {
    public static final List<Integer> values = new ArrayList<Integer>();

    static int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> function, Predicate<Integer> predicate) {
        return function.apply(values, predicate);
    }

    static int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils1::findMaxByCondition, predicate);
    }
}

