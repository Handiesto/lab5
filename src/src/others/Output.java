package src.others;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The class witch works with user output.
 * @version 1.0.0
 */

public class Output {
    private PrintWriter writer;

    /**
     * Constructor.
     * @throws IOException can throw an input/output exception
     */


    public Output() throws IOException {
        try {
            writer = new PrintWriter(new FileWriter("D:/laba5/src/Lab5_Input.xml"));
        } catch(NullPointerException ex) {
            System.err.println("Can not get a path from environment.");
        }
    }

    /**
     * Constructor
     * @param path - the path to file
     * @throws IOException
     */

    public Output(String path) throws IOException {
        writer = new PrintWriter(new FileWriter(path));
    }

    /**
     * Method for writing a text.
     * Use it only once.
     * @param text - the text will be written to a file
     * @throws IOException can throw an input/output exception
     */

    public void Write(String text) throws IOException {
        writer.write(text);
        writer.close();
    }

    /**
     * Method for writing a line of text.
     * @param line - the line of text
     * @throws IOException can throw an input/output exception
     */

    public void writeLine(String line) throws IOException {
        writer.write(line+"\n");
    }

    /**
     * Method for closing the writer.
     * Recommend to close the writer with every time you open it.
     * @throws IOException can throw an input/output exception
     */

    public void closeWriter() throws IOException {
        writer.close();
    }
}
