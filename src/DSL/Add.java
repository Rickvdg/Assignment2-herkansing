package DSL;

import Domain.Collection;
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

        Train tr = Collection.getTrainbyName(trainName);
        Wagon wg = Collection.getWagonByName(wagonName);

        return null;
    }

}
