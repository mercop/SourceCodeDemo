package com.marving.code.java.lang;

import java.util.Arrays;

/**
 * Created by mercop on 2017/7/24.
 * System 类示例
 */

public class SystemDemo {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int[] result = new int[10];
        System.arraycopy(nums,0,result,0,7);
        System.out.println(Arrays.toString(result));

        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);

        Course course = new Course();
        course = null;
        System.gc();
    }
}

class Course{

    @Override
    protected void finalize() throws Throwable {
        System.out.println("this course is over");

        //抛出异常不会影响程序执行
        throw new Exception("no");
    }
}
