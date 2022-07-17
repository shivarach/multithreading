package com.shiva.multithreading.synchronization;

public class SynchronizedBlock {
    public static void main(String args[]) {
        final TableData obj = new TableData();//only one object

//        Without synchronization
//        Thread t1= new Thread(() -> obj.printTableWithoutSynchronization(5));
//        Thread t2= new Thread(() -> obj.printTableWithoutSynchronization(100));
//        t1.start();
//        t2.start();

        //        With synchronization
        Thread t3 = new Thread(() -> obj.printTable(5));
        Thread t4 = new Thread(() -> obj.printTable(100));
        t3.start();
        t4.start();
    }
}

class TableData {
    void printTable(int n) {//synchronized method
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    void printTableWithoutSynchronization(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
