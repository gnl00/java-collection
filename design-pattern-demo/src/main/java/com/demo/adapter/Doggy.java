package com.demo.adapter;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-04-02 15:19
 */

public class Doggy implements Dog {
    @Override
    public void bark() {
        System.out.println("this little doggy is barking");
    }

    @Override
    public void run() {
        System.out.println("this little doggy is running");
    }
}
