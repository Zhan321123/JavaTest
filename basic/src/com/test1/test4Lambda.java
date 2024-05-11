package com.test1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试Lambda表达式
 */
public class test4Lambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("h","d","c","a");
        {
            //常规遍历
            for (String s : list) {
                System.out.print(s);
            }
            //lambda1遍历
            list.forEach(s -> {
                System.out.print(s);
            });
            //lambda2遍历
            list.forEach(System.out::print);
        }

        System.out.println("-----------------");

        {
            //常规排序
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            //lambda1
            Collections.sort(list, (o1, o2) -> {
                return o1.compareTo(o2);
            });
            //lambda2
            Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
            //lambda3
            Collections.sort(list, String::compareTo);

            //常规
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s2) {
                    return s.compareTo(s2);
                }
            });
            //lambda1
            list.sort((String s, String s2) -> {
                return s.compareTo(s2);
            });
            //lambda2
            list.sort((s, s2) -> {
                return s.compareTo(s2);
            });
            //lambda3
            list.sort((s, s2) -> s.compareTo(s2));
            //lambda4
            list.sort(String::compareTo);
            //快捷比较器
            list.sort(Comparator.naturalOrder());
        }
    }
}
