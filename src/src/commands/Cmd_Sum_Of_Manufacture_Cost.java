package src.commands;

        import src.exceptions.BadNumberOfArgsException;

        import src.exceptions.ValidationException;
        import src.main.Receiver;


/**
 * Class of the command sum of manufacture cost.
 * This command sum of manufacture cost in collection.
 */

public class Cmd_Sum_Of_Manufacture_Cost implements Command {

    private final Receiver receiver;

    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     */

    public Cmd_Sum_Of_Manufacture_Cost(Receiver receiver) {
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
        if (args.length != 0) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            receiver.Sum_Of_Manufacture_Cost();
        }
    }
}
