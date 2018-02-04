package DSL;

import Controller.CommandChecker;
import Domain.Station;
import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

/**
 * Created by Rick vd Gun on 3-2-2018.
 */
public class Remove implements ICommand {

    @Override
    public String interpret(ArrayList<String> input) {
        boolean notEnoughWords = !(input.size() >= 4);
        boolean middlewordCheck = !input.get(2).toLowerCase().equals("from");

        if (notEnoughWords || middlewordCheck) {
            return "Invalid command";
        }

        Wagon wagon = Station.getWagonByName(input.get(1));
        Train train = Station.getTrainbyName(input.get(3));

        if (!CommandChecker.exists(wagon) && !CommandChecker.exists(train)) {
            return "Wagon or train nog found";
        }

        if (train.getConnected().contains(wagon)) {
            train.removeWagon(wagon);
            return String.format("Wagon '%s' removed from train '%s'", wagon.getName(), train.getName());
        } else {
            return String.format("Wagon '%s' is not connected to train '%s'", wagon.getName(), train.getName());
        }
    }
}
