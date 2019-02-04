package me.chanjar.javarelearn.algorithm.looplinklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 用循环链表解决
 * <a href="https://zh.wikipedia.org/wiki/%E7%BA%A6%E7%91%9F%E5%A4%AB%E6%96%AF%E9%97%AE%E9%A2%98">约瑟夫问题</a>
 * <p>
 * 思路：利用循环链表，模拟整个过程，得到最终结果。
 * </p>
 * <ul>
 * <li>时间复杂度：O(n)</li>
 * <li>空间复杂度：O(1)</li>
 * </ul>
 */
public class JosephProblem {

  public static List<Node> solve(Node node, int step) {

    List<Node> result = new ArrayList<>();

    final Node initial = node;
    Node curr = initial;
    while (curr.getNext() != curr) {
      Node prev = null;
      for (int i = 0; i < step; i++) {
        prev = curr;
        curr = curr.getNext();
      }

      result.add(curr);

      prev.setNext(curr.getNext());
      curr.setNext(null);
      curr = prev.getNext();
    }

    return result;
  }

}
