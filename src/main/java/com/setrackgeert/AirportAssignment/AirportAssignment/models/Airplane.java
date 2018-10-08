package com.setrackgeert.AirportAssignment.AirportAssignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane
{
// XYZ Airlines
// destinations --> Amsterdam, London, Parijs, Stockholm en Berlijn
// Option to say isFlying
// Minimum fuel is 2ton --> max fuel is 5ton
// Possibility to fill fuel to max
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int maxFuel = 5;
    private int flyFuel = 2;
    private int currentFuel = 5;
    private String currentAirport;

    public Airplane()
    {

    }

    public int flyingFuel ()
    {
        int newCurrentFuel = getCurrentFuel() - flyFuel;
        this.currentFuel = newCurrentFuel;
        return newCurrentFuel;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public int getFlyFuel() {
        return flyFuel;
    }

    public void setFlyFuel(int flyFuel) {
        this.flyFuel = flyFuel;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getCurrentAirport() {
        return currentAirport;
    }

    public void setCurrentAirport(String currentAirport) {
        this.currentAirport = currentAirport;
    }
}
