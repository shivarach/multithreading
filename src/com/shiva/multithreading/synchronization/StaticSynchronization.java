package com.shiva.multithreading.synchronization;

public class StaticSynchronization {
    public static void main(String args[]) {
        final MyTable tableData = new MyTable();//only one object

//        Without synchronization
//        Thread t1= new Thread(() -> tableData.printTableWithoutSynchronization(5));
//        Thread t2= new Thread(() -> tableData.printTableWithoutSynchronization(100));
//        t1.start();
//        t2.start();

        //        With synchronization
        Thread t3 = new Thread(() -> tableData.printTable(5));
        Thread t4 = new Thread(() -> tableData.printTable(100));
        t3.start();
        t4.start();
    }
}

class MyTable {
    synchronized static void printTable(int n) {//synchronized method
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
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
