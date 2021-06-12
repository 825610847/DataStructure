package com.darknessvenom.algorithm.search.sorting;

import com.darknessvenom.Stopwatch;
import com.darknessvenom.algorithm.sorting.Insection;
import com.darknessvenom.algorithm.sorting.Selection;

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
public class TestInsection {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{-4, 4, 6, 2, 3, 7, 8, 4, 6, 7, 8, 9, 5, 6, 7, 8, -9};
        Integer[] c = new Integer[]{-4, 4, 6, 2, 3, 7, 8, 4, 6, 7, 8, 9, 5, 6, 7, 8, -9};
        Character[] b = new Character[]{'e','f','g','r','s','f','a','c'};
        Stopwatch a1 = new Stopwatch();
        Insection.sort(a);
        System.out.println(a1.elpasedTime());
        Stopwatch a2 = new Stopwatch();
        Selection.sort(c);
        System.out.println(a2.elpasedTime());
        System.out.println(Insection.show(a));
        System.out.println(Insection.show(b));
    }
}
