package com.company.sprint8;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        Predicate<Integer> bigger0 = t -> t > 0;
        Predicate<Integer> bigger1 = t -> t < 4;
        Predicate<Integer> eq2 = t -> t == 2;

        Set<Predicate<Integer>> predicates = new HashSet<>();
        Collections.addAll(predicates, bigger0, bigger1, eq2);

        System.out.println(MyUtil.getPredicateFromSet(predicates).test(5));
    }
}

class MyUtil {
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates){
        Predicate<Integer> c = t -> true;
        for (Predicate<Integer> s:predicates)
            c = s.and(c);
        return c;
    }
}
