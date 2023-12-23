package com.example.geektrust.repositories;

import com.example.geektrust.entities.Passenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PassengerRepository implements IPassengerRepository{
    private final Map<String, Passenger> passengerMap;


    public PassengerRepository() {
        passengerMap = new HashMap<>();
    }

    @Override
    public void save(Passenger passenger) {
        passengerMap.put(passenger.getCardNumber(), passenger);
    }

    @Override
    public Optional<Passenger> find(String metroCardNumber) {
        return Optional.ofNullable(passengerMap.get(metroCardNumber));
    }
}
