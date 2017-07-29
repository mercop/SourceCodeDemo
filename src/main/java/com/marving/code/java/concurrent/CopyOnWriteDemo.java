package com.marving.code.java.concurrent;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by mercop on 2017/7/29.
 * CopyOnWriteArrayList 与 synchronizedList性能比较
 */

public class CopyOnWriteDemo {

    private static List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
    private static List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
    private static CountDownLatch cdl1 = new CountDownLatch(2);
    private static CountDownLatch cdl2 = new CountDownLatch(2);
    private static CountDownLatch cdl3 = new CountDownLatch(2);
    private static CountDownLatch cdl4 = new CountDownLatch(2);

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++)
                arrayList.add(String.valueOf(i));
            cdl1.countDown();
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++)
                copyOnWriteArrayList.add(String.valueOf(i));
            cdl2.countDown();
        }
    }

    static class Thread3 extends Thread1 {
        @Override
        public void run() {
            int size = arrayList.size();
            for (int i = 0; i < size; i++)
                arrayList.get(i);
            cdl3.countDown();
        }
    }

    static class Thread4 extends Thread1 {
        @Override
        public void run() {
            int size = copyOnWriteArrayList.size();
            for (int i = 0; i < size; i++)
                copyOnWriteArrayList.get(i);
            cdl4.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start1 = System.currentTimeMillis();
        new Thread1().start();
        new Thread1().start();
        cdl1.await();
        System.out.println("arrayList add: " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        new Thread2().start();
        new Thread2().start();
        cdl2.await();
        System.out.println("copyOnWriteArrayList add: " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        new Thread3().start();
        new Thread3().start();
        cdl3.await();
        System.out.println("arrayList get: " + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        new Thread4().start();
        new Thread4().start();
        cdl4.await();
        System.out.println("copyOnWriteArrayList get: " + (System.currentTimeMillis() - start4));
    }
}
