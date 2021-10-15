package com.demo.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxyTest 反射实现动态代理
 *
 * @author gnl
 */

public class DynamicProxyTest {
    public static void main(String[] args) {

        // 可以实现不编写实现类，直接执行某个interface的方法

        // 将返回的Object强制转型为接口
        Animal proxyInstance = (Animal) DProxyFactory.getProxyInstance(new Man());

        System.out.println(proxyInstance.skill());
        proxyInstance.eat("rice");
    }
}

interface Animal {

    /**
     * skill
     * @return java.lang.String
     */
    String skill();

    /**
     * eat
     * @param food
     * @return void
     */
    void eat(String food);

}

/**
 * 被代理类
 */
class Man implements Animal {

    @Override
    public String skill() {
        return "i can work";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat: " + food);
    }
}

/**
 * 被代理类
 */
class Dog implements Animal {

    @Override
    public String skill() {
        return "i can run";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat: " + food);
    }
}

/**
 * 代理类
 */
class MyInvocationHandler implements InvocationHandler {

    /**
     * 注入被代理类
     */
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * invoke 执行方法
     *
     * @param proxy 代理类
     * @param method 执行的方法
     * @param args 方法参数
     * @return 返回方法执行后得到的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass());

        System.out.println("方法执行前 ===》do something");

        // 执行方法 获得返回值
        Object returnVal = method.invoke(obj, args);

        System.out.println("方法执行后 ===》do something");

        return returnVal;
    }
}

/**
 * 代理类工厂 调用工厂返回代理类
 *
 */
class DProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler(obj);

        // 通过JDK提供的一个Proxy.newProxyInstance() 方法创建某个接口对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

