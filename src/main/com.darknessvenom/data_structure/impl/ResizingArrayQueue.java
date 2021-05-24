package com.darknessvenom.data_structure.impl;

import com.darknessvenom.data_structure.interfaces.Queue;

import java.util.Iterator;
import java.util.Objects;

/**
 * P102 1.3.14
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/22/21
 */
public class ResizingArrayQueue<T> implements Queue<T> {

    private static int DEFAULT_CAPACITY = 8;

    private T[] elements;

    private int capacity;

    private int size;

    private int first;

    private int last;

    public ResizingArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ResizingArrayQueue(int capacity) {
        elements = (T[])new Objects[capacity];
        this.capacity = capacity;
        first = 0;
        last = 0;
    }

    @Override
    public void enqueue(T t) {
        beforeResize();
        elements[last++] = t;
        size++;
    }

    @Override
    public T dequeue() {
        beforeResize();
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return last == capacity;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void beforeResize() {
        if(isFull()) {
            resize(capacity * 2);
        }else if(size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    /**
     * 调整大小
     * @param cap 新的大小
     */
    public void resize(int cap) {
        T[] temp = (T[]) new Object[cap];

        for(int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }

        capacity = cap;
        first = 0;
        last = cap;
        elements = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayQueueIterator();
    }

    class ResizingArrayQueueIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
