package com.darknessvenom.algorithm.search.sorting;

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
 * @date: 6/15/21
 */
public class TestShell {

    public static void main(String[] args) {
        String s = "SHELLSORTEXAMPLE";
        Character[] array = new Character[s.length()];
        for (int i = 0; i < s.length() ; i++) {
            array[i] = s.charAt(i);
        }

        Shell.sort(array);
        System.out.println(array);
    }
}
