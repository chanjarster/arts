package me.chanjar.javarelearn.algorithm.sort;

/**
 * 在一个数组中查找第K大数组
 * <p>
 * 题目来源：<a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 * </p>
 * 笔记：<a href="https://chanjarster.github.io/post/algo/13-find-kth-big-number/"></a>
 */
public class FindKthBigNumber {

  public static int findKthBigNumber(int[] a, int kthBig) {

    int n = a.length;
    if (kthBig > n) {
      return -1;
    }
    int lthSmall = n - kthBig;

    return quickFind(a, 0, a.length - 1, lthSmall);
  }

  private static int quickFind(int[] a, int start, int end, int lthSmall) {

    if (start > end) {
      return -1;
    }
    int pivot = a[end];

    int pivot_i = start;
    for (int j = start; j <= end - 1; j++) {
      if (a[j] < pivot) {
        int tmp = a[j];
        a[j] = a[pivot_i];
        a[pivot_i] = tmp;
        pivot_i++;
      }
    }

    a[end] = a[pivot_i];
    a[pivot_i] = pivot;

    if (pivot_i == lthSmall) {
      return a[pivot_i];
    }

    if (pivot_i < lthSmall) {
      return quickFind(a, pivot_i + 1, end, lthSmall);
    }

    return quickFind(a, start, pivot_i - 1, lthSmall);

  }
}
