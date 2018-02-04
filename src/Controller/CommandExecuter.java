package Controller;

import DSL.*;

import java.util.ArrayList;

public class CommandExecuter {

    public String execute(String string) {
        ArrayList<String> input = stringToList(string);
        String commandString = input.get(0).toLowerCase();
        ICommand commandType = null;

        switch (commandString) {
            case "new":
                commandType = new New();
                break;
            case "add":
                commandType = new Add();
                break;
            case "getnumseats":
                commandType = new Get();
                break;
            case "delete":
                commandType = new Delete();
                break;
            case "remove":
                commandType = new Delete();
                break;
            default:
                return String.format("Invalid command '%s'", commandString);
        }

        return commandType.interpret(input);
    }

    private static ArrayList<String> stringToList(String s) {
        ArrayList<String> output = new ArrayList<String>();
        for (String string : s.split(" ")) {
            output.add(string);
        }
        return output;
    }
}
