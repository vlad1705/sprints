package com.company.sprint3;


import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        1_________________________________________________________________
        Integer arr [][] = {
                {1,2,3},
                {1,4},
                {3,2},
                {3,3,5}
        };
        for(Integer[] elem: arrSort(arr)){
            System.out.println(Arrays.toString(elem));
        }
//        System.out.println(Arrays.toString(arrSort(arr)));
//        System.out.println(Arrays.toString(arrSort(arr)));

//        2________________________________________________________________

//        List<String> cars = new ArrayList<>();
//        Collections.addAll(cars, "zz", "abc", "aa", "aaa", "a");
//        System.out.println(strSort(cars));

//        3_________________________________________________________________

//        HashMap<String, String> someLettersMap = new HashMap<>();
//        someLettersMap.put("1", "cc");
//        someLettersMap.put("2", "bb");
//        someLettersMap.put("3", "cc");
//        someLettersMap.put("4", "aa");
//        someLettersMap.put("5", "cc");
//
//        List<String> someLetters = new ArrayList<>();
//        Collections.addAll(someLetters, "cc", "bb", "aa", "cc");
//
//        System.out.println(listMapCompare(someLetters, someLettersMap));

//        4__________________________________________________________________
//        HashMap<String, String> phones = new HashMap<>();
//        phones.put("0967654321", "Petro");
//        phones.put("0677654321", "Petro");
//        phones.put("0501234567", "Ivan");
//        phones.put("0970011223", "Stepan");
//        phones.put("0631234567", "Ivan");
//
//        System.out.println(createNotebook(phones));

//        5__________________________________________________________________
//        List<Student> list1 = new ArrayList<>();
//        Collections.addAll(list1,
//                new Student(1, "Ivan"),
//                new Student(2, "Petro"),
//                new Student(3, "Stepan"));
//
//        List<Student> list2 = new ArrayList<>();
//        Collections.addAll(list2,
//                new Student(1, "Ivan"),
//                new Student(3, "Stepan"),
//                new Student(4, "Andriy"));
//
////        Student ivan = new Student(1, "Ivan");
////        System.out.println(ivan.equals(new Student(1, "Ivan")));
//
//        System.out.println(commonStudents(list1,list2));
//
//        Set<String> list = new HashSet<>();
//        Student student1 = new Student(1, "Ivan");
//        Student student2 = new Student(1, "Ivan");
//
//
//        System.out.println(student1.hashCode());
//        System.out.println(student2.hashCode());
    }



        static Integer[][] arrSort(Integer[][] arr) {
            Integer [][] array = Arrays.copyOf(arr, arr.length);

            Arrays.sort(array, new CompareArrElements());

            return array;

        }
        public static class CompareArrElements implements Comparator<Integer[]>{
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1]<o2[1] && o1[0]>=o2[0]){
                    return 1;
                    }
                else if (o1[1]<o2[1] && o1[0]<=o2[0]){
                    return -1;
                }
                return 0;
//                if(o1[0]>o2[0] ){
//                    if(o1[1]<o2[1]){
//                        return 1;
//                    }
//                    return -1;
//                }
//                else if(o1[0]<o2[0] ){
//                    if(o1[1]>o2[1]){
//                        return -1;
//                    }
//                    return 1;
//                }
//                return 0;
            }
        }

    static List<String> strSort(List<String> originList) {
        List<String> strSort = new ArrayList<>(originList);
        Collections.sort(strSort);
        for (int i = 0; i < strSort.size(); i++) {
            for (int j = 0; j < strSort.size() - 1; j++) {
                if (strSort.get(j).length() > strSort.get(j + 1).length()) {
                    String temp = strSort.get(j);
                    strSort.set(j, strSort.get(j + 1));
                    strSort.set(j + 1, temp);
                }
            }
        }
        return strSort;
    }

    ;

    static boolean listMapCompare(List<String> list, Map<String, String> map) {
        HashSet<String> listSet = new HashSet<String>(list);
        HashSet<String> mapSet = new HashSet<String>(map.values());

        return listSet.equals(mapSet);
    }

    static Map<String, List<String>> createNotebook(Map<String, String> phones) {
        HashMap<String, List<String>> notebook = new HashMap<>();

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (!notebook.containsKey(entry.getValue())) {
                notebook.put(entry.getValue(), new ArrayList<String>());
            }
            notebook.get(entry.getValue()).add(entry.getKey());
        }
        return notebook;
    }

    public static class Student {
        private final Integer id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != null ? !id.equals(student.id) : student.id != null) return false;
            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    static Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> list1_set = new HashSet<Student>(list1);
        Set<Student> list2_set = new HashSet<Student>(list2);

        list1_set.addAll(list2_set);

        return list1_set;
    }
}

