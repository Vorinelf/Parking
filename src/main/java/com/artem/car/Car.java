package com.artem.car;


import com.artem.exception.PossibleException;
import com.artem.parking.Parking;
import com.artem.parking.Place;
import org.apache.log4j.Logger;

public class Car extends Thread {
    private static Logger loggerCar = Logger.getLogger(Car.class);
    private boolean reading = false;
    private Parking<Place> parking;

    public Car(Parking<Place> parking) {
        this.parking = parking;
    }

    public void run() {
        Place place = null;
        try {
            place = parking.getResource(500);
            reading = true;
            loggerCar.info("CAR: Car #" + this.getId() + " took place #" + place.getNumberPlace());
            place.using();
        } catch (PossibleException e) {
            loggerCar.info("CAR:Car #" + this.getId() + " lost ->" + e.getMessage());
        } finally {
            if (place != null) {
                reading = false;
                loggerCar.info("CAR: Car #" + this.getId() + " : " + place.getNumberPlace() + " place released");
                parking.returnResource(place);
            }
        }

    }

    public boolean isReading() {
        return reading;
    }
}