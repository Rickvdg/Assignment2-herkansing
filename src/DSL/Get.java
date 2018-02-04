package DSL;

import Domain.Station;
import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

/**
 * Created by Rick vd Gun on 4-2-2018.
 */
public class Get implements ICommand {


    @Override
    public String interpret(ArrayList<String> input) {

        boolean notEnoughWords = input.size() < 3;
        if (notEnoughWords)
            return "Invalid command";

        String type = input.get(1).toLowerCase();
        String name = input.get(2);

        if (type.equals("train")) {
            return getTrain(name);
        } else if (type.equals("wagon")) {
            return getWagon(name);
        } else {
            return String.format("Invalid type '%s'", type);
        }


    }

    private String getTrain(String name) {
        Train train = Station.getTrainbyName(name);
        if (train != null) return String.format("%s with %d seats", train.toString(), train.getSeats());
        return String.format("Train '%s' doesn't exist");
    }

    private String getWagon(String name) {
        Wagon wagon = Station.getWagonByName(name);
        if (wagon != null) return String.format(wagon.toString());
        return String.format("Wagon '%s' doesn't exist");
    }
}
