package com.marving.code.java.concurrent;

/**
 * Created by mercop on 2017/7/29.
 * Synchronized 示例
 */

public class SynchronizedDemo {

    public static void main(String[] args){
        Sync sync = new Sync();
        new Thread(()->{
            sync.method1();
            System.out.println(sync.num);
        }).start();

        new Thread(()->{
            sync.method2();
            System.out.println(sync.num);
        }).start();


        //类方法Synchronized不会与对象方法冲突
        //static获取到的锁，是属于类的锁。而非static方法获取到的锁，是属于当前对象的锁。所以，他们之间不会产生互斥
        new Thread(()->{
            sync.method3();

        }).start();

    }
}

class Sync{

    public int num = 10;

    //方法锁定
    public synchronized void method1(){
        System.out.println("method1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("try to release lock method1");
    }

    public synchronized void method2(){
        System.out.println("method2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("try to release lock method2");
    }

    public synchronized static void method3(){
        System.out.println("method3");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method3 end");
    }
}
