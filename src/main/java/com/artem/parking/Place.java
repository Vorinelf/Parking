package com.artem.parking;

import java.util.LinkedList;

public class Place {
    final LinkedList<Place> allPlace = new LinkedList<Place>();

    private int numberPlace;

    public Place() {
    }

    public Place(int numberPlace) {
        super();
        this.numberPlace = numberPlace;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public LinkedList<Place> getAllPlace() {
        return allPlace;
    }

    public void using() {
        try {   // using parking place
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buildPlace() { // building parking places
        allPlace.add(new Place(1));
        allPlace.add(new Place(2));
        allPlace.add(new Place(3));
        allPlace.add(new Place(4));
        allPlace.add(new Place(5));
        allPlace.add(new Place(6));
        allPlace.add(new Place(7));
        allPlace.add(new Place(8));
        allPlace.add(new Place(9));
        allPlace.add(new Place(10));
        allPlace.add(new Place(11));
        allPlace.add(new Place(12));
        allPlace.add(new Place(13));
        allPlace.add(new Place(14));
        allPlace.add(new Place(15));
    }

}

