package com.example.geektrust.entities;

public class Passenger {
    private int balance;
    private String cardNumber;

    public Passenger(int balance, String cardNumber){
        this.cardNumber = cardNumber;
        this.balance = balance;
//        basePrice = switch(type){
//            case ADULT-> 200;
//            case SENIOR_CITIZEN->100;
//            case KID->50;
//        };
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}
