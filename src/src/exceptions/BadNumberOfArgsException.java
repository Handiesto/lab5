package src.exceptions;

public class BadNumberOfArgsException extends Exception {
    public BadNumberOfArgsException(){
        super("Invalid number of arguments passed to method!");
    }
    public BadNumberOfArgsException(String message){
        super(message);
    }
}
