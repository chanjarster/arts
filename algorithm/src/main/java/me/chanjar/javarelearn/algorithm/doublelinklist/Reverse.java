package me.chanjar.javarelearn.algorithm.doublelinklist;

public class Reverse {

  public static Node solve(Node node) {

    Node prev = null;
    Node curr = node;

    while (curr != null) {

      Node next = curr.getNext();
      curr.setPrev(next);
      curr.setNext(prev);
      prev = curr;
      curr = next;

    }

    return prev;
  }

}
