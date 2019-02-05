package me.chanjar.javarelearn.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

  @Test
  public void testPush() {
    Stack stack = new Stack();
    assertEquals(0, stack.size());
    stack.push("A");
    assertEquals(1, stack.size());
    stack.push("A");
    assertEquals(2, stack.size());
    stack.push("A");
    assertEquals(3, stack.size());
  }

  @Test
  public void testPop() {
    Stack stack = new Stack();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    assertEquals("C", stack.pop());
    assertEquals(2, stack.size());
    assertEquals("B", stack.pop());
    assertEquals(1, stack.size());
    assertEquals("A", stack.pop());
    assertEquals(0, stack.size());
    assertEquals(null, stack.pop());
    assertEquals(0, stack.size());
  }
}
