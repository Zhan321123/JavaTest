package com.DateStructure3;

public class Sort <E extends Integer>{

    private Node<E> root;

    public void add(E element){
        Node<E> node = new Node<>(element);
        if (this.root == null){
            this.root = node;
        }else {
            this.root.addNode(node);
        }
    }

    public void sort(){
        if (this.root != null){
            this.root.inorder();
        }
    }

    private class Node<E extends Integer> {
        private E item;
        private Node<E> left;
        private Node<E> right;

        public Node(E item, Node<E> left, Node<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public Node(E item) {
            this.item = item;
        }

        public void addNode(Node<E> node){
            if (node.item.intValue() > this.item.intValue()){
                if (this.left == null) {
                    this.left = node;
                }else {
                    this.left.addNode(node);
                }
            }else {
                if (this.right == null) {
                    this.right = node;
                }else {
                    this.right.addNode(node);
                }
            }
        }

        public void inorder(){
            if (this.left != null){
                this.left.inorder();
            }
            System.out.println(this.item);
            if (this.right != null){
                this.right.inorder();
            }

        }
    }

}
