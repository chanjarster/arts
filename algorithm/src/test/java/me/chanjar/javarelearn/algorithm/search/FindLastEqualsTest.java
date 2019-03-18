package me.chanjar.javarelearn.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindLastEqualsTest {

  FindLastEquals search = new FindLastEquals();

  @Test
  public void search() {

    assertEquals(-1, search.search(new int[0], 1));
    assertEquals(0, search.search(new int[] { 1 }, 1));
    assertEquals(-1, search.search(new int[] { 1 }, 2));

    assertEquals(-1, search.search(new int[] { 1, 2, 3 }, 0));
    assertEquals(0, search.search(new int[] { 1, 2, 3 }, 1));
    assertEquals(1, search.search(new int[] { 1, 2, 3 }, 2));
    assertEquals(2, search.search(new int[] { 1, 2, 3 }, 3));
    assertEquals(-1, search.search(new int[] { 1, 2, 3 }, 4));

    assertEquals(-1, search.search(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 0));
    assertEquals(2, search.search(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 1));
    assertEquals(5, search.search(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 2));
    assertEquals(8, search.search(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 3));
    assertEquals(-1, search.search(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 4));
  }
}
