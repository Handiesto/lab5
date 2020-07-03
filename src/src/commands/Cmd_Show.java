package src.commands;

import src.exceptions.BadNumberOfArgsException;

import src.exceptions.ValidationException;
import src.main.Receiver;


/**
 * Class of the command Add.
 * This command adds a new element to collection.
 */

public class Cmd_Show implements Command {

    private final Receiver receiver;

    /**
     * Simple constructor.
     * @param receiver - the object of Collection Manager
     */

    public Cmd_Show(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Execute method add in Collection Manager.
     * @param args - the arguments that are passed to command
     * @throws ValidationException
     * @throws BadNumberOfArgsException
     */

    @Override
    public void Execute(String ... args) throws ValidationException, BadNumberOfArgsException {
        if (args.length != 0) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            receiver.Show();
        }
    }
}
