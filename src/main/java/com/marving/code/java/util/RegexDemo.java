package com.marving.code.java.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mercop on 2017/7/25.
 */

public class RegexDemo {

    public static void main(String[] args) {

        //单个匹配
        System.out.println("a".matches("a"));
        System.out.println("\\".matches("\\\\"));

        //描述范围
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[^abc]"));
        System.out.println("A".matches("[a-zA-Z]"));
        System.out.println();

        //简化表达式
        System.out.println("a".matches("."));   //匹配字符
        System.out.println("9".matches("\\d")); //匹配任意一位数字
        System.out.println("9".matches("\\D")); //匹配任意非数字
        System.out.println(" ".matches("\\s")); //匹配空格,\t,\n
        System.out.println(" ".matches("\\S")); //匹配不是空格,\t,\n
        System.out.println("_".matches("\\w")); //匹配字母数字下划线
        System.out.println();

        //数量表达
        System.out.println("a".matches("\\w?"));        //一次或零次
        System.out.println("aaa".matches("\\w+"));      //一次或多次
        System.out.println("aaa".matches("\\w*"));      //0,1,多
        System.out.println("aaa".matches("\\w{3}"));    //n次
        System.out.println("aaaa".matches("\\w{3,}"));  //n次，或以上
        System.out.println("aaaa".matches("\\w{3,4}"));  //n次-m次

        //逻辑匹配
    }


    @Test
    public void testStringReplace(){
        //取出字母
        String str = "asd234914jksajfd@(#*(*(@#*!(@#!jkJSDKFASJDLKASJDALDLKASDA";
        String regex = "[^a-zA-Z]";
        System.out.println(str.replaceAll(regex,""));
    }

    @Test
    public void testStringSplit(){
        //根据数字拆分
        String str = "a1s2f3g4nh5nb6mjk76n7n6nm6n6k87n8k";
        String[] result = str.split("\\d+");
        for(String str1 : result)
            System.out.print(str1 + " ");
    }

    @Test
    public void testNum(){
        //数字匹配
        String str = "121313.2323";
        String regex = "\\d+(\\.\\d+)?";//整数或小数
        if(str.matches(regex)){
            double data = Double.parseDouble(str);
            System.out.println(data);
        }
    }

    @Test
    public void testDate() throws ParseException {
        String str = "2018-10-20 23:34:21";
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        String regex2 = "\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}";

        if(str.matches(regex)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(str);
            System.out.println(date);
        } else if(str.matches(regex2)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:SSS");
            Date date = simpleDateFormat.parse(str);
            System.out.println(date);
        }
    }


    @Test
    public void testTel(){
        //String str = "2836670";       //regex = \d{7,8}
        //String str = "0282836670";    //regex = (\d{3,4})?\d{7,8}
        String str = "(028)-2836670";   //regex = ((\(\d{3,4}\))-)?(\d{3,4})?\d{7,8}
        String regex = "((\\(\\d{3,4}\\))-\\d{7,8})|(\\d{3,4})?\\d{7,8}";
        if(str.matches(regex)){
            System.out.println("电话号码匹配成功：" + str);
        }
    }

    @Test
    public void testEmail(){
        String str = "mer@live.com";    //simple regex = \w+@\w+\.\w+
        String regex = "\\w+@\\w+\\.\\w+";
        if(str.matches(regex)){
            System.out.println("邮箱地址匹配成功：" + str);
        }

        //email 用户名必须由字母开头，长度6-15，域名后缀：.com .net .cn .org

        String str2 = "merop-ab1.asd@live.com";

        String regex2 = "[a-zA-Z][0-9a-zA-Z_\\-.]{5,14}@[0-9a-zA-Z_\\-.]+\\.com|cn|org|net";
        if(str2.matches(regex2)){
            System.out.println("邮箱地址匹配成功：" + str2);
        }
    }


    @Test
    public void testPattern(){

        String str ="a|b|c";
        String regex = "\\|";
        Pattern pattern = Pattern.compile(regex);
        String[] result = pattern.split(str);
        for(String str1 : result)
            System.out.print(str1 + " ");

        String regex2 = "(\\w\\|){2}.";
        boolean isMached = Pattern.compile(regex2).matcher(str).matches();
        System.out.println(isMached);

        String regex3 = "\\|";
        String end = Pattern.compile(regex3).matcher(str).replaceAll(":");
        System.out.println(end);
    }

    @Test
    //Pattern 的使用场景
    public void testSplitMybatisSql(){
        String str = "INSERT INTO member(id,name,age) VALUES (#{member.id},#{member.name},#{member.age})";
        String regex = "#\\{[a-zA-Z0-9_.]+\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
