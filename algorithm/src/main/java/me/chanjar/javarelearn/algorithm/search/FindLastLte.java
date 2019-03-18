package me.chanjar.javarelearn.algorithm.search;

/**
 * <a href="https://time.geekbang.org/column/article/42733">极客时间 - 数据结构与算法之美 - 16 | 二分查找（下）</a>
 * <p>查找最后一个小于等于给定值的下标</p>
 */
public class FindLastLte implements Search {

  @Override
  public int search(int[] a, int num) {

    if (a.length == 0) {
      return -1;
    }

    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (a[mid] > num) {
        hi = mid - 1;
        continue;
      }
      if (mid == a.length - 1 || a[mid + 1] > num) {
        return mid;
      }
      lo = mid + 1;
    }
    return -1;
  }
}
