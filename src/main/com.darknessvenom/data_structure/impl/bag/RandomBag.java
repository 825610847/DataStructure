package com.darknessvenom.data_structure.impl.bag;

import com.darknessvenom.ArrayUtils;
import com.darknessvenom.data_structure.interfaces.Bag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Title: 随机背包
 * </p>
 * <p>
 * Module: P104 1.3.34
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/29/21
 */
public class RandomBag<T> implements Bag<T> {

    private Object[] items;

    private static final int DEFAULT_CAPACITY = 8;

    private int size;

    private int capacity;

    public RandomBag() {
        this(DEFAULT_CAPACITY);
    }

    public RandomBag(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void add(T t) {
        beforeResize();
        items[size++] = t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void beforeResize() {
        if (isFull()) {
            resize(capacity * 2);
        }
//        else if(size == capacity / 4) {
//            resize(capacity / 2);
//        }
    }

    /**
     * 调整大小
     *
     * @param cap 新的大小
     */
    private void resize(int cap) {
        Object[] temp = new Object[cap];

        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }

        capacity = cap;
        items = temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    class RandomBagIterator implements Iterator<T> {

        private int count;

        T[] randomArray;

        /**
         * 随机打乱数组的顺序
         */
        public RandomBagIterator() {
            count = 0;
            randomArray = (T[])ArrayUtils
                    .shuffle(Arrays.copyOfRange(items, 0, size));
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return randomArray[count++];
            }
            throw new NoSuchElementException("only " + size + " elements");
        }
    }
}
