package me.chanjar.javarelearn.classloader;

import com.sun.javafx.util.Logging;

public class PrintClassLoaderClassLoader {

  public static void main(String[] args) {

    // Launcher$ExtClassLoader
    System.out.println("ClassLoader for Logging's ClassLoader: " + Logging.class.getClassLoader().getClass().getClassLoader());
    // Launcher$AppClassLoader
    System.out.println("ClassLoader for this class's ClassLoader: " + PrintClassLoaderClassLoader.class.getClassLoader().getClass().getClassLoader());
    // 自定义ClassLoader
    System.out.println("ClassLoader for custom ClassLoader: " + DummyClassLoader.class.getClassLoader().getClass().getClassLoader());
  }

  public static class DummyClassLoader extends ClassLoader {

  }
}
