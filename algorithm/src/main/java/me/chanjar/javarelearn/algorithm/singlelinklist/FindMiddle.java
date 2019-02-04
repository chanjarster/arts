package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41149">极客时间 - 数据结构与算法之美 - 07 | 链表（下）：如何轻松写出正确的链表代码？</a>
 * <p>
 * 求链表的中间结点
 * </p>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 */
public class FindMiddle {
  public static Node solve(Node node) {
    if (node == null) {
      return null;
    }
    Node slow = node;
    Node fast = node;
    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      fast = fast.getNext().getNext();
      slow = slow.getNext();
    }
    return slow;
  }
}
