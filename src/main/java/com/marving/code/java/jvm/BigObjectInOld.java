package com.marving.code.java.jvm;

import java.nio.MappedByteBuffer;

/**
 * Created by mercop on 2017/7/29.
 */

public class BigObjectInOld {

    private static final int _1MB = 1024 * 1024;
    /**
     *
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728 -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4* _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
