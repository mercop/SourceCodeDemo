package com.marving.code.java.concurrent;

import java.util.concurrent.CountDownLatch;


/**
 * Created by mercop on 2017/7/16.
 */
public class CountDownLatchDemo {
    private static int SIZE = 5;

    private static CountDownLatch countDownLatch;

    private static CountDownLatch start;

    public static void main(String[] args) throws InterruptedException {
        countDownLatch = new CountDownLatch(SIZE);
        start = new CountDownLatch(1);
        for (int i = 0; i < SIZE; i++) {
            new CountDownLatchDemo.MyTask().start();
        }
        System.out.println("等待5S...");
        Thread.sleep(5000);
        System.out.println("开始...");
        //开始
        start.countDown();
        //等待完成
        countDownLatch.await();
        System.out.println("所有线程写入完毕");
    }

    static class MyTask extends Thread {
        @Override
        public void run() {
            try {
                start.await();
                System.out.println("线程" + Thread.currentThread().getName() + "正在执行同一个任务");
                // 以睡眠来模拟几个线程执行一个任务的时间
                Thread.sleep(1000);
                System.out.println("线程" + Thread.currentThread().getName() + "执行任务完成，等待其他线程执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }
    }

}

