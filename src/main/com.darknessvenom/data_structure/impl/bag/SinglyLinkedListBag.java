package com.darknessvenom.data_structure.impl.bag;

import com.darknessvenom.data_structure.SinglyLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Bag;

import java.util.Iterator;

/**
 * <p>
 * Title: 单链表背包
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/13/21
 */
public class SinglyLinkedListBag<T> implements Bag<T> {

    /**
     * 指向头结点的指针
     */
    private SinglyLinkedListNode<T> head;

    /**
     * 指向尾结点的指针
     */
    private SinglyLinkedListNode<T> tail;

    private int size;

    @Override
    public void add(T t) {

        if(isEmpty()) {
            head = new SinglyLinkedListNode<>(t);
            tail = head;
        } else {
            tail.nextNode = new SinglyLinkedListNode<>(t);
            tail = tail.nextNode;
        }

        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    class SinglyLinkedListBagIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

}
