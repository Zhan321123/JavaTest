package com.DateStructure4;

public class Test1 {
    public static void main(String[] args) {

        MyTree<String> myTree = new MyTree<>();
        myTree.add("animal",null);
        myTree.add("bird","animal");
        myTree.add("pu ru","animal");
        myTree.add("people","pu ru");
        myTree.add("dog","pu ru");
        myTree.add("cat","pu ru");
        myTree.add("pig","pu ru");
        myTree.add("sheep","pu ru");
        myTree.add("xi que","bird");
        myTree.add("xi","bird");
        myTree.add("que","bird");
        myTree.add("chicken","bird");
        myTree.add("huang huang","dog");
        myTree.add("huang","dog");
        myTree.add("xia bai","dog");

        for (String s:myTree.getBrother("people")){
            System.out.println(s);
        }
        System.out.println("--------------------");
        System.out.println(myTree.getMother("xi"));

        System.out.println("-------------");
        for (String s:myTree.getChildren("animal")){
            System.out.println(s);
        }
        System.out.println("------------------");
        for (String s:myTree.getForeMother("xia bai")){
            System.out.println(s);
        }
        System.out.println("-------------------------");
        for (String s:myTree.getGrandChildren("animal")){
            System.out.println(s);
        }
    }
}
