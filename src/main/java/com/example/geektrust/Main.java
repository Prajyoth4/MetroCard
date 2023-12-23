package com.example.geektrust;

import com.example.geektrust.commands.CommandRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs){

        Configuration conf = Configuration.getInstance();

        CommandRegistry commandRegistry = conf.getCommandRegistry();
        //System.out.println(commandLineArgs);

        String inputFile = commandLineArgs.get(0);

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                commandRegistry.invokeCommand(line);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
