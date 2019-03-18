package me.chanjar.javarelearn.algorithm.search;

/**
 * <a href="https://time.geekbang.org/column/article/42733">极客时间 - 数据结构与算法之美 - 16 | 二分查找（下）</a>
 * <p>查找第一个值等于给定值的下标</p>
 */
public class FindFirstEquals implements Search {

  @Override
  public int search(int[] a, int num) {

    if (a.length == 0) {
      return -1;
    }

    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (a[mid] < num) {
        lo = mid + 1;
        continue;
      }
      if (a[mid] > num) {
        hi = mid - 1;
        continue;
      }
      if (mid == 0 || a[mid - 1] != num) {
        return mid;
      }
      hi = mid - 1;
    }
    return -1;
  }
}
