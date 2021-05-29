package com.darknessvenom.data_structure.impl;

import com.darknessvenom.data_structure.SinglyLinkedListNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Title: 单链表
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/29/21
 */
public class SinglyLinkedList<T> implements Iterable<T>{

    SinglyLinkedListNode<T> head;

    SinglyLinkedListNode<T> tail;

    private int size;

    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T t) {
        if(isEmpty()) {
            head = new SinglyLinkedListNode<>(t);
            tail = head;
            size = 1;
            return;
        }

        tail.nextNode = new SinglyLinkedListNode<>(t);
        tail = tail.nextNode;
        size++;
    }

    public static <T> String display(SinglyLinkedList<T> list) {
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

    @Override
    public Iterator<T> iterator() {
        return new SinglyListIterator();
    }

    class SinglyListIterator implements Iterator<T> {

        SinglyLinkedListNode<T> temp = head;

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
}
