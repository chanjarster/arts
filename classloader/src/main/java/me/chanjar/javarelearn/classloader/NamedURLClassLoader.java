package me.chanjar.javarelearn.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class NamedURLClassLoader extends URLClassLoader {

  private String name;

  public NamedURLClassLoader(String name, URL[] urls, ClassLoader parent) {
    super(urls, parent);
    this.name = name;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    System.out.println("ClassLoader: " + this.name + " findClass(" + name + ")");
    return super.findClass(name);
  }

  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    System.out.println("ClassLoader: " + this.name + " loadClass(" + name + ")");
    return super.loadClass(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
