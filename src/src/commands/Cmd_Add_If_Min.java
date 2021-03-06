package src.commands;

import src.exceptions.BadNumberOfArgsException;

import src.exceptions.ValidationException;
import src.main.Receiver;


/**
 * Class of the command Add_if_min.
 * This command adds a new element to collection.
 */

public class Cmd_Add_If_Min implements Command {

    private final Receiver receiver;

    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     */

    public Cmd_Add_If_Min(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Execute method add in receiver.
     * @param args - the arguments that are passed to command
     * @throws ValidationException
     * @throws BadNumberOfArgsException
     */

    @Override
    public void Execute(String ... args) throws ValidationException, BadNumberOfArgsException {
        if (args.length != 1) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            receiver.Add_If_Min(args[0]);
        }
    }
}
