package me.chanjar.javarelearn.algorithm.doublelinklist;

import org.junit.Test;

import java.util.Arrays;

import static me.chanjar.javarelearn.algorithm.doublelinklist.Node.collectValue;
import static me.chanjar.javarelearn.algorithm.doublelinklist.Node.collectValueReversely;
import static me.chanjar.javarelearn.algorithm.doublelinklist.Reverse.solve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 双向链表反转
 */
public class ReverseTest {

  @Test
  public void testSingleElement() {
    System.out.println(this);
    Node a = new Node("A", null);
    solve(a);
    assertNull(null, a.getNext());
    assertNull(null, a.getPrev());
  }

  @Test
  public void testEvenElements() {
    System.out.println(this);

    Node d = new Node("D", null);
    Node a = new Node("A", new Node("B", new Node("C", d)));

    Node reversed = solve(a);
    assertEquals(d, reversed);

    assertEquals(Arrays.asList("A", "B", "C", "D"), collectValueReversely(a));
    assertEquals(Arrays.asList("D", "C", "B", "A"), collectValue(d));

  }
}
