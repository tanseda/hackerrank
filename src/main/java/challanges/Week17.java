package challanges;

import java.util.function.Function;

import static java.lang.String.join;

/**
 * Created by stan on 26/04/2021.
 */
public class Week17 {
    interface Jedi {
        String MASTER = "Yoda";

        default String attack(){
            return jump(jedi -> String.join(jedi, useSaber(), useForce()));
        }

        private String jump(Function<String, String> function) {
            return function.apply("Luke");
        }

        private static String useSaber(){return "S";};

        private String useForce(){return "F";};

    }

     class ForceJedi implements Jedi {

        private String useForce(){ return "X";};

    }

    public static void main(String[] args) {
        Week17 week  = new Week17();
        Jedi jedi = week.new ForceJedi();
        System.out.println(jedi.attack() + Jedi.useSaber() + Jedi.MASTER);
    }

}
