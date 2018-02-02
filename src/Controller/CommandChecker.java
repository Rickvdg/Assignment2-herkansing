package Controller;

import Domain.Train;
import Domain.Wagon;
import Domain.Station;

import java.util.ArrayList;

public class CommandChecker {

    public boolean wordCheck(ArrayList<String> words, int index, String wordToCompareTo) {
        String wordToCompare = words.get(index);
        return (wordToCompare.equals(wordToCompareTo));
    }

    public boolean sizeCheck(int size, ArrayList<String> wordsOfCommand) {
        if (wordsOfCommand.size() == size) {
            return true;
        }
        return false;
    }

    public boolean idCheck(String id) {
        if (id.matches("[a-z]{1}[a-z0-9]{0,}")) {
            return true;
        }
        return false;
    }

    public boolean numberCheck(int number) {
        return (number >= 0);
    }

    public int stringToNumber(String numberToParse) {
        try {
            return Integer.parseInt(numberToParse);

        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
