package src.exceptions;

public class InvalidCommand extends Exception {
    public InvalidCommand(){
        super("Invalid command was entered!");
    }
    public InvalidCommand(String message){
        super(message);
    }
}
