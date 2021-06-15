package com.darknessvenom.algorithm.sorting;

/**
 * <p>
 * Title: 希尔排序（加强版插入排序）
 * </p>
 * <p>最差复杂性： Depends on gap sequence
 * <p>平均复杂性： n*log(n)^2 or n^(3/2)
 * <p>最优复杂性： n
 * <p>方法： Insertion
 * <p>稳定： No
 * <p>类别： 比較排序
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public class Shell extends BaseSorting {

    public static void sort(Comparable[] a) {
        if(a == null) {
            return;
        }
        int length = a.length;
        if(length <= 1) {
            return;
        }

        int h = 1;
        while (h < length / 3) {
            //1, 4, 13, 40, 121, 364, 1093, ...
            h = h * 3 + 1;
        }

        //将数组变为h有序
        while(h >= 1) {
            for(int i = h; i < length; i++) {
                //将a[i]插入到a[i - h], a[i - 2*h] ......
                for(int j = i; h <= j && less(a[j], a[j - 1]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
