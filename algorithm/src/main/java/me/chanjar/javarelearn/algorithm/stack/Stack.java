package me.chanjar.javarelearn.algorithm.stack;

import me.chanjar.javarelearn.algorithm.singlelinklist.Node;

public class Stack {

  private Node top;

  private int size;

  public void push(String element) {
    if (top == null) {
      top = new Node(element, null);
      size = 1;
      return;
    }
    top = new Node(element, top);
    size++;
  }

  public String pop() {

    if (top == null) {
      return null;
    }

    String res = top.getValue();
    Node newTop = top.getNext();
    top.setNext(null);
    top = newTop;
    size--;
    return res;
  }

  public String peek() {
    if (top == null) {
      return null;
    }
    return top.getValue();
  }

  public int size() {
    return size;
  }
}
