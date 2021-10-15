package com.demo.visitor;

/**
 * Student ConcreteElement
 *
 * @author gnl
 */

public class Student extends Person {

    public Student(String name, Integer essayCount, Integer score) {
        super(name, essayCount, score);
    }

    @Override
    public void award() {
        if (this.getEssayCount() > 2){
            System.out.println("***** 学生: "+getName()+" 【可】评选科研奖");
        } else {
            System.out.println("***** 学生: "+getName()+" 【不可】评选科研奖");
        }

        if (this.getScore() > 90){
            System.out.println("***** 学生: "+getName()+" 【可】评选成绩优秀奖");
        } else {
            System.out.println("***** 学生: "+getName()+" 【不可】评选成绩优秀奖");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
