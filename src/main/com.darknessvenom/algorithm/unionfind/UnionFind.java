package com.darknessvenom.algorithm.unionfind;

import com.darknessvenom.ArrayUtils;

import java.util.Arrays;

/**
 * <p>
 * Title: 并查集算法基类
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/6/21
 */
public abstract class UnionFind {

    /**
     * 分量ID（以触点作为索引）
     */
    protected int[] id;

    /**
     * 分量数量
     */
    protected int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 如果p和q存在于同一个分量中则返回true
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public String displayArray() {
        return ArrayUtils.displayArray
                (Arrays.stream(id).boxed().toArray(Integer[]::new));
    }

    /**
     * p (0 到 N-1) 所在的分量的标识符
     * @param p
     * @return
     */
    public abstract int find(int p);

    /**
     * 在p和q之间添加一条连接
     * @param p
     * @param q
     */
    public abstract void union(int p, int q);

}
