package com.demo.iterator;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {

        Department sos = new Department("sos", "sos good");
        Department cs = new Department("cs", "cs good");
        Department tea = new Department("tea", "tea good");
        Department phy = new Department("phy", "phy good");

        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addElement(sos);
        aggregate.addElement(cs);
        aggregate.addElement(tea);
        aggregate.addElement(phy);

        ConcreteIterator iterator = aggregate.createIterator();
        System.out.println(iterator.hasNext());

        iterator.show();

    }
}
