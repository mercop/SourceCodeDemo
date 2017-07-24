package com.marving.code.java.lang;

import org.junit.Test;

/**
 * Created by mercop on 2017/6/19.
 * 枚举实例，枚举就是多例设计模式
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


    @Test
    public void TestEnumSwitch(){
        Color color = Color.Blank;
        switch (color){
            //Wrong :Color.Blank
            case Blank:
                System.out.println("blank-");
                break;
            case Red:
                System.out.println("red-");
                break;
            case Green:
                System.out.println("green-");
                break;
        }
    }
}
enum Color {Red,Green,Blank}

enum Person{

    ZhangSan,LiSi,WangWu;
    //可以创建属性，需要放在枚举变量后面
    public String title;

    //无参构造函数，枚举类型只能为私有
    Person(){
        System.out.println(this + " init");
    }
    @Override
    public String toString() {
        return this.name();
    }
}


enum Person2{

    ZhangSan("1"),LiSi("2"),WangWu("2");
    //可以创建属性，需要放在枚举变量后面
    public String title;

    //有参构造函数，枚举类型只能为私有
    Person2(String name){
        this.title = name;
    }
    @Override
    public String toString() {
        return this.name();
    }
}

//枚举实现接口
enum Person3 implements IColor{

    ZhangSan("1"),LiSi("2"),WangWu("2");
    //可以创建属性，需要放在枚举变量后面
    public String title;

    //有参构造函数，枚举类型只能为私有
    Person3(String name){
        this.title = name;
    }
    @Override
    public String toString() {
        return this.name();
    }

    @Override
    public String getColor(){
        return title;
    }

}

interface IColor{
    String getColor();
}


