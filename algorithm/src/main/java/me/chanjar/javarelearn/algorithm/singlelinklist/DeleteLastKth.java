package me.chanjar.javarelearn.algorithm.singlelinklist;

/**
 * <a href="https://time.geekbang.org/column/article/41149">极客时间 - 数据结构与算法之美 - 07 | 链表（下）：如何轻松写出正确的链表代码？</a>
 * <p>
 * 删除链表倒数第k个结点
 * </p>
 * <a href="https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java">参考答案</a>
 * <p>
 * 解决思路：两个指针，curr：从第一个node开始，kthAhead：从第k个node开始，两个每次都前进一步。如果kthAhead到达tail，则删除curr。
 * </p>
 */
public class DeleteLastKth {

  public static Node solve(Node node, int k) {

    if (k <= 0) {
      return node;
    }
    if (node == null) {
      return node;
    }
    Node head = node;
    Node kthAhead = node;
    for (int i = 0; i < k - 1; i++) {
      kthAhead = kthAhead.getNext();
      if (kthAhead == null) {
        // k > n, do nothing
        return node;
      }
    }

    Node curr = node;
    Node prev = null;
    while (kthAhead.getNext() != null) {

      kthAhead = kthAhead.getNext();
      prev = curr;
      curr = curr.getNext();
    }

    if (prev != null) {
      prev.setNext(curr.getNext());
      curr.setNext(null);
      return head;
    }

    // 说明删除的就是head节点
    Node second = head.getNext();
    head.setNext(null);
    return second;

  }
}
