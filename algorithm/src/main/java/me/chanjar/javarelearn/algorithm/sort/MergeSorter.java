package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 * <p>
 * 笔记：<a href="https://chanjarster.github.io/post/algo/11-merge-sort/">归并排序</a>
 * </p>
 */
public class MergeSorter implements Sorter {

  public void sort(int[] a) {

    merge_sort(a, 0, a.length - 1);

  }

  private void merge_sort(int[] a, int start, int end) {

    if (start >= end) {
      return;
    }

    int mid = (start + end) / 2;

    merge_sort(a, start, mid);
    merge_sort(a, mid + 1, end);

    merge(a, start, mid, end);

  }

  private void merge(int[] a, int start, int mid, int end) {
    // 合并两个有序数组

    int i = start;
    int j = mid + 1;

    int k = 0;
    int[] tmp = new int[end - start + 1];

    while (i <= mid && j <= end) {
      if (a[i] <= a[j]) {
        tmp[k] = a[i];
        i++;
      } else {
        tmp[k] = a[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      tmp[k] = a[i];
      i++;
      k++;
    }

    while (j <= end) {
      tmp[k] = a[j];
      j++;
      k++;
    }

    for (int x = 0; x < k; x++) {
      a[start + x] = tmp[x];
    }
  }

}
