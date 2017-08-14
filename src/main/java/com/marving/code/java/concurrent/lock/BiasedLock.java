package com.marving.code.java.concurrent.lock;

import java.util.List;
import java.util.Vector;

/**
 * Created by mercop on 2017/8/12.
 * 偏向锁实验
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 * -XX:-UseBiasedLocking
 */

public class BiasedLock {

    public static List<Integer> numberList =new Vector<Integer>();
    public static void main(String[] args) throws InterruptedException {
        long begin=System.currentTimeMillis();
        int count=0;
        int startnum=0;
        while(count<10000000){
            numberList.add(startnum);
            startnum+=2;
            count++;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }

}
