package com.demo.composite;

/**
 * Department Leaf
 *
 * @author gnl
 */

public class Department extends Component {

    // 叶子节点，不需要集合

    public Department(String name, String desc) {
        super(name, desc);
    }

    // 叶子节点，不需要重写add和remove方法

    @Override
    protected void show() {
        System.out.println(getName());
    }
}
