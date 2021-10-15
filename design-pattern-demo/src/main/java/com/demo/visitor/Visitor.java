package com.demo.visitor;

/**
 * Visitor
 * @author gnl
 */

public abstract class Visitor {

    /**
     * visit 用于访问Element
     * @param element
     * @return void
     * @author gnl
     */
    public abstract void visit(Person element);

}
