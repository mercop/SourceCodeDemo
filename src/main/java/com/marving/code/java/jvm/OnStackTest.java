package com.marving.code.java.jvm;

/**
 * Created by mercop on 2017/8/11.
 * 栈上分配与逃逸分析
 *
 * 设置逃逸分析
 * -server -Xmx20m -Xms20m
 -XX:+DoEscapeAnalysis -XX:+PrintGC

 * 不设置逃逸分析
 * -server -Xmx20m -Xms20m
 -XX:-DoEscapeAnalysis -XX:+PrintGC
 */

public class OnStackTest {
    public static void alloc(){
        byte[] b=new byte[2];
        b[0]=1;
    }
    public static void main(String[] args) {
        long b=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-b);
    }
}

