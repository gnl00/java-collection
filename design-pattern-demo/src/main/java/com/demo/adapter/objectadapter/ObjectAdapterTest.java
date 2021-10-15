package com.demo.adapter.objectadapter;

/**
 * ObjectAdapterTest 对象适配器
 *
 * @author gnl
 */

public class ObjectAdapterTest {
    public static void main(String[] args) {
        Voltage5V adapter = new VoltageAdapter(new Voltage220V());
        new Phone().charge(adapter);
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

class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int source = voltage220V.output220V();
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