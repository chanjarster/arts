package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41802">极客时间 - 数据结构与算法之美 - 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 * <p>冒泡排序</p>
 */
public class BubbleSorter implements Sorter {

  public int[] sort(int[] a) {

    int n = a.length;
    if (n <= 1) {
      return a;
    }

    for (int i = 0; i < n; i++) {

      boolean flag = false;

      for (int j = 0; j < n - i - 1; j++) {

        // 每次交换把一个较大的元素移动到数组尾部
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          flag = true;
        }

      }
      if (!flag) {
        // 如果没有数据交换，则说明数组已经有序
        break;
      }
    }
    return a;
  }
}
