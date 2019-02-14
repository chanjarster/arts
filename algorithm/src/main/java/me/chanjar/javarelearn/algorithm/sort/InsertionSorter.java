package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41802">极客时间 - 数据结构与算法之美 - 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 * <p>插入排序</p>
 */
public class InsertionSorter implements Sorter {

  public void sort(int[] a) {
    int n = a.length;
    if (n <= 1) {
      return;
    }

    for (int i = 1; i < n; i++) {
      int value = a[i];
      int j = i - 1;
      // 查找插入位置
      for (; j >= 0; j--) {
        if (a[j] > value) {
          // 数据移动到后面
          a[j + 1] = a[j];
        } else {
          break;
        }
        // 在插入点插入数据
        a[j + 1] = value;
      }
    }
  }
}
