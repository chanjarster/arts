package me.chanjar.javarelearn.algorithm.singlelinklist;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Node {

  private String value;
  private Node next;

  public static Node create(String... values) {

    Node head = new Node(values[0], null);
    Node prev = head;
    for (int i = 1; i < values.length; i++) {
      Node node = new Node(values[i], null);
      prev.setNext(node);
      prev = node;
    }

    return head;
  }

  protected Node() {
  }

  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }

  /**
   * 按顺序获得链表上的所有值
   *
   * @return
   */
  public List<String> collectValues() {

    List<String> result = new ArrayList<>();

    Node curr = this;
    while (curr != null) {
      result.add(curr.getValue());
      curr = curr.getNext();
    }

    return result;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
        .add("value='" + value + "'")
        .toString();
  }
}
