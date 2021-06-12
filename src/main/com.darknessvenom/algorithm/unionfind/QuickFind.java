package com.darknessvenom.algorithm.unionfind;

/**
 * <p>
 * Title: quick-find算法
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/6/21
 */
public class QuickFind extends UnionFind{

    public QuickFind(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        //将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pID == qID) {
            return;
        }

        //将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }

            count--;
        }
    }
}
