package com.demo.iterator;

import java.util.Iterator;

/**
 * ConcreteArrayAggregate
 * @author gnl
 */

public class ConcreteArrayAggregate implements Aggregate {

    private Department[] departments;
    private int index = 0;

    public ConcreteArrayAggregate() {
        this.departments = new Department[50];
    }


    @Override
    public String getName() {
        return "ConcreteArrayAggregate";
    }

    @Override
    public void addElement(Department department) {
        departments[index] = department;
        index += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteArrayIterator(departments);
    }
}
