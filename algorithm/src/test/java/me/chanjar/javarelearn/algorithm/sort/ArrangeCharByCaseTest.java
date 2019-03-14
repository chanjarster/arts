package me.chanjar.javarelearn.algorithm.sort;

import org.junit.Test;

import static me.chanjar.javarelearn.algorithm.sort.ArrangeCharByCase.arrange;
import static org.junit.Assert.assertTrue;

public class ArrangeCharByCaseTest {

  @Test
  public void testSort() {

    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'A' })));

    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a', 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a', 'A' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'A', 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'A', 'A' })));

    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a', 'a', 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a', 'Z', 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'Z', 'Z', 'a' })));
    assertTrue(wellArranged(arrangeWrapper(new char[] { 'Z', 'Z', 'Z' })));

    assertTrue(wellArranged(arrangeWrapper(new char[] { 'a', 'b', 'C', 'd' })));

  }

  private boolean wellArranged(char[] a) {
    if (a.length <= 1) {
      return true;
    }

    int l = 0;
    while (l < a.length) {
      if ('a' <= a[l] && a[l] <= 'z') {
        l++;
      } else {
        break;
      }
    }

    while (l < a.length) {
      if ('A' <= a[l] && a[l] <= 'Z') {
        l++;
      } else {
        return false;
      }
    }

    return true;
  }

  private char[] arrangeWrapper(char[] a) {
    arrange(a);
    return a;
  }
}
