package com.demo.composite;

/**
 * Component
 *
 * @author gnl
 */

public abstract class Component {

    private String name;
    private String desc;

    public Component(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * add
     * @param component
     * @return void
     * @author gnl
     */
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    /**
     * remove
     * @param component
     * @return void
     * @author gnl
     */
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    /**
     * show
     * @return void
     * @author gnl
     */
    protected abstract void show();
}
