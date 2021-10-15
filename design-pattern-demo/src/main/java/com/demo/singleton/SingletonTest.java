package com.demo.singleton;

/**
 * 单例模式
 * 采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象的实例
 * 并且该类只提供一个取得其对象实例的方法
 *
 * @author gnl
 */

public class SingletonTest {
    public static void main(String[] args) {
        Singleton1 obj1 = Singleton1.getInstance();
        Singleton1 obj2 = Singleton1.getInstance();

        // true
        System.out.println(obj1 == obj2);

        Singleton4 instance1 = Singleton4.INSTANCE;
        Singleton4 instance2 = Singleton4.INSTANCE;
        System.out.println(instance1 == instance2);
    }
}

/**
 * 饿汉式
 * 优 线程安全
 * 缺 对象加载在内存中的时间长
 */
class Singleton1 {

    // 私有化构造方法，确保只能通过向外暴露的public方法获取对象
    private Singleton1() {}

    // 加载类的时候就将对象创建好
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

}

/**
 * 懒汉式
 * 优 延迟对象创建时间
 * 缺 线程不安全 需要使用同步代码来进行双重检查保证线程安全
 */
class Singleton2 {

    private Singleton2() {}

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }

}

/**
 * 静态内部类
 */
class Singleton3 {
    private Singleton3(){}

    /**
     * 提供一个静态内部类，该类中声明一个返回对象类型的静态属性
     */
    private static class Singleton3Instance {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Singleton3Instance.INSTANCE;
    }
}

/**
 * 枚举实现单例
 */
enum Singleton4 {
    INSTANCE;
    public void getInstance() {
        System.out.println("get enum instance...");
    }
}
