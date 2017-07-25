package com.marving.code.java.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mercop on 2017/7/15.
 * LRU Cache 实现
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private int MAX_ENTRIES;

    public LRUCache(int size){

        super((int) Math.ceil (size / 0.75f) + 1,0.75f, true);
        MAX_ENTRIES = size;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
    public static void main(String[] args){
        LRUCache<String,String> linkedHashMap =
                new LRUCache<String,String>(4);
        linkedHashMap.put("a","1");
        linkedHashMap.put("b","2");
        linkedHashMap.put("c","3");
        linkedHashMap.put("d","4");
        linkedHashMap.put("e","5");
        System.out.println("访问前：");
        System.out.println(linkedHashMap);
        //access items
        System.out.println("访问后：");
        linkedHashMap.get("d");
        System.out.println(linkedHashMap);
        System.out.println("新增后：");
        linkedHashMap.put("f","6");
        System.out.println(linkedHashMap);
    }
}
