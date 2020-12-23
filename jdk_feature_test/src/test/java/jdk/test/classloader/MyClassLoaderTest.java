package jdk.test.classloader;

import jdk.test.classloader.impl.MyClassLoaderDemoClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MyClassLoaderTest {

    @Test
    public void test_noParent() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> myClass = loader.loadClass("jdk.test.classloader.impl.MyClassLoaderDemoClass");
        assertThat(myClass).isNotNull();
        Constructor<?> constructor = myClass.getConstructor();
        Object o = constructor.newInstance();
        Method sayHelloMethod = myClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(o); // print hello from class in resource folder

        MyInterface instanceFromResource = (MyInterface) o;
        instanceFromResource.sayHello(); // print hello from class in resource folder

        MyClassLoaderDemoClass instance2 = new MyClassLoaderDemoClass();
        instance2.sayHello(); // hello from class in package

        Class<?> fornameClass = Class.forName("jdk.test.classloader.impl.MyClassLoaderDemoClass");
        Constructor<?> fornameConstructor = fornameClass.getConstructor();
        Object o1 = fornameConstructor.newInstance();
        Method sayHello = fornameClass.getDeclaredMethod("sayHello");
        sayHello.invoke(o1); // hello from class in package


        myClass = loader.loadClass("jdk.test.classloader.impl.MyClassLoaderDemoClass");
        constructor = myClass.getConstructor();
        Object o3 = constructor.newInstance();
        sayHelloMethod = myClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(o3);


    }


    @Test
    public void test_withParent() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> myClass = loader.loadClass("jdk.test.classloader.impl.MyClassLoaderDemoClass");
        assertThat(myClass).isNotNull();
        Constructor<?> constructor = myClass.getConstructor();
        Object o = constructor.newInstance();
        Method sayHelloMethod = myClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(o);

        MyInterface instanceFromResource = (MyInterface) o;
        instanceFromResource.sayHello();


        MyClassLoaderDemoClass instance2 = new MyClassLoaderDemoClass();
        instance2.sayHello();
    }

}