package com.reflection1;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class反射对泛型的测试使用
 * 获取泛型方法的泛型参数和泛型结果
 * Method.getParameterTypes（），获取参数类型组，不带有泛型，返回 Class<?>[]
 * Method.getGenericParameterTypes（），获取带有泛型的参数类型组，返回 Type[]
 * Method.getReturnType（），获取方法的结果参数类型，不包含泛型，返回 Class<?>
 * Method.getGenericReturnType（），获取带有泛型的结果参数类型 ，返回 Type
 *
 * 也获取泛型中的参数，即获取<T>中的T
 * Type instanceof ParameterizedType，检测参数类型Type是否是参数化类型
 * 是就强转为ParameterizedType
 * ParameterizedType.getActualTypeArguments（），获取泛型的的泛型类型，返回Type[]
 *
 * 获取数组的元素类型
 * Class.getComponentType()，返回一个数组元素的类型，返回Class<?>
 */
public class Test7 {

    //泛型方法，有泛型参数的方法
    private <T, V> void method1(List<T> list, Map<Integer, V> map, String name) {
        for (T t : list) {
            System.out.println(t);
        }
        Set<Integer> set = map.keySet();
        for (int k : set) {
            System.out.println(map.get(k));
        }
        System.out.println(name);
    }

    //返回结果有泛型的泛型方法
    private <K> Map<K, String> method2() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.reflection1.Test7");

        Method method = aClass.getDeclaredMethod("method1", List.class, Map.class, String.class);
        method.setAccessible(true);
        //Method.getParameterTypes（），获取参数类型组，不带有泛型
        Class<?>[] types1 = method.getParameterTypes();
        out(types1);
        //Method.getGenericParameterTypes（），获取带有泛型的参数类型组
        Type[] types2 = method.getGenericParameterTypes();
        out(types2);

        //获取泛型<T>中的T
        for (Type t : types2) {
            System.out.println(t);
            //Type instanceof ParameterizedType，检测参数类型Type是否是参数化类型
            if (t instanceof ParameterizedType) {
                //是就强转为ParameterizedType
                //ParameterizedType.getActualTypeArguments（），获取泛型的的泛型类型
                Type[] types3 = ((ParameterizedType) t).getActualTypeArguments();
                for (Type t2 : types3) {
                    System.out.println("\t" + t2);
                }
            }
        }
        System.out.println("================");

        Method method2 = aClass.getDeclaredMethod("method2");
        method2.setAccessible(true);

        //Method.getReturnType（），获取方法的结果参数类型，不包含泛型
        Class<?> type1 = method2.getReturnType();
        System.out.println(type1);
        System.out.println("------------------------");

        //Method.getGenericReturnType（），获取带有泛型的结果参数类型
        Type type2 = method2.getGenericReturnType();
        System.out.println(type2);
        //如果是泛型，就强转为ParameterizedType.getActualTypeArguments（）
        Type[] types4 = ((ParameterizedType) type2).getActualTypeArguments();
        for (Type t:types4){
            System.out.println("\t"+t);
        }
        System.out.println("------------------------");

        int[] is = new int[10];
        Class<?> aClass1 = is.getClass();
        System.out.println(aClass1);
        //Class.getComponentType()，返回一个数组元素的类型
        Class<?> aClass2 = aClass1.getComponentType();
        System.out.println(aClass2);

    }
    private static void out(Type[] classes){
        for (Type t:classes){
            System.out.println(t);
        }
        System.out.println("------------------------");
    }
}
