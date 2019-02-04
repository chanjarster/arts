package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeSortedTest {

  @Test
  public void testAnyNull() {
    assertEquals(Arrays.asList("A"), MergeSorted.merge(Node.create("A"), null).collectValues());
    assertEquals(Arrays.asList("A"), MergeSorted.merge(null, Node.create("A")).collectValues());
    assertNull(MergeSorted.merge(null, null));
  }

  @Test
  public void testOne_OneElement() {
    assertEquals(Arrays.asList("A", "B"), MergeSorted.merge(Node.create("A"), Node.create("B")).collectValues());
    assertEquals(Arrays.asList("A", "B"), MergeSorted.merge(Node.create("B"), Node.create("A")).collectValues());
  }

  @Test
  public void testTwo_TwoElements() {
    assertEquals(Arrays.asList("A", "B", "C", "D"),
        MergeSorted.merge(Node.create("A", "B"), Node.create("C", "D")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D"),
        MergeSorted.merge(Node.create("A", "C"), Node.create("B", "D")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D"),
        MergeSorted.merge(Node.create("A", "D"), Node.create("B", "C")).collectValues());

  }

  @Test
  public void testTwo_ThreeElements() {

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("A", "B", "C"), Node.create("D", "E")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("D", "E"), Node.create("A", "B", "C")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("C", "E"), Node.create("A", "B", "D")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("C", "D"), Node.create("A", "B", "E")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("B", "E"), Node.create("A", "C", "D")).collectValues());

    assertEquals(Arrays.asList("A", "B", "C", "D", "E"),
        MergeSorted.merge(Node.create("B", "C"), Node.create("A", "D", "E")).collectValues());

  }

}
