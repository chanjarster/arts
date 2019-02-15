package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41802">极客时间 - 数据结构与算法之美 - 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 * <p>插入排序</p>
 * 算法解释：
 * <p>数组a代表数组</p>
 * <p>i是下标，i 左边是已排序数组，i 右边(含)是未排序数组</p>
 * 取 i 位置的元素 v，和 i 左边的元素比较，比较顺序是 i-1 ... 0，用 j 记作被比较元素的下标
 * <p>如果 v < a[j]，那么就把 a[j] 往后移动，即被比较元素往后挪位</p>
 * 直到 v >= a[j]，把v插入到 a[j+1] 位置，即放在被比较元素的后面
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
        if (value < a[j]) {
          // 数据移动到后面
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      // 在插入点插入数据
      a[j + 1] = value;
    }
  }
}
