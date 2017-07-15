package main.java.com.marving.code.java.collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by mercop on 2017/7/15.
 */
public class MapDemo {

    @Test
    public void testMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        System.out.print("HashMap:");
        for(String key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }

        Map<String, String> linkedMap = new LinkedHashMap<String, String>();
        linkedMap.put("a", "1");
        linkedMap.put("c", "3");
        linkedMap.put("b", "2");
        linkedMap.put("d", "4");
        System.out.println();
        System.out.print("LinkedHashMap:");
        for(String key : linkedMap.keySet()) {
            System.out.print(linkedMap.get(key) + " ");
        }
        System.out.println();

        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("a", "1");
        treeMap.put("c", "3");
        treeMap.put("b", "2");
        treeMap.put("d", "4");

        System.out.print("TreeMap:");
        for(String key : treeMap.keySet()) {
            System.out.print(treeMap.get(key) + " ");
        }
        System.out.println();
    }

    @Test
    public void testLinkedHashMap(){

    }

    @Test
    public void priorityQueueTest(){

        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.offer("1");
        priorityQueue.offer("3");
        priorityQueue.offer("4");
        priorityQueue.offer("2");
        System.out.println("PriorityQueue:");
        //迭代器打印
        Iterator<String> iterator = priorityQueue.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() +" ");
        }
        System.out.println();
        //poll打印，顺序输出
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
