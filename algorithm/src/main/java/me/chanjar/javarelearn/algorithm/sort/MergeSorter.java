package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 * <p>归并排序</p>
 * 算法说明：
 * <p>a 代表数组</p>
 * mergeSort算法是递归算法：
 * <ol>
 * <li>把 a 一分为二</li>
 * <li>对 a 左半部分排序</li>
 * <li>对 a 右半部分排序</li>
 * <li>把两部分合并，合并结果得是有序的</li>
 * </ol>
 * 其中对 a 左、右部分排序也是使用mergeSort算法
 *
 * <p>
 * 上述文字用代码表现就是：
 * </p>
 * <pre>
 * <code>mergeSort(a) {
 *   mergeSort(a_left_part)
 *   mergeSort(a_right_part)
 *   merge(a_left_part, a_right_part)
 * }</code>
 * </pre>
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
