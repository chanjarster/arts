package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import java.util.Arrays;

import static me.chanjar.javarelearn.algorithm.singlelinklist.Reverse.solve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseTest {

  @Test
  public void testReverseOneElement() {

    Node a = new Node("A", null);

    Node reverse = solve(a);

    assertEquals(a, reverse);
    assertNull(null, a.getNext());
    assertEquals("A", a.getValue());

  }

  @Test
  public void testReverse() {

    Node d = new Node("D", null);
    Node a = new Node("A", new Node("B", new Node("C", d)));

    Node reversed = solve(a);

    assertEquals(d, reversed);
    assertEquals(Arrays.asList("D", "C", "B", "A"), reversed.collectValues());
  }
}
