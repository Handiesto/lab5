package src.exceptions;

public class ValidationException extends Exception{
    public ValidationException() {super("Validation Exception: 'the variable is not in correct range!'");}
    public ValidationException(String message){
        super(message);
    }
}
