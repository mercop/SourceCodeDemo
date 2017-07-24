package com.marving.code.java.newfeature18;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/24.
 * JDK1.8 方法引用
 *
 * 四种类型：
 *  引用静态方法
 *  引用某个对象的方法
 *  引用某个特定的类方法
 *  构造方法
 */


interface IUtil<P,R>{
    public R covert(P p);
}

interface IUtil2<R>{
    public R covert();
}

interface IUtil3<R,FP>{
    public R create(FP fp);

}

class Person{
    String name;

    public Person(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person name " + this.name;
    }


}

public class FunctionReferenceDemo {

    @Test
    public void testStaticFunction(){
        IUtil<Integer,String> iu = String::valueOf;
        String str = iu.covert(1000);
        System.out.println("len of string: " + str.length());
    }

    @Test
    public void testObjectFunction(){
        IUtil2<String> iu = "hello"::toUpperCase;
        System.out.println(iu.covert());
    }

    @Test
    public void testConstractorFunction(){
        IUtil3<Person,String> iu = Person::new;
        System.out.println(iu.create("zhangsan"));
    }
}
