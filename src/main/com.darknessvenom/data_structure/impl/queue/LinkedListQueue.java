package com.darknessvenom.data_structure.impl.queue;

import com.darknessvenom.data_structure.DoubleLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Queue;

import java.util.Iterator;

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
public class LinkedListQueue<T> implements Queue<T> {

    /**
     * 指向头结点的指针
     */
    private DoubleLinkedListNode<T> head;

    /**
     * 指向尾结点的指针
     */
    private DoubleLinkedListNode<T> tail;

    private int size;

    public LinkedListQueue() {}

    /**
     * P106 1.3.41
     * @param queue
     */
    public LinkedListQueue(Queue<T> queue) {
        for(T t : queue) {
            this.enqueue(t);
        }
    }

    @Override
    public void enqueue(T t) {

        if(isEmpty()) {
            head = new DoubleLinkedListNode<>(t);
            tail = head;
        }else {
            DoubleLinkedListNode<T> temp = tail;
            tail.nextNode = new DoubleLinkedListNode<>(t);
            tail = tail.nextNode;
            tail.previousNode = temp;
        }

        size++;
    }

    @Override
    public T dequeue() {

        if(isEmpty()) {
            return null;
        }

        T result = head.node;
        head = head.nextNode;
        head.previousNode = null;
        size--;

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
    public Iterator iterator() {
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<T> {

        private DoubleLinkedListNode<T> temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T node = temp.node;
            temp = temp.nextNode;
            return node;
        }
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            T t = it.next();
            sb.append(t == this ? "(this Collection)" : t);
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(" <-->").append(' ');
        }
    }

}
