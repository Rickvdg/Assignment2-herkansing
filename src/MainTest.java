import Controller.CommandExecuter;
import DSL.Add;
import DSL.Delete;
import DSL.New;
import DSL.Remove;

import java.util.ArrayList;

/**
 * Created by Rick vd Gun on 3-2-2018.
 */
public class MainTest {
    public static void main(String[] args) {
        CommandExecuter ce = new CommandExecuter();

        print(ce.execute("new train tr1"));
        print(ce.execute("new train tr1"));                 // invalid
        print(ce.execute("new train tr3"));
        print(ce.execute("new train"));                     // invalid
        print(ce.execute("new wagon wg1"));
        print(ce.execute("new wagon wg1"));                 // invalid
        print(ce.execute("new wagon wg2 2"));
        print(ce.execute("new wagon"));                     // invalid
        print(ce.execute("new iets"));                      // invalid
        print(ce.execute("new wagon $#$%"));                // invalid
        print(" "); // --------------------------
        print(ce.execute("add wg1 to tr1"));
        print(ce.execute("add wg2 to tr1"));
        print(ce.execute("add tr1 to wg1"));                // invalid
        print(ce.execute("add wg1 to tr1 dhdasjkhdajk"));
        print(" "); // --------------------------
        print(ce.execute("getnumseats train tr1"));
        print(ce.execute("getnUmSeAtS WaGoN wg2"));
        print(ce.execute("getnumseats invalid-type-test ja")); // invalid
        print(" "); // --------------------------
        print(ce.execute("remove wg1 from tr1"));
        print(ce.execute("remove wg1 to tr1"));             // invalid
        print(ce.execute("remove wg1 from tr1"));
        print(ce.execute("remove wg1 from tr1"));           // invalid
        print(" "); // --------------------------
        print(ce.execute("delete train tr1"));
        print(ce.execute("delete train tr1"));              // invalid
        print(ce.execute("delete wagon wg1"));
        print(ce.execute("delete wagon wg1"));              // invalid
        print(ce.execute("delete wg1 tr1"));                // invalid
        print(" "); // --------------------------
        print(ce.execute("command-test-die-niet-werkt"));   // invalid

    }

    private static void print(String input) {
        System.out.println(input);
    }
}
