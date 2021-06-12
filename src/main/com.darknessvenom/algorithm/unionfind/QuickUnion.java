package com.darknessvenom.algorithm.unionfind;

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
public class QuickUnion extends UnionFind{

    public QuickUnion(int n) {
        super(n);
    }

    /**
     * 找出分量的名称
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        while(p != id[p]) {
            p = id[p];
        }

        return p;
    }

    /**
     * 将p和q的根节点统一
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }
}
