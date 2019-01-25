package me.chanjar.javarelearn.classloader;

import com.sun.javafx.util.Logging;

/**
 * 打印二维数组的ClassLoader
 */
public class PrintArrayArrayClassLoader {

  public static void main(String[] args) {

    System.out.println("ClassLoader for int[][]: " + new int[0][].getClass().getClassLoader());
    System.out.println("ClassLoader for string[][]: " + new String[0][].getClass().getClassLoader());
    System.out.println("ClassLoader for Logging[][]: " + new Logging[0][].getClass().getClassLoader());
    System.out.println("ClassLoader for this class[][]: " + new PrintArrayClassLoader[0][].getClass().getClassLoader());
    System.out.println("ClassLoader for this Object[][] of this class[]: " + new Object[][]{new PrintArrayArrayClassLoader[0]}.getClass().getClassLoader());

  }
}
