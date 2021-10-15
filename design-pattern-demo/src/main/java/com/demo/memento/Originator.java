package com.demo.memento;

/**
 * Originator 保存状态的对象
 *
 * @author gnl
 */

public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * saveMementoState 将对象状态保存
     * @return com.demo.memento.Memento
     * @author gnl
     */
    public Memento saveMementoState() {
        return new Memento(this.state);
    }

    /**
     * getMementoState 通过备忘录，恢复对象状态
     * @param memento
     * @return void
     * @author gnl
     */
    public void getMementoState(Memento memento) {
        this.state = memento.getState();
    }

}
