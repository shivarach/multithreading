package com.shiva.multithreading;

import static java.lang.String.format;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(format("New Thread '%s' started running....", Thread.currentThread().getName()));
    }
}

class ThreadWithRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(String.format("New Thread '%s' started running....", Thread.currentThread().getName()));
    }
}

class ThreadClient {

    public static void main(String[] args) {

        //        We can also use Thread class
        final MyThread threadExample1 = new MyThread("NewThread-1");
        threadExample1.start();

        // Thread created with runnable
        final Thread thread = new Thread(new ThreadWithRunnable(), "NewThread-2");
        thread.start();
    }
}
