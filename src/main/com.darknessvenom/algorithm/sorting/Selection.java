package com.darknessvenom.algorithm.sorting;

/**
 * <p>
 * Title: 选择排序
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public class Selection extends BaseSorting {

    /**
     * 将a[]升序排列
     * @param a
     */
    public static void sort(Comparable[] a) {
        if(a == null) {
            return;
        }
        int length = a.length;
        if(length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, min, i);
        }
    }
}
