package src.commands;

        import src.exceptions.BadNumberOfArgsException;

        import src.exceptions.ValidationException;
        import src.main.Receiver;


/**
 * Class of the command print ascending.

 */

public class Cmd_Print_Ascending implements Command {

    private final Receiver receiver;

    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     */

    public Cmd_Print_Ascending(Receiver receiver) {
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
            receiver.Print_Ascending();
        }
    }
}
