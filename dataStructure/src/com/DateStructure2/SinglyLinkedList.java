package com.DateStructure2;

public class SinglyLinkedList<E> implements MyList<E>{

    public int size;//元素个数
    private Node<E> head;//头节点

    //增加元素
    @Override
    public void add(E element) {
        //创建节点
        Node<E> node = new Node<>(element,null);
        //寻找尾节点
        Node<E> tail = getTail();
        //节点挂接
        if (tail==null){
            this.head = node;
        }else {
            tail.next = node;
        }
        //记录元素增加
        this.size++;
    }
    //寻找尾节点
    private Node<E> getTail(){
        if (this.head==null){
            return null;
        }
        //创建一个新的光标,让他指向尾节点
        Node<E> node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    //获取元素
    @Override
    public E get(int index) {
        //校验index
        this.checkIndex(index);
        //寻找节点
        Node<E> node = getNode(index);
        //节点元素返回
        return node.item;
    }
    //校验index的合法性
    private void checkIndex(int index){
        if (index<0 || index>=this.size){
            throw new IndexOutOfBoundsException("size: "+size);
        }
    }
    //寻找index指向的节点
    private Node getNode(int index){
        //创建一个新的节点，让他指向index
        Node<E> node = this.head;
        for (int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    //获取容器元素个数
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E remove(int index) {
        //校验index
        this.checkIndex(index);
        //根据index寻找节点
        Node<E> node = this.getNode(index);
        //获取节点元素对象
        E item = node.item;
        //删除该节点
        if (this.head == node){
            this.head = node.next;
        }else {
            Node<E> temp = this.getNode(index-1);
            temp.next = node.next;
        }
        node.next = null;
        //记录元素个数
        this.size--;
        //返回节点对象
        return item;
    }

    //内部类Node，节点，保存 自己节点的元素 和 下一个节点
    class Node<E>{
        private E item;
        private Node next;
        Node(E item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}
