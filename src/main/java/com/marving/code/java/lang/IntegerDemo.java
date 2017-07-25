package com.marving.code.java.lang;

/**
 * Created by mercop on 2017/7/25.
 */

public class IntegerDemo {
    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        //IntegerCache
        System.out.println(e==f);
        //当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
        //而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));

        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
    }
}
