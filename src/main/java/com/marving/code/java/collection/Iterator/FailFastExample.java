package com.marving.code.java.collection.Iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mercop on 2017/9/11.
 * Fail-Fast 迭代器
 */
public class FailFastExample {
    public static void main(String[] args)
    {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }

    }
}
