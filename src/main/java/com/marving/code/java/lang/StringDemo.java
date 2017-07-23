package com.marving.code.java.lang;


/**
 *  jvm编译时优化原理,jvm有常量池，常量计算在编译时就已经获得结果，如"a"+"b"编译后字节码中只有“ab”常量，
 *  运行时直接赋值,方法中的返回值不能确定，new String(“ab”)新建对象也是运行时决定，也当作变量，final修饰的对象，
 *  引用只能被赋值一次，如果编译时不能确定赋值的内容，也当作变量，变量会在运行时新建对象赋值。
 *
 *  java的基本类型比较，因为编译器的优化原理，编译时，节省常量池空间，编译时能确定的相同常量只用一个引用地址，
 *  所以基本类型和其他常量的比较用==比较引用地址。
 *
 *  intern()是在常量池中用equals()遍历查找值和比较对象相等的引用地址返回，没有就创建一个等值字符串。所以一定会返回相同的引用
 *  String的equals()方法是重写Object的，在object中是直接用“==”的比较的，String的源码，先用==比较地址引用是否相等，
 *  在比较字符串长度，然后逐个字符（charA[i]==charB[i])比较。
 *
 *  String赋值   用“+”不一定比StringBuffer.append()慢，因为常量相加在编译时就计算好结果了，而append()需要在运行时计算。
 */
public class StringDemo {
    static String a = "a";
    static String b = "b";
    final static String c = "a";
    static String d = "a" + "b";
    static String e = a + "b";
    static String f = c + "b";
    static String g = getA() + "b";
    static String h = new String(d);


    //final 变量1
    final static String i;
    static{
        i = "ab";
    }
    //final变量2
    final String j;
    public StringDemo(){
        j ="ab";
    }

    public static String getA() {
        return a;
    }

    public static void main(String[] args) {



        System.out.println(d == e);
        System.out.println(d == f);
        System.out.println(d == g);
        System.out.println(d == h);
        System.out.println(d == g.intern());

        System.out.println(d == i);

        StringDemo stringDemo = new StringDemo();

        System.out.println(d == stringDemo.j);
    }

}
