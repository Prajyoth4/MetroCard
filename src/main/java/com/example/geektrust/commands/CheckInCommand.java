package com.example.geektrust.commands;

import com.example.geektrust.constants.PassengerType;
import com.example.geektrust.services.StationService;

import java.util.List;

public class CheckInCommand implements ICommand{
    private final StationService stationService;

    public CheckInCommand(StationService stationService) {
        this.stationService = stationService;
    }
    @Override
    public void invoke(List<String> tokens) {
        PassengerType type = PassengerType.valueOf(tokens.get(2));
        String metroCardNumber = tokens.get(1);
        String stationName = tokens.get(3);
        stationService.checkInPassenger(metroCardNumber, type, stationName);
    }
}
