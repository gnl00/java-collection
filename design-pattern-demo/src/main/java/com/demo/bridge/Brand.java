package com.demo.bridge;

/**
 * Brand
 *
 * @author gnl
 */

public interface Brand {
    void sale();
}

class Lenovo implements Brand {

    @Override
    public void sale() {
        System.out.println("lenovo");
    }
}

class Dell implements Brand {

    @Override
    public void sale() {
        System.out.println("dell");
    }
}

class HP implements Brand {

    @Override
    public void sale() {
        System.out.println("hp");
    }
}
