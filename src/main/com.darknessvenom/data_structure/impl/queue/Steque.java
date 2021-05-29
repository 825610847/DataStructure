package com.darknessvenom.data_structure.impl.queue;

import com.darknessvenom.data_structure.DoubleLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Queue;
import com.darknessvenom.data_structure.interfaces.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Title: 栈队列
 * </p>
 * <p>
 * Module: P104 1.3.32
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/29/21
 */
public class Steque<T> implements Stack<T>, Queue<T> {
    /**
     * 指向头结点的指针
     */
    private DoubleLinkedListNode<T> head;

    /**
     * 指向尾结点的指针
     */
    private DoubleLinkedListNode<T> tail;

    private int size;

    @Override
    public void enqueue(T t) {
        push(t);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T result = head.node;

        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        } else {
            DoubleLinkedListNode<T> temp = head.nextNode;
            head.nextNode = null;
            head = temp;
            head.previousNode = null;
            size--;
        }

        return result;
    }

    @Override
    public void push(T t) {
        if (isEmpty()) {
            head = new DoubleLinkedListNode<>(t);
            tail = head;
            size = 1;
            return;
        }

        tail.nextNode = new DoubleLinkedListNode<>(t);
        tail = tail.nextNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T result = tail.node;

        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        } else {
            DoubleLinkedListNode<T> temp = tail.previousNode;
            tail.previousNode = null;
            tail = temp;
            tail.nextNode = null;
            size--;
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : tail.node;
    }

    @Override
    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    class StequeIterator implements Iterator<T> {

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
}
