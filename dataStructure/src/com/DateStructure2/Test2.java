package com.DateStructure2;

public class Test2 {
    public static void main(String[] args) {

        MyList<String> myList = new DoublyLinkedList<>();
        myList.add("yan");
        myList.add("wei");
        myList.add("hang");
        myList.add("jin");

        System.out.println(myList.size());
        display(myList);

        String s = myList.remove(3);
        System.out.println(s);
        display(myList);

        System.out.println("--------------------------------");

        DoublyLinkedList<String> d = new DoublyLinkedList<>();
        d.addFirst("gao");
        d.add("zhan");
        d.addFirst("liu");
        d.addFirst("lin");
        display(d);

        d.remove(0);
        display(d);

    }
    static <E> void display(MyList<E> myList){
        for (int i=0;i<myList.size();i++){
            System.out.print(myList.get(i)+"  ");
        }
        System.out.println();
    }
}
