package com.darknessvenom.algorithm.sorting;

/**
 * <p>发明者： 约翰·冯·诺伊曼
 * <p>最差复杂性： n*log(n)
 * <p>平均复杂性： n*log(n)
 * <p>最优复杂性： n*log(n)
 * <p>空间复杂性： n
 * <p>方法： Merging
 * <p>稳定： Yes
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/12/21
 */
public class Merge extends BaseSorting {

    /**
     * 归并所需的辅助数组
     */
    private static Comparable[] assistArray;

    /**
     * 自顶向下的归并排序
     * @param a
     */
    public static void sortTopDown(Comparable[] a) {
        assistArray = new Comparable[a.length];
        sortTopDown(a, 0, a.length - 1);
    }

    /**
     * 自底向上的归并排序
     * @param a
     */
    public static void sortBottomUp(Comparable[] a) {
        int arraySize = a.length;
        assistArray = new Comparable[arraySize];
        for (int size = 1; size < arraySize; size *= 2) {
            for(int left = 0; left < arraySize - size; left += size + size) {
                merge(a, left, left + size - 1,
                        Math.min(left + size + size - 1, arraySize - 1));
            }
        }
    }

    private static void sortTopDown(Comparable[] a, int left, int right) {
        if (right <= left) {
            return;
        }
        //将数组a[left..right]排序
        int mid = left + (right - left) / 2;
        //将左半边排序
        sortTopDown(a, left, mid);
        //将右半边排序
        sortTopDown(a, mid + 1, right);
        //归并
        merge(a, left, mid, right);
    }

    /**
     * 原地归并
     *
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(Comparable[] a, int left, int mid, int right) {
        //将a[left ... mid] 和 a[mid + 1 ... right] 归并
        int i = left, j = mid + 1;
        //将a[left..right]复制到assistArray[left...right]
        for (int k = left; k <= right; k++) {
            assistArray[k] = a[k];
        }
        //归并回到a[left..right]
        for (int k = left; k <= right; k++) {
            //左半边用尽（取右半边的元素）
            if (i > mid) {
                a[k] = assistArray[j++];
            }
            //右半边用尽（取左半边的元素）
            else if (j > right) {
                a[k] = assistArray[i++];
            }
            //右半边的当前元素小于左半边的当前元素（取右半边的元素）
            else if (less(assistArray[j], assistArray[i])) {
                a[k] = assistArray[j++];
            }
            //右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
            else {
                a[k] = assistArray[i++];
            }
        }
    }

}
