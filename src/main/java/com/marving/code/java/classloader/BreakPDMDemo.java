package com.marving.code.java.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by mercop on 2017/8/1.
 * 打破双亲委派实现加载自定义String 类
 */

public class BreakPDMDemo {

    public static void main(String[] args) throws Exception {
        StringClassLoader stringClassLoader = new StringClassLoader();
        Class c = stringClassLoader.loadClass("com.marving.demo.String");
        Object obj = c.newInstance();
        Method method= c.getMethod("getString",null);
        method.invoke(obj,null);

        Constructor constructor = c.getConstructor(String.class);

        Object obj2 = constructor.newInstance("user define");
        method.invoke(obj2,null);
    }
}
class StringClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(name);
        return clazz;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);

        File file = new File("H:\\lib", fileName);

        try {
            FileInputStream is = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = is.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data = bos.toByteArray();
            is.close();
            bos.close();

            return defineClass(name, data, 0, data.length);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        } else {
            return name.substring(index + 1) + ".class";
        }
    }
}
