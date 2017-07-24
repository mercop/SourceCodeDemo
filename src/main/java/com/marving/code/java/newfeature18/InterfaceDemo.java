package com.marving.code.java.newfeature18;

import java.awt.image.ImageConsumer;

/**
 * Created by mercop on 2017/7/24.
 * JDK 1.8 接口定义加强
 */

interface  IMessage{

    //接口默认方法
    public default void defaultprint(){
        System.out.println("default print function ");
    }


    //接口静态方法
    public static void staticprint(){
        System.out.println("static print function");
    }

    public void print();
}


class MessageImpl  implements IMessage{

    @Override
    public void print() {
        System.out.println("print function");
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {
        IMessage message = new MessageImpl();
        message.defaultprint();
        message.print();
        IMessage.staticprint();
    }

}
