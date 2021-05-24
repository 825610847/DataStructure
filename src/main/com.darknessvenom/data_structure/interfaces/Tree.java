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
 * @date: 4/14/21
 */
public interface Tree<T> extends Iterable<T> {

    /**
     * 返回存放于当前节点处的对象
     * @return
     */
    T getElement();

    /**
     * 将对象 t 存入当前节点，并返回其中此前所存的内容
     * @param t
     * @return
     */
    T setElement(T t);

    /**
     * 返回当前节点的父节点
     * @return
     */
    T getParent();

    /**
     * 返回当前节点的长子
     * @return
     */
    T getFirstChild();

    /**
     * 返回当前节点的最大弟弟
     * @return
     */
    T getNextSibling();

    /**
     * 返回当前节点后代元素的数目，即以当前节点为根的子树的规模
     *
     * @return int
     */
    int getSize();
    /**
     * 返回当前节点的高度
     *
     * @return int
     */
    int getHeight();
    /**
     * 返回当前节点的深度
     *
     * @return int
     */
    int getDepth();

    /**
     * 树是否为空
     */
    boolean isEmpty();
}
