package com.marving.code.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by mercop on 17-6-29.
 */
public class UnsafeTest {

    public static void main(String[] arg) throws Exception {

        //通过反射实例化Unsafe
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        //只要内存够大，可以把这个调大，大于Integer.MAX_VALUE
        long size = (long) Integer.MAX_VALUE / 2;
        long addr = unsafe.allocateMemory(size);
        System.out.println("unsafe address :" + addr);

        for (int i = 0; i < size; i++) {
            unsafe.putByte(addr + i, (byte) 6);
            if (unsafe.getByte(addr + i) != 6) {
                System.out.println("failed at offset");
            }
        }
    }


    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}
