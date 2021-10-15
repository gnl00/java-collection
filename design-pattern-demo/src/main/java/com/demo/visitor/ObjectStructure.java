package com.demo.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectStructure 负责处理Element角色
 * @author gnl
 */

public class ObjectStructure {

    private List<Person> elements = new ArrayList<>();

    public boolean addElement(Person person) {
        if (person != null) {
           return elements.add(person);
        }
        return false;
    }

    public boolean removeElement(Person person) {
        if (elements.contains(person)) {
            return elements.remove(person);
        }
        return false;
    }

    public void showElement(Visitor visitor) {
        elements.forEach(p -> {
            p.accept(visitor);
        });
    }

}
