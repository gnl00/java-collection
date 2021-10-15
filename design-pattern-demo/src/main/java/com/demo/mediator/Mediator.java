package com.demo.mediator;

/**
 * Mediator
 *
 * @author gnl
 */

public interface Mediator {

    /**
     * register 将同事对象加入集合
     * @param colleague
     * @param name
     * @return void
     * @author gnl
     */
    public void register(Colleague colleague, String name);

    /**
     * getMessage 接收同事对象传过来的消息，完成相应任务
     * @param colleagueName
     * @return void
     * @author gnl
     * @date 2021/4/8 10:45
     */
    public void getMessage(String colleagueName);

}
