package com.demo.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * ConcreteIterator
 * @author gnl
 */

public class ConcreteIterator implements Iterator {

    private List<Department> departments;
    private int index = -1;

    public ConcreteIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= (departments.size()-1)){
            return false;
        }else{
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    @Override
    public void remove() {}

    public void show() {
        while (hasNext()) {
            Department department = (Department) next();
            System.out.println(department.getName());
        }
    }
}
