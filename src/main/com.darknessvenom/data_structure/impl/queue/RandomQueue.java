package com.darknessvenom.data_structure.impl.queue;

import com.darknessvenom.ArrayUtils;
import com.darknessvenom.data_structure.AbstractArray;
import com.darknessvenom.data_structure.interfaces.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * <p>
 * Title: 随机队列
 * </p>
 * <p>
 * Module: P105 1.3.35
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/30/21
 */
public class RandomQueue<T> extends AbstractArray<T> implements Queue<T> {

    private static Random rand = new Random();

    public RandomQueue() {
        super(DEFAULT_CAPACITY);
    }

    public RandomQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(T t) {
        beforeResize();
        items[size++] = t;
    }

    /**
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        beforeResize();
        shuffle();

        int index = size - 1;
        ArrayUtils.swap(items, getRandomItemIndex(), index);
        T result = (T) items[index];
        items[index] = null;
        size--;
        return result;
    }

    public T sample() {
        if (isEmpty()) {
            return null;
        }
        return (T) items[getRandomItemIndex()];
    }

    private int getRandomItemIndex() {
        int bound = size - 1;
        return bound > 0 ? rand.nextInt(size - 1) : 0;
    }

    /**
     * 随机打乱数组的元素
     */
    private void shuffle() {
        if (!isEmpty() && size > 1) {
            ArrayUtils.shuffle(items, size - 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        shuffle();
        return super.iterator();
    }

}
