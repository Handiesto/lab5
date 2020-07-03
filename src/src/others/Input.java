package src.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Input {
    private Scanner scanner;

    public Input() throws FileNotFoundException{
        File file = new File("D:/laba5/src/Lab5_Input.xml");
        scanner = new Scanner(file);
    }

    public Input(String path) throws FileNotFoundException {
        scanner = new Scanner(new File(path));
    }

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

    public boolean hasNextLine() {
        boolean exist = false;
        if (scanner.hasNextLine()) {
            exist = true;
        } else {
            exist = false;
        }
        return exist;
    }

    public String readLine() {
        String text;
        text = scanner.nextLine();
        return text;
    }


    public void closeFile() throws IOException {
        scanner.close();
    }
}


