package com.darknessvenom.algorithm.sorting;

import com.darknessvenom.ArrayUtils;

/**
 <p>发明者： 东尼·霍尔
 <p>最差复杂性： n^2
 <p>平均复杂性： n*log(n)
 <p>最优复杂性： n*log(n)
 <p>方法： Partitioning（切分）
 <p>稳定： No
 <p>类别： 比较排序
 *
 * @author: DarknessVenom@gmail.com
 * @date: 7/3/21
 */
public class Quick {

    public static void sort(Comparable[] a) {
        ArrayUtils.shuffle(a);

    }
}
