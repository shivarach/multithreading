package com.shiva.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final WorkerThread workerThread = new WorkerThread("" + i);
            executorService.execute(workerThread);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String s) {
        this.message = s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processMessage();//call processMessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
