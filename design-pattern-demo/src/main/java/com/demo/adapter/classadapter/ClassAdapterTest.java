package com.demo.adapter.classadapter;

/**
 * ClassAdapterTest 类适配器
 *
 * @author gnl
 */

public class ClassAdapterTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charge(new VoltageAdapter());
    }
}

interface Voltage5V{
    int output5V();
}

class Voltage220V {
    public int output220V() {
        return 220;
    }
}

class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int source = output220V();
        return source/44;
    }
}

class Phone {
    public void charge(Voltage5V voltage5V) {
        if (voltage5V.output5V() == 5) {
            System.out.println("Voltage is 5V, charging now...");
        } else {
            System.out.println("Voltage is not 5V, can not charge");
        }
    }
}