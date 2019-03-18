package me.chanjar.javarelearn.algorithm.search;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <a href="https://time.geekbang.org/column/article/42520">极客时间 - 数据结构与算法之美 - 15 | 二分查找（上）</a>
 * <br/>
 * 有一个数字n，求n的平方根，精确到小数点后6位。
 * <p>算法：</p>
 * 先计算整数部分，取n的整形部分i的平方根x，那么x具有以下特性：
 * <ol>
 * <li>要么 x^2 == i</li>
 * <li>要么 x^2 &lt; i &amp;&amp; (x+1)^2 &gt; i</li>
 * </ol>
 * 然后计算小数部分，先取第一个小数f的值，f具有以下特性：：
 * <ol>
 * <li>要么 (x+f)^2 == n</li>
 * <li>要么 (x+f)^2 &lt; n &amp;&amp; (x+f+0.1)^2 &gt; n</li>
 * </ol>
 * 然后按照这个方法计算第2、3、4、5、6位小数的值。
 * <p>
 * 整个过程采用二分发
 * </p>
 */
public class SquareRoot {

  public double solve(double n) {
    if (n < 0) {
      return -1;
    }
    if (n <= 1) {
      return n;
    }

    int int_r = calcIntPart((int) n);
    return calc(BigDecimal.valueOf(n), int_r, 6).doubleValue();

  }

  private int calcIntPart(int n) {
    int lo = 0;
    int hi = n;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      int mid_plus_1 = mid + 1;
      if (mid * mid == n) {
        return mid;
      }

      if (mid * mid > n) {
        hi = mid - 1;
        continue;
      }

      if (mid * mid < n) {
        if (mid_plus_1 * mid_plus_1 > n) {
          return mid;
        }
        lo = mid_plus_1;
        continue;
      }

    }

    return -1;
  }

  private BigDecimal calc(BigDecimal n, int int_r, int scale) {

    BigDecimal result = new BigDecimal(int_r);

    for (int i = 1; i <= scale; i++) {

      BigDecimal step = BigDecimal.ONE.divide(BigDecimal.TEN.pow(i), i, RoundingMode.UNNECESSARY);

      int lo = 0;
      int hi = 9;
      while (lo <= hi) {

        int mid = (lo + hi) / 2;
        int mid_step_1 = mid + 1;

        BigDecimal tmp_m = new BigDecimal(mid).multiply(step).add(result);
        BigDecimal tmp_m_step_1 = new BigDecimal(mid_step_1).multiply(step).add(result);

        if (tmp_m.pow(2).compareTo(n) == 0) {
          result = tmp_m;
          break;
        }

        if (tmp_m.pow(2).compareTo(n) > 0) {
          hi = mid - 1;
          continue;
        }

        if (tmp_m.pow(2).compareTo(n) < 0) {
          if (tmp_m_step_1.pow(2).compareTo(n) > 0) {
            result = tmp_m;
            break;

          }
          lo = mid_step_1;
          continue;
        }
      }

    }

    return result;
  }
}
