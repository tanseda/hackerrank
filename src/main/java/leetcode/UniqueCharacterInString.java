package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by stan on 08/04/2021.
 */
public class UniqueCharacterInString {
    public static void main(String[] args) {
        UniqueCharacterInString solution = new UniqueCharacterInString();
        solution.firstUniqChar("loveleetcode");
        solution.firstUniqCharSolution2("loveleetcode");
    }

    public int firstUniqChar(String s) {
        //s = "leetcode"    l, 0
        //s = "loveleetcode" v, 2
        //s = "aabb" -1

         /*
          a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  y  z
                4  6 -1                    0        5              3

         */

        int[] address = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (address[index] != 0) {
                address[index] = -1;
            } else {
                address[index] = i + 1;
            }
        }

        Arrays.sort(address);

        for (int i : address) {
            if (i > 0) {
                return i - 1;
            }
        }

        return -1;
    }

    public int firstUniqCharSolution2(String s) {
        LinkedHashMap<Character, Integer> frequency = new LinkedHashMap<>();


        for (int i = 0; i < s.length(); i++) {
            frequency.merge(s.charAt(i), 1, (k, v) -> k + v);
        }

        char value = frequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(' ');

        if (value == ' ') {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == value) {
                return i;
            }
        }

        return -1;
    }
}
