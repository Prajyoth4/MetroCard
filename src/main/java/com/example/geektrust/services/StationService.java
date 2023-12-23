package com.example.geektrust.services;

import com.example.geektrust.constants.PassengerType;
import com.example.geektrust.entities.Passenger;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.IPassengerRepository;
import com.example.geektrust.repositories.IStationRepository;

public class StationService {
    private final IStationRepository stationRepository;
    private final IPassengerRepository passengerRepository;

    public StationService(IStationRepository stationRepository, IPassengerRepository passengerRepository) {
        this.stationRepository = stationRepository;
        this.passengerRepository = passengerRepository;
    }

    public void checkInPassenger(String cardNumber, PassengerType type, String stationName){
        Station station = stationRepository.find(stationName);
        Passenger passenger = passengerRepository.find(cardNumber).orElseThrow();
        station.checkIn(passenger, type);
    }

    public void printSummary(){
        stationRepository.find("CENTRAL").printSummary();
        stationRepository.find("AIRPORT").printSummary();
    }
}
