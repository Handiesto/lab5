package src.exceptions;

public class EqualsNull extends Exception {
    public EqualsNull(){
        super("Null Equals Exception: 'Variable is equal to null!'");
    }
    public EqualsNull(String message){
        super(message);
    }
}
