package com.demo.visitor;

/**
 * Person Element
 * @author gnl
 */

public abstract class Person {

    private String name;
    private Integer essayCount;
    private Integer score;

    public Person(String name, Integer essayCount, Integer score) {
        this.name = name;
        this.essayCount = essayCount;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEssayCount() {
        return essayCount;
    }

    public void setEssayCount(Integer essayCount) {
        this.essayCount = essayCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * award 获得的奖项
     * @return void
     * @author gnl
     */
    public abstract void award();

    /**
     * accept 接受visitor访问，参数为Visitor
     * @param visitor
     * @return void
     * @author gnl
     */
    public abstract void accept(Visitor visitor);

}
