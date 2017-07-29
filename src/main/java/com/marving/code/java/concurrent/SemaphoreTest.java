package com.marving.code.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by mercop on 2017/7/29.
 */

public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);

        for (int index = 0; index < 20; index++) {
            final int NO = index;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Access:" + NO);
                    Thread.sleep(10000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
