package com.company.sprint8;

import java.util.*;

@FunctionalInterface
interface ElementProcessor{
    double proccess(int element);
}
public class LambdaTraining {
    public static void main(String[] args) {
        String arr[] = {"Vlad","Vova","Vitalik","Rozi"};
        Arrays.sort(arr,(o1, o2)->
                    o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1));
        System.out.println(Arrays.toString(arr));

        List<Integer> elements = new ArrayList<>();
        Collections.addAll(elements, 1,2,3,4,5);

        processelements(elements, x->x+1);
        System.out.println(Math.sin(3));

    }

    private static void processelements(List<Integer> inList, ElementProcessor function){
        List<Double> res = new ArrayList<>();

        for (Integer i : inList)
            res.add(function.proccess(i));

        System.out.println(res);
    }


}

