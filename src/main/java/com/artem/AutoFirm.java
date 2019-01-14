package com.artem;


import com.artem.car.Car;
import com.artem.car.TimerCar;
import com.artem.parking.Parking;
import com.artem.parking.Place;

import java.util.ArrayList;

public class AutoFirm {


    public static void main(String[] args) {

        Place place = new Place();
        place.buildPlace();
        Parking<Place> parking = new Parking<Place>(place.getAllPlace());
        Car car1 = new Car(parking, 5, 1);
        Car car2 = new Car(parking, 4, 2);
        Car car3 = new Car(parking, 3, 3);
        ArrayList<Car> lst = new ArrayList<Car>();
        lst.add(car1);
        lst.add(car2);
        lst.add(car3);
        TimerCar timerCar = new TimerCar(lst);
        car1.start();
        car2.start();
        car3.start();
        timerCar.start();

    }
}




