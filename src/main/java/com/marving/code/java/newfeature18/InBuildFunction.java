package com.marving.code.java.newfeature18;

import org.junit.Test;

import java.util.function.*;

/**
 * Created by mercop on 2017/7/24.
 * 内建函数式接口
 * java.util.function
 *
 * 功能型函数接口
 * public interface Function<T, R> {R apply(T t);}
 *
 * 供给型函数接口
 *
 * public interface Supplier<T> {T get();}
 *
 * 消费型函数接口
 * public interface Consumer<T> {void accept(T t);}
 *
 * 断言型函数接口
 *
 * public interface Predicate<T>{ boolean test(T t); }
 *
 * * */

public class InBuildFunction {

    @Test
    public void test(){

        Function<Integer,String> function = String::valueOf;
        System.out.println(function.apply(1000));

        //扩展Function接口
        IntFunction<String> function1 =String::valueOf;
        System.out.println(function1.apply(1000));
    }

    @Test
    public void test1(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello World");

    }

    @Test
    public void test2(){
        Supplier<String> supplier = "hello"::toUpperCase;
        System.out.println(supplier.get());
    }

    @Test
    public void test3(){
        Predicate<String> predicate = "hello"::equals;
        System.out.println(predicate.test("hello".intern()));
    }
}
