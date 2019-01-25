package me.chanjar.javarelearn.classloader;

import com.sun.javafx.util.Logging;

import java.util.ArrayList;

/**
 * 打印基本ClassLoader
 */
public class PrintClassLoader {

  public static void main(String[] args) {

    System.out.println("ClassLoader for ArrayList: " + ArrayList.class.getClassLoader());
    System.out.println("ClassLoader for Logging: " + Logging.class.getClassLoader());
    System.out.println("ClassLoader for this class: " + PrintClassLoader.class.getClassLoader());

  }

}
