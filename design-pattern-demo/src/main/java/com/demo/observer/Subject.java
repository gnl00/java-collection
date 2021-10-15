package com.demo.observer;

/**
 * Subject
 * @author gnl
 */

public interface Subject {

    /**
     * registerObs
     * @param observer
     * @return void
     * @author gnl
     */
    public void registerObs(Observer observer);

    /**
     * removeObs
     * @param observer
     * @return void
     * @author gnl
     */
    public void removeObs(Observer observer);

    /**
     * notifyObs
     * @return void
     * @author gnl
     */
    public void notifyObs();

}
