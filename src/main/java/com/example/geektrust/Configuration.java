package com.example.geektrust;

import com.example.geektrust.commands.*;

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
    private final IUserRepository userRepository = new UserRepository();
    private final IQuestionRepository questionRepository = new QuestionRepository();
    private final IContestRepository contestRepository = new ContestRepository();
    private final IContestantRepository contestantRepository = new ContestantRepository();


    // Initialize services
    private final UserService userService = new UserService(userRepository);
    private final QuestionService questionService = new QuestionService(questionRepository);
    private final ContestService contestService = new ContestService(contestantRepository, contestRepository, questionRepository, userRepository);

    // Initialize commands
    private final BalanceCommand balanceCommand = new BalanceCommand(userService);
    private final CheckInCommand checkInCommand = new CheckInCommand(questionService);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(questionService);

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
