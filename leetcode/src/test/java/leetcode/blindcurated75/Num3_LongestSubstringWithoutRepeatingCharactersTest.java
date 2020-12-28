package leetcode.blindcurated75;

import org.junit.Test;

public class Num3_LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void lengthOfLongestSubstring() {
        Num3_LongestSubstringWithoutRepeatingCharacters solve = new Num3_LongestSubstringWithoutRepeatingCharacters();
        int result = solve.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result); //3
    }

    @Test
    public void lengthOfLongestSubstring2() {
        Num3_LongestSubstringWithoutRepeatingCharacters solve = new Num3_LongestSubstringWithoutRepeatingCharacters();
        int result = solve.lengthOfLongestSubstring("pwwkewp");
        System.out.println(result); //3
    }
}