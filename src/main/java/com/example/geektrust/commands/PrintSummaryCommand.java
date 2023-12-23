package com.example.geektrust.commands;

import com.example.geektrust.constants.PassengerType;
import com.example.geektrust.services.StationService;

import java.util.List;

public class PrintSummaryCommand implements ICommand{
    private final StationService stationService;

    public PrintSummaryCommand(StationService stationService) {
        this.stationService = stationService;
    }
    @Override
    public void invoke(List<String> tokens) {
        stationService.printSummary();
    }
}
