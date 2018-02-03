package Domain;

/**
 * Created by Rick on 1-2-2018.
 */
public class Wagon {

    private String name;
    private int seats;

    public Wagon(String name) {
        this.name = name;
        seats = 20;
    }

    public Wagon(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public boolean equals(Object object) {
        if (object.getClass() == getClass()) {
            Wagon wagon = (Wagon) object;
            if (wagon.name.equals(name)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "Wagon " + name + " met " + seats + " plekken";
    }
}
