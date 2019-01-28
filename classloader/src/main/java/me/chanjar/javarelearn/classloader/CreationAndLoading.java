package me.chanjar.javarelearn.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试某类被某ClassLoader加载后，其所引用的类的ClassLoader是否与其相同。
 * <p>
 * 比如、A类引用B类，A类被ClassLoaderX加载，那么B类是否同样也被ClassLoaderX加载。
 * </p>
 * 测试方法
 * <p>
 * 1. <code>mvn clean package</code>
 * </p>
 * 2. copy classloader.jar 到 /tmp 目录下
 * <p>
 * 3. java -cp target/classloader.jar me.chanjar.javarelearn.classloader.CreationAndLoading
 * </p>
 */
public class CreationAndLoading {

  public static void main(String[] args) throws Exception {
    // ucl1的parent是bootstrap class loader
    URLClassLoader ucl1 = new NamedURLClassLoader("user-defined 1", new URL[] { new URL("file:///tmp/classloader.jar") }, null);
    // ucl1是ucl2的parent
    URLClassLoader ucl2 = new NamedURLClassLoader("user-defined 2", new URL[0], ucl1);
    Class<?> fooClass2 = ucl2.loadClass("me.chanjar.javarelearn.classloader.Foo");
    fooClass2.newInstance();
  }

}



