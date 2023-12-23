package com.example.geektrust.entities;

import com.example.geektrust.constants.PassengerType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Station {
    private String stationName;
    private Map<PassengerType, Integer> mapOfSummary = new HashMap<>();
    private Set<Passenger> setOfPassengers;
    private int amountCollected = 0;
    private int discountGiven = 0;

    public Station(Set<Passenger> setOfPassengers, String stationName){
        this.setOfPassengers = setOfPassengers;
        this.stationName = stationName;
    }

    public void checkIn(Passenger passenger, PassengerType type) {
        int price = switch (type) {
            case ADULT -> 200;
            case SENIOR_CITIZEN -> 100;
            case KID -> 50;
        };

        if (setOfPassengers.contains(passenger)) {
            // discount
            price = price / 2;
            discountGiven += price/2;
            setOfPassengers.remove(passenger);
        } else {
            setOfPassengers.add(passenger);
        }

        int balance = passenger.getBalance();
        if (balance >= price){
            passenger.setBalance(balance - price);
            amountCollected += price;
        } else {
            amountCollected += price + (int) (0.02 * (price - balance));
            passenger.setBalance(0);
        }

        mapOfSummary.merge(type, 1, Integer::sum);
    }


    public void printSummary(){
        System.out.println("TOTAL COLLECTION " + stationName + " " + amountCollected + " " + discountGiven);
        System.out.println("PASSENGER_TYPE_SUMMARY");
        mapOfSummary.entrySet().stream()
                .filter((ele) -> ele.getValue()>0)
                .sorted(Map.Entry.comparingByValue())
                .forEach((ele) -> System.out.println(ele.getKey() + " " + ele.getValue()));
    }

}
