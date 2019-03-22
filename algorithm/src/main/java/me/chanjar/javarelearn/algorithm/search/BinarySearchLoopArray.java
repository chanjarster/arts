package me.chanjar.javarelearn.algorithm.search;

/**
 * <a href="https://time.geekbang.org/column/article/42733">极客时间 - 数据结构与算法之美 - 16 | 二分查找（下）</a>
 * <p>对一个循环有序数组查找指定元素的位置，比如在 3,4,1,2 中找到 2的位置</p>
 * 实现思路：
 * <ol>
 * <li>找到这个数组的head pos</li>
 * <li>拿head pos作为offset，参与到后面的二分查找里去</li>
 * </ol>
 * 找数组head pos的思路：
 * <ol>
 * <li>当a[i-1] &gt; a[i]时，i 就是 head pos</li>
 * <li>用二分思路找：</li>
 * <li>如果a[lo] &gt; a[mid]，意味着 head pos 在左侧</li>
 * <li>如果a[mid] &gt; a[hi]，意味着 head pos 在右侧</li>
 * <li>在左侧时，如果a[mid-1] &gt; a[mid]，那么 mid 就是 head pos</li>
 * <li>在右侧时，如果a[mid] &gt; a[mid+1]，那么 mid+1 就是 head pos</li>
 * </ol>
 */
public class BinarySearchLoopArray implements Search {

  @Override
  public int search(int[] a, int x) {
    if (a.length == 0) {
      return -1;
    }
    int offset = findHeadPos(a);

    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      int modMid = (mid + offset) % a.length;
      if (a[modMid] < x) {
        lo = mid + 1;
        continue;
      }
      if (a[modMid] > x) {
        hi = mid - 1;
        continue;
      }
      return modMid;
    }

    return -1;
  }

  public int findHeadPos(int[] a) {

    if (a.length == 1) {
      return 0;
    }

    int lo = 0;
    int hi = a.length - 1;
    if (a[lo] < a[hi]) {
      return lo;
    }

    while (lo < hi) {

      int mid = lo + ((hi - lo) >> 1);
      if (a[lo] > a[mid]) {
        if (a[mid - 1] > a[mid]) {
          return mid;
        }
        hi = mid - 1;
        continue;
      }

      if (a[mid] > a[hi]) {
        if (a[mid] > a[mid + 1]) {
          return mid + 1;
        }
        lo = mid + 1;
        continue;
      }

    }

    return -1;
  }
}
