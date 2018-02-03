import DSL.Add;
import DSL.New;
import DSL.Remove;

import java.util.ArrayList;

/**
 * Created by Rick vd Gun on 3-2-2018.
 */
public class MainTest {
    public static void main(String[] args) {
        New n = new New();
        Add a = new Add();
        Remove r = new Remove();

        System.out.println(n.interpret(stringToList("new train tr1")));
        System.out.println(n.interpret(stringToList("new train tr1")));
        System.out.println(n.interpret(stringToList("new train")));
        System.out.println(n.interpret(stringToList("new wagon wg1")));
        System.out.println(n.interpret(stringToList("new wagon wg1")));
        System.out.println(n.interpret(stringToList("new wagon wg2 2")));
        System.out.println(n.interpret(stringToList("new wagon")));
        System.out.println(n.interpret(stringToList("new iets")));
        System.out.println(n.interpret(stringToList("new wagon $#$%")));
        System.out.println(" "); // ---------------------------------------
        System.out.println(a.interpret(stringToList("add wg1 to tr1")));
        System.out.println(a.interpret(stringToList("add tr1 to wg1")));
        System.out.println(a.interpret(stringToList("add wg1 to tr1 dhdasjkhdajk")));
        System.out.println(" "); // ---------------------------------------
        System.out.println(r.interpret(stringToList("remove wg1 from tr1")));
        System.out.println(r.interpret(stringToList("remove wg1 to tr1")));
        System.out.println(r.interpret(stringToList("remove wg1 from tr1")));
        System.out.println(r.interpret(stringToList("remove wg1 from tr1")));
    }

    private static ArrayList<String> stringToList(String s) {
        ArrayList<String> output = new ArrayList<String>();
        for (String string : s.split(" ")) {
            output.add(string);
//            System.out.print(s+" ");
        }
        return output;
    }
}
