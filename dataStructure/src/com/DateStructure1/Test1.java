package com.DateStructure1;

public class Test1 {
    public static void main(String[] args) {

        MyStack myStack = new MyStack<>();
        for (int i=0;i<3;i++) {
            myStack.push("liu");
            myStack.push("gao");
            myStack.push("zhan");
            myStack.push("yan");
        }

        System.out.println(myStack.size);

        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        while (!myStack.isEmpty()){
            System.out.print(myStack.pop()+" ");
        }
        System.out.println();

        System.out.println(myStack.isEmpty());

        System.out.println("------------------------");

        myStack.push("liu");
        myStack.push("gao");
        myStack.push("zhan");
        myStack.push("yan");
        display(myStack);


    }
    static <E> void display(MyStack<E> myStack){
        while(!myStack.isEmpty()){
            System.out.print(myStack.pop()+" \t");
        }
        System.out.println();
    }
}
