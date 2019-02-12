package me.chanjar.javarelearn.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicQueueTest {

  @Test
  public void testEnqueueZeroCapacity() {

    CyclicQueue queue = new CyclicQueue(0);
    assertEquals(0, queue.size());
    assertEquals(true, queue.isFull());
    assertEquals(false, queue.isEmpty());

    assertEquals(false, queue.enqueue("A"));
    assertEquals(false, queue.enqueue("B"));
    assertEquals(false, queue.enqueue("C"));

    assertEquals(0, queue.size());
    assertEquals(true, queue.isFull());
    assertEquals(false, queue.isEmpty());
  }

  @Test
  public void testDequeueZeroCapacity() {
    CyclicQueue queue = new CyclicQueue(0);

    assertNull(queue.dequeue());
    assertNull(queue.dequeue());
    assertNull(queue.dequeue());

    assertEquals(0, queue.size());
    assertEquals(true, queue.isFull());
    assertEquals(false, queue.isEmpty());
  }

  @Test
  public void testEnqueueOneCapacity() {
    CyclicQueue queue = new CyclicQueue(1);
    assertEquals(0, queue.size());
    assertEquals(false, queue.isFull());
    assertEquals(true, queue.isEmpty());

    assertTrue(queue.enqueue("A"));
    assertFalse(queue.enqueue("B"));
    assertFalse(queue.enqueue("D"));

    assertEquals(1, queue.size());
    assertEquals(true, queue.isFull());
    assertEquals(false, queue.isEmpty());
  }

  @Test
  public void testDequeueOneCapacity() {

    CyclicQueue queue = new CyclicQueue(1);

    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    assertEquals("A", queue.dequeue());
    assertNull(queue.dequeue());
    assertNull(queue.dequeue());

    assertEquals(0, queue.size());
    assertEquals(false, queue.isFull());
    assertEquals(true, queue.isEmpty());

  }

  @Test
  public void testFourCapacity() {

    CyclicQueue queue = new CyclicQueue(4);

    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    queue.enqueue("D");

    assertEquals("A", queue.dequeue());
    assertEquals("B", queue.dequeue());
    assertEquals("C", queue.dequeue());
    assertEquals("D", queue.dequeue());

    assertEquals(0, queue.size());
    assertEquals(false, queue.isFull());
    assertEquals(true, queue.isEmpty());
  }

  @Test
  public void testFourCapacityLoop() {

    // 测试head、tail循环
    CyclicQueue queue = new CyclicQueue(4);

    assertEquals(true, queue.enqueue("A"));
    assertEquals(true, queue.enqueue("B"));
    assertEquals(true, queue.enqueue("C"));
    assertEquals(true, queue.enqueue("D"));
    assertEquals(4, queue.size());

    assertEquals("A", queue.dequeue());
    assertEquals(3, queue.size());
    assertEquals(true, queue.enqueue("E"));
    assertEquals(4, queue.size());

    assertEquals("B", queue.dequeue());
    assertEquals(3, queue.size());
    assertEquals(true, queue.enqueue("F"));
    assertEquals(4, queue.size());

    assertEquals("C", queue.dequeue());
    assertEquals(3, queue.size());
    assertEquals(true, queue.enqueue("G"));
    assertEquals(4, queue.size());

    assertEquals("D", queue.dequeue());
    assertEquals(3, queue.size());
    assertEquals(true, queue.enqueue("H"));
    assertEquals(4, queue.size());

    assertEquals("E", queue.dequeue());
    assertEquals(3, queue.size());
    assertEquals("F", queue.dequeue());
    assertEquals(2, queue.size());
    assertEquals("G", queue.dequeue());
    assertEquals(1, queue.size());
    assertEquals("H", queue.dequeue());
    assertEquals(0, queue.size());

    assertEquals(0, queue.size());
    assertEquals(false, queue.isFull());
    assertEquals(true, queue.isEmpty());
  }

}
