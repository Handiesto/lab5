package src.main;

import src.commands.Command;
import src.exceptions.BadNumberOfArgsException;
import src.exceptions.InvalidCommand;

import java.util.HashMap;

/**
 * Class of Invoker.
 * This class works with classes of commands.
 */

public class Invoker {

    private HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Method for register a new command
     * @param commandName - the name of command
     * @param command - the class of command
     */

    void Register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * Method which executes command
     * @param commandName - the name of command
     * @throws Exception
     */

    public void Execute(String commandName) throws Exception {
        if(commandName.equals("")){
            throw new InvalidCommand("Trying to call invalid command! See more info about available commands. \"info\"");
        }
        String[] input = commandName.split(" ");
        Command command = commandMap.get(input[0]);
        if (command == null) {
            throw new InvalidCommand("Trying to call invalid command! " + "\"" + commandName + "\"" + " See more info about available commands. \"info\"");
        }
        String[] args = new String[input.length-1];
        for(int i = 0; i < args.length; i++){
            args[i] = input[i+1];
        }
        try {
            command.Execute(args);
        } catch (BadNumberOfArgsException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
