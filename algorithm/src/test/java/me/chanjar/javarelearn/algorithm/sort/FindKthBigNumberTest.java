package me.chanjar.javarelearn.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindKthBigNumberTest {

  @Test
  public void testFindKthBigNumber() {

    assertEquals(4, FindKthBigNumber.findKthBigNumber(new int[] { 1, 2, 3, 4 }, 1));
    assertEquals(3, FindKthBigNumber.findKthBigNumber(new int[] { 1, 2, 3, 4 }, 2));
    assertEquals(2, FindKthBigNumber.findKthBigNumber(new int[] { 1, 2, 3, 4 }, 3));
    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 2, 3, 4 }, 4));

    assertEquals(4, FindKthBigNumber.findKthBigNumber(new int[] { 4, 3, 2, 1 }, 1));
    assertEquals(3, FindKthBigNumber.findKthBigNumber(new int[] { 4, 3, 2, 1 }, 2));
    assertEquals(2, FindKthBigNumber.findKthBigNumber(new int[] { 4, 3, 2, 1 }, 3));
    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 4, 3, 2, 1 }, 4));

    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 1, 1, 1 }, 1));
    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 1, 1, 1 }, 2));
    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 1, 1, 1 }, 3));
    assertEquals(1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 1, 1, 1 }, 4));

    assertEquals(-1, FindKthBigNumber.findKthBigNumber(new int[] { 1, 1, 1, 1 }, 5));

  }

}
