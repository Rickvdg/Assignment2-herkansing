package DSL;

import Controller.CommandChecker;
import Domain.Station;
import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

/**
 * Created by Rick on 2-2-2018.
 */
public class New implements ICommand {

    @Override
    public String interpret(ArrayList<String> input) {
        boolean notEnoughWords = input.size() < 3;

        if (notEnoughWords) {
            return "Invalid command";
        }

        String type = input.get(1).toLowerCase();
        String name = input.get(2);

        if (!CommandChecker.nameCheck(name)) {
            return "Name can only be numbers and letters";
        }

        if (type.equals("train")) {                                     // Trains
            Train tr = new Train(name);
            if (!CommandChecker.exists(tr)) {
                Station.addTrain(new Train(name));
            } else {
                return "This train already exists";
            }
        } else if (type.equals("wagon")) {                              // Wagons
            if (input.size() == 3) {                                    // -> Without seats
                Wagon wg = new Wagon(name);
                if (!CommandChecker.exists(wg)) {
                    Station.addWagon(wg);
                    return String.format("New %s '%s' added with %s seats", type, name, 20);
                } else {
                    return "This wagon already exists";
                }
            } else {
                String seats = input.get(3);                            // -> With seats
                if (CommandChecker.stringToNumber(seats) > 0) {
                    Wagon wg = new Wagon(name, Integer.parseInt(seats));
                    if (!CommandChecker.exists(wg)) {
                        Station.addWagon(new Wagon(name, Integer.parseInt(seats)));
                        return String.format("New %s '%s' added with %s seats", type, name, seats);
                    } else {
                        return "This wagon already exists";
                    }
                } else {
                    return String.format("'%s' is not a number or not positive", seats);
                }
            }
        } else {                                                        // Invalid types
            return String.format("Invalid type: '%s'", type);
        }
        return String.format("New %s '%s' added", type, name);
    }
}
