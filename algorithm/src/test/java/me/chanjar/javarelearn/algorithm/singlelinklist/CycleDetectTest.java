package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CycleDetectTest {

  @Test
  public void testEmpty() {
    assertEquals(false, CycleDetect.solve(null));
  }

  @Test
  public void testSingleElement() {
    Node node = new Node("A", null);
    assertEquals(false, CycleDetect.solve(node));

  }

  @Test
  public void testSingleElementBad() {
    Node node = new Node("A", null);
    node.setNext(node);
    assertEquals(true, CycleDetect.solve(node));
  }

  @Test
  public void testOddElement() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    a.setNext(b);
    b.setNext(c);
    assertEquals(false, CycleDetect.solve(a));
  }

  @Test
  public void testOddElementBad1() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(a);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testOddElementBad2() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(b);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testOddElementBad3() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(c);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testEvenElement() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    a.setNext(b);
    assertEquals(false, CycleDetect.solve(a));
  }

  @Test
  public void testEvenElementBad1() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    Node d = new Node("D", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(d);
    d.setNext(a);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testEvenElementBad2() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    Node d = new Node("D", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(d);
    d.setNext(b);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testEvenElementBad3() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    Node d = new Node("D", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(d);
    d.setNext(c);
    assertEquals(true, CycleDetect.solve(a));
  }

  @Test
  public void testEvenElementBad4() {
    Node a = new Node("A", null);
    Node b = new Node("B", null);
    Node c = new Node("C", null);
    Node d = new Node("D", null);
    a.setNext(b);
    b.setNext(c);
    c.setNext(d);
    d.setNext(d);
    assertEquals(true, CycleDetect.solve(a));
  }
}
