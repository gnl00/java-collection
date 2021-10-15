package com.demo.iterator;

import java.util.Iterator;

/**
 * ConcreteArrayIterator
 * @author gnl
 */

public class ConcreteArrayIterator implements Iterator {

    private Department[] departments;
    private int index = 0;

    public ConcreteArrayIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.length || departments[index] == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[index];
        index += 1;
        return department;
    }
}
