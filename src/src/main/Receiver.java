package src.main;

import src.constituents.Coordinates;
import src.constituents.Organization;
import src.constituents.Product;
import src.exceptions.ValidationException;
import src.others.Initializer;
import src.others.Input;
import src.others.Output;
import src.others.ParserXML;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
/**
 * Class which manages collection.
 */
public class Receiver {
    private Stack<Product> products;
    private LocalDateTime creationDate;
    private Scanner scanner;
    private boolean exit = false;
    /**
     * Constructor
     * @throws ValidationException
     * @throws IOException
     */

    Receiver() throws ValidationException, IOException{
        Input input = new Input();
        ParserXML parser = new ParserXML();
        products = new Stack<>();
        creationDate = LocalDateTime.now();
        scanner = new Scanner(System.in);
        parser.Parse(input.readFile());
        for(int i = 1; i <= parser.getProductsNum(); i++){
            Product product = new Product();
            Initializer.Initialize(product, parser.getValues());
            products.push(product);
        }
    }


    private boolean ReadElement(String name, Product product) throws ValidationException {
        boolean success = true;
        Coordinates coordinates = new Coordinates();
        Organization manufacturer = new Organization();
        String nextValue = new String();
        if (name.length()!=0){
        product.setName(name);
        }
        else {System.out.println("Enter name of product");
            name = scanner.nextLine();
            product.setName(name);
        }
        try {
            System.out.println("Enter the coordinate x of coordinates");
            nextValue = scanner.nextLine();
            coordinates.setX(Double.parseDouble(nextValue));

            System.out.println("Enter the coordinate y of coordinates");
            nextValue = scanner.nextLine();
            coordinates.setY(Integer.parseInt(nextValue));

            System.out.println("Enter the price of product");
            nextValue = scanner.nextLine();
            product.setPrice(Integer.parseInt(nextValue));

            System.out.println("Enter the part number of product");
            nextValue = scanner.nextLine();
            product.setPartNumber(nextValue);

            System.out.println("Enter the manufactureCost of product");
            nextValue = scanner.nextLine();
            product.setManufactureCost(Long.parseLong(nextValue));

            System.out.println("Enter the unit of measure of product");
            nextValue = scanner.nextLine();
            product.setUnitOfMeasure(nextValue);

            System.out.println("Enter the manufacturer name of Organization");
            nextValue = scanner.nextLine();
            manufacturer.setName(nextValue);

            System.out.println("Enter the manufacturer fullname of Organization");
            nextValue = scanner.nextLine();
            manufacturer.setFullName(nextValue);

            System.out.println("Enter the manufacturer employeesCount of Organization");
            nextValue = scanner.nextLine();
            manufacturer.setemployeesCount(Long.parseLong(nextValue));

            product.setCoordinates(coordinates);
            product.setManufacturer(manufacturer);
        }
        catch (NumberFormatException ex) {
            if (nextValue.equals("")) {
                System.err.println("Empty string!");
            } else {
                System.err.println("Invalid value!");
            }
            success = false;
        } catch (ValidationException ex) {
            System.err.println(ex.getMessage());
            success = false;
        }
        return success;
    }
    /**
     * Adds a new element to collection
     * @param name - the name of element
     * @throws ValidationException
     */
    public void Add(String name) throws ValidationException {
        Product product = new Product();
        if (ReadElement(name, product)) {
            products.push(product);
        } else {
            System.out.println("Some problems with adding a product.");
        }
    }
    /**
     * Shows info about collection
     */
    public void Info() {
        try {
            Field stackField = Receiver.class.getDeclaredField("products");
            String stackType = stackField.getGenericType().getTypeName();
            if (!products.isEmpty()) {
                System.out.println("Type: " + products.getClass().getName() + "<" + stackType + ">" + "\nCreation Date" + creationDate + "\nSize: " + products.size());
            } else {
                System.out.println("Type can not be defined because collection is empty! " + "\nCreation Date" + creationDate + "\nSize: " + products.size());
            }
        } catch (NoSuchFieldException ex) {
            System.err.println("Problem with general class. Can not find type of class!");
        }
    }
    /**
     * Shows collection in string presentation
     */
    public void Show() {
        Iterator<Product> it = products.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    /**
     * Updates id of element
     * @param args
     */
    public void Update_Id(String args) throws ValidationException {
        long id = Long.parseLong(args);
        String name = "";
        for(Product p : products) {
            if (id == p.getId()) {
                ReadElement(name, p);
            }
        }
    }
    /**
     * Removes an element by id
     * @param args
     */
    public void Remove_By_Id(String args) {
        Product redundant = new Product();
        long id = Long.parseLong((args));
        for(Product product : products) {
            if (product.getId() == id){
                redundant = product;
            }
        }
        products.remove(redundant);
    }
    /**
     * Clears collection
     */
    public void Clear() {
        products.clear();
    }

    public void Exit() {
        exit = true;
        scanner.close();
    }
    /**
     * Finds a min price of elements in collection
     * @return the minimal value
     */
    private long FindMin() {
        long min = products.peek().getPrice();
        for (Product p: products) {
            if (p.getPrice() < min) {
                min = p.getPrice();
            }
        }
        return min;
    }
    /**
     * Adds an element to collection if it is min
     * @param name - the name of element
     * @throws ValidationException
     */
    public void Add_If_Min(String name) throws ValidationException {
        Product product = new Product();
        if (ReadElement(name, product)) {
            if (product.getPrice() < FindMin()) {
                products.push(product);
                System.out.println("Product was added!");
            } else {
                System.out.println("Your entered product isn't min.");
            }
        } else {
            System.out.println("Some problems with adding a product.");
        }
    }
    /**
     * Adds an element to collection
     * @param args - the name of elements
     * @throws ValidationException
     */
    public void Insert_at(String args) throws ValidationException{
        Product p = new Product();
        long id = Long.parseLong((args));
        int b = 0;
        String name = "";
        ReadElement(name,p);
        p.setId(id);
        products.insertElementAt(p,(int)id);
        for (Product product:products){
            if (product.getId()<=p.getId() && b==0){
                if(product.getId()==p.getId()){b++;}
            }
            else{product.Plusid();}
        }
        p.Lastid();
    }
    /**
     * Just for saving in history command execute script
     */
    public void Execute_Script() {

    }

    /**
     * sort collection
     */
    public void Sort(){
        Collections.sort(products);
    }
    /**
     * sum of manufacture cost
     */
    public void Sum_Of_Manufacture_Cost(){
        long sum_mc = 0;
        for (Product p: products) {
            sum_mc += p.getManufactureCost();
        }
        System.out.println("Sum of manufacture cost: "+sum_mc);
    }
    /**
     * Count Greater than Price
     * @param args - the name of elements
     * @throws ValidationException
     */
    public void Count_Greater_Than_Price(String args){
        int k = 0;
        int price = Integer.parseInt((args));
        for (Product p:products){
            if(price<p.getPrice()){k++;}
        }
        System.out.println("Count greater than price: "+k);
    }

    public void Print_Ascending(){
        Collections.sort(products);
        Iterator<Product> it = products.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    /**
     * Shows the list of available commands
     */
    public void Help() {
        System.out.println("//// HELP //// " +
                "\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" +
                "\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении" +
                "\nadd {element} : добавить новый элемент в коллекцию" +
                "\nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному" +
                "\nremove_by_id id : удалить элемент из коллекции по его id" +
                "\nclear : очистить коллекцию" +
                "\nsave : сохранить коллекцию в файл" +
                "\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме" +
                "\nexit : завершить программу (без сохранения в файл)" +
                "\ninsert_at index {element} : добавить новый элемент в заданную позицию" +
                "\nadd_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции" +
                "\nsort : отсортировать коллекцию в естественном порядке" +
                "\nsum_of_manufacture_cost : вывести сумму значений поля manufactureCost для всех элементов коллекции" +
                "\ncount_greater_than_price price : вывести количество элементов, значение поля price которых больше заданного" +
                "\nprint_ascending : вывести элементы коллекции в порядке возрастания");
    }

    /**
     * Saves collection to file
     * @throws IOException
     */

    public void Save() throws IOException {
        String path;
        System.out.println("Enter the path to the file where you want to save the data.");
        try {
            path = scanner.nextLine();
            Output output = new Output();
            output.writeLine("<xml -version 8.0>");
            output.writeLine("<Class>");
            for (Product product : products) {
                output.writeLine("  <Product>");
                output.writeLine("    <Name>" + product.getName() + "<\\Name>");
                output.writeLine("    <Coordinates>");
                output.writeLine("      <X>" + product.getCoordinates().getX() + "<\\X>");
                output.writeLine("      <Y>" + product.getCoordinates().getY() + "<\\Y>");
                output.writeLine("    <\\Coordinates>");
                output.writeLine("    <CreationDate>" + product.getCreationDate() + "<\\CreationDate>");
                output.writeLine("    <Price>" + product.getPrice() + "<\\Price>");
                output.writeLine("    <partNumber>" + product.getPartNumber() + "<\\partNumber>");
                output.writeLine("    <manufactureCost>" + product.getManufactureCost() + "<\\manufactureCost>");
                output.writeLine("    <UnitOfMeasure>" + product.getUnitOfMeasure() + "<\\UnitOfMeasure>");
                output.writeLine("    <Organization>");
                output.writeLine("      <Name>" + product.getManufacturer().getName() + "<\\Name>");
                output.writeLine("      <fullName>" + product.getManufacturer().getFullName() + "<\\fullName>");
                output.writeLine("      <employeesCount>" + product.getManufacturer().getemployeesCount() + "<\\employeesCount>");
                output.writeLine("    <\\Organization>");
                output.writeLine("  <\\Product>");
            }
            output.writeLine("<\\Class>");
            output.closeWriter();
            System.out.println("Saving is successful!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean getExit() {
        return exit;
    }
    


}
