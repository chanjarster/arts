package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41013">极客时间 - 数据结构与算法之美 - 06 | 链表（上）：如何实现LRU缓存淘汰算法?</a>
 * <p>
 * 字符串以单链表存储，判断字符串是否回文（正过来与反过来读是一样的字符串）。下面是回文的例子：
 * </p>
 * <ul>
 * <li>A: yes</li>
 * <li>ABA: yes</li>
 * <li>ABXBA: yes</li>
 * <li>ABXAB: no</li>
 * </ul>
 * <p>
 * 思路：快慢两个指针找到链表的中间节点，再判断中间节点两端是否一致。
 * 慢指针每次前进1步，快指针每次前进2步，快指针先走，当快指针走到底的时候，
 * 就知道慢指针停止前进，此时慢指针处于ceil(总元素数目/2)的位置。同时慢指针在走的时候将链表反转。
 * 最后遍历两段，看是否一致
 * </p>
 * 时间复杂度分析：
 * <ul>
 * <li>最好：O(n)</li>
 * <li>最坏：O(n)</li>
 * <li>平均：O(n)</li>
 * </ul>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 */
public class Palindrome {

  public static boolean solve(Node node) {
    Node slow = node;
    Node slowPrev = null;
    Node fast = node;

    Node left = null;
    Node right = null;

    while (fast != null) {

      fast = fast.getNext();
      if (fast == null) {
        // 单数个元素
        left = slowPrev;
        right = slow.getNext();
        break;
      }

      fast = fast.getNext();
      if (fast == null) {
        // 偶数个元素
        left = slow;
        right = slow.getNext();

        // 将slow当前元素反转
        slow.setNext(slowPrev);
        break;
      }

      // 将slow当前元素反转
      Node slowNext = slow.getNext();
      slow.setNext(slowPrev);
      slowPrev = slow;
      slow = slowNext;

    }

    return equals(left, right);

  }

  public static boolean equals(Node node1, Node node2) {

    Node left = node1;
    Node right = node2;

    if (left == right) {
      // 包含了left right都为null的情况
      return true;
    }

    while (true) {
      if (left == null && right == null) {
        return true;
      }
      if (left == null) {
        return false;
      }
      if (right == null) {
        return false;
      }

      if (!left.getValue().equals(right.getValue())) {
        return false;
      }
      left = left.getNext();
      right = right.getNext();
    }

  }

}
