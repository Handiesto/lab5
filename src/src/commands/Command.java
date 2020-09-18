package src.commands;
/**
 * Interface Command which should be implemented by all types of commands.
 */
public interface Command {
    /**
     * Method to interact with Collection Manager.
     * @param args - the arguments that are passed to command
     * @throws Exception
     */
    public void Execute(String ... args) throws Exception;
}
