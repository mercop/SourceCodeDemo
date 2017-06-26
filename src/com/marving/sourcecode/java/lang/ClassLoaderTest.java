package com.marving.sourcecode.java.lang;

import sun.reflect.MethodAccessor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mercop on 2017/6/19.
 */
public class ClassLoaderTest {


    public static void main(String[] args) {
        //创建自定义classloader对象。
        DiskClassLoader diskLoader = new DiskClassLoader("H:\\lib");
        //加载class文件
        Class c = null;
        try {
            c = diskLoader.loadClass("com.marving.test.HelloWorld");
            System.out.println(diskLoader.toString());
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

class DiskClassLoader extends ClassLoader {

    private String mLibPath;

    public DiskClassLoader(String path) {
        // TODO Auto-generated constructor stub
        mLibPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);

        File file = new File(mLibPath, fileName);

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
            return name.substring(index) + ".class";
        }
    }

}
