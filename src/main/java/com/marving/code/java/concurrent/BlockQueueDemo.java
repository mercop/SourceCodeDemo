package com.marving.code.java.concurrent;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mercop on 2017/7/29.
 *
 */

public class BlockQueueDemo {

    //生产消费者模式
    public static void main(String[] args) {
        BlockingQueue<MessageStore> queue = new LinkedBlockingDeque<>();

        new Thread(() -> {
            try {
                System.out.println("Producer handle this process");
                Thread.sleep(5000);
                queue.offer(new MessageStore(10));
                System.out.println("Producer offer message into queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Consumer to take this message and blocking");
                MessageStore messageStore = queue.take();
                //MessageStore messageStore = queue.poll(1000, TimeUnit.MILLISECONDS);
                if (messageStore != null)
                    System.out.println("got it" + " " + messageStore.messageId);
                else
                    System.out.println("get message failed ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    //put方法元素满的时候会await()
    //offer方法元素满直接返回true false
    @Test
    public void testOfferAndPut() throws Exception {
        LinkedBlockingDeque<MessageStore> linkedBlockingDeque = new LinkedBlockingDeque<>(2);

        new Thread(()->{
            try {
                System.out.println("start");
                linkedBlockingDeque.put(new MessageStore(1));
                linkedBlockingDeque.put(new MessageStore(2));
                linkedBlockingDeque.put(new MessageStore(3));
                System.out.println("finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

class MessageStore {
    public int messageId;

    public MessageStore(int messageId) {
        this.messageId = messageId;
    }
}
