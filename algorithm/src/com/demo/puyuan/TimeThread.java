package com.demo.puyuan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * TimeThread
 *
 * @author gnl
 */

public class TimeThread {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);

        thread.start();

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date(currentTimeMillis));
            System.out.println(time);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
