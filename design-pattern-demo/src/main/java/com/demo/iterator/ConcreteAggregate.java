package com.demo.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConcreteAggregate
 * @author gnl
 */

public class ConcreteAggregate implements Aggregate {

    private List<Department> departments;

    public ConcreteAggregate() {
        this.departments = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "ConcreteAggregate";
    }

    @Override
    public void addElement(Department department) {
        if (department != null) {
            departments.add(department);
        }
    }

    @Override
    public ConcreteIterator createIterator() {
        return new ConcreteIterator(this.departments);
    }
}
