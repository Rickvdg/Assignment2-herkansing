package DSL;

import Controller.CommandChecker;
import Domain.Station;
import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

/**
 * Created by Rick vd Gun on 3-2-2018.
 */
public class Delete implements ICommand {

    @Override
    public String interpret(ArrayList<String> input) {
        boolean notEnoughWords = !(input.size() >= 3);

        if (notEnoughWords) {
            return "Invalid command";
        }

        String type = input.get(1).toLowerCase();
        String name = input.get(2);

        if (type.equals("train")) {
            return deleteTrain(name);
        } else if (type.equals("wagon")) {
            return deleteWagon(name);
        } else {
            return String.format("Invalid type '%s'", input.get(1));
        }
    }

    private String deleteTrain(String name) {
        Train train = Station.getTrainbyName(name);
        if (train != null) {
            Station.removeTrain(train);
            return String.format("Train '%s' deleted", name);
        } else {
            return String.format("Train '%s' doesn't exist", name);
        }
    }

    private String deleteWagon(String name) {
        Wagon wagon = Station.getWagonByName(name);
        if (wagon != null) {
            Station.removeWagon(wagon);
            return String.format("Wagon '%s' deleted", name);
        } else {
            return String.format("Wagon '%s' doesn't exist", name);
        }

    }
}
