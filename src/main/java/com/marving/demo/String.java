package com.marving.demo;
/**
 * Created by mercop on 2017/8/1.
 */

public class String {

    java.lang.String str = null;

    public String(){
        this.str = "null String";
    }

    public String(java.lang.String str){
        this.str = str;
    }

    public static void print(){
        System.out.println("hello String Class");
    }

    public void getString(){
        System.out.println("get String: " + str);
    }
}
