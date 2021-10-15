package com.demo.iterator;

import java.util.Iterator;

/**
 * Aggregate
 * @author gnl
 */

public interface Aggregate {

    /**
     * getName
     * @return java.lang.String
     * @author gnl
     */
    public String getName();

    /**
     * addElement
     * @param department
     * @return void
     * @author gnl
     */
    public void addElement(Department department);

    /**
     * createIterator
     * @return java.util.Iterator
     * @author gnl
     */
    public Iterator createIterator();

}
