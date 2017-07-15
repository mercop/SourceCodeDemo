package com.marving.sourcecode.java.lang;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/12.
 */
public class ClassLoaderDemo {

    /*
     * 实验：
     * 1.拷贝类到不同path查看使用的ClassLoader
     * 2.测试双亲委派模型与破坏双亲委派
     */


    @Test
    public void testClassPath(){
        System.out.println("Bootstrap Class loader");
        String[] paths = System.getProperty("sun.boot.class.path").split(";");
        for(String str : paths)
            System.out.println(str);

        System.out.println();
        String[] extpaths = System.getProperty("java.ext.dirs").split(";");
        for(String str : extpaths)
            System.out.println(str);

        System.out.println();
        String[] appPaths = System.getProperty("java.class.path").split(";");
        for(String str: appPaths)
            System.out.println(str);
    }

    @Test
    public void testClassLoader(){
        ClassLoader loader = Test.class.getClassLoader();
        while (loader!=null){
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
