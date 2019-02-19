package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 * <p>
 * 笔记：<a href="https://chanjarster.github.io/post/algo/12-quick-sort/">快速排序</a>
 * </p>
 */
public class QuickSorter implements Sorter {

  public void sort(int[] a) {
    quickSort(a, 0, a.length - 1);
  }

  private void quickSort(int[] a, int start, int end) {

    if (start >= end) {
      return;
    }

    // 取数组最后一个元素作为pivot
    int pivot = a[end];
    // 要计算的pivot的下标
    // pivot_i 左边的都是 < pivot的元素
    // pivot_i 右边的(含)都是 >= pivot的元素
    int pivot_i = start;

    for (int j = start; j <= end - 1; j++) {
      if (a[j] < pivot) {
        if (pivot_i != j) {
          // 因为 pivot_i 右边(含) 都是 >= pivot 的元素
          // 一个元素 < pivot，则将其和 pivot_i 的位置互换
          // pivot_i++
          int tmp = a[pivot_i];
          a[pivot_i] = a[j];
          a[j] = tmp;
        }
        pivot_i++;
      }
    }

    // 把 pivot 和 pivot_i 元素位置互换
    int tmp = a[pivot_i];
    a[end] = tmp;
    a[pivot_i] = pivot;

    // 对 pivot_i 左边的元素进行排序
    quickSort(a, start, pivot_i - 1);
    // 对 pivot_i 右边的元素进行排序
    quickSort(a, pivot_i + 1, end);
  }

}
