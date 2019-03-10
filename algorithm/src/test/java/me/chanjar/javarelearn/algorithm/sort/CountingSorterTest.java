package me.chanjar.javarelearn.algorithm.sort;

public class CountingSorterTest extends SorterTestBase {
  @Override
  protected Sorter getSorter() {
    return new CountingSorter();
  }
}
