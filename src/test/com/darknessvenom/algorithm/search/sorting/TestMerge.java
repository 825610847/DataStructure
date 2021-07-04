package com.darknessvenom.algorithm.search.sorting;

import com.darknessvenom.ArrayUtils;
import com.darknessvenom.algorithm.sorting.Merge;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/26/21
 */
public class TestMerge {

    public static void main(String[] args) {
        String s = "MERGESORTEXAMPLE";
        Character[] a = ArrayUtils.stringToCharacterArray(s);
        Merge.sortTopDown(a);
        System.out.println(ArrayUtils.displayArray(a));
    }
}
