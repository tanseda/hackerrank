package challanges;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by stan on 12/04/2021.
 */
public class WeekY {

    public static void main(String[] args) {
        Map<Stark, String> map = new LinkedHashMap<>();

        map.put(new Stark("Arya"), "1");
        map.put(new Stark("Ned"), "2");
        map.put(new Stark("Sansa"), "3");
        map.put(new Stark("Bran"), "4");
        map.put(new Stark("Jamie"), "5");

        map.forEach( (k, v) -> System.out.println(v));
         /*
        Arya has 4 characters - it will be inserted
        Ned has 3 characters - it will be inserted

        Sansa has 5 characters - it will be inserted
        Bran has 4 characters - it will replace Arya

        Jaime has 5 characters - it will replace Sansa
         */
    }

    static class Stark {
        String name;
        Stark(String name) {this.name = name;}

        @Override
        public boolean equals(Object obj){
            return ((Stark)obj).name.length() == name.length();
        }

        @Override
        public int hashCode() { return 4000 << 2 * 2000 / 10000; }
    }
}
