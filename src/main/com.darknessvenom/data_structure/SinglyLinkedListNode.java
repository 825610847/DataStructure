package com.darknessvenom.data_structure;

/**
 * <p>
 * Title: 单链节点
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/13/21
 */
public class SinglyLinkedListNode<T> {

    public T node;

    public SinglyLinkedListNode<T> nextNode;

    public SinglyLinkedListNode(T t) {
        this.node = t;
    }
}
