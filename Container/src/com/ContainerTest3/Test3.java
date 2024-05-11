package com.ContainerTest3;

import java.util.Stack;

/**
 * 利用栈容器做一个小方法
 * 检测一个字符串括号的正误
 */
public class Test3 {

    public static void main(String[] args) {

        //这里检测一下Test1的括号规范性
        String s = "public class Test1 {\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        List<String> v = new Vector<>();\n" +
                "        v.add(\"123\");\n" +
                "        v.add(\"234\");\n" +
                "        v.add(\"345\");\n" +
                "\n" +
                "        for (String s:v){\n" +
                "            System.out.print(s+\"\\t\");\n" +
                "        }\n" +
                "        System.out.println();\n" +
                "        System.out.println(v);\n" +
                "\n" +
                "        ArrayList<String> a = new ArrayList<>();\n" +
                "        a.add(\"qwe\");\n" +
                "        System.out.println(a);\n" +
                "\n" +
                "        Vector<Integer> i = new Vector<>();\n" +
                "        i.add(1232);\n" +
                "        System.out.println(i);\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "}\n";

        boolean b = symmetry(s);
        System.out.println(b);
    }


    //利用Stack从最顶上取出元素的性质，来检测一个String的括号的对称性，即括号的规范性
    public static boolean symmetry(String s){
        Stack<Character> st = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='{'){
                st.push('}');
            }
            if (c=='['){
                st.push(']');
            }
            if (c=='('){
                st.push(')');
            }
            if (c=='}'||c==']'||c==')'){
                if (st.empty()){
                    return false;
                }
                if (c!=st.pop()){
                    return false;
                }
            }
        }
        return st.empty();
    }
}
