package com.marving.code.java.concurrent.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mercop on 2017/8/3.
 */

public class Test {

    public static void main(String[] args) {
        DefaultThreadPool<MessageHandler> defaultThreadPool = new DefaultThreadPool();
        for(int i = 0; i < 20; i ++)
            defaultThreadPool.execute(new MessageHandler());
    }


}

class MessageHandler implements Runnable{
    public static AtomicInteger n = new AtomicInteger(0);
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " current message index is: " + n.getAndIncrement());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
