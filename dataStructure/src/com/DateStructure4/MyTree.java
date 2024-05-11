package com.DateStructure4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义树形容器结构
 * @param <E>
 */

public class MyTree <E>{

    private Map<E,E> map1 = new HashMap<>();
    private Map<E,List<E>> map2 = new HashMap<>();

    /**
     * 向容器中添加元素
     * @param element
     * @param mother
     */
    public void add(E element,E mother){
        map1.put(element,mother);
        List<E> list = this.map2.get(mother);
        if (list == null){
            list = new ArrayList<>();
            this.map2.put(mother,list);
        }
        list.add(element);
    }

    /**
     * 获取元素的母节点
     * @param element
     * @return
     */
    public E getMother(E element){
        return this.map1.get(element);
    }

    /**
     * 获取元素的子节点
     * @param element
     * @return
     */
    public List<E> getChildren(E element){
        return this.map2.get(element);
    }

    /**
     * 获取元素的兄弟节点
     * @param element
     * @return
     */
    public List<E> getBrother(E element) {
        E e = this.map1.get(element);
        List<E> list = this.map2.get(e);
        List<E> brother = null;
        if (list != null) {
            brother = new ArrayList<>(list);
            brother.remove(element);
        }
        return brother;
    }

    /**
     * 获取元素的母节点
     * @param element
     * @return
     */
    public List<E> getForeMother(E element){
        E mother = getMother(element);
        if (mother == null){
            return new ArrayList<>();
        }
        List<E> list = this.getForeMother(mother);
        list.add(mother);
        return list;
    }

    /**
     * 获取元素的子孙节点
     * @param element
     * @return
     */
    public List<E> getGrandChildren(E element) {
        List<E> children = getChildren(element);
        if (children == null) {
            return new ArrayList<>();
        }
        List<E> l = new ArrayList<>();
        for (E e : children) {
            List<E> list = this.getGrandChildren(e);
            l.addAll(list);
            l.add(e);
        }
        return l;
    }

}
