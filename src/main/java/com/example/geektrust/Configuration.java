package com.example.geektrust;

import com.example.geektrust.commands.*;
import com.example.geektrust.repositories.IPassengerRepository;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.repositories.PassengerRepository;
import com.example.geektrust.repositories.StationRepository;
import com.example.geektrust.services.PassengerService;
import com.example.geektrust.services.StationService;

public class Configuration {
    // Singleton Pattern
    //create an object of Single Configuration Object
    private static Configuration instance = new Configuration();

    //make the constructor private so that this class cannot be
    //instantiated
    private Configuration(){}

    //Get the only object available
    public static Configuration getInstance(){
        return instance;
    }

    // Initialize repositories
    private final IPassengerRepository passengerRepository = new PassengerRepository(passengerMap);
    private final IStationRepository stationRepository = new StationRepository(stationMap);


    // Initialize services
    private final PassengerService passengerService = new PassengerService(passengerRepository);
    private final StationService stationService = new StationService(stationRepository);

    // Initialize commands
    private final BalanceCommand balanceCommand = new BalanceCommand(passengerService);
    private final CheckInCommand checkInCommand = new CheckInCommand(stationService);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(stationService);

    // Initialize commandRegistery
    private final CommandRegistry commandRegistry = new CommandRegistry();

    // Register commands
    private void registerCommands(){
        commandRegistry.registerCommand(CommandKeyword.BALANCE_COMMAND.getName(),balanceCommand);
        commandRegistry.registerCommand(CommandKeyword.CHECK_IN_COMMAND.getName(),checkInCommand);
        commandRegistry.registerCommand(CommandKeyword.PRINT_SUMMARY_COMMAND.getName(), printSummaryCommand);
    }

    public CommandRegistry getCommandRegistry(){
        registerCommands();
        return commandRegistry;
    }

}
