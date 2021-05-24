package com.darknessvenom.data_structure.interfaces;

/**
 * <p>
 * Title: 背包
 * </p>
 * <p>
 * Module: 背包是一种不支持从中删除元素的集合数据类型--它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素
 * 。迭代的顺序不确定且与用例无关。(P76页)
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/13/21
 */
public interface Bag<T> extends Iterable<T>{

    /**
     * 添加一个元素
     * @param t
     */
    void add(T t);

    /**
     * 背包是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 背包中的元素数量
     * @return
     */
    int getSize();
}
