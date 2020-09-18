package src.constituents;

import org.jetbrains.annotations.NotNull;
import src.exceptions.ValidationException;


/**
 * Class of organization of product.
 */
public class Organization {
    private static int lastId;
    @NotNull
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    @NotNull
    private long employeesCount; //Значение поля должно быть больше 0
    /**
     * Constructor
     */
    public Organization() {
        id = lastId;
        lastId++;

    }
    /**
     * Constructor
     * @param name - the name of organization
     * @param fullName - the fullname of organization
     * @param employeesCount - the employees count of organization
     * @throws NullPointerException
     * @throws ValidationException
     */

    public Organization(String name, String fullName, long employeesCount) throws NullPointerException, ValidationException {
        if(name == null || name.equals("") || fullName == null || fullName.equals("")) {
            throw new NullPointerException("Check the values of variables. name, annualTurnover and type can be empty!");
        }
        if(employeesCount <= 0) {
            throw new ValidationException("The height is out of range! It must be more than 0");
        }
        id = lastId;
        lastId++;
        this.name = name;
        this.employeesCount = employeesCount;


    }
    /**
     * Updates id of organization
     */
    public void UpdateId() {
        id = lastId;
        lastId++;
    }

    public void setName(String name) throws NullPointerException, ValidationException {
        if(name == null || name.equals("")) {
            throw new NullPointerException("The name can not be empty!");
        }
        this.name = name;
    }
    public void setFullName(String fullName) throws NullPointerException, ValidationException {
        if(fullName == null || fullName.equals("")) {
            throw new NullPointerException("The name can not be empty!");
        }
        this.fullName = fullName;
    }

    public void setemployeesCount(long employeesCount) throws NullPointerException, ValidationException {

        if(employeesCount <= 0) {
            throw new ValidationException("The height is out of range! It must be more than 0");
        }
        this.employeesCount = employeesCount;
    }




    public long getId() {return id;}
    public String getName() {return name;}
    public String getFullName() {return fullName;}
    public Long getemployeesCount() {return employeesCount;}

    /**
     * Method which compares coordinates with each other.
     * @param aman - another coordinates.
     * @return
     */
    public int compareTo(Organization aman) {
        return (int) (this.employeesCount - aman.employeesCount);
    }

    @Override
    public String toString() {
        return "Organization [Name = " + name + " fullname = " + fullName + ", employeesCount = " + employeesCount +"] ";
    }
}