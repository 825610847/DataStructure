package com.darknessvenom;

import java.util.Random;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/29/21
 */
public class ArrayUtils {

    private static Random rand = new Random();

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 随机打乱数组里的元素
     *
     * @param arr
     * @param <T>
     */
    public static <T>T[] shuffle(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return null;
        }
        for (int i = arr.length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }

        return arr;
    }
}

