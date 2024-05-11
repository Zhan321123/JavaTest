package com.DateStructure2;

/**
 * 基于链表的自定义API
 * @param <E>
 */
public interface MyList<E> {
    void add(E element);
    E get(int index);
    int size();
    E remove(int index);
}
