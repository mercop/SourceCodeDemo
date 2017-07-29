package com.marving.code.java.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by mercop on 2017/7/29.
 */

public class BlockQueueDemo {

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
}

class MessageStore {
    public int messageId;

    public MessageStore(int messageId) {
        this.messageId = messageId;
    }
}
