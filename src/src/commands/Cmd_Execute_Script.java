package src.commands;

import src.exceptions.BadNumberOfArgsException;
import src.main.Invoker;
import src.main.Receiver;
import src.others.Input;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Class of command Execute Script.
 * This command execute file with script.
 */

public class Cmd_Execute_Script implements Command {
    private Receiver receiver;
    private Invoker handler;
    private static ArrayList<String> calls;



    public Cmd_Execute_Script(Receiver receiver, Invoker handler) {
        this.receiver = receiver;
        this.handler = handler;
        calls = new ArrayList<>();
    }

    /**
     * This method executes script.
     * @param args - the arguments that are passed to command
     * @throws Exception
     */

    @Override
    public void Execute(String ... args) throws Exception {
        String[] command = new String[2];
        boolean exit = false;
        if (args.length != 1) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            try {
                for (String com : calls) {
                    if (com.equals(args[0])) {
                        exit = true;
                    }
                }
                if (exit) {
                    System.err.println("Warning! The danger of infinite recursion: " +
                            "the same script is called more that once");
                } else {
                    Input input = new Input(args[0]);
                    String nextLine;
                    while (input.hasNextLine()) {
                        nextLine = input.readLine();
                        command = nextLine.split(" ");

                        if (exit) {
                            exit = false;
                            break;
                        }
                        calls.add(args[0]);
                        handler.Execute(nextLine);
                    }

                    input.closeFile();
                    receiver.Execute_Script();

                }
            }
            catch (FileNotFoundException e) {
                System.err.println("File not found! Enter the correct path to the file!");
            }
        }
    }
}
