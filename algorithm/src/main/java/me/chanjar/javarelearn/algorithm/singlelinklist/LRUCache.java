package me.chanjar.javarelearn.algorithm.singlelinklist;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://time.geekbang.org/column/article/41013">极客时间 - 数据结构与算法之美 - 06 | 链表（上）：如何实现LRU缓存淘汰算法?</a>
 * <p>
 * 单链表实现
 * </p>
 * 复杂度分析：
 * <ul>
 * <li>最好：O(n)</li>
 * <li>最坏：O(n)</li>
 * <li>平均：O(n)</li>
 * </ul>
 */
public class LRUCache {

  private Node head;

  private int size = 0;
  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public void put(String value) {

    if (capacity == 0) {
      return;
    }

    if (size == 0) {
      head = new Node(value, null);
      size = 1;
      return;
    }

    Node entry = findByValue(value);
    if (entry == null) {
      // 该值没有被缓存过
      if (size == capacity) {
        // 容量已满
        Node tailPrev = findTailPrev();
        if (tailPrev == null) {
          // tail没有前置节点，说明tail就是head，直接替换head
          head = new Node(value, null);
        } else {
          // 删除tail，新值成为新的head
          tailPrev.setNext(null);
          head = new Node(value, head);
        }
      } else {
        // 容量未满，新值成为新的head
        head = new Node(value, head);
        size++;
      }
    } else {
      // 该值被缓存过
      Node entryPrev = findPrev(entry);
      if (entryPrev != null) {
        entryPrev.setNext(entry.getNext());
        entry.setNext(head);
        head = entry;
      }
    }

  }

  /**
   * 找到tail节点
   *
   * @return
   */
  private Node findTail() {
    Node walker = head;
    while (walker != null) {
      if (walker.getNext() == null) {
        return walker;
      }
      walker = walker.getNext();
    }
    return null;
  }

  /**
   * 找到tail前一个节点
   *
   * @return
   */
  private Node findTailPrev() {
    Node tail = findTail();
    return findPrev(tail);
  }

  /**
   * 找到某节点前一个节点
   *
   * @param node
   * @return
   */
  private Node findPrev(Node node) {
    Node walker = head;
    while (walker != null) {
      if (walker.getNext() == node) {
        return walker;
      }
      walker = walker.getNext();
    }
    return null;
  }

  /**
   * 找到包含某值的节点
   *
   * @param value
   * @return
   */
  private Node findByValue(String value) {
    Node walker = head;
    while (walker != null) {
      if (walker.getValue().equals(value)) {
        return walker;
      }
      walker = walker.getNext();
    }
    return null;
  }

  /**
   * 按顺序获得Cache中的所有值
   *
   * @return
   */
  public List<String> getValues() {
    if (head != null) {
      return head.collectValues();
    }
    return Collections.emptyList();
  }

  public int size() {
    return size;
  }
}
