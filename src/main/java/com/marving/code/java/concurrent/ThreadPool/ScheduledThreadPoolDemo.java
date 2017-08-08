package com.marving.code.java.concurrent.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mercop on 2017/8/8.
 * 定时任务示例
 */

public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        for(int i = 0; i < 5 ; i++)
            scheduledExecutorService.scheduleWithFixedDelay(new EchoService(),0,2000, TimeUnit.MILLISECONDS);
    }
}


class EchoService implements Runnable{
    private volatile AtomicInteger count = new AtomicInteger(0);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
    @Override
    public void run() {
        System.out.println("Time:" + simpleDateFormat.format(System.currentTimeMillis()) + " " +
                Thread.currentThread().getName() + " "  + count.getAndIncrement());
    }
}
