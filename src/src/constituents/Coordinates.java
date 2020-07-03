package src.constituents;


import org.jetbrains.annotations.NotNull;
import src.exceptions.ValidationException;


public class Coordinates {
    private double x;
    @NotNull
    private int y; //Значение поля должно быть больше -158, Поле не может быть null
    private final int MIN_Y = -325;

    public Coordinates() {}

    public Coordinates(double x,int y) throws ValidationException {

        if (y <= MIN_Y)
            throw new ValidationException("The coordinate y must be more than " + MIN_Y);
        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }

    public void setY(int y) throws NullPointerException, ValidationException {

        if (y <= MIN_Y)
            throw new ValidationException("The  y is out of range! The coordinate y must be more than " + MIN_Y);
        this.y = y;
    }

    public double getX() {return x;}
    public int getY() {return y;}


    public int compareTo(Coordinates anotherCoordinates){
        return (int) (this.x - anotherCoordinates.x);
    }

    @Override
    public String toString() {
        return "Coordinates [x = " + x + ", y = " + y +"] ";
    }
}