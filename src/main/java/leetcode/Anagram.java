package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by stan on 08/04/2021.
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> firstStringFrequency = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            firstStringFrequency.merge(s.charAt(i), 1, (k,v) -> k + v);
        }

        //check the second string with firstStringFrequency
        for(int i = 0; i < t.length(); i++) {
            Integer freq = firstStringFrequency.merge(t.charAt(i), -1, (k,v) -> k+v);
            if(freq < 0)
                return false;
        }

        Optional<Integer> freq = firstStringFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> entry.getValue())
                .findFirst();



        return !freq.isPresent();
    }
}
