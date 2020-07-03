package src.others;

import java.time.LocalDateTime;
import src.constituents.Coordinates;
import src.constituents.Organization;
import src.constituents.Product;
import src.exceptions.ValidationException;


/**
 * Class of Initializer.
 * This class initializes collection.
 */

public class Initializer {
    private static int offset = 0;

    /**
     * Constructor
     */

    public Initializer() {
    }

    /**
     * Method for initialization of collection
     * @param product - the element of collection
     * @param values - the fields of element
     * @throws NullPointerException
     * @throws ValidationException
     */

    public static void Initialize(Product product, String[] values) throws NullPointerException, ValidationException {
        try {
            product.setName(values[offset++]);
            Coordinates coordinates = new Coordinates();
            coordinates.setX(Double.parseDouble(values[offset++]));
            coordinates.setY(Integer.parseInt(values[offset++]));
            product.setCoordinates(coordinates);
            product.setCreationDate(LocalDateTime.parse(values[offset++]));
            product.setPrice(Integer.parseInt(values[offset++]));
            product.setPartNumber(values[offset++]);
            product.setManufactureCost(Long.parseLong(values[offset++]));
            product.setUnitOfMeasure(values[offset++]);
            Organization manufacturer = new Organization();
            manufacturer.setName(values[offset++]);
            manufacturer.setFullName(values[offset++]);
            manufacturer.setemployeesCount(Long.parseLong(values[offset++]));
            product.setManufacturer(manufacturer);
        } catch (NullPointerException ex) {
            System.err.println("The field can not be null! Check the file.");
        } catch (ValidationException ex) {
            System.err.println(ex.getMessage());
        } catch (NumberFormatException ex) {
            System.err.println("The field can not be null! Check the file.");
        }
    }
}
