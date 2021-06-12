package com.darknessvenom.algorithm.search.sorting;

import com.darknessvenom.algorithm.sorting.BaseSorting;
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
public class TestSelection {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4, 6, 2, 3, 7, 8, 4, 6, 7, 8, 9, 5, 6, 7, 8};
        Character[] b = new Character[]{'e','f','g','r','s','f','a','c'};
        Selection.sort(a);
        Selection.sort(b);
        System.out.println(Selection.show(a));
        System.out.println(Selection.show(b));
    }
}
