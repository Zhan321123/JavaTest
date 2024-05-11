package com.Annotation2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解可以被读取在Class等类里面
 * getAnnotations（），获取类对象上面的注解，返回Annotation[]
 * getAnnotation（注解.class），获取类对象上某个特定注解，返回该注解Annotation
 * 注解.变量，因为注解的变量默认都是public，所以可以直接获取
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Test1.class;
        //getAnnotations（），获取类对象上面的注解，返回Annotation[]
        //getAnnotation（注解.class），获取类对象上某个特定注解，返回该注解
        Annotation[] annotations = aClass.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
            System.out.println(/*((MyAnnotation4) a).name()*/);
        }

        Field field = aClass.getDeclaredField("name");
        MyAnnotation3 annotation = field.getAnnotation(MyAnnotation3.class);
        System.out.println(annotation);
        System.out.print(annotation.column()+"\t");
        System.out.print(annotation.space()+"\t");
        System.out.print(annotation.type()+"\t");
        System.out.println(annotation.precision());
        System.out.println("-----------------------");

        //获取每个成员变量的注解及其注解上的数据
        Field[] fields = aClass.getDeclaredFields();
        for (Field f:fields){
            Annotation[] an = f.getAnnotations();
            for (Annotation a:an){
                System.out.println(a);
                if (a instanceof MyAnnotation3){
                    MyAnnotation3 ma = (MyAnnotation3) a;
                    System.out.println(ma.column()+"\t"+ma.type()+"\t"+ma.space()+"\t"+ma.precision());
                }
            }
        }
        System.out.println("-------------------------");
    }
}
