package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41149">极客时间 - 数据结构与算法之美 - 07 | 链表（下）：如何轻松写出正确的链表代码？</a>
 * <p>
 * 两个有序的链表合并，保证合并后的结果依然是从小到大的顺序
 * </p>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 */
public class MergeSorted {

  public static Node merge(Node node1, Node node2) {

    if (node1 == null) {
      return node2;
    }
    if (node2 == null) {
      return node1;
    }

    Node p1 = node1;
    Node p2 = node2;
    Node head;

    if (p1.getValue().compareTo(p2.getValue()) <= 0) {
      head = p1;
      p1 = p1.getNext();
    } else {
      head = p2;
      p2 = p2.getNext();
    }

    Node tail = head;
    while (p1 != null && p2 != null) {
      if (p1.getValue().compareTo(p2.getValue()) <= 0) {
        tail.setNext(p1);
        p1 = p1.getNext();
      } else {
        tail.setNext(p2);
        p2 = p2.getNext();
      }
      tail = tail.getNext();
    }

    if (p1 == null) {
      tail.setNext(p2);
    }

    if (p2 == null) {
      tail.setNext(p1);
    }

    return head;
  }

}
