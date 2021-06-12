package com.darknessvenom.algorithm.unionfind;

import com.darknessvenom.ArrayUtils;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/6/21
 */
public class TestQuickFind {

    public static void main(String[] args) {
        UnionFind uf = new QuickFind(10);

        System.out.println(uf.displayArray());

        uf.union(4, 3);

        System.out.println(uf.displayArray());

        uf.union(3, 8);

        System.out.println(uf.displayArray());

        uf.union(6, 5);

        System.out.println(uf.displayArray());

        uf.union(9, 4);

        System.out.println(uf.displayArray());

        uf.union(2, 1);

        System.out.println(uf.displayArray());

        uf.union(5, 0);

        System.out.println(uf.displayArray());

        uf.union(7, 2);

        System.out.println(uf.displayArray());

        uf.union(6, 1);

        System.out.println(uf.displayArray());
    }
}
