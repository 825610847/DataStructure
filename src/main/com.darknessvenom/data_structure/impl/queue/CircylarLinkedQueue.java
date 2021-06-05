package com.darknessvenom.data_structure.impl.queue;

import com.darknessvenom.data_structure.SinglyLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Title: 循环链队列 Circylar Linked Queue
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/25/21
 */
public class CircylarLinkedQueue<T> implements Queue<T> {

    private SinglyLinkedListNode<T> head;

    private SinglyLinkedListNode<T> tail;

    private int size;

    @Override
    public void enqueue(T t) {
        if (isEmpty()) {
            head = new SinglyLinkedListNode<>(t);
            tail = head;
            size = 1;
            return;
        }

        tail.nextNode = new SinglyLinkedListNode<>(t);
        tail = tail.nextNode;
        tail.nextNode = head;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T result = head.node;
        head = head.nextNode;
        tail.nextNode = head;
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircylarLinkedQueueIterator();
    }

    class CircylarLinkedQueueIterator implements Iterator<T> {

        SinglyLinkedListNode<T> temp = head;

        int count = 0;

        @Override
        public boolean hasNext() {
            return temp != null && count < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T node = temp.node;
                temp = temp.nextNode;
                count++;
                return node;
            }
            throw new NoSuchElementException("only " + size + " elements");
        }
    }

    public String josephus(int m) {
        return josephus(m, size);
    }

    /**
     * P105 1.3.37
     *
     * @param m 杀死报到m的人
     * @param n 深陷绝境的人数
     */
    public String josephus(int m, int n) {
        if (isEmpty()) {
            return null;
        } else if (m > n) {
            throw new RuntimeException("Josephus: m must <= n");
        }

        StringBuilder builder = new StringBuilder();
        int count = 1;
        while(size != 1) {
            if(count == m) {
                builder.append(dequeue()).append(" ");
                count = 0;
            }else {
                head = head.nextNode;
                tail = tail.nextNode;
            }

            count++;
        }

        builder.append("\nwinner winner chichen dinner: ").append(dequeue());
        return builder.toString();
    }

}
