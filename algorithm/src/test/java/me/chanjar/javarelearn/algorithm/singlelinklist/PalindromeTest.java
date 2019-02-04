package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

  @Test
  public void testEmpty() {
    assertEquals(true, Palindrome.solve(null));
  }

  @Test
  public void testEvenElements() {
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "A" })));
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "A", "A", "A"})));
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "B", "B", "A"})));
  }

  @Test
  public void testEvenElementsBad() {
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "B" })));
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "A", "B", "A" })));
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "A", "B", "B" })));
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "B", "A", "B" })));
  }

  @Test
  public void testOddElements() {
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A" })));
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "A", "A" })));
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "B", "A" })));
    assertEquals(true, Palindrome.solve(Node.create(new String[] { "A", "B", "C", "B", "A" })));
  }

  @Test
  public void testOddElementsBad() {
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "A", "B" })));
    assertEquals(false, Palindrome.solve(Node.create(new String[] { "A", "B", "C", "B", "B" })));
  }


}
