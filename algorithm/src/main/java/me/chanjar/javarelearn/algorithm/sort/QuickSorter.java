package me.chanjar.javarelearn.algorithm.sort;

/**
 * <a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 * <p>快速排序</p>
 * 算法解释：
 * <p>a代表数组</p>
 * pivot 是在数组中选择的一个元素， pivot_i 代表该元素的下标。
 * <p>下标 &lt; pivot_i 的元素都比 pivot 小，下标 &gt; pivot_i 的元素都比 pivot 大</p>
 *
 * quickSort算法是递归算法：
 *
 * <ol>
 *   <li>去a的最后一个元素作为 pivot</li>
 *   <li>把 &lt; pivot 的元素放到 pivot 左边</li>
 *   <li>把 &gt; pivot 的元素放到 pivot 右边</li>
 *   <li>对 pivot 左边的元素 重复 1-3 步骤</li>
 *   <li>对 pivot 右边的元素 重复 1-3 步骤</li>
 * </ol>
 *
 * 上述文字用代码表现就是：
 *
 * <pre>
 * <code>quickSort(a) {
 *   pivot = last element of a;
 *   arrange all elements < pivot on the left side of pivot
 *   arrange all elements >= pivot on the right side of pivot
 *   quickSort(a_pivot_left_part);
 *   quickSort(a_pivot_right_part);
 * }</code>
 * </pre>
 *
 * 其中把元素移动到pivot左右两边到算法：
 *
 * <ol>
 *   <li>定义 i 作为下标，它具有以下特性：a[&lt; i] &lt; pivot ; a[&gt;= i] &gt;= pivot</li>
 *   <li>定义 pivot = a[len - 1]，即 a 的最后一个元素 </li>
 *   <li>初始 i = 0，意思是其左边还没有比 pivot 小的元素</li>
 *   <li>遍历 a[0 ... len - 1 - 1]，从头到倒数第二个元素，遍历用下标为 j
 *   <p>
 *     如果 a[j] &lt; pivot，那么 swap(a[i], a[j])，i++
 *   </p>
 *   <p>在整个过程满足：a[0 ... i-1] &lt; pivot，a[i ... j-1] &gt;= pivot</p>
 *   因此如果 a[j] &lt; pivot，把 a[i], a[j]互换位置，然后 i++，这个关系依旧保持不变。
 *   <p>此外还达成：a[0 ... i-1] &lt; pivot，a[i ... j] &gt;= pivot</p>
 *   <p>当遍历结束时，再把 pivot 放到 i 位置，</p>
 *   </li>
 * </ol>
 */
public class QuickSorter implements Sorter {

  public void sort(int[] a) {

    quickSort(a, 0, a.length - 1);
  }

  private void quickSort(int[] a, int start, int end) {

    if (start >= end) {
      return;
    }

    // 取数组最后一个元素作为pivot
    int pivot = a[end];
    // 要计算的pivot的下标
    // pivot_i 左边的都是 < pivot的元素
    // pivot_i 右边的(含)都是 >= pivot的元素
    int pivot_i = start;

    for (int j = start; j <= end - 1; j++) {
      if (a[j] < pivot) {
        if (pivot_i != j) {
          // 因为 pivot_i 右边(含) 都是 >= pivot 的元素
          // 一个元素 < pivot，则将其和 pivot_i 的位置互换
          // pivot_i++
          int tmp = a[pivot_i];
          a[pivot_i] = a[j];
          a[j] = tmp;
        }
        pivot_i++;
      }
    }

    // 把 pivot 和 pivot_i 元素位置互换
    int tmp = a[pivot_i];
    a[end] = tmp;
    a[pivot_i] = pivot;

    // 对 pivot_i 左边的元素进行排序
    quickSort(a, start, pivot_i - 1);
    // 对 pivot_i 右边的元素进行排序
    quickSort(a, pivot_i + 1, end);
  }

}
