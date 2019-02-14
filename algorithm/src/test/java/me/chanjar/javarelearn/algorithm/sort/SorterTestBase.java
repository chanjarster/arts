package me.chanjar.javarelearn.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class SorterTestBase {

  private final Sorter sorter = getSorter();

  protected abstract Sorter getSorter();

  private int[] sortWrapper(int[] a) {
    sorter.sort(a);
    return a;
  }

  @Test
  public void testSort() {

    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 2, 3, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 2, 4, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 3, 2, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 3, 4, 2 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 4, 2, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 1, 4, 3, 2 }));

    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 1, 3, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 1, 4, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 3, 1, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 3, 4, 1 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 4, 1, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 2, 4, 3, 1 }));

    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 1, 2, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 1, 4, 2 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 2, 1, 4 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 2, 4, 1 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 4, 1, 2 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 3, 4, 2, 1 }));

    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 1, 2, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 1, 3, 2 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 2, 1, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 2, 3, 1 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 3, 1, 2 }));
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortWrapper(new int[] { 4, 3, 2, 1 }));

    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, sortWrapper(new int[] { 5, 4, 3, 2, 1 }));

  }

  @Test
  public void testSort2() {

    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 1, 2, 3 }));
    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 1, 3, 2 }));

    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 2, 1, 3 }));
    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 2, 3, 1 }));

    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 3, 1, 2 }));
    assertArrayEquals(new int[] { 1, 1, 2, 3 }, sortWrapper(new int[] { 1, 3, 2, 1 }));
  }

  @Test
  public void testSort3() {

    assertArrayEquals(new int[] { 1 }, sortWrapper(new int[] { 1 }));
  }

}
