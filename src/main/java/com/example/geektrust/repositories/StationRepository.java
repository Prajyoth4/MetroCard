package com.example.geektrust.repositories;

import com.example.geektrust.entities.Passenger;
import com.example.geektrust.entities.Station;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StationRepository implements IStationRepository{
    private final Map<String, Station> stationMap;
    private final Set<Passenger> setOfPassengers;

    public StationRepository() {
        stationMap = new HashMap<>();
        setOfPassengers = new HashSet<>();
        stationMap.put("CENTRAL", new Station(setOfPassengers, "CENTRAL"));
        stationMap.put("AIRPORT", new Station(setOfPassengers, "AIRPORT"));
    }

    @Override
    public Station find(String name) {
        return stationMap.get(name);
    }
}
