package me.chanjar.javarelearn.classloader;

public class Foo {

  public Foo() {
    System.out.println("Foo's ClassLoader: " + Foo.class.getClassLoader());
    System.out.println("Bar's ClassLoader: " + Bar.class.getClassLoader());
  }

}
