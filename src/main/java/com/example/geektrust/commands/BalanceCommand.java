package com.example.geektrust.commands;

import com.example.geektrust.services.PassengerService;

import java.util.List;

public class BalanceCommand implements ICommand{
    private final PassengerService passengerService;

    public BalanceCommand(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @Override
    public void invoke(List<String> tokens) {
        Integer balance = Integer.parseInt(tokens.get(2));
        String metroCardNumber = tokens.get(1);
        passengerService.createPassenger(metroCardNumber, balance);
    }
}
