package me.chanjar.javarelearn.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个数组中查找第K大数组
 * <p>
 * 题目来源：<a href="https://time.geekbang.org/column/article/41913">极客时间 - 数据结构与算法之美 - 12 | 排序（下）：合并10个有序文件</a>
 * </p>
 * 笔记：<a href="https://chanjarster.github.io/post/algo/14-merge-sorted-files/"></a>
 */
public class MergeSortedFiles {

  public static void merge(List<FileIterator> fileIteratorList) {

    FileWriter fileWriter = null;

    // 记录还没有遍历结束的文件
    List<FileIterator> notEndingFileIterators = new ArrayList<>(fileIteratorList);

    while (!notEndingFileIterators.isEmpty()) {

      FileIterator min = getMin(notEndingFileIterators);
      fileWriter.writeLine(min.getLine());

      if (!min.nextLine()) {
        // 该文件已经遍历到尾了，将其移除
        notEndingFileIterators.remove(min);
      }

    }
  }

  private static FileIterator getMin(List<FileIterator> notEndingFileIterators) {

    FileIterator min = null;

    for (FileIterator fi : notEndingFileIterators) {
      if (min == null) {
        min = fi;
        continue;
      }

      if (fi.getLine().compareTo(min.getLine()) < 0) {
        min = fi;
      }
    }
    return min;
  }

}

/**
 * 这里不做实现，只表达意思
 */
interface FileIterator {

  /**
   * 返回当前行
   *
   * @return
   */
  String getLine();

  /**
   * 前进到下一行
   *
   * @return 如果已经是最后一行了，返回false。否则返回true。
   */
  boolean nextLine();

}

/**
 * 这里不做实现，只表达意思
 */
interface FileWriter {
  /**
   * 写一行到文件中
   *
   * @param line
   */
  void writeLine(String line);
}
