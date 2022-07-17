package com.shiva.multithreading.synchronization;

public class InterThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        final Customer customer = new Customer();
        new Thread(() -> customer.withdraw(150)).start();
        new Thread(() -> customer.deposit(100)).start();
    }
}

class Customer {
    int amount = 100;

    public synchronized void withdraw(int withdrawAmount) {
        if (withdrawAmount >= amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amount -= withdrawAmount;
        System.out.println("withdraw completed...");
    }

    public synchronized void deposit(int depositAmount) {
        System.out.println("going to deposit...");
        amount += depositAmount;
        System.out.println("deposit completed... ");
        notify();
    }
}
