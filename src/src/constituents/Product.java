package src.constituents;


import src.exceptions.ValidationException;

import java.time.LocalDateTime;

public class Product implements  Comparable<Product>{
    private static int lastIdProduct;
    private long id; //Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int price; //Значение поля должно быть больше 0
    private String partNumber; //Строка не может быть пустой, Длина строки не должна быть больше 41, Поле может быть null
    private Long manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле не может быть null


    public Product(){
        id = lastIdProduct;
        lastIdProduct++;
        creationDate = LocalDateTime.now();
    }

    public Product(String name, Coordinates coordinates, int price, String partNumber, Long manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer) throws NullPointerException, ValidationException {
        if (name == null || name.equals("") || coordinates == null  || partNumber == null || partNumber.equals("") || manufactureCost == null || unitOfMeasure == null || manufacturer == null) {
            throw new NullPointerException();
        }
        if(price <= 0) {
            throw new ValidationException("The price is out of range! It must be more than 0");
        }
        if(partNumber.length() > 41) {
            throw new ValidationException("The number of parts is out of range! It must be less than 76");
        }

        id = lastIdProduct;
        lastIdProduct++;
        this.name = name;
        this.coordinates = coordinates;
        creationDate = LocalDateTime.now();
        this.price = price;
        this.partNumber = partNumber;
        this.unitOfMeasure = unitOfMeasure;
        this.manufactureCost = manufactureCost;
        this.manufacturer = manufacturer;
    }

    public void UpdateId() {
        id = lastIdProduct;
        lastIdProduct++;
    }
    public void Lastid(){
        lastIdProduct++;
    }
    public void Plusid(){
        id ++;
    }


    public void setId(Long id) throws NullPointerException {
        if (id == null || id>0) {
            throw new NullPointerException("The name can not be empty!'");
        }
        this.id = id;
    }

    public void setName(String name) throws NullPointerException {
        if (name == null || name.equals("")) {
            throw new NullPointerException("The name can not be empty!'");
        }
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) throws NullPointerException {
        if(coordinates == null) {
            throw new NullPointerException("The coordinates can not be empty!");
        }
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) throws NullPointerException {
        if (creationDate == null) {
            throw new NullPointerException("The creation date can not be empty!");
        }
        this.creationDate = creationDate;
    }

    public void setPrice(int price) throws NullPointerException, ValidationException {

        if(price <= 0) {
            throw new ValidationException("The price is out of range! It must be more than 0");
        }
        this.price = price;
    }

    public void setManufactureCost(Long manufactureCost) throws NullPointerException, ValidationException {

        if(manufactureCost == null) {
            throw new NullPointerException("The number of parts can not be empty!");
        }
        this.manufactureCost = manufactureCost;
    }

    public void setPartNumber(String partNumber) throws NullPointerException, ValidationException {
        if(partNumber == null) {
            throw new NullPointerException("The number of parts can not be empty!");
        }
        if(partNumber.length() > 75) {
            throw new ValidationException("The number of parts is out of range! It must be less than 76");
        }
        this.partNumber = partNumber;
    }

    public void setUnitOfMeasure(String unitOfMeasure) throws NullPointerException {
        if(unitOfMeasure == null) {
            throw new NullPointerException("The unit of measure can not be null!");
        }
        if (unitOfMeasure.equals("PCS")) {
            this.unitOfMeasure = UnitOfMeasure.PCS;
        } else if (unitOfMeasure.equals("KILOGRAMS")) {
            this.unitOfMeasure = UnitOfMeasure.KILOGRAMS;
        } else if (unitOfMeasure.equals("CENTIMETERS")) {
            this.unitOfMeasure = UnitOfMeasure.CENTIMETERS;
        }  else if (unitOfMeasure.equals("SQUARE_METERS")) {
            this.unitOfMeasure = UnitOfMeasure.SQUARE_METERS;
        }  else {
            this.unitOfMeasure = UnitOfMeasure.LITERS;
        }
    }

    public void setManufacturer(Organization manufacturer) throws NullPointerException {
        if(manufacturer == null) {
            throw new NullPointerException("Null Equals Exception: 'The variable owner is null!'");
        }
        this.manufacturer = manufacturer;
    }

    public long getId() {return id;}
    public String getName() {return name;}
    public Coordinates getCoordinates() {return coordinates;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public int getPrice() {return price;}
    public String getPartNumber() { return partNumber;}
    public Long getManufactureCost() {return manufactureCost;}
    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}
    public Organization getManufacturer() {return manufacturer;}



    @Override
    public int compareTo(Product product){
        return (int) (this.id - product.id);
    }

    @Override
    public String toString() {
        return "Product [Id = " + id +  ", Name = " + name + " coordinates = " + coordinates
                + ", creationDate = " + creationDate  + ", price = " + price
                + ", partNumber = " + partNumber + ", manufactureCost = " + manufactureCost +  ", unitOfMeasure = " + unitOfMeasure +", manufacturer =  " + manufacturer + "] ";
    }
}

