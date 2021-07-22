package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stan on 13/04/2021.
 */
public class LengthOfLongestSubstring {

    //Given a string s, find the length of the longest substring without repeating characters.
    //With extre space O(min(n,m)).
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        Deque<Character> uniqueString = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(uniqueString.contains(c)) {
                maxLength = Math.max(maxLength, uniqueString.size());
                while(uniqueString.pollFirst() != c);
            }

            uniqueString.offerLast(c);
            maxLength = Math.max(maxLength, uniqueString.size());
        }
        return maxLength;
    }

    //Sliding window with HashMap solution
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
