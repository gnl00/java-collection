package com.demo.decorator;

/**
 * Decorator 装饰类
 *
 * @author gnl
 */

public abstract class Decorator extends Drink {

    /**
     * 将Drink类聚合到Decorator中
     */
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }


    @Override
    public String getDesc() {
        return super.getDesc() + super.getPrice() +" + "+ drink.getDesc() + drink.getPrice();
    }
}
