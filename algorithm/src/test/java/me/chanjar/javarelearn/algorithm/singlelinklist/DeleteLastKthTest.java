package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteLastKthTest {

  @Test
  public void testEmpty() {
    assertNull(DeleteLastKth.solve(null, 0));
    assertNull(DeleteLastKth.solve(null, 1));
    assertNull(DeleteLastKth.solve(null, 2));
  }

  @Test
  public void testKgtN() {
    Node one = new Node("A", null);
    assertEquals(one, DeleteLastKth.solve(one, 2));
    assertEquals(one, DeleteLastKth.solve(one, 3));

    Node two = Node.create(new String[] { "A", "B" });
    assertEquals(two, DeleteLastKth.solve(two, 3));
    assertEquals(two, DeleteLastKth.solve(two, 4));
  }

  @Test
  public void testSingleElement() {
    assertNull(DeleteLastKth.solve(new Node("A", null), 1));
  }

  @Test
  public void testTwoElements1() {
    Node two = Node.create(new String[] { "A", "B" });
    Node solve = DeleteLastKth.solve(two, 1);
    assertEquals(Collections.singletonList("A"), solve.collectValues());
  }

  @Test
  public void testTwoElements2() {
    Node two = Node.create(new String[] { "A", "B" });
    Node solve = DeleteLastKth.solve(two, 2);
    assertEquals(Collections.singletonList("B"), solve.collectValues());
  }

  @Test
  public void testThreeElements1() {
    Node two = Node.create(new String[] { "A", "B", "C" });
    Node solve = DeleteLastKth.solve(two, 1);
    assertEquals(Arrays.asList("A", "B"), solve.collectValues());
  }

  @Test
  public void testThreeElements2() {
    Node two = Node.create(new String[] { "A", "B", "C" });
    Node solve = DeleteLastKth.solve(two, 2);
    assertEquals(Arrays.asList("A", "C"), solve.collectValues());
  }

  @Test
  public void testThreeElements3() {
    Node two = Node.create(new String[] { "A", "B", "C" });
    Node solve = DeleteLastKth.solve(two, 3);
    assertEquals(Arrays.asList("B", "C"), solve.collectValues());
  }

}
