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

    public String toString() {
        return "Wagon " + name + " met " + seats + " plekken";
    }
}
