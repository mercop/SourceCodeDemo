package com.marving.code.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mercop on 2017/7/24.
 * 简单日期格式
 */

public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateString = simpleDateFormat.format(date);
        System.out.println(dateString);

        Date date1 = simpleDateFormat.parse(dateString);
        System.out.println(date1);
    }
}
