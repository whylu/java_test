package jdk.test.classloader;

import jdk.test.classloader.impl.MyClassLoaderDemoClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * run this command before run test
 * ```sh
 *   cd src/test/resources
 *   javac ../../main/java/jdk/test/classloader/MyInterface.java MyClassLoaderDemoClass.java
 * ```
 *
 *
 如果classpath已經有相同名字的class，會依照 customizedClassLoader 實作有不同情況：
 - 沒有override loadClass(String name, boolean resolve):
 - parent如果是預設(systemClassLoader), 則會抓到classpath裡面的
 - parent如果是null, 則會執行customizedClassLoader.findClass()
 - override loadClass(String name, boolean resolve):
 根據 override 的內容

 Class.forName 會拿到 classpath 裡面的 class
 外部class 必須從 customizedClassLoader 取得
 jvm 裡面可以載入同樣名字的 class，存在各自的classloader裡面
 比如說tomcat裡面不同web app，都有自己的 classloader 運行時互不相干
 */
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