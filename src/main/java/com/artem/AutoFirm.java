package com.artem;


import com.artem.car.Car;
import com.artem.parking.Parking;
import com.artem.parking.Place;

public class AutoFirm {


    public static void main(String[] args) {

        Place place = new Place();
        place.buildPlace();
        Parking<Place> parking = new Parking<Place>(place.getAllPlace());
        for (int i = 0; i < 25; i++) {
            new Car(parking).start();
        }
    }
}




