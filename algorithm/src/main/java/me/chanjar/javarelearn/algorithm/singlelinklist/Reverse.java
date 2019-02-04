package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41149">极客时间 - 数据结构与算法之美 - 07 | 链表（下）：如何轻松写出正确的链表代码？</a>
 * <p>
 * 单向链表反转
 * </p>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 */
public class Reverse {

  public static Node solve(Node node) {

    Node prev = null;
    Node curr = node;

    while (curr != null) {

      Node next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;

    }

    return prev;
  }

}
