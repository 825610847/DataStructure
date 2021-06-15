package com.darknessvenom.algorithm.sorting;

/**
 * <p>
 * Title: 插入排序
 * </p>
 * <p>最差复杂性： n^2
 * <p>平均复杂性： n^2
 * <p>最优复杂性： n
 * <p>空间复杂性： 1
 * <p>方法： Insertion
 * <p>稳定： Yes
 * <p>类别： 比較排序
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public class Insection extends BaseSorting {

    public static void sort(Comparable a[]) {
        if (a == null) {
            return;
        }
        int length = a.length;
        if (length <= 1) {
            return;
        }

        //将a[i]插入到a[i-1] a[i-2] a[i-3] ... 中
        for(int i = 0; i < length; i++) {
            for(int j = i; 0 < j && less(a[j],a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }

    }
}
