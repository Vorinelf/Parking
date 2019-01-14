package com.artem.car;


import com.artem.exception.PossibleException;
import com.artem.parking.Parking;
import com.artem.parking.Place;
import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class Car extends Thread {
    private static Logger loggerCar = Logger.getLogger(Car.class);
    private final int timeForCar;
    private final int numberCar;
    private CountDownLatch countDown;
    private boolean reading = false;
    private Parking<Place> parking;


    public int getTimeForCar() {
        return timeForCar;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public Car(Parking<Place> parking, int timeForCar, int numberCar) {
        this.parking = parking;
        this.timeForCar = timeForCar;
        this.numberCar = numberCar;
        this.countDown = new CountDownLatch(timeForCar);
    }

    public void run() {
        Place place = null;
        try {
            place = parking.getResource(500);
            loggerCar.info("CAR: Car #" + getNumberCar() + " took place #" + place.getNumberPlace());
            place.using();
            countDown.await();

        } catch (PossibleException e) {
            loggerCar.info("CAR:Car #" + getNumberCar() + " lost ->" + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (place != null) {
                loggerCar.info("CAR: Car #" + getNumberCar() + " : " + place.getNumberPlace() + " place released");
                parking.returnResource(place);
            }
        }

    }

    public boolean isReading() {
        return reading;
    }

    public CountDownLatch getCountDownLanch() {
        return countDown;
    }
}