package Controller;

import Domain.Train;
import Domain.Wagon;
import Domain.Station;

import java.util.ArrayList;

public class CommandChecker {

    public static boolean nameCheck(String name) {
        if (name.matches("[a-z]{1}[a-z0-9]{0,}")) {
            return true;
        }
        return false;
    }

    public static boolean exists(Object object) {
        if (object.getClass() == Train.class && Station.getTrains().size() > 0) {
            for (Train tr : Station.getTrains()) {
                if (tr.equals(object)) {
                    return true;
                }
            }
            return false;
        } else if (object.getClass() == Wagon.class && Station.getWagons().size() > 0) {
            for (Wagon wg : Station.getWagons()) {
                if (wg.equals(object)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean existsTrain(Train object) {
        if (Station.getTrains().size() > 0) {
            for (Train tr : Station.getTrains()) {
                if (tr.equals(object)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean existsWagon(Wagon object) {
        if (Station.getWagons().size() > 0) {
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
