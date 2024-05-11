package com.reflection1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用反射突破泛型限制
 * 比如在List<String>里添加int和Object类型
 * 方法如下：
 * 对象.getClass（）.getMethod（方法名，其他类型）.invoke（对象，值）
 * List<String> list = new List<String>()
 * list.getClass().getMethod("add",Object.class).invoke(list,true)
 */
public class Test8 {
    public static void main(String[] args) throws Exception{

        List<String> list = new ArrayList<>();
        list.add("liu");
        list.add("gao");
        list.add("zhan");
        //原本不能添加
//        list.add(18);
//        list.add(new Dog());

        Class<?> aClass = list.getClass();
        //Class.getMethod（""，其他类型），就能突破泛型擦除限制
        Method method = aClass.getDeclaredMethod("add",Object.class);
        method.invoke(list,18);
        method.invoke(list,new Dog());

        System.out.println(list);


    }
}
