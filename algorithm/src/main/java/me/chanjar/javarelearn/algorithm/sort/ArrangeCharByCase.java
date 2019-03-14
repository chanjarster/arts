package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/42038">极客时间 - 数据结构与算法之美 - 13 | 线性排序：如何根据年龄给100万用户数据排序？</a>
 * <p>输入：一个有大小写字母的字符串，字母顺序是乱的</p>
 * 要求输出：所有小写字母在左边，大写字母在右边。
 * <ul>
 * <li>两个指针</li>
 * <li>一个从左往右，直到碰到大写字母为止，停住。</li>
 * <li>一个从右往左，直到碰到小写字母为止，停住。</li>
 * <li>两个指针所在元素交换</li>
 * <li>重复这个过程</li>
 * <li>如果两个指针相遇或者交错了，那么就结束</li>
 * </ul>
 */
public class ArrangeCharByCase {

  public static void arrange(char[] a) {
    if (a.length <= 1) {
      return;
    }

    int l = 0;
    int u = a.length - 1;

    while (l < u) {

      while (l < a.length) {
        char lc = a[l];
        if ('a' <= lc && lc <= 'z') {
          l++;
        } else {
          break;
        }
      }

      while (u >= 0) {
        char uc = a[u];
        if ('A' <= uc && uc <= 'Z') {
          u--;
        } else {
          break;
        }
      }

      if (l >= u) {
        break;
      }

      char tmp = a[l];
      a[l] = a[u];
      a[u] = tmp;

    }
  }
}
