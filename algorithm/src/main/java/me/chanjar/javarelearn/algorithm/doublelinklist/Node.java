package me.chanjar.javarelearn.algorithm.doublelinklist;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Node {

  private Node next;
  private Node prev;
  private String value;

  public static List<String> collectValue(Node node) {

    List<String> result = new ArrayList<>();

    Node curr = node;
    do {
      result.add(curr.getValue());
      curr = curr.getNext();
    } while (curr != null);
    return result;
  }

  public static List<String> collectValueReversely(Node node) {

    List<String> result = new ArrayList<>();

    Node curr = node;
    do {
      result.add(curr.getValue());
      curr = curr.getPrev();
    } while (curr != null);
    return result;
  }

  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
    if (next != null) {
      next.prev = this;
    }
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
        .add("value='" + value + "'")
        .toString();
  }
}
