package com.darknessvenom.algorithm.search.sorting;

import com.darknessvenom.ArrayUtils;
import com.darknessvenom.Stopwatch;
import com.darknessvenom.algorithm.sorting.Insection;
import com.darknessvenom.algorithm.sorting.Shell;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public class TestSortingSpeed {

    public static void main(String[] args) {
        Integer[] a = ArrayUtils.initialize(1000, Integer.class);
        Integer[] b = a.clone();

        Stopwatch insectionTimer = new Stopwatch();
        Insection.sort(a);
        System.out.println(insectionTimer.elpasedTimeInSecond());
        Stopwatch shellTimer = new Stopwatch();
        Shell.sort(b);
        System.out.println(shellTimer.elpasedTimeInSecond());
        System.out.println(ArrayUtils.displayArray(a));
        System.out.println(ArrayUtils.displayArray(b));
    }
}
