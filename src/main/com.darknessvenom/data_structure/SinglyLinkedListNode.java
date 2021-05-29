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

    /**
     * P103 1.3.30
     * 单链表指针反转
     * @param node
     * @return
     */
    public static <T>SinglyLinkedListNode<T> reverse(SinglyLinkedListNode<T> node) {
        if(node == null) {
            return null;
        }

        SinglyLinkedListNode<T> first = node;

        SinglyLinkedListNode<T> reverse = null;

        while (first != null) {
            SinglyLinkedListNode<T> second = first.nextNode;
            first.nextNode = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }
}
