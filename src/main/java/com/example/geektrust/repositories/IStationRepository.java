package com.example.geektrust.repositories;

import com.example.geektrust.entities.Station;

public interface IStationRepository {
    //void save(Passenger passenger);
    Station find(String name);
}
