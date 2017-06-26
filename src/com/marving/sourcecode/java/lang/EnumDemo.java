package com.marving.sourcecode.java.lang;

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
}
enum Color {Red,Green,Blank}


