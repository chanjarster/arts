package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41149">极客时间 - 数据结构与算法之美 - 07 | 链表（下）：如何轻松写出正确的链表代码？</a>
 * <p>
 * 链表中环的检测
 * </p>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 * <p>
 * 问题的本质在于，如果链表出现循环，那么这个链表是不可能有tail node的（即next==null）
 * </p>
 * 解决思路：快慢两个指针，慢指针每次走一步，快指针每次走两步
 * <p>
 * 如果快指针走到tail node，或者tail node的前一个，则说明没有循环。
 * </p>
 * 如果有循环，那么快慢指针总有一天会相遇
 */
public class CycleDetect {

  public static boolean solve(Node node) {
    if (node == null) {
      return false;
    }
    Node slow = node;
    Node fast = node;
    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      fast = fast.getNext().getNext();
      if (slow == fast) {
        return true;
      }
      slow = slow.getNext();

    }
    return false;
  }
}
