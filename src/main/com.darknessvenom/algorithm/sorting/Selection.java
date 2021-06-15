package com.darknessvenom.algorithm.sorting;

/**
 * <p>
 * Title: 选择排序
 * </p>
 * <p>最差复杂性： n^2
 * <p>平均复杂性： n^2
 * <p>最优复杂性： n^2
 * <p>空间复杂性： 1
 * <p>方法： Selection
 * <p>稳定： No
 * <p>类别： 比較排序
 *
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
