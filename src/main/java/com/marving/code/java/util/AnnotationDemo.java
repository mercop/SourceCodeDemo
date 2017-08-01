package com.marving.code.java.util;

import java.lang.annotation.*;

/**
 * Created by mercop on 2017/7/31.
 */

public class AnnotationDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        Annotation annotations[] = Person.class.getAnnotations();
        for(Annotation annotation: annotations)
            System.out.println(annotation.toString());

        System.out.println("========================");
        annotations = Person.class.getDeclaredMethod("method1").getAnnotations();

        for(Annotation annotation: annotations)
            System.out.println(annotation.toString());
    }
}


//自定义Annotation
@MyAnnotation(name = "lili")
class Person{
    private String name;
    @Deprecated
    public void method1(){
        System.out.println("method1");
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

    public String name() default "123";

    public String age() default "123";
}
