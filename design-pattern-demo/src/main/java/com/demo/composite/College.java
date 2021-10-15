package com.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * College Composite
 *
 * @author gnl
 */

public class College extends Component {

    /**
     * components 存放Department
     */
    private List<Component> components = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    /**
     * 输出 College 包含的 Department
     * @return void
     */
    @Override
    protected void show() {
        System.out.println("==="+getName()+"===");
        components.stream().map(Component::getName).forEach(System.out::println);
    }
}
