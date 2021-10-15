package com.demo.visitor;

/**
 * Teacher ConcreteElement
 *
 * @author gnl
 */

public class Teacher extends Person {

    public Teacher(String name, Integer essayCount, Integer score) {
        super(name, essayCount, score);
    }

    @Override
    public void award() {
        if (this.getEssayCount() > 10){
            System.out.println("***** 教师: "+getName()+" 【可】评选科研奖");
        } else {
            System.out.println("***** 教师: "+getName()+" 【不可】评选科研奖");
        }

        if (this.getScore() > 90){
            System.out.println("***** 教师: "+getName()+" 【可】评选成绩优秀奖");
        } else {
            System.out.println("***** 教师: "+getName()+" 【不可】评选成绩优秀奖");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
