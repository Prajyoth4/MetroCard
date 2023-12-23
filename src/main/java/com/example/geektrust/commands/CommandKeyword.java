package com.example.geektrust.commands;

public enum CommandKeyword {
    BALANCE_COMMAND("BALANCE"),
    CHECK_IN_COMMAND("CHECK_IN"),
    PRINT_SUMMARY_COMMAND("PRINT_SUMMARY")
    ;


    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}