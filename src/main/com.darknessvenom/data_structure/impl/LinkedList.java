package com.darknessvenom.data_structure.impl;

import com.darknessvenom.data_structure.DoubleLinkedListNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Title: 普通双链表
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/23/21
 */
public class LinkedList<T> implements Iterable<T> {

    private DoubleLinkedListNode<T> head;

    private DoubleLinkedListNode<T> tail;

    private int size;

    public DoubleLinkedListNode<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void add(T t) {
        if (isEmpty()) {
            head = new DoubleLinkedListNode<>(t);
            tail = head;
        } else {
            DoubleLinkedListNode<T> temp = tail;
            tail.nextNode = new DoubleLinkedListNode<>(t);
            tail = tail.nextNode;
            tail.previousNode = temp;
        }

        size++;
    }


    /**
     * 删除第k个元素
     *
     * @param k 第k个元素
     * @return
     */
    public T delete(int k) {
        if (k <= 0 || isEmpty() || k > size) {
            return null;
        }

        DoubleLinkedListNode<T> temp = head;

        for (int i = 1; i < k; i++) {
            temp = temp.nextNode;
        }

        return temp.remove();

    }

    public T deleteHead() {
        return delete(1);
    }

    public T deleteTail() {
        return delete(size);
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<T> {

        DoubleLinkedListNode<T> temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T node = temp.node;
                temp = temp.nextNode;
                return node;
            }
            throw new NoSuchElementException("only " + size + " elements");
        }
    }

    /**
     * P103 1.3.21
     *
     * @param list
     * @param key
     * @param <T>
     * @return
     */
    public static <T> boolean find(LinkedList<T> list, T key) {
        if (list == null || list.isEmpty()) {
            return false;
        }

        for (T item : list) {
            if (item == null) {
                return key == null;
            } else if (item.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * P103 1.3.26
     *
     * @param list
     * @param key
     * @param <T>
     * @return
     */
    public static <T> int remove(LinkedList<T> list, T key) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        DoubleLinkedListNode<T> temp = list.head;
        int deletedElements = 0;

        while (temp != null) {
            if (isEqual(temp.node, key)) {
                temp.remove();
                deletedElements++;
            }

            temp = temp.nextNode;
        }

        list.setSize(list.getSize() - deletedElements);

        return deletedElements;
    }

    public static <T> String display(LinkedList<T> list) {
        StringBuilder builder = new StringBuilder();
        for (T t : list) {
            builder.append(t).append(" -> ");
        }

        builder.append("Ø");
        return builder.toString();

    }

    @Override
    public String toString() {
        return display(this);
    }

    private static boolean isEqual(Object obj1, Object obj2) {

        if (obj2 == null) {
            return obj1 == null;
        } else {
            return obj2.equals(obj1);
        }
    }

    /**
     * P103 1.3.27
     *
     * @param list
     * @return
     */
    public static int max(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        DoubleLinkedListNode<Integer> temp = list.getHead();
        int max = 0;

        while (temp != null) {
            int nodeNum = temp.node == null ? 0 : temp.node;
            max = max > nodeNum ? max : nodeNum;
            temp = temp.nextNode;
        }

        return max;
    }

    /**
     * P103 1.3.28
     *
     * @param node
     * @param max
     * @return
     */
    public static int maxRecursion(DoubleLinkedListNode<Integer> node, int max) {
        if (node == null) {
            return max;
        }
        int nodeNum = node.node == null ? 0 : node.node;
        max = max > nodeNum ? max : nodeNum;
        return maxRecursion(node.nextNode, max);
    }

}
