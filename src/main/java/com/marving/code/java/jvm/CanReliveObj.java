package com.marving.code.java.jvm;

/**
 * Created by mercop on 2017/8/11.
 * 可触及行分析以及finalize 方法特性（只能被调用一次，对象有一次复活机会）
 */

public class CanReliveObj {

    public static CanReliveObj obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws
            InterruptedException{
        obj=new CanReliveObj();
        obj=null;   //可复活
        System.gc();
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj 是 null");
        }else{
            System.out.println("obj 可用");
        }
        System.out.println("第二次gc");
        obj=null;    //不可复活
        System.gc();
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj 是 null");
        }else{
            System.out.println("obj 可用");
        }
    }
}

