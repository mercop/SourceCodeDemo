package com.marving.code.java.unsafe;

import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * Created by mercop on 17-6-29.
 */
public class UnsafeByteBuffer {

    public static Unsafe UNSAFE;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            UNSAFE = (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000);
        byte b = 1;
        byteBuffer.put(b);
        byteBuffer.put(b);
        long address = ((DirectBuffer)byteBuffer).address();
        System.out.println(address);
        byte result = getByte(address, 0);
        System.out.println(result);

    }

    public static byte getByte(long addr, int pos){
        return UNSAFE.getByte(addr+pos);
    }

}
