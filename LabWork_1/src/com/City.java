package com;

public class City {
    private String name;
    private int distanceToCity;

    public City(String name, int distanceToCity) {
        this.name = name;
        this.distanceToCity = distanceToCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(int distanceToCity) {
        this.distanceToCity = distanceToCity;
    }
}
