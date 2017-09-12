package com.marving.code.java.collection.Iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mercop on 2017/9/11.
 * Fail-Safe 迭代器
 * 弱一致性迭代器，不会报Throw ConcurrentModification Exception
 * 但是获取数据可能不是最新的
 */
public class FailSafeExample {

    public static void main(String[] args) {

        ConcurrentHashMap<String,String> premiumPhone =
                new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            //不保证数据最新
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}
