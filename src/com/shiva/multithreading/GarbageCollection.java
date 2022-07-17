package com.shiva.multithreading;

//Note: Neither finalization nor garbage collection is guaranteed. So run it multiple times and find your luck
public class GarbageCollection {

    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        GarbageCollection s1 = new GarbageCollection();
        GarbageCollection s2 = new GarbageCollection();
        s1 = null;
        s2 = null;
        System.gc();
    }


}
