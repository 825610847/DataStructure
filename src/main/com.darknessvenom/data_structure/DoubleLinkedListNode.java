package com.darknessvenom.data_structure;

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
public class DoubleLinkedListNode<T> {

    public T node;

    public DoubleLinkedListNode<T> previousNode;

    public DoubleLinkedListNode<T> nextNode;

    public DoubleLinkedListNode(T t) {
        this.node = t;
    }

    /**
     * P103 1.3.24
     *
     * @param node
     * @param <T>
     * @return
     */
    public static <T> void removeAfter(DoubleLinkedListNode<T> node) {
        if (node == null || node.nextNode == null) {
            return;
        }

        DoubleLinkedListNode<T> head = node.nextNode;
        DoubleLinkedListNode<T> next = head.nextNode;
        node.nextNode = null;

        //手动GC
        while (head != null) {

            head = null;
            head = next;
            if (next != null) {
                next = next.nextNode;
            }
        }
    }

    /**
     * P103 1.3.25
     *
     * @param node1
     * @param node2
     * @param <T>
     */
    public static <T> void insertAfter(DoubleLinkedListNode<T> node1,
                                       DoubleLinkedListNode<T> node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        DoubleLinkedListNode<T> tail = node1;
        while (tail.nextNode != null) {
            tail = tail.nextNode;
        }

        tail.nextNode = node2;
        node2.previousNode = tail;
    }

    /**
     * 删除节点
     * @param node
     * @param <T>
     * @return
     */
    public static <T>T removeNode(DoubleLinkedListNode<T> node) {
        if(node == null) {
            return null;
        }

        T element = node.node;

        if(!(node.previousNode == null && node.nextNode == null)) {
            if (node.previousNode == null) {
                node = node.nextNode;
                node.previousNode = null;
            }else if(node.nextNode == null) {
                node.previousNode.nextNode = null;
            }else {
                node.previousNode.nextNode = node.nextNode;
                node.nextNode.previousNode = node.previousNode;
            }
        }

        return element;
    }

    public T remove() {
        return removeNode(this);
    }
}
