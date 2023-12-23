package com.example.geektrust.repositories;

import com.example.geektrust.entities.Passenger;

import java.util.Optional;

public interface IPassengerRepository {
    void save(Passenger passenger);
    Optional<Passenger> find(String metroCardNumebr);
}
