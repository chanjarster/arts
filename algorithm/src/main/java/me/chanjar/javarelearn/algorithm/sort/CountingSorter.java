package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/42038">极客时间 - 数据结构与算法之美 - 13 | 线性排序：如何根据年龄给100万用户数据排序？</a>
 * <p>
 * 笔记：TODO
 * </p>
 */
public class CountingSorter implements Sorter {

  public void sort(int[] a) {
    if (a.length <= 1) {
      return;
    }
    int min = findMin(a);
    if (min < 0) {
      throw new IllegalArgumentException("element must greater than or equal to zero");
    }

    int max = findMax(a);
    int[] counting = new int[max];
    for (int i = 0; i < a.length; i++) {
      counting[a[i] - 1]++;
    }

    for (int i = 1; i < counting.length; i++) {
      counting[i] = counting[i] + counting[i - 1];
    }

    int[] r = new int[a.length];
    for (int i = a.length - 1; i >= 0; i--) {
      int idx = counting[a[i] - 1]--;
      r[idx - 1] = a[i];
    }

    for (int i = 0; i < a.length; i++) {
      a[i] = r[i];
    }
  }

  private int findMin(int[] a) {
    int min = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }
  private int findMax(int[] a) {
    int max = a[0];

    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }
}
