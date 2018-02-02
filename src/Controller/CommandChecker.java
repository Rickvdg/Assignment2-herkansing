package Controller;

import Domain.Train;
import Domain.Wagon;
import Domain.Station;

import java.util.ArrayList;

public class CommandChecker {

    public static boolean wordCheck(ArrayList<String> words, int index, String wordToCompareTo) {
        String wordToCompare = words.get(index);
        return (wordToCompare.equals(wordToCompareTo));
    }

    public static boolean nameCheck(String name) {
        if (name.matches("[a-z]{1}[a-z0-9]{0,}")) {
            return true;
        }
        return false;
    }

    public static boolean exists(Object object) {
        if (object.getClass() == Train.class) {
            for (Train tr : Station.getTrains()) {
                if (tr.equals(object)) {
                    return true;
                }
            }
            return false;
        } else if (object.getClass() == Wagon.class) {
            for (Wagon wg : Station.getWagons()) {
                if (wg.equals(object)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int stringToNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
