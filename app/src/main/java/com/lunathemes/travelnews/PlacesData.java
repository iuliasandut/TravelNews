package com.lunathemes.travelnews;

public class PlacesData {

    private final String city;
    private final String observation;

    public PlacesData(String city, String observation) {
        this.city = city;
        this.observation = observation;
    }

    public String getCity() {
        return city;
    }

    public String getObservation() {
        return observation;
    }
}
