package com.demo.decorator;

/**
 * Drink Component
 *
 * @author gnl
 */

public abstract class Drink {

    private String desc;
    private float price;

    /**
     * cost 计费
     * @return float
     * @author gnl
     */
    public abstract float cost();

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
