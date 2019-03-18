package me.chanjar.javarelearn.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SearchTestBase {

  private final Search search = getSearch();

  protected abstract Search getSearch();

  @Test
  public void testSearch() {

    assertEquals(-1, search.search(new int[0], 1));

    assertEquals(-1, search.search(new int[] { 1 }, 0));
    assertEquals(0, search.search(new int[] { 1 }, 1));
    assertEquals(-1, search.search(new int[] { 1 }, 2));

    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 0));

    assertEquals(0, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 1));
    assertEquals(1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 2));
    assertEquals(2, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 3));
    assertEquals(3, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 4));
    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 5));
    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 6));
    assertEquals(4, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 7));
    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 8));
    assertEquals(5, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 9));
    assertEquals(6, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 10));
    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 11));
    assertEquals(7, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 30));

    assertEquals(-1, search.search(new int[] { 1, 2, 3, 4, 7, 9, 10, 30 }, 31));
  }

}
