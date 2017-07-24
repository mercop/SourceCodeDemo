package com.marving.code.java.lang;


/**
 * Created by mercop on 2017/7/24.
 * Runtime demo 类
 */

public class RuntimeDemo {

    static int M_1 = 1024*1024;

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println("1.max: " + runtime.maxMemory()/ M_1);
        System.out.println("1.total: " + runtime.totalMemory()/ M_1);
        System.out.println("1.free:" + runtime.freeMemory()/ M_1);

        String str = "";
        for(int i = 0; i < 1000; i ++)
            str+="a";

        System.out.println("2.max: " + runtime.maxMemory()/ M_1);
        System.out.println("2.total: " + runtime.totalMemory()/ M_1);
        System.out.println("2.free:" + runtime.freeMemory()/ M_1);

        //
        runtime.gc();
        System.gc();


        System.out.println("3.max: " + runtime.maxMemory()/ M_1);
        System.out.println("3.total: " + runtime.totalMemory()/ M_1);
        System.out.println("3.free:" + runtime.freeMemory()/ M_1);

    }

}
