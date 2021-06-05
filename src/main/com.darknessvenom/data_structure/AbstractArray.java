package com.darknessvenom.data_structure;

import com.darknessvenom.data_structure.interfaces.Queue;

import java.util.Iterator;

/**
 * <p>
 * Title: 数组抽象数据结构类
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/30/21
 */
public abstract class AbstractArray<T> implements Iterable<T> {

    protected Object[] items;

    protected int size;

    protected static final int DEFAULT_CAPACITY = 8;

    protected int capacity;

    protected AbstractArray(int capacity) {
        items = new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    protected void beforeResize() {
        if (isFull()) {
            resize(capacity * 2);
        } else if (size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    /**
     * 扩容/缩容
     *
     * @param capacity
     */
    protected void resize(int capacity) {
        Object[] newItems = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }

        items = newItems;
        this.capacity = capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new AbstractArrayIterator();
    }

    class AbstractArrayIterator implements Iterator<T> {

        private int count;

        public AbstractArrayIterator() {
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T result = (T) items[count++];
            return result;
        }
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }


        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            T t = it.next();
            sb.append(t == this ? "(this Collection)" : t);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
