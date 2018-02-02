package Domain;

import java.util.ArrayList;

/**
 * Created by Rick on 1-2-2018.
 */
public class Station {

    private static ArrayList<Train> trains;
    private static ArrayList<Wagon> wagons;

    public static void addTrain(Train train) {
        trains.add(train);
    }

    public static void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }

    public static void removeTrain(Train train) {
        trains.remove(train);
    }

    public static void removeWagon(Wagon wagon) {
        wagons.remove(wagon);
    }

    public static Train getTrainbyName(String name) {
        for (Train train : trains) {
            if (train.getName().equals(name)) {
                return train;
            }
        }
        return null;
    }

    public static Wagon getWagonByName(String name) {
        for (Wagon wagon : wagons) {
            if (wagon.getName().equals(name)) {
                return wagon;
            }
        }
        return null;
    }
}
