package jdk.test.classloader.impl;
import jdk.test.classloader.MyInterface;

// javac ../../main/java/jdk/test/classloader/MyInterface.java MyClassLoaderDemoClass.java
public class MyClassLoaderDemoClass implements MyInterface {
    public void sayHello() {
        System.out.println("hello from class in resource folder");
    }
}