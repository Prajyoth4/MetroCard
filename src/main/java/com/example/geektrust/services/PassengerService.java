package com.example.geektrust.services;

import com.example.geektrust.repositories.IPassengerRepository;

public class PassengerService {
    private final IPassengerRepository passengerRepository;

    public PassengerService(IPassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    public void createPassenger(String metroCardNumber, Integer balance){

    }
}
