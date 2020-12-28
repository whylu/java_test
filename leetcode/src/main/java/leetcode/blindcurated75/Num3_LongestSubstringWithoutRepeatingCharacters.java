package leetcode.blindcurated75;

import java.util.HashMap;
import java.util.Map;

public class Num3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> window = new HashMap<>();
        int i = 0, j = 0;
        int maxSize = 0;
        while (i<n && j<n) {

            char c = s.charAt(j);
            Integer existedInIndex = window.get(c);
            if(existedInIndex!=null) {
                i = Math.max(i, existedInIndex+1); // substring start jump to
            }
            window.put(c, j);

            maxSize = Math.max(maxSize, j-i+1);
            j++;
        }
        return maxSize;

    }
}
