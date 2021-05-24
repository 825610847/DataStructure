package com.darknessvenom.data_structure.impl;

import com.darknessvenom.data_structure.interfaces.Stack;

import java.util.Iterator;

/**
 * <p>
 * Title: 定容栈
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/17/21
 */
public class ArrayListStack<T> implements Stack<T> {

    private T[] entries;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 容器最大容量
     */
    private int capacity;

    private static final int DEFAULT_CAPACITY = 16;

    public ArrayListStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListStack(int cap) {
        entries = (T[]) new Object[cap];
        capacity = cap;
        size = 0;
    }

    @Override
    public void push(T t) {
        //满栈时扩容两倍
        if(isFull()) {
            capacity *= 2;
            resize(capacity);
        }
        entries[size++] = t;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            return null;
        }

        //如果数组太大就将其长度减半
        if(size == capacity / 4) {
            capacity /= 2;
            resize(capacity);
        }

        T t = entries[--size];
        //避免对象游离
        entries[size] = null;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : entries[size - 1];
    }

    /**
     * 调整大小
     * @param cap 新的大小
     */
    private void resize(int cap) {
        T[] temp = (T[]) new Object[cap];

        for(int i = 0; i < size; i++) {
            temp[i] = entries[i];
        }

        capacity = cap;
        entries = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListStackIterator();
    }

    private class ArrayListStackIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != (size - 1);
        }

        @Override
        public T next() {
            return entries[++index];
        }
    }
}
