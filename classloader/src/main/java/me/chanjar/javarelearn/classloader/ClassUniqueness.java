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
 * 3. java -cp target/classloader.jar me.chanjar.javarelearn.classloader.ClassUniqueness
 * </p>
 */
public class ClassUniqueness {

  public static void main(String[] args) throws Exception {
    Class<?> fooClass1 = Class.forName("me.chanjar.javarelearn.classloader.ClassUniqueness");
    System.out.println("1st ClassUniqueness's ClassLoader: " + fooClass1.getClassLoader());

    // 故意将parent class loader设置为null，否则就是SystemClassLoader（即ApplicationClassLoader）
    URLClassLoader ucl = new URLClassLoader(new URL[] { new URL("file:///tmp/classloader.jar") }, null);
    Class<?> fooClass2 = ucl.loadClass("me.chanjar.javarelearn.classloader.ClassUniqueness");
    System.out.println("2nd ClassUniqueness's ClassLoader: " + fooClass2.getClassLoader());

    System.out.println("Two ClassUniqueness class equals? " + fooClass1.equals(fooClass2));
  }

}



