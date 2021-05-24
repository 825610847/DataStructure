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
public interface Stack<T> extends Iterable<T> {

    /**
     * 进栈
     * @param t
     */
    void push(T t);

    /**
     * 出栈
     */
    T pop();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 栈中的元素数量
     * @return
     */
    int getSize();

    /**
     * 返回栈顶元素（不弹出）
     * @return
     */
    T peek();
}
