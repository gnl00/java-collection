package com.demo.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * CareTaker
 *
 * @author gnl
 */

public class CareTaker {

    private List<Memento> mementos;

    public CareTaker() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    /**
     * getMemento 获取到第n条备忘录信息
     * @param index
     * @return com.demo.memento.Memento
     * @author gnl
     */
    public Memento getMemento(int index) {
        return mementos.get(index);
    }

}
