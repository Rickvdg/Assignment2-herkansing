package DSL;

import Controller.CommandChecker;
import Domain.Station;
import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

/**
 * Created by Rick on 1-2-2018.
 */
public class Add implements ICommand {

    @Override
    public String interpret(ArrayList<String> input) {
        String wagonName = input.get(1);
        String trainName = input.get(3);

        Train tr = Station.getTrainbyName(trainName);
        Wagon wg = Station.getWagonByName(wagonName);


        if (tr != null && wg != null) {
            tr.addWagon(wg);
            return String.format("Wagon %s toegevoegd aan trein %s", wagonName, trainName);
        } else {
            return String.format("Train or wagon nog found");
        }

        //return null;
    }

}
