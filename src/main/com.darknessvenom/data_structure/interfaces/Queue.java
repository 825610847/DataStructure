package com.darknessvenom.data_structure.interfaces;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/13/21
 */
public interface Queue<T> extends Iterable<T> {

    /**
     * 进队
     * @param t
     */
    void enqueue(T t);

    /**
     * 出队
     */
    T dequeue();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列中的元素数量
     * @return
     */
    int getSize();
}
