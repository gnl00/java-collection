package com.demo.reflection.proxy;

/**
 * 静态代理
 * 代理类和被代理类在编译期间就已经确定
 * @author gnl
 */

public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理对象
        ClothFactory clothFactory = new ClothFactory();

        // 创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(clothFactory);

        // 代理对象执行方法
        proxyFactory.doProduce();
    }
}

interface Factory {

    /**
     * doProduce
     */
    void doProduce();
}

/**
 * 代理类
 */
class ProxyFactory implements Factory {

    private Factory factory;

    public ProxyFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void doProduce() {
        System.out.println("代理工厂做准备工作哦");

        factory.doProduce();

        System.out.println("代理工厂做后续工作工作哦");
    }
}

class ClothFactory implements Factory {
    @Override
    public void doProduce() {
        System.out.println("服装厂进行工作。。。");
    }
}




