package Domain;

import java.util.ArrayList;

/**
 * Created by Rick on 1-2-2018.
 */
public class Train {

    private String name;
    private ArrayList<Wagon> aangesloten = new ArrayList<Wagon>();

    public Train(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Wagon> getAangesloten() {
        return aangesloten;
    }

    public void addWagon(Wagon wagon) {
        aangesloten.add(wagon);
    }

    public void removeWagon(Wagon wagon) {
        aangesloten.remove(wagon);
    }

    public int getSeats() {
        int seats = 0;
        if (aangesloten.size() > 0) {
            for (Wagon wagon : aangesloten) {
                seats += wagon.getSeats();
            }
        }
        return seats;
    }

    public boolean equals(Object object) {
        if (object.getClass() == getClass()) {
            Train train = (Train) object;
            if (train.name.equals(name)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String getTrainInfo() {
        String trainInformation = "(" + name + ")";
        for (Wagon wagon : aangesloten) {
            trainInformation = trainInformation + "-(" + wagon.getName() + ")";
        }
        return trainInformation;
    }

    public String toString() {
        return "Train '" + name + "'";
    }
}
