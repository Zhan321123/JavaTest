package com.DateStructure1;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 自定义栈容器
 */
public class MyStack<E> {

    public int size = 0;//容量大小
    private Object[] arr;
    private int StackLength = 10;//数组大小
    private int index = -1;//索引


    public boolean isEmpty() {
        //判断数组是否为空
        return size==0;
    }

    public E pop() {
        //抛出异常
        if (this.index == -1) {
            throw new EmptyStackException();
        }
        //记录变化
        size--;
        //返回内容
        return (E) arr[index--];
    }

    private void capacity(){
        //创建数组
        if (arr==null){
            arr = new Object[StackLength];
        }
        //数组扩容,达到80%容量，就1.2倍扩容
        if (StackLength*0.8 > size){
            StackLength = (int)(StackLength*1.2);
            arr = Arrays.copyOf(arr,StackLength);
        }
    }


    public E push(E item) {
        //创建数组
        this.capacity();
        //存放内容
        arr[++index] = item;
        //记录容器变化
        this.size++;
        //返回添加值
        return item;
    }

}
