package me.chanjar.javarelearn.algorithm.search;

/**
 * <a href="https://time.geekbang.org/column/article/42520">极客时间 - 数据结构与算法之美 - 15 | 二分查找（上）</a>
 * <br/>
 */
public class BinarySearch implements Search {

  @Override
  public int search(int[] a, int x) {
    if (a.length == 0) {
      return -1;
    }
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // 避免溢出
      int mid = lo + ((hi - lo) >> 1);
      if (a[mid] < x) {
        lo = mid + 1;
        continue;
      }
      if (a[mid] > x) {
        hi = mid - 1;
        continue;
      }
      return mid;
    }
    return -1;
  }

}
