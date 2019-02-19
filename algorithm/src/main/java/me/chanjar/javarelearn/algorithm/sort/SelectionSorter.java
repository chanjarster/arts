package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41802">极客时间 - 数据结构与算法之美 - 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 * <p>
 * 笔记：<a href="https://chanjarster.github.io/post/algo/10-selection-sort/">选择排序</a>
 * </p>
 */
public class SelectionSorter implements Sorter {

  public void sort(int[] a) {
    int n = a.length;
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n; i++) {

      int min_i = i;
      // 找到最小值
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[min_i]) {
          // 更新最小值数据
          min_i = j;
        }
      }

      if (min_i == i) {
        continue;
      }

      // 交换数据
      int tmp = a[i];
      a[i] = a[min_i];
      a[min_i] = tmp;

    }
  }
}
