package com.darknessvenom;

import java.lang.reflect.Array;
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

    /**
     * 随机生成一个数组
     * @param length
     * @param cls
     * @param <T>
     * @return
     */
    public static <T extends Number>T[] initialize(int length, Class<T> cls) {
        if(length <= 0 || cls == null) {
            return null;
        }

        T[] arr = (T[])Array.newInstance(cls, length);

        for(int i = 0; i < length; i++) {
            Array.set(arr, i, rand.nextInt(length));
        }

        return arr;
    }

    public static <T> void swap(T[] a, int i, int j) {
        if (a == null || a.length <= 1 || i == j) {
            return;
        }
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 随机打乱数组里的所有元素
     *
     * @param arr
     * @param <T>
     */
    public static <T> void shuffle(T[] arr) {
        shuffle(arr, arr.length - 1);
    }

    /**
     * 打乱前index + 1个的元素
     *
     * @param arr
     * @param index
     * @param <T>
     * @return
     */
    public static <T> void shuffle(T[] arr, int index) {
        shuffle(arr, 0, index);
    }

    /**
     * 打乱arr[firstIndex] 到 arr[lastIndex] 的元素
     *
     * @param arr
     * @param firstIndex
     * @param lastIndex
     * @param <T>
     */
    public static <T> void shuffle(T[] arr, int firstIndex, int lastIndex) {

        if (arr == null || arr.length <= 1) {
            return;
        } else if (lastIndex < 1 || firstIndex >= lastIndex) {
            throw new RuntimeException("Wrong index!");
        }

        for (int i = lastIndex; i > firstIndex; i--) {
            int randInd = rand.nextInt(i) + firstIndex;
            swap(arr, randInd, i);
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     * @return
     */
    public static String displayArray(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        int i = 0;

        while (true) {
            builder.append(arr[i++]);
            if (i == arr.length) {
                return builder.append(']').toString();
            }
            builder.append(", ");
        }

    }

    /**
     * String转Character数组
     * @param s
     * @return
     */
    public static Character[] stringToCharacterArray(String s) {
        return s == null ? null
                : s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }

}

