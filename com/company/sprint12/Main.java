package com.company.sprint12;
import java.lang.Thread;


public class Main {
    public static void main(final String[] args){
        for (int i = 0; i < 10; i++) {
            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }
}

class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm Thread! My name is " + getName());
    }
}




