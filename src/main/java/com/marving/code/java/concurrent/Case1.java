package com.marving.code.java.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mercop on 2017/7/29.
 * 场景：主线程中有多个子线程，要求子线程都执行完之后，主线程才执行
 */

public class Case1 {

    private static final ExecutorService EXEC1 = Executors.newCachedThreadPool();
    private static final CountDownLatch coutDownLatch = new CountDownLatch(100);
    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < 100; i ++){
            EXEC1.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+ " start");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  finally {
                    System.out.println(Thread.currentThread().getName() + " Job finished");
                    coutDownLatch.countDown();
                }
            });

        }
        coutDownLatch.await();
        System.out.println("start running main job");

        EXEC1.shutdown();
    }


    @Test
    public void test() throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 100 ; i++){
            Thread thread = new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+ " start");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }  finally {
                    System.out.println(Thread.currentThread().getName() + " Job finished");
                }
            });
            threadList.add(thread);
        }

        for(Thread thread : threadList)
            thread.start();

        for(Thread thread : threadList)
            thread.join();
        System.out.println("start running main job");
    }
}
