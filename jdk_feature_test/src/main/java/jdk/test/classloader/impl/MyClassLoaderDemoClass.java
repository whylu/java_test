package jdk.test.classloader.impl;

import jdk.test.classloader.MyInterface;

public class MyClassLoaderDemoClass implements MyInterface {
    public void sayHello() {
        System.out.println("hello from class in package");
    }
}
