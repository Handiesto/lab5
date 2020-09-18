package src.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Class which works with files.
 * It has a few method which helps read information in file.
 */

public class Input {
    private Scanner scanner;

    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public Input() throws FileNotFoundException{
        File file = new File("Lab5_Input.xml");
        scanner = new Scanner(file);
    }

    /**
     * Constructor
     * @param path - the path to file
     * @throws FileNotFoundException
     */
    public Input(String path) throws FileNotFoundException {
        scanner = new Scanner(new File(path));
    }

    /**
     * Reads whole file
     * @return the text of file
     * @throws IOException
     */
    public String readFile() throws IOException {
        String text = "";
        StringBuilder textBuilder = new StringBuilder(text);
        while(scanner.hasNextLine()) {
            textBuilder.append(scanner.nextLine());
        }
        scanner.close();
        text = textBuilder.toString();
        return text;
    }
    /**
     * Check if the next line in file exists
     * @return the result of checking
     */
    public boolean hasNextLine() {
        boolean exist = false;
        if (scanner.hasNextLine()) {
            exist = true;
        } else {
            exist = false;
        }
        return exist;
    }
    /**
     * Reads line in file
     * @return the line of text
     */
    public String readLine() {
        String text;
        text = scanner.nextLine();
        return text;
    }
    /**
     * Closes file.
     * @throws IOException
     */


    public void closeFile() throws IOException {
        scanner.close();
    }
}


