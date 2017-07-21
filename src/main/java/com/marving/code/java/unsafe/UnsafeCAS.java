package com.marving.code.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by mercop on 2017/7/21.
 * Unsafe方法调用CAS乐观锁
 */
public class UnsafeCAS {
    private int flag = 100;
    private static long offset;
    private static Unsafe unsafe = null;
    static{
        try{
            unsafe= getUnsafeInstance();
            offset= unsafe.objectFieldOffset(UnsafeCAS.class
                    .getDeclaredField("flag"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int expect = 100;
        //int expect = 108
        //不同时候调用compareAndSwapInt则不更新
        int update = 101;
        UnsafeCAS unsafeTest = new UnsafeCAS();
        System.out.println("unsafeTest对象的flag字段的地址偏移量为："+offset);
        unsafeTest.doSwap(offset,expect, update);
        System.out.println("CAS操作后的flag值为：" +unsafeTest.getFlag());

    }
    //CAS核心方法compareAndSwapInt
    private boolean doSwap(long offset, int expect, int update) {
        return unsafe.compareAndSwapInt(this, offset, expect, update);
    }

    public int getFlag() {
        return flag;
    }

    private static Unsafe getUnsafeInstance() throws Exception{
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return(Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}
