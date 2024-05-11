package com.DateStructure2;

public class Test1 {
    public static void main(String[] args) {

        MyList<String> myList = new SinglyLinkedList<>();
        myList.add("liu");
        myList.add("gao");
        myList.add("zhan");
        myList.add("wei");

        System.out.println(myList.get(1));
        System.out.println(myList.size());
        System.out.println(myList.remove(0));
        System.out.println(myList.size());

        for (int i =0;i<myList.size();i++){
            System.out.print(myList.get(i)+"  ");
        }
        System.out.println();


    }
}
