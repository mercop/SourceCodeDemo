package com.marving.code.java.classloader;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mercop on 2017/6/19.
 */
public class ClassLoaderTest {
    @Test
    public void testUserDefineClassLoader() throws Exception {
        UserDefineClassLoader userDefineClassLoader = new UserDefineClassLoader("H:\\lib");
        Class c = userDefineClassLoader.loadClass("com.marving.test.String");
        Object obj = c.newInstance();
        System.out.println(c);
        Method method= c.getMethod("function",null);
        method.invoke(obj,null);
    }

    public static void main(String[] args) {
        //创建自定义classloader对象。
        DiskClassLoader diskLoader = new DiskClassLoader("H:\\lib");
        //加载class文件
        Class c = null;
        try {
            c = diskLoader.loadClass("com.marving.test.HelloWorld");
            System.out.println(diskLoader.toString());
            System.out.println(diskLoader.getParent());
            if(c !=null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("sayHi", null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);

                    Method method1 = c.getDeclaredMethod("sayHello", String.class);
                    method1.invoke(obj,"Guobin");

                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


