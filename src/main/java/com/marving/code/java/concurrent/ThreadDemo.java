package com.marving.code.java.concurrent;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/29.
 *
 * 结束线程的方法
 */

public class ThreadDemo {

    class MyThread extends Thread {
        public boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
            }
        }
    }

    class InterruptThread extends Thread {
        @Override
        public void run() {

            while (!this.isInterrupted()){
                try {

                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
            }
        }
    }

    @Test
    public void test1() throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000); // 主线程延迟5秒
        thread.flag = false;  // 终止线程thread
        thread.join();
        System.out.println("线程退出!");
    }

    @Test
    public void test2() throws InterruptedException {
        InterruptThread thread = new InterruptThread();
        thread.start();
        Thread.sleep(2000); // 主线程延迟5秒
        //thread.flag= false;  // 终止线程thread
        thread.interrupt();
        thread.join();
        System.out.println("线程退出!");
    }

}
