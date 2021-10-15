package com.demo.visitor;

/**
 * ConcreteVisitor
 * @author gnl
 */

public class ConcreteVisitor extends Visitor {

    /**
     * visit 访问person
     * @param element
     * @return void
     * @author gnl
     */
    @Override
    public void visit(Person element) {
        element.award();
    }
}
