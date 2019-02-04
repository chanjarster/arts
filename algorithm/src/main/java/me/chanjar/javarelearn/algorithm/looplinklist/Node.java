package me.chanjar.javarelearn.algorithm.looplinklist;

import java.util.StringJoiner;

public class Node {

  private String value;
  private Node next;

  public static Node create(String[] values) {

    Node head = new Node(values[0], null);
    Node prev = head;
    for (int i = 1; i < values.length ; i++) {
      Node node = new Node(values[i], null);
      prev.setNext(node);
      prev = node;
    }

    prev.setNext(head);
    return head;
  }

  protected Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }

  public String getValue() {
    return value;
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
