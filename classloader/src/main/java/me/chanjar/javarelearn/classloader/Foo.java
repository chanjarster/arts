package me.chanjar.javarelearn.classloader;

public class Foo {
  public Foo() {
    System.out.println("Foo's classLoader: " + Foo.class.getClassLoader());
    System.out.println("Bar's classLoader: " + Bar.class.getClassLoader());
  }
}
