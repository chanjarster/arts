package me.chanjar.javarelearn.algorithm.singlelinklist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

  @Test
  public void testCapacity0() {

    LRUCache cache = new LRUCache(0);
    cache.put("A");
    assertEquals(0, cache.size());
    cache.put("B");
    assertEquals(0, cache.size());
    cache.put("C");
    assertEquals(0, cache.size());
    assertEquals(Collections.emptyList(), cache.getValues());

  }

  @Test
  public void testCapacity1() {

    LRUCache cache = new LRUCache(1);
    cache.put("A");
    assertEquals(1, cache.size());
    assertEquals(singletonList("A"), cache.getValues());

    cache.put("B");
    assertEquals(1, cache.size());
    assertEquals(singletonList("B"), cache.getValues());

    cache.put("C");
    assertEquals(1, cache.size());
    assertEquals(singletonList("C"), cache.getValues());

    cache.put("C");
    assertEquals(1, cache.size());
    assertEquals(singletonList("C"), cache.getValues());

    cache.put("C");
    assertEquals(1, cache.size());
    assertEquals(singletonList("C"), cache.getValues());

  }

  @Test
  public void testCapacity2() {

    LRUCache cache = new LRUCache(2);
    cache.put("A");
    assertEquals(1, cache.size());
    assertEquals(singletonList("A"), cache.getValues());

    cache.put("B");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("B", "A"), cache.getValues());

    cache.put("A");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("A", "B"), cache.getValues());

    cache.put("C");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("C", "A"), cache.getValues());

    cache.put("A");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("A", "C"), cache.getValues());

    cache.put("A");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("A", "C"), cache.getValues());

    cache.put("C");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("C", "A"), cache.getValues());
  }


  @Test
  public void testCapacity3() {

    LRUCache cache = new LRUCache(3);
    cache.put("A");
    assertEquals(1, cache.size());
    assertEquals(singletonList("A"), cache.getValues());

    cache.put("B");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("B", "A"), cache.getValues());

    cache.put("A");
    assertEquals(2, cache.size());
    assertEquals(Arrays.asList("A", "B"), cache.getValues());

    cache.put("C");
    assertEquals(3, cache.size());
    assertEquals(Arrays.asList("C", "A", "B"), cache.getValues());

    cache.put("A");
    assertEquals(3, cache.size());
    assertEquals(Arrays.asList("A", "C", "B"), cache.getValues());

    cache.put("A");
    assertEquals(3, cache.size());
    assertEquals(Arrays.asList("A", "C", "B"), cache.getValues());

    cache.put("B");
    assertEquals(3, cache.size());
    assertEquals(Arrays.asList("B", "A", "C"), cache.getValues());

    cache.put("D");
    assertEquals(3, cache.size());
    assertEquals(Arrays.asList("D", "B", "A"), cache.getValues());
  }
}
