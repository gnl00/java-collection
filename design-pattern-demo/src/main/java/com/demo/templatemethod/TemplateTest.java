package com.demo.templatemethod;

/**
 * 模板方法模式
 * 当实现的功能有一部分确定，另一部分不确定时，可以把不确定的部分暴露出去，让子类实现
 * @author gnl
 */

public class TemplateTest {
    public static void main(String[] args) {
        SubTemlpate subTemlpate = new SubTemlpate();
        subTemlpate.runTime();
    }
}

abstract class Template {

    /**
     * 模板中的不确定部分
     */
    abstract void code();

    public void runTime() {
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();

        System.out.println(String.format("花费时间为: %d", end-start));

    }
}

class SubTemlpate extends Template {

    @Override
    void code() {

        for (int i = 2; i < 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if ( i % j ==0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(i);
            }

        }
    }
}
