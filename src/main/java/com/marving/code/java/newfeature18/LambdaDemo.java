package com.marving.code.java.newfeature18;

/**
 * Created by mercop on 2017/7/24.
 * JDK 1.8 Lambda 表达式
 * 面向对象语法要求结果必须非常完整。=>函数式编程(接口必须只有一个方法)
 *
 *  函数式编程接口@FunctionInterface
 */

@FunctionalInterface // 保证接口只能有一个方法
interface IUser{
    public void print();
    //Error
    //public void print2();
}
public class LambdaDemo {


    public static void main(String[] args) {
        IUser user = () -> System.out.println("Hello World");

        IUser user2 = () ->{
            System.out.println("1");
            System.out.println("2");
        };
        user.print();
        user2.print();
    }
}
