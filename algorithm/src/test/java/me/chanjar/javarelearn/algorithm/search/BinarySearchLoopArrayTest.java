package me.chanjar.javarelearn.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchLoopArrayTest {

  @Test
  public void testSearch() {

    BinarySearchLoopArray search = new BinarySearchLoopArray();

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

  @Test
  public void testSearchLoop() {

    BinarySearchLoopArray search = new BinarySearchLoopArray();

    assertEquals(-1, search.search(new int[] { 4, 1, 2, 3 }, 0));
    assertEquals(-1, search.search(new int[] { 3, 4, 1, 2 }, 0));
    assertEquals(-1, search.search(new int[] { 2, 3, 4, 1 }, 0));

    assertEquals(1, search.search(new int[] { 4, 1, 2, 3 }, 1));
    assertEquals(2, search.search(new int[] { 3, 4, 1, 2 }, 1));
    assertEquals(3, search.search(new int[] { 2, 3, 4, 1 }, 1));

    assertEquals(2, search.search(new int[] { 4, 1, 2, 3 }, 2));
    assertEquals(3, search.search(new int[] { 3, 4, 1, 2 }, 2));
    assertEquals(0, search.search(new int[] { 2, 3, 4, 1 }, 2));

    assertEquals(3, search.search(new int[] { 4, 1, 2, 3 }, 3));
    assertEquals(0, search.search(new int[] { 3, 4, 1, 2 }, 3));
    assertEquals(1, search.search(new int[] { 2, 3, 4, 1 }, 3));

    assertEquals(0, search.search(new int[] { 4, 1, 2, 3 }, 4));
    assertEquals(1, search.search(new int[] { 3, 4, 1, 2 }, 4));
    assertEquals(2, search.search(new int[] { 2, 3, 4, 1 }, 4));

  }

  @Test
  public void testFindHeadPos() {

    BinarySearchLoopArray search = new BinarySearchLoopArray();

    assertEquals(1, search.findHeadPos(new int[] { 4, 1, 2, 3 }));
    assertEquals(2, search.findHeadPos(new int[] { 3, 4, 1, 2 }));
    assertEquals(3, search.findHeadPos(new int[] { 2, 3, 4, 1 }));

    assertEquals(1, search.findHeadPos(new int[] { 5, 1, 2, 3, 4 }));
    assertEquals(2, search.findHeadPos(new int[] { 4, 5, 1, 2, 3 }));
    assertEquals(3, search.findHeadPos(new int[] { 3, 4, 5, 1, 2 }));
    assertEquals(4, search.findHeadPos(new int[] { 2, 3, 4, 5, 1 }));
  }
}
