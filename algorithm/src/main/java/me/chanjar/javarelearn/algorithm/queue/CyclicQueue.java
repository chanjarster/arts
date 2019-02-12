package me.chanjar.javarelearn.algorithm.queue;

/**
 * <a href="https://time.geekbang.org/column/article/41330">极客时间 - 数据结构与算法之美 - 09 | 队列：队列在线程池等有限资源池中的应用</a>
 * <p>循环队列</p>
 */
public class CyclicQueue {

  private final Object[] array;

  private final int capacity;
  private int head = 0;
  private int tail = 0;

  public CyclicQueue(int capacity) {
    // 因为tail指向的是null，浪费掉一个位置
    this.capacity = capacity + 1;
    this.array = new Object[this.capacity];
  }

  public int size() {
    if (tail >= head) {
      return tail - head;
    }
    return capacity + tail - head;
  }

  public boolean isFull() {
    if (capacity == 0) {
      return true;
    }
    return (tail + 1) % capacity == head;
  }

  public boolean isEmpty() {
    if (capacity == 1) {
      return false;
    }
    return head == tail;
  }

  public boolean enqueue(Object e) {
    if (isFull()) {
      return false;
    }
    array[tail] = e;
    tail = (tail + 1) % capacity;
    return true;

    // 0 1 2 3 4 5 6 7
  }

  public Object dequeue() {
    if (isEmpty()) {
      return null;
    }
    Object ret = array[head];
    array[head] = null;
    head = (head + 1) % capacity;
    return ret;
  }

}
