package com.company.sprint7;

import java.util.Iterator;

public class Task2 {
    public static void main(String[] args) {
        NameList qwe = new NameList();
        NameList qwa = new NameList();
        NameList.Iterator c = qwe.getIterator();
//        System.out.println(qwe.getIterator().hasNext());
        System.out.println(c.next());
        System.out.println(c.next());
    }
}

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }
    public class Iterator{
        private int counter = 0;

        private Iterator(){};

        public boolean hasNext(){
            return (counter <= names.length-1) ? true : false;
        }
        public String next(){
            return names[counter++];
        }

    }
}

