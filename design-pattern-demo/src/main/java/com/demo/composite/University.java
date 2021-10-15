package com.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * University Composite
 * 可以管理College
 *
 * @author gnl
 */

public class University extends Component {

    /**
     * components 存放College
     */
    private List<Component> components = new ArrayList<>();

    public University(String name, String desc) {
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
     * 输出 University 包含的 College
     * @return void
     */
    @Override
    protected void show() {
        System.out.println("==="+getName()+"===");
        components.stream().map(Component::getName).forEach(System.out::println);
    }
}
