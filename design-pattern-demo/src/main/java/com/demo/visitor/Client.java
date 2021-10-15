package com.demo.visitor;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {

        Person tea1 = new Teacher("t-aaa", 11, 99);
        Person tea2 = new Teacher("t-bbb", 5, 89);

        Person stu1 = new Student("s-ccc", 11, 99);
        Person stu2 = new Student("s-ddd", 1, 89);

        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.addElement(tea1);
        objectStructure.addElement(tea2);
        objectStructure.addElement(stu1);
        objectStructure.addElement(stu2);

        objectStructure.showElement(new ConcreteVisitor());

    }
}
