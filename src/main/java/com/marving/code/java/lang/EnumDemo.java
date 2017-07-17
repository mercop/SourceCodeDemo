package com.marving.code.java.lang;

import org.junit.Test;

/**
 * Created by mercop on 2017/6/19.
 */
public class EnumDemo {

    @Test
    public void TestLangEnumClass(){

    }

    @Test
    public void TestEnumType() {
        System.out.println(Color.Red.ordinal());
        System.out.println(Color.Green.name());
    }


    @Test
    public void TestEnumInit(){
        System.out.println(Person.ZhangSan);
        //Enum从0开始枚举，通过ordinal方法获取值
        System.out.println(Person.ZhangSan.ordinal());
    }
}
enum Color {Red,Green,Blank}

enum Person{
    ZhangSan,LiSi,WangWu;

    //构造函数，枚举类型只能为私有
    Person(){
        System.out.println(this + " init");
    }

    @Override
    public String toString() {
        return this.name();
    }
}


