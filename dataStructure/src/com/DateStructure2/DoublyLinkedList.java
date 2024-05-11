package com.DateStructure2;

public class DoublyLinkedList <E> implements MyList<E> {
    public int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E element) {
        addLast(element);
    }
    public void addLast(E element){
        Node<E> tail = this.tail;
        Node<E> node = new Node<>(tail, element, null);
        this.tail=node;
        if (this.head==null){
            this.head = node;
        }else {
            tail.next = node;
        }
        this.size++;
    }
    public void addFirst(E element){
        Node<E> head = this.head;
        Node<E> node = new Node<>(null, element, head);
        this.head = node;
        if (this.tail==null){
            this.tail = node;
        }else {
            head.previous = node;
        }
        this.size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }
    private void checkIndex(int index){
        if (index<0 || index>=this.size){
            throw new IndexOutOfBoundsException("index"+index+" Size: "+this.size);
        }
    }
    private Node<E> getNode(int index){
        Node<E> node;
        if (index*2<this.size){
            node = this.head;
            for (int i=0;i<index;i++){
                node = node.next;
            }
        }else {
            node = this.tail;
            for (int i=this.size-1;i>index;i--){
                node = node.previous;
            }
        }
        return node;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E remove(int index) {
        this.checkIndex(index);
        Node<E> node = this.getNode(index);
        if (node.previous==null){
            this.head = node.next;
        }else {
            node.previous.next = node.next;
        }
        if (node.next==null){
            this.tail = node.previous;
        }else {
            node.next.previous = node.previous;
        }
        this.size--;
        return node.item;
    }
    static class Node<E>{
        Node<E> previous;
        E item;
        Node<E> next;

        public Node(Node<E> previous,E item,  Node<E> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }
}
