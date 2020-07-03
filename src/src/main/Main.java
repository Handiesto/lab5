package src.main;

import java.util.Scanner;

import src.commands.*;
import src.exceptions.InvalidCommand;

public class Main {

    public static void main(String[] args) throws Exception {
        Receiver receiver = new Receiver();
        Invoker handler = new Invoker();
        Scanner userInput = new Scanner(System.in);
        RegisterCommands(receiver, handler);
        while(!receiver.getExit()) {
            try {
                handler.Execute(ReadUserInput(userInput));
            } catch (InvalidCommand ex) {
                System.err.println(ex.getMessage());
            }
        }
        userInput.close();
    }




    public static void RegisterCommands(Receiver receiver, Invoker handler) {
        handler.Register("help", new Cmd_Help(receiver));
        handler.Register("info", new Cmd_Info(receiver));
        handler.Register("show", new Cmd_Show(receiver));
        handler.Register("add", new Cmd_Add(receiver));
        handler.Register("update_id", new Cmd_UpdateId(receiver));
        handler.Register("remove_by_id", new Cmd_Remove_By_Id(receiver));
        handler.Register("clear", new Cmd_Clear(receiver));
        handler.Register("save", new Cmd_Save(receiver));
        handler.Register("execute_script", new Cmd_Execute_Script(receiver, handler));
        handler.Register("exit", new Cmd_Exit(receiver));
        handler.Register("insert_at", new Cmd_Insert_At(receiver));
        handler.Register("add_if_min", new Cmd_Add_If_Min(receiver));
        handler.Register("sort", new Cmd_Sort(receiver));
        handler.Register("sum_of_manufacture_cost", new Cmd_Sum_Of_Manufacture_Cost(receiver));
        handler.Register("count_greater_than_price", new Cmd_Count_Greater_Than_Price(receiver));
        handler.Register("print_ascending", new Cmd_Print_Ascending(receiver));
    }

    private static String ReadUserInput(Scanner userInput) {
        String nextCommand;
        nextCommand = userInput.nextLine();
        return nextCommand;
    }
}
