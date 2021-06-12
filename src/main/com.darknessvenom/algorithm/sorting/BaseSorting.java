package com.darknessvenom.algorithm.sorting;

import com.darknessvenom.ArrayUtils;

/**
 * <p>
 * Title: 排序算法基类
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public abstract class BaseSorting {

    /**
     *
     * @param x
     * @param y
     * @return true: x < y
     */
    protected static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    /**
     * 交换a[i]与a[j]的值
     * @param a
     * @param i
     * @param j
     */
    protected static void exchange(Comparable[] a, int i, int j) {
        ArrayUtils.swap(a, i, j);
    }

    /**
     * 打印数组
     * @param a
     * @return
     */
    public static String show(Comparable[] a) {
        return ArrayUtils.displayArray(a);
    }

    /**
     * 测试数组元素是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
