package com.setrackgeert.AirportAssignment.AirportAssignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {
    // airports --> Amsterdam, London, Parijs, Stockholm en Berlijn
    // max number of airplanes on airport (5) if above 5 than not able to land
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int currentPlanes;
    private int maxPlanes = 5;
    private String name;

    public Airport ()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCurrentPlanes() {
        return currentPlanes;
    }

    public void setCurrentPlanes(int currentPlanes) {
        this.currentPlanes = currentPlanes;
    }

    public int getMaxPlanes() {
        return maxPlanes;
    }

    public void setMaxPlanes(int maxPlanes) {
        this.maxPlanes = maxPlanes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
