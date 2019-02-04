package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import static me.chanjar.javarelearn.algorithm.singlelinklist.FindMiddle.solve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FindMIddleTest {

  @Test
  public void testEmpty() {
    Node middle = solve(null);
    assertNull(middle);
  }

  @Test
  public void testSingleElement() {
    Node node = Node.create(new String[] { "A" });
    Node middle = solve(node);
    assertEquals(true, middle == node);
  }

  @Test
  public void testOddElement() {

    Node node = Node.create(new String[] { "A", "B", "C" });
    Node middle = solve(node);
    assertEquals(middle.getValue(), "B");

  }

  @Test
  public void testEvenElement() {
    Node node = Node.create(new String[] { "A", "B", "C", "D" });
    Node middle = solve(node);
    assertEquals(middle.getValue(), "B");

  }
}
