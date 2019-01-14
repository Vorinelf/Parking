package com.artem.car;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TimerCar extends Thread {
    private static Logger loggerTimerCar = Logger.getLogger(TimerCar.class);
    private List<Car> list;

    public TimerCar() {
        this.list = new ArrayList<>();
    }

    public TimerCar(List<Car> list) {
        this.list = list;
    }

    public void run() {
        for (Car car : list) {
            int k = car.getTimeForCar();
            int j = car.getNumberCar();
            for (int i = 1; i <= k; i++) {
                car.getCountDownLanch().countDown();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loggerTimerCar.info("TimerCar: Car #" + j + " stand on the place " + i + " hour(s)");
            }
        }
    }
}
